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
    private TextView bZV;
    private TbImageView caS;
    private LinearGradientView fJe;
    private BarImageView fJf;
    private String fJg;
    private FrsViewData fot;
    private final View.OnClickListener fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.caS) {
                if (!ap.isEmpty(a.this.fJg) && a.this.fot != null && a.this.fot.getForum() != null) {
                    ba.aiz().a(a.this.mContext, new String[]{a.this.fJg}, true);
                    TiebaStatic.log(new am("c13415").bT("fid", a.this.fot.getForum().getId()).P("obj_type", a.this.fwF ? 2 : 1));
                }
            } else if ((view == a.this.fJf || view == a.this.bZV) && a.this.fot != null && a.this.fot.getForum() != null) {
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
            this.caS = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fJe = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fJf = (BarImageView) view.findViewById(R.id.frs_image);
            this.bZV = (TextView) view.findViewById(R.id.forum_name);
            this.caS.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJf.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fJf.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fJf.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fJf.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fot = frsViewData;
            this.fwM = false;
            String name = this.fot.getForum().getName();
            if (ap.nP(name) > 20) {
                name = ap.k(name, 20, "...");
            }
            this.bZV.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fJf.startLoad(this.fot.getForum().getImage_url(), 10, false);
            bpz();
            this.fJf.setOnClickListener(this.fra);
            this.bZV.setOnClickListener(this.fra);
        }
    }

    public void v(String str, String str2, boolean z) {
        this.fJf.refresh();
        if (ap.isEmpty(str)) {
            this.fwM = false;
            bpz();
            return;
        }
        this.fwM = true;
        this.fJg = str2;
        this.fwF = z;
        this.caS.startLoad(str, 10, false);
        this.caS.setOnClickListener(this.fra);
    }

    private void bpz() {
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
                if (this.fJe != null) {
                    this.fJe.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fJe.changeSkinType(skinType);
                }
                if (this.caS != null) {
                    this.caS.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bpz();
        al.j(this.bZV, R.color.cp_btn_a);
        if (this.fJf != null) {
            this.fJf.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fJf.setBorderColor(al.getColor(R.color.black_alpha15));
            this.fJf.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fJf.invalidate();
        }
    }
}
