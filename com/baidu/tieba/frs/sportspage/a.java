package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
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
/* loaded from: classes4.dex */
public class a {
    private TextView cbY;
    private TbImageView ccW;
    private boolean fEc;
    private boolean fEj;
    private LinearGradientView fQI;
    private BarImageView fQJ;
    private String fQK;
    private FrsViewData fvE;
    private final View.OnClickListener fyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ccW) {
                if (!aq.isEmpty(a.this.fQK) && a.this.fvE != null && a.this.fvE.getForum() != null) {
                    ba.ajK().a(a.this.mContext, new String[]{a.this.fQK}, true);
                    TiebaStatic.log(new an("c13415").bT("fid", a.this.fvE.getForum().getId()).P("obj_type", a.this.fEc ? 2 : 1));
                }
            } else if ((view == a.this.fQJ || view == a.this.cbY) && a.this.fvE != null && a.this.fvE.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.mContext.getPageActivity(), a.this.fvE.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").bT("fid", a.this.fvE.getForum().getId()));
            }
        }
    };
    private TbPageContext mContext;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            this.ccW = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fQI = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fQJ = (BarImageView) view.findViewById(R.id.frs_image);
            this.cbY = (TextView) view.findViewById(R.id.forum_name);
            this.ccW.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fQJ.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fQJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fQJ.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fQJ.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fQJ.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fvE = frsViewData;
            this.fEj = false;
            String name = this.fvE.getForum().getName();
            if (aq.od(name) > 20) {
                name = aq.k(name, 20, "...");
            }
            this.cbY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fQJ.startLoad(this.fvE.getForum().getImage_url(), 10, false);
            bsC();
            this.fQJ.setOnClickListener(this.fyk);
            this.cbY.setOnClickListener(this.fyk);
        }
    }

    public void w(String str, String str2, boolean z) {
        this.fQJ.refresh();
        if (aq.isEmpty(str)) {
            this.fEj = false;
            bsC();
            return;
        }
        this.fEj = true;
        this.fQK = str2;
        this.fEc = z;
        this.ccW.startLoad(str, 10, false);
        this.ccW.setOnClickListener(this.fyk);
    }

    private void bsC() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fvE != null && this.fvE.getForum() != null && (themeColorInfo = this.fvE.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fEj) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fQI != null) {
                    this.fQI.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fQI.changeSkinType(skinType);
                }
                if (this.ccW != null) {
                    this.ccW.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bsC();
        am.j(this.cbY, R.color.cp_cont_a);
        if (this.fQJ != null) {
            this.fQJ.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fQJ.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fQJ.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fQJ.invalidate();
        }
    }
}
