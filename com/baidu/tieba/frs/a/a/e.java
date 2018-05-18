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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes3.dex */
public class e extends q.a {
    View.OnClickListener bOY;
    private RelativeLayout dgO;
    private LinearLayout dgP;
    private TbImageView dgQ;
    private TextView dgR;
    private TextView dgS;
    private TextView dgT;
    private TextView dgU;
    private View dgV;
    private TextView dgW;
    private ImageView dgX;
    private View dgY;
    private TbPageContext mContext;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view2, BdUniqueId bdUniqueId) {
        super(view2);
        this.mSkinType = 3;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(e.this.mContext.getPageActivity()) && l.hg()) {
                    if (view3 == e.this.dgO) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.tj())) {
                            TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ax.wf().c((TbPageContext) i.ab(e.this.mContext.getPageActivity()), new String[]{e.this.top_code.tj()});
                        }
                    } else if (view3 == e.this.dgP && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.tr())) {
                        TiebaStatic.eventStat(e.this.mContext.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ax.wf().c((TbPageContext) i.ab(e.this.mContext.getPageActivity()), new String[]{e.this.news_info.tr()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dgO = (RelativeLayout) view2.findViewById(d.g.u9_top_code);
        this.dgP = (LinearLayout) view2.findViewById(d.g.u9_news_info);
        this.dgQ = (TbImageView) view2.findViewById(d.g.top_code_img);
        this.dgQ.setPageId(bdUniqueId);
        this.dgR = (TextView) view2.findViewById(d.g.top_code_detail_summary_text);
        this.dgS = (TextView) view2.findViewById(d.g.top_code_detail_surplus_text);
        this.dgT = (TextView) view2.findViewById(d.g.top_code_detail_giftworth_text);
        this.dgU = (TextView) view2.findViewById(d.g.top_code_getnum_btn);
        this.dgV = view2.findViewById(d.g.u9_top_code_divider);
        this.dgX = (ImageView) view2.findViewById(d.g.news_info_img);
        this.dgX.setBackgroundDrawable(ak.getDrawable(d.f.icon_frs_news));
        this.dgW = (TextView) view2.findViewById(d.g.news_info_text);
        this.dgY = view2.findViewById(d.g.frs_list_item_u9_top_line);
        ak.i(this.dgU, d.f.frs_star_btn_like);
        ak.h(this.dgU, d.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bf bru = vVar.bru();
            bi brv = vVar.brv();
            this.top_code = bru;
            this.news_info = brv;
            if (vVar.brt()) {
                this.dgY.setVisibility(0);
            } else {
                this.dgY.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dgO.setVisibility(8);
                this.dgV.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dgO.setVisibility(8);
                this.dgV.setVisibility(8);
            } else {
                this.dgO.setVisibility(0);
                this.dgV.setVisibility(0);
                this.dgQ.startLoad(this.top_code.qF(), 10, false);
                this.dgR.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bru.tn())) {
                    this.dgU.setVisibility(8);
                } else {
                    this.dgU.setText(bru.tn());
                    this.dgU.setVisibility(0);
                }
                int tk = this.top_code.tk();
                if (tk == 1 || tk == 2) {
                    if (StringUtils.isNull(this.top_code.tl())) {
                        this.dgS.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.tl();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.tl(), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                        this.dgS.setText(spannableString);
                        this.dgS.setVisibility(0);
                    }
                    if (bru.tm() <= 0) {
                        this.dgT.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.tm();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tm()), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                        this.dgT.setText(spannableString2);
                        this.dgT.setVisibility(0);
                    }
                } else {
                    this.dgT.setVisibility(8);
                    this.dgS.setText(bru.getSubTitle());
                    this.dgS.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(brv.getSummary())) {
                this.dgP.setVisibility(8);
                return;
            }
            this.dgP.setVisibility(0);
            this.dgW.setText(brv.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dgO.setOnClickListener(this.bOY);
        this.dgP.setOnClickListener(this.bOY);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.i(this.dgX, d.f.icon_frs_news);
            ak.i(this.dgU, d.f.frs_star_btn_like);
            ak.h(this.dgU, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().u(getView());
            this.mSkinType = i;
        }
    }
}
