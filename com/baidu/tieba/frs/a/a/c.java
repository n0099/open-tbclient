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
    View.OnClickListener dIp;
    private RelativeLayout fiZ;
    private LinearLayout fja;
    private TbImageView fjb;
    private TextView fjc;
    private TextView fjd;
    private TextView fje;
    private TextView fjf;
    private View fjg;
    private TextView fjh;
    private ImageView fji;
    private View fjj;
    private TbPageContext mContext;
    private int mSkinType;
    private bl news_info;
    private bi top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(c.this.mContext.getPageActivity()) && l.lo()) {
                    if (view2 == c.this.fiZ) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aaF())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.adA().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.aaF()});
                        }
                    } else if (view2 == c.this.fja && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aaM())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.adA().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.aaM()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fiZ = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.fja = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.fjb = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fjb.setPageId(bdUniqueId);
        this.fjc = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fjd = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.fje = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.fjf = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.fjg = view.findViewById(d.g.u9_top_code_divider);
        this.fji = (ImageView) view.findViewById(d.g.news_info_img);
        this.fji.setBackgroundDrawable(al.getDrawable(d.f.icon_frs_news));
        this.fjh = (TextView) view.findViewById(d.g.news_info_text);
        this.fjj = view.findViewById(d.g.frs_list_item_u9_top_line);
        al.k(this.fjf, d.f.frs_star_btn_like);
        al.j(this.fjf, d.f.frs_text_color_selector);
        bfW();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            bi cdK = vVar.cdK();
            bl cdL = vVar.cdL();
            this.top_code = cdK;
            this.news_info = cdL;
            if (vVar.blF()) {
                this.fjj.setVisibility(0);
            } else {
                this.fjj.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fiZ.setVisibility(8);
                this.fjg.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fiZ.setVisibility(8);
                this.fjg.setVisibility(8);
            } else {
                this.fiZ.setVisibility(0);
                this.fjg.setVisibility(0);
                this.fjb.startLoad(this.top_code.Xk(), 10, false);
                this.fjc.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cdK.aaJ())) {
                    this.fjf.setVisibility(8);
                } else {
                    this.fjf.setText(cdK.aaJ());
                    this.fjf.setVisibility(0);
                }
                int aaG = this.top_code.aaG();
                if (aaG == 1 || aaG == 2) {
                    if (StringUtils.isNull(this.top_code.aaH())) {
                        this.fjd.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.j.u9_shengyu) + this.top_code.aaH();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aaH(), new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)));
                        this.fjd.setText(spannableString);
                        this.fjd.setVisibility(0);
                    }
                    if (cdK.aaI() <= 0) {
                        this.fje.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.j.u9_worth) + this.top_code.aaI();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aaI()), new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_d)));
                        this.fje.setText(spannableString2);
                        this.fje.setVisibility(0);
                    }
                } else {
                    this.fje.setVisibility(8);
                    this.fjd.setText(cdK.getSubTitle());
                    this.fjd.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cdL.getSummary())) {
                this.fja.setVisibility(8);
                return;
            }
            this.fja.setVisibility(0);
            this.fjh.setText(cdL.getSummary());
        }
    }

    public void bfW() {
        this.fiZ.setOnClickListener(this.dIp);
        this.fja.setOnClickListener(this.dIp);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fji, d.f.icon_frs_news);
            al.k(this.fjf, d.f.frs_star_btn_like);
            al.j(this.fjf, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
