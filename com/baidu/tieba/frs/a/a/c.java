package com.baidu.tieba.frs.a.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener dYB;
    private RelativeLayout fGW;
    private LinearLayout fGX;
    private TbImageView fGY;
    private TextView fGZ;
    private TextView fHa;
    private TextView fHb;
    private TextView fHc;
    private View fHd;
    private TextView fHe;
    private ImageView fHf;
    private View fHg;
    private TbPageContext mContext;
    private int mSkinType;
    private bm news_info;
    private bj top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cF(c.this.mContext.getPageActivity()) && l.kt()) {
                    if (view2 == c.this.fGW) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.agx())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.ajK().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.agx()});
                        }
                    } else if (view2 == c.this.fGX && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.agE())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.ajK().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.agE()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fGW = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fGX = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fGY = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fGY.setPageId(bdUniqueId);
        this.fGZ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fHa = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fHb = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fHc = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fHd = view.findViewById(R.id.u9_top_code_divider);
        this.fHf = (ImageView) view.findViewById(R.id.news_info_img);
        this.fHf.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.fHe = (TextView) view.findViewById(R.id.news_info_text);
        this.fHg = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.k(this.fHc, R.drawable.frs_star_btn_like);
        am.j(this.fHc, R.drawable.frs_text_color_selector);
        bqs();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bj cpU = xVar.cpU();
            bm cpV = xVar.cpV();
            this.top_code = cpU;
            this.news_info = cpV;
            if (xVar.bwi()) {
                this.fHg.setVisibility(0);
            } else {
                this.fHg.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fGW.setVisibility(8);
                this.fHd.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fGW.setVisibility(8);
                this.fHd.setVisibility(8);
            } else {
                this.fGW.setVisibility(0);
                this.fHd.setVisibility(0);
                this.fGY.startLoad(this.top_code.acZ(), 10, false);
                this.fGZ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cpU.agB())) {
                    this.fHc.setVisibility(8);
                } else {
                    this.fHc.setText(cpU.agB());
                    this.fHc.setVisibility(0);
                }
                int agy = this.top_code.agy();
                if (agy == 1 || agy == 2) {
                    if (StringUtils.isNull(this.top_code.agz())) {
                        this.fHa.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(R.string.u9_shengyu) + this.top_code.agz();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.agz(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fHa.setText(spannableString);
                        this.fHa.setVisibility(0);
                    }
                    if (cpU.agA() <= 0) {
                        this.fHb.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(R.string.u9_worth) + this.top_code.agA();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.agA()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fHb.setText(spannableString2);
                        this.fHb.setVisibility(0);
                    }
                } else {
                    this.fHb.setVisibility(8);
                    this.fHa.setText(cpU.getSubTitle());
                    this.fHa.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cpV.getSummary())) {
                this.fGX.setVisibility(8);
                return;
            }
            this.fGX.setVisibility(0);
            this.fHe.setText(cpV.getSummary());
        }
    }

    public void bqs() {
        this.fGW.setOnClickListener(this.dYB);
        this.fGX.setOnClickListener(this.dYB);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fHf, R.drawable.icon_frs_news);
            am.k(this.fHc, R.drawable.frs_star_btn_like);
            am.j(this.fHc, R.drawable.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
