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
    private TbPageContext cVi;
    private TextView dhr;
    private TbImageView dip;
    private LinearGradientView gIZ;
    private BarImageView gJa;
    private String gJb;
    private FrsViewData gnZ;
    private final View.OnClickListener gqD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dip) {
                if (!aq.isEmpty(a.this.gJb) && a.this.gnZ != null && a.this.gnZ.getForum() != null) {
                    ba.aGG().a(a.this.cVi, new String[]{a.this.gJb}, true);
                    TiebaStatic.log(new an("c13415").cy("fid", a.this.gnZ.getForum().getId()).X("obj_type", a.this.gwl ? 2 : 1));
                }
            } else if ((view == a.this.gJa || view == a.this.dhr) && a.this.gnZ != null && a.this.gnZ.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cVi.getPageActivity(), a.this.gnZ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cy("fid", a.this.gnZ.getForum().getId()));
            }
        }
    };
    private boolean gwl;
    private boolean gws;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVi = frsSportsRecommendFragment.getPageContext();
            this.dip = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gIZ = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gJa = (BarImageView) view.findViewById(R.id.frs_image);
            this.dhr = (TextView) view.findViewById(R.id.forum_name);
            this.dip.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gJa.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gJa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gJa.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gJa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gJa.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.gnZ = frsViewData;
            this.gws = false;
            String name = this.gnZ.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dhr.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gJa.startLoad(this.gnZ.getForum().getImage_url(), 10, false);
            bJH();
            this.gJa.setOnClickListener(this.gqD);
            this.dhr.setOnClickListener(this.gqD);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gJa.refresh();
        if (aq.isEmpty(str)) {
            this.gws = false;
            bJH();
            return;
        }
        this.gws = true;
        this.gJb = str2;
        this.gwl = z;
        this.dip.startLoad(str, 10, false);
        this.dip.setOnClickListener(this.gqD);
    }

    private void bJH() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gnZ != null && (forum = this.gnZ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gws) {
                if (this.gIZ != null) {
                    this.gIZ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gIZ.changeSkinType(skinType);
                }
                if (this.dip != null) {
                    this.dip.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bJH();
        am.setViewTextColor(this.dhr, (int) R.color.cp_cont_a);
        if (this.gJa != null) {
            this.gJa.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gJa.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gJa.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gJa.invalidate();
        }
    }
}
