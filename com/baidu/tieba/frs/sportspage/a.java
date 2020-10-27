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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes22.dex */
public class a {
    private TextView aiP;
    private TbPageContext eCn;
    private TbImageView eRf;
    private FrsViewData iAQ;
    private final View.OnClickListener iEe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eRf) {
                if (!at.isEmpty(a.this.iZi) && a.this.iAQ != null && a.this.iAQ.getForum() != null) {
                    be.boR().a(a.this.eCn, new String[]{a.this.iZi}, true);
                    TiebaStatic.log(new aq("c13415").dR("fid", a.this.iAQ.getForum().getId()).aj("obj_type", a.this.iKL ? 2 : 1));
                }
            } else if ((view == a.this.iZh || view == a.this.aiP) && a.this.iAQ != null && a.this.iAQ.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eCn.getPageActivity(), a.this.iAQ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dR("fid", a.this.iAQ.getForum().getId()));
            }
        }
    };
    private boolean iKL;
    private boolean iKS;
    private LinearGradientView iZg;
    private BarImageView iZh;
    private String iZi;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eCn = frsSportsRecommendFragment.getPageContext();
            this.eRf = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.iZg = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.iZh = (BarImageView) view.findViewById(R.id.frs_image);
            this.aiP = (TextView) view.findViewById(R.id.forum_name);
            this.eRf.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iZh.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iZh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iZh.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.iZh.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.iZh.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iAQ = frsViewData;
            this.iKS = false;
            String name = this.iAQ.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aiP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.iZh.startLoad(this.iAQ.getForum().getImage_url(), 10, false);
            cCl();
            this.iZh.setOnClickListener(this.iEe);
            this.aiP.setOnClickListener(this.iEe);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.iZh.refresh();
        if (at.isEmpty(str)) {
            this.iKS = false;
            cCl();
            return;
        }
        this.iKS = true;
        this.iZi = str2;
        this.iKL = z;
        this.eRf.startLoad(str, 10, false);
        this.eRf.setOnClickListener(this.iEe);
    }

    private void cCl() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iAQ != null && (forum = this.iAQ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iKS) {
                if (this.iZg != null) {
                    this.iZg.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.iZg.changeSkinType(skinType);
                }
                if (this.eRf != null) {
                    this.eRf.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cCl();
        ap.setViewTextColor(this.aiP, R.color.cp_cont_a);
        if (this.iZh != null) {
            this.iZh.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.iZh.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iZh.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iZh.invalidate();
        }
    }
}
