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
    private LinearGradientView fJd;
    private BarImageView fJe;
    private String fJf;
    private FrsViewData fos;
    private final View.OnClickListener fqZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.caS) {
                if (!ap.isEmpty(a.this.fJf) && a.this.fos != null && a.this.fos.getForum() != null) {
                    ba.aiz().a(a.this.mContext, new String[]{a.this.fJf}, true);
                    TiebaStatic.log(new am("c13415").bT("fid", a.this.fos.getForum().getId()).P("obj_type", a.this.fwE ? 2 : 1));
                }
            } else if ((view == a.this.fJe || view == a.this.bZV) && a.this.fos != null && a.this.fos.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(a.this.mContext.getPageActivity(), a.this.fos.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new am("c13416").bT("fid", a.this.fos.getForum().getId()));
            }
        }
    };
    private boolean fwE;
    private boolean fwL;
    private TbPageContext mContext;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.mContext = frsSportsRecommendFragment.getPageContext();
            this.caS = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fJd = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fJe = (BarImageView) view.findViewById(R.id.frs_image);
            this.bZV = (TextView) view.findViewById(R.id.forum_name);
            this.caS.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJe.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fJe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fJe.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fJe.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fJe.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fos = frsViewData;
            this.fwL = false;
            String name = this.fos.getForum().getName();
            if (ap.nP(name) > 20) {
                name = ap.k(name, 20, "...");
            }
            this.bZV.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fJe.startLoad(this.fos.getForum().getImage_url(), 10, false);
            bpw();
            this.fJe.setOnClickListener(this.fqZ);
            this.bZV.setOnClickListener(this.fqZ);
        }
    }

    public void v(String str, String str2, boolean z) {
        this.fJe.refresh();
        if (ap.isEmpty(str)) {
            this.fwL = false;
            bpw();
            return;
        }
        this.fwL = true;
        this.fJf = str2;
        this.fwE = z;
        this.caS.startLoad(str, 10, false);
        this.caS.setOnClickListener(this.fqZ);
    }

    private void bpw() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fos != null && this.fos.getForum() != null && (themeColorInfo = this.fos.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fwL) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fJd != null) {
                    this.fJd.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fJd.changeSkinType(skinType);
                }
                if (this.caS != null) {
                    this.caS.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bpw();
        al.j(this.bZV, R.color.cp_btn_a);
        if (this.fJe != null) {
            this.fJe.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fJe.setBorderColor(al.getColor(R.color.black_alpha15));
            this.fJe.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fJe.invalidate();
        }
    }
}
