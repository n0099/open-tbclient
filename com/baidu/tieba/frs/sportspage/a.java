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
    private TextView dHD;
    private TbImageView dIB;
    private TbPageContext duK;
    private FrsViewData gXU;
    private final View.OnClickListener haG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dIB) {
                if (!aq.isEmpty(a.this.htD) && a.this.gXU != null && a.this.gXU.getForum() != null) {
                    ba.aOV().a(a.this.duK, new String[]{a.this.htD}, true);
                    TiebaStatic.log(new an("c13415").cI("fid", a.this.gXU.getForum().getId()).af("obj_type", a.this.hgk ? 2 : 1));
                }
            } else if ((view == a.this.htC || view == a.this.dHD) && a.this.gXU != null && a.this.gXU.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.duK.getPageActivity(), a.this.gXU.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cI("fid", a.this.gXU.getForum().getId()));
            }
        }
    };
    private boolean hgk;
    private boolean hgr;
    private LinearGradientView htB;
    private BarImageView htC;
    private String htD;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.duK = frsSportsRecommendFragment.getPageContext();
            this.dIB = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.htB = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.htC = (BarImageView) view.findViewById(R.id.frs_image);
            this.dHD = (TextView) view.findViewById(R.id.forum_name);
            this.dIB.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.htC.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.htC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.htC.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.htC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.htC.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.gXU = frsViewData;
            this.hgr = false;
            String name = this.gXU.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dHD.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.htC.startLoad(this.gXU.getForum().getImage_url(), 10, false);
            bUq();
            this.htC.setOnClickListener(this.haG);
            this.dHD.setOnClickListener(this.haG);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.htC.refresh();
        if (aq.isEmpty(str)) {
            this.hgr = false;
            bUq();
            return;
        }
        this.hgr = true;
        this.htD = str2;
        this.hgk = z;
        this.dIB.startLoad(str, 10, false);
        this.dIB.setOnClickListener(this.haG);
    }

    private void bUq() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gXU != null && (forum = this.gXU.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hgr) {
                if (this.htB != null) {
                    this.htB.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.htB.changeSkinType(skinType);
                }
                if (this.dIB != null) {
                    this.dIB.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bUq();
        am.setViewTextColor(this.dHD, (int) R.color.cp_cont_a);
        if (this.htC != null) {
            this.htC.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.htC.setBorderColor(am.getColor(R.color.black_alpha15));
            this.htC.setStrokeColorResId(R.color.cp_bg_line_d);
            this.htC.invalidate();
        }
    }
}
