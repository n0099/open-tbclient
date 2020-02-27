package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext cVg;
    private TextView dhd;
    private TbImageView dia;
    private LinearGradientView gIL;
    private BarImageView gIM;
    private String gIN;
    private FrsViewData gnK;
    private final View.OnClickListener gqo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dia) {
                if (!aq.isEmpty(a.this.gIN) && a.this.gnK != null && a.this.gnK.getForum() != null) {
                    ba.aGE().a(a.this.cVg, new String[]{a.this.gIN}, true);
                    TiebaStatic.log(new an("c13415").cy("fid", a.this.gnK.getForum().getId()).X("obj_type", a.this.gvX ? 2 : 1));
                }
            } else if ((view == a.this.gIM || view == a.this.dhd) && a.this.gnK != null && a.this.gnK.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cVg.getPageActivity(), a.this.gnK.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cy("fid", a.this.gnK.getForum().getId()));
            }
        }
    };
    private boolean gvX;
    private boolean gwe;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVg = frsSportsRecommendFragment.getPageContext();
            this.dia = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gIL = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gIM = (BarImageView) view.findViewById(R.id.frs_image);
            this.dhd = (TextView) view.findViewById(R.id.forum_name);
            this.dia.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gIM.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gIM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gIM.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gIM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gIM.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.gnK = frsViewData;
            this.gwe = false;
            String name = this.gnK.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dhd.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gIM.startLoad(this.gnK.getForum().getImage_url(), 10, false);
            bJE();
            this.gIM.setOnClickListener(this.gqo);
            this.dhd.setOnClickListener(this.gqo);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gIM.refresh();
        if (aq.isEmpty(str)) {
            this.gwe = false;
            bJE();
            return;
        }
        this.gwe = true;
        this.gIN = str2;
        this.gvX = z;
        this.dia.startLoad(str, 10, false);
        this.dia.setOnClickListener(this.gqo);
    }

    private void bJE() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gnK != null && (forum = this.gnK.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gwe) {
                if (this.gIL != null) {
                    this.gIL.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gIL.changeSkinType(skinType);
                }
                if (this.dia != null) {
                    this.dia.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bJE();
        am.setViewTextColor(this.dhd, (int) R.color.cp_cont_a);
        if (this.gIM != null) {
            this.gIM.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gIM.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gIM.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gIM.invalidate();
        }
    }
}
