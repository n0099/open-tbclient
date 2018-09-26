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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class c extends q.a {
    View.OnClickListener cgg;
    private RelativeLayout dCG;
    private LinearLayout dCH;
    private TbImageView dCI;
    private TextView dCJ;
    private TextView dCK;
    private TextView dCL;
    private TextView dCM;
    private View dCN;
    private TextView dCO;
    private ImageView dCP;
    private View dCQ;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bA(c.this.mContext.getPageActivity()) && l.lb()) {
                    if (view2 == c.this.dCG) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.xT())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ay.AN().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.xT()});
                        }
                    } else if (view2 == c.this.dCH && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.ya())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ay.AN().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.ya()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dCG = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dCH = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dCI = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dCI.setPageId(bdUniqueId);
        this.dCJ = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dCK = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dCL = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dCM = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dCN = view.findViewById(e.g.u9_top_code_divider);
        this.dCP = (ImageView) view.findViewById(e.g.news_info_img);
        this.dCP.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dCO = (TextView) view.findViewById(e.g.news_info_text);
        this.dCQ = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dCM, e.f.frs_star_btn_like);
        al.h(this.dCM, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd byh = vVar.byh();
            bg byi = vVar.byi();
            this.top_code = byh;
            this.news_info = byi;
            if (vVar.aFM()) {
                this.dCQ.setVisibility(0);
            } else {
                this.dCQ.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dCG.setVisibility(8);
                this.dCN.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dCG.setVisibility(8);
                this.dCN.setVisibility(8);
            } else {
                this.dCG.setVisibility(0);
                this.dCN.setVisibility(0);
                this.dCI.startLoad(this.top_code.uW(), 10, false);
                this.dCJ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(byh.xX())) {
                    this.dCM.setVisibility(8);
                } else {
                    this.dCM.setText(byh.xX());
                    this.dCM.setVisibility(0);
                }
                int xU = this.top_code.xU();
                if (xU == 1 || xU == 2) {
                    if (StringUtils.isNull(this.top_code.xV())) {
                        this.dCK.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.xV();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.xV(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dCK.setText(spannableString);
                        this.dCK.setVisibility(0);
                    }
                    if (byh.xW() <= 0) {
                        this.dCL.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.xW();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.xW()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dCL.setText(spannableString2);
                        this.dCL.setVisibility(0);
                    }
                } else {
                    this.dCL.setVisibility(8);
                    this.dCK.setText(byh.getSubTitle());
                    this.dCK.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(byi.getSummary())) {
                this.dCH.setVisibility(8);
                return;
            }
            this.dCH.setVisibility(0);
            this.dCO.setText(byi.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dCG.setOnClickListener(this.cgg);
        this.dCH.setOnClickListener(this.cgg);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dCP, e.f.icon_frs_news);
            al.i(this.dCM, e.f.frs_star_btn_like);
            al.h(this.dCM, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
