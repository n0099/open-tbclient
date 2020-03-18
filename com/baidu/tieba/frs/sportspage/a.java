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
    private TbPageContext cVv;
    private TextView dhE;
    private TbImageView diE;
    private LinearGradientView gKe;
    private BarImageView gKf;
    private String gKg;
    private FrsViewData goJ;
    private final View.OnClickListener grn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.diE) {
                if (!aq.isEmpty(a.this.gKg) && a.this.goJ != null && a.this.goJ.getForum() != null) {
                    ba.aGK().a(a.this.cVv, new String[]{a.this.gKg}, true);
                    TiebaStatic.log(new an("c13415").cx("fid", a.this.goJ.getForum().getId()).X("obj_type", a.this.gwU ? 2 : 1));
                }
            } else if ((view == a.this.gKf || view == a.this.dhE) && a.this.goJ != null && a.this.goJ.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cVv.getPageActivity(), a.this.goJ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cx("fid", a.this.goJ.getForum().getId()));
            }
        }
    };
    private boolean gwU;
    private boolean gxb;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cVv = frsSportsRecommendFragment.getPageContext();
            this.diE = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gKe = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gKf = (BarImageView) view.findViewById(R.id.frs_image);
            this.dhE = (TextView) view.findViewById(R.id.forum_name);
            this.diE.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gKf.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gKf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gKf.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gKf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gKf.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.goJ = frsViewData;
            this.gxb = false;
            String name = this.goJ.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dhE.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gKf.startLoad(this.goJ.getForum().getImage_url(), 10, false);
            bJU();
            this.gKf.setOnClickListener(this.grn);
            this.dhE.setOnClickListener(this.grn);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gKf.refresh();
        if (aq.isEmpty(str)) {
            this.gxb = false;
            bJU();
            return;
        }
        this.gxb = true;
        this.gKg = str2;
        this.gwU = z;
        this.diE.startLoad(str, 10, false);
        this.diE.setOnClickListener(this.grn);
    }

    private void bJU() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.goJ != null && (forum = this.goJ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gxb) {
                if (this.gKe != null) {
                    this.gKe.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gKe.changeSkinType(skinType);
                }
                if (this.diE != null) {
                    this.diE.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bJU();
        am.setViewTextColor(this.dhE, (int) R.color.cp_cont_a);
        if (this.gKf != null) {
            this.gKf.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gKf.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gKf.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gKf.invalidate();
        }
    }
}
