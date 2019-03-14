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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener dIW;
    private RelativeLayout fjn;
    private LinearLayout fjo;
    private TbImageView fjp;
    private TextView fjq;
    private TextView fjr;
    private TextView fjs;
    private TextView fjt;
    private View fju;
    private TextView fjv;
    private ImageView fjw;
    private View fjx;
    private TbPageContext mContext;
    private int mSkinType;
    private bl news_info;
    private bi top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(c.this.mContext.getPageActivity()) && l.lo()) {
                    if (view2 == c.this.fjn) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aaI())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.adD().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.aaI()});
                        }
                    } else if (view2 == c.this.fjo && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aaP())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.adD().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.aaP()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fjn = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.fjo = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.fjp = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fjp.setPageId(bdUniqueId);
        this.fjq = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fjr = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.fjs = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.fjt = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.fju = view.findViewById(d.g.u9_top_code_divider);
        this.fjw = (ImageView) view.findViewById(d.g.news_info_img);
        this.fjw.setBackgroundDrawable(al.getDrawable(d.f.icon_frs_news));
        this.fjv = (TextView) view.findViewById(d.g.news_info_text);
        this.fjx = view.findViewById(d.g.frs_list_item_u9_top_line);
        al.k(this.fjt, d.f.frs_star_btn_like);
        al.j(this.fjt, d.f.frs_text_color_selector);
        bfY();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            bi cdO = vVar.cdO();
            bl cdP = vVar.cdP();
            this.top_code = cdO;
            this.news_info = cdP;
            if (vVar.blI()) {
                this.fjx.setVisibility(0);
            } else {
                this.fjx.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fjn.setVisibility(8);
                this.fju.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fjn.setVisibility(8);
                this.fju.setVisibility(8);
            } else {
                this.fjn.setVisibility(0);
                this.fju.setVisibility(0);
                this.fjp.startLoad(this.top_code.Xn(), 10, false);
                this.fjq.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cdO.aaM())) {
                    this.fjt.setVisibility(8);
                } else {
                    this.fjt.setText(cdO.aaM());
                    this.fjt.setVisibility(0);
                }
                int aaJ = this.top_code.aaJ();
                if (aaJ == 1 || aaJ == 2) {
                    if (StringUtils.isNull(this.top_code.aaK())) {
                        this.fjr.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.j.u9_shengyu) + this.top_code.aaK();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aaK(), new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)));
                        this.fjr.setText(spannableString);
                        this.fjr.setVisibility(0);
                    }
                    if (cdO.aaL() <= 0) {
                        this.fjs.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.j.u9_worth) + this.top_code.aaL();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aaL()), new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)));
                        this.fjs.setText(spannableString2);
                        this.fjs.setVisibility(0);
                    }
                } else {
                    this.fjs.setVisibility(8);
                    this.fjr.setText(cdO.getSubTitle());
                    this.fjr.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cdP.getSummary())) {
                this.fjo.setVisibility(8);
                return;
            }
            this.fjo.setVisibility(0);
            this.fjv.setText(cdP.getSummary());
        }
    }

    public void bfY() {
        this.fjn.setOnClickListener(this.dIW);
        this.fjo.setOnClickListener(this.dIW);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fjw, d.f.icon_frs_news);
            al.k(this.fjt, d.f.frs_star_btn_like);
            al.j(this.fjt, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
