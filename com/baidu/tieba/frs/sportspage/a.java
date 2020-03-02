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
    private TbPageContext cVh;
    private TextView dhe;
    private TbImageView dib;
    private LinearGradientView gIN;
    private BarImageView gIO;
    private String gIP;
    private FrsViewData gnM;
    private final View.OnClickListener gqq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dib) {
                if (!aq.isEmpty(a.this.gIP) && a.this.gnM != null && a.this.gnM.getForum() != null) {
                    ba.aGG().a(a.this.cVh, new String[]{a.this.gIP}, true);
                    TiebaStatic.log(new an("c13415").cy("fid", a.this.gnM.getForum().getId()).X("obj_type", a.this.gvZ ? 2 : 1));
                }
            } else if ((view == a.this.gIO || view == a.this.dhe) && a.this.gnM != null && a.this.gnM.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cVh.getPageActivity(), a.this.gnM.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cy("fid", a.this.gnM.getForum().getId()));
            }
        }
    };
    private boolean gvZ;
    private boolean gwg;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVh = frsSportsRecommendFragment.getPageContext();
            this.dib = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gIN = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gIO = (BarImageView) view.findViewById(R.id.frs_image);
            this.dhe = (TextView) view.findViewById(R.id.forum_name);
            this.dib.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gIO.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gIO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gIO.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gIO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gIO.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.gnM = frsViewData;
            this.gwg = false;
            String name = this.gnM.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dhe.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gIO.startLoad(this.gnM.getForum().getImage_url(), 10, false);
            bJG();
            this.gIO.setOnClickListener(this.gqq);
            this.dhe.setOnClickListener(this.gqq);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gIO.refresh();
        if (aq.isEmpty(str)) {
            this.gwg = false;
            bJG();
            return;
        }
        this.gwg = true;
        this.gIP = str2;
        this.gvZ = z;
        this.dib.startLoad(str, 10, false);
        this.dib.setOnClickListener(this.gqq);
    }

    private void bJG() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gnM != null && (forum = this.gnM.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gwg) {
                if (this.gIN != null) {
                    this.gIN.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gIN.changeSkinType(skinType);
                }
                if (this.dib != null) {
                    this.dib.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bJG();
        am.setViewTextColor(this.dhe, (int) R.color.cp_cont_a);
        if (this.gIO != null) {
            this.gIO.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gIO.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gIO.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gIO.invalidate();
        }
    }
}
