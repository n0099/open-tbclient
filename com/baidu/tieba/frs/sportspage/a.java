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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a {
    private TextView caY;
    private TbImageView cbV;
    private boolean fBB;
    private boolean fBI;
    private LinearGradientView fOe;
    private BarImageView fOf;
    private String fOg;
    private FrsViewData fts;
    private final View.OnClickListener fvY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cbV) {
                if (!aq.isEmpty(a.this.fOg) && a.this.fts != null && a.this.fts.getForum() != null) {
                    bb.ajC().a(a.this.mContext, new String[]{a.this.fOg}, true);
                    TiebaStatic.log(new an("c13415").bT("fid", a.this.fts.getForum().getId()).P("obj_type", a.this.fBB ? 2 : 1));
                }
            } else if ((view == a.this.fOf || view == a.this.caY) && a.this.fts != null && a.this.fts.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.mContext.getPageActivity(), a.this.fts.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").bT("fid", a.this.fts.getForum().getId()));
            }
        }
    };
    private TbPageContext mContext;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            this.cbV = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fOe = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fOf = (BarImageView) view.findViewById(R.id.frs_image);
            this.caY = (TextView) view.findViewById(R.id.forum_name);
            this.cbV.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fOf.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fOf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fOf.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fOf.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fOf.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fts = frsViewData;
            this.fBI = false;
            String name = this.fts.getForum().getName();
            if (aq.ob(name) > 20) {
                name = aq.k(name, 20, "...");
            }
            this.caY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fOf.startLoad(this.fts.getForum().getImage_url(), 10, false);
            brC();
            this.fOf.setOnClickListener(this.fvY);
            this.caY.setOnClickListener(this.fvY);
        }
    }

    public void v(String str, String str2, boolean z) {
        this.fOf.refresh();
        if (aq.isEmpty(str)) {
            this.fBI = false;
            brC();
            return;
        }
        this.fBI = true;
        this.fOg = str2;
        this.fBB = z;
        this.cbV.startLoad(str, 10, false);
        this.cbV.setOnClickListener(this.fvY);
    }

    private void brC() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fts != null && this.fts.getForum() != null && (themeColorInfo = this.fts.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fBI) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fOe != null) {
                    this.fOe.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fOe.changeSkinType(skinType);
                }
                if (this.cbV != null) {
                    this.cbV.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        brC();
        am.j(this.caY, R.color.cp_btn_a);
        if (this.fOf != null) {
            this.fOf.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fOf.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fOf.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fOf.invalidate();
        }
    }
}
