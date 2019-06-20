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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private TextView bZW;
    private TbImageView caT;
    private LinearGradientView fJg;
    private BarImageView fJh;
    private String fJi;
    private FrsViewData fot;
    private final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.caT) {
                if (!ap.isEmpty(a.this.fJi) && a.this.fot != null && a.this.fot.getForum() != null) {
                    ba.aiz().a(a.this.mContext, new String[]{a.this.fJi}, true);
                    TiebaStatic.log(new am("c13415").bT("fid", a.this.fot.getForum().getId()).P("obj_type", a.this.fwF ? 2 : 1));
                }
            } else if ((view == a.this.fJh || view == a.this.bZW) && a.this.fot != null && a.this.fot.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.mContext.getPageActivity(), a.this.fot.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new am("c13416").bT("fid", a.this.fot.getForum().getId()));
            }
        }
    };
    private boolean fwF;
    private boolean fwM;
    private TbPageContext mContext;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            this.caT = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fJg = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fJh = (BarImageView) view.findViewById(R.id.frs_image);
            this.bZW = (TextView) view.findViewById(R.id.forum_name);
            this.caT.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJh.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fJh.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fJh.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fJh.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fot = frsViewData;
            this.fwM = false;
            String name = this.fot.getForum().getName();
            if (ap.nO(name) > 20) {
                name = ap.k(name, 20, "...");
            }
            this.bZW.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fJh.startLoad(this.fot.getForum().getImage_url(), 10, false);
            bpB();
            this.fJh.setOnClickListener(this.fra);
            this.bZW.setOnClickListener(this.fra);
        }
    }

    public void v(String str, String str2, boolean z) {
        this.fJh.refresh();
        if (ap.isEmpty(str)) {
            this.fwM = false;
            bpB();
            return;
        }
        this.fwM = true;
        this.fJi = str2;
        this.fwF = z;
        this.caT.startLoad(str, 10, false);
        this.caT.setOnClickListener(this.fra);
    }

    private void bpB() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fot != null && this.fot.getForum() != null && (themeColorInfo = this.fot.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fwM) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fJg != null) {
                    this.fJg.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fJg.changeSkinType(skinType);
                }
                if (this.caT != null) {
                    this.caT.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bpB();
        al.j(this.bZW, R.color.cp_btn_a);
        if (this.fJh != null) {
            this.fJh.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fJh.setBorderColor(al.getColor(R.color.black_alpha15));
            this.fJh.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fJh.invalidate();
        }
    }
}
