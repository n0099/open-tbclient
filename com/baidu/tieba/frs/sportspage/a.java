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
    private TextView cbf;
    private TbImageView ccc;
    private boolean fCp;
    private boolean fCw;
    private LinearGradientView fOS;
    private BarImageView fOT;
    private String fOU;
    private FrsViewData ftR;
    private final View.OnClickListener fwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ccc) {
                if (!aq.isEmpty(a.this.fOU) && a.this.ftR != null && a.this.ftR.getForum() != null) {
                    bb.ajE().a(a.this.mContext, new String[]{a.this.fOU}, true);
                    TiebaStatic.log(new an("c13415").bT("fid", a.this.ftR.getForum().getId()).P("obj_type", a.this.fCp ? 2 : 1));
                }
            } else if ((view == a.this.fOT || view == a.this.cbf) && a.this.ftR != null && a.this.ftR.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.mContext.getPageActivity(), a.this.ftR.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").bT("fid", a.this.ftR.getForum().getId()));
            }
        }
    };
    private TbPageContext mContext;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            this.ccc = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fOS = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fOT = (BarImageView) view.findViewById(R.id.frs_image);
            this.cbf = (TextView) view.findViewById(R.id.forum_name);
            this.ccc.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fOT.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fOT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fOT.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fOT.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fOT.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.ftR = frsViewData;
            this.fCw = false;
            String name = this.ftR.getForum().getName();
            if (aq.ob(name) > 20) {
                name = aq.k(name, 20, "...");
            }
            this.cbf.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fOT.startLoad(this.ftR.getForum().getImage_url(), 10, false);
            brP();
            this.fOT.setOnClickListener(this.fwx);
            this.cbf.setOnClickListener(this.fwx);
        }
    }

    public void v(String str, String str2, boolean z) {
        this.fOT.refresh();
        if (aq.isEmpty(str)) {
            this.fCw = false;
            brP();
            return;
        }
        this.fCw = true;
        this.fOU = str2;
        this.fCp = z;
        this.ccc.startLoad(str, 10, false);
        this.ccc.setOnClickListener(this.fwx);
    }

    private void brP() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.ftR != null && this.ftR.getForum() != null && (themeColorInfo = this.ftR.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fCw) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fOS != null) {
                    this.fOS.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fOS.changeSkinType(skinType);
                }
                if (this.ccc != null) {
                    this.ccc.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        brP();
        am.j(this.cbf, R.color.cp_btn_a);
        if (this.fOT != null) {
            this.fOT.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fOT.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fOT.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fOT.invalidate();
        }
    }
}
