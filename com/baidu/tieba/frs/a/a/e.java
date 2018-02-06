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
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes3.dex */
public class e extends r.a {
    private TbPageContext aRR;
    View.OnClickListener cyh;
    private RelativeLayout dNk;
    private LinearLayout dNl;
    private TbImageView dNm;
    private TextView dNn;
    private TextView dNo;
    private TextView dNp;
    private TextView dNq;
    private View dNr;
    private TextView dNs;
    private ImageView dNt;
    private View dNu;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(e.this.aRR.getPageActivity()) && l.pa()) {
                    if (view2 == e.this.dNk) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.AC())) {
                            TiebaStatic.eventStat(e.this.aRR.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            aw.Du().c((TbPageContext) i.ak(e.this.aRR.getPageActivity()), new String[]{e.this.top_code.AC()});
                        }
                    } else if (view2 == e.this.dNl && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.AJ())) {
                        TiebaStatic.eventStat(e.this.aRR.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        aw.Du().c((TbPageContext) i.ak(e.this.aRR.getPageActivity()), new String[]{e.this.news_info.AJ()});
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.dNk = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dNl = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dNm = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dNm.setPageId(bdUniqueId);
        this.dNn = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dNo = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dNp = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dNq = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dNr = view.findViewById(d.g.u9_top_code_divider);
        this.dNt = (ImageView) view.findViewById(d.g.news_info_img);
        this.dNt.setBackgroundDrawable(aj.getDrawable(d.f.icon_frs_news));
        this.dNs = (TextView) view.findViewById(d.g.news_info_text);
        this.dNu = view.findViewById(d.g.frs_list_item_u9_top_line);
        aj.s(this.dNq, d.f.frs_star_btn_like);
        aj.r(this.dNq, d.f.frs_text_color_selector);
        axO();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bf bws = vVar.bws();
            bi bwt = vVar.bwt();
            this.top_code = bws;
            this.news_info = bwt;
            if (vVar.bwr()) {
                this.dNu.setVisibility(0);
            } else {
                this.dNu.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dNk.setVisibility(8);
                this.dNr.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dNk.setVisibility(8);
                this.dNr.setVisibility(8);
            } else {
                this.dNk.setVisibility(0);
                this.dNr.setVisibility(0);
                this.dNm.startLoad(this.top_code.ya(), 10, false);
                this.dNn.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bws.AG())) {
                    this.dNq.setVisibility(8);
                } else {
                    this.dNq.setText(bws.AG());
                    this.dNq.setVisibility(0);
                }
                int AD = this.top_code.AD();
                if (AD == 1 || AD == 2) {
                    if (StringUtils.isNull(this.top_code.AE())) {
                        this.dNo.setVisibility(8);
                    } else {
                        String str = this.aRR.getResources().getString(d.j.u9_shengyu) + this.top_code.AE();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.AE(), new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_d)));
                        this.dNo.setText(spannableString);
                        this.dNo.setVisibility(0);
                    }
                    if (bws.AF() <= 0) {
                        this.dNp.setVisibility(8);
                    } else {
                        String str2 = this.aRR.getResources().getString(d.j.u9_worth) + this.top_code.AF();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.AF()), new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_d)));
                        this.dNp.setText(spannableString2);
                        this.dNp.setVisibility(0);
                    }
                } else {
                    this.dNp.setVisibility(8);
                    this.dNo.setText(bws.getSubTitle());
                    this.dNo.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bwt.getSummary())) {
                this.dNl.setVisibility(8);
                return;
            }
            this.dNl.setVisibility(0);
            this.dNs.setText(bwt.getSummary());
        }
    }

    public void axO() {
        this.dNk.setOnClickListener(this.cyh);
        this.dNl.setOnClickListener(this.cyh);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dNt, d.f.icon_frs_news);
            aj.s(this.dNq, d.f.frs_star_btn_like);
            aj.r(this.dNq, d.f.frs_text_color_selector);
            this.aRR.getLayoutMode().aQ(i == 1);
            this.aRR.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }
}
