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
    private TbPageContext aRG;
    View.OnClickListener cxV;
    private RelativeLayout dMY;
    private LinearLayout dMZ;
    private TbImageView dNa;
    private TextView dNb;
    private TextView dNc;
    private TextView dNd;
    private TextView dNe;
    private View dNf;
    private TextView dNg;
    private ImageView dNh;
    private View dNi;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(e.this.aRG.getPageActivity()) && l.pa()) {
                    if (view2 == e.this.dMY) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.AC())) {
                            TiebaStatic.eventStat(e.this.aRG.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            aw.Dt().c((TbPageContext) i.ak(e.this.aRG.getPageActivity()), new String[]{e.this.top_code.AC()});
                        }
                    } else if (view2 == e.this.dMZ && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.AJ())) {
                        TiebaStatic.eventStat(e.this.aRG.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        aw.Dt().c((TbPageContext) i.ak(e.this.aRG.getPageActivity()), new String[]{e.this.news_info.AJ()});
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        this.dMY = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dMZ = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dNa = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dNa.setPageId(bdUniqueId);
        this.dNb = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dNc = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dNd = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dNe = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dNf = view.findViewById(d.g.u9_top_code_divider);
        this.dNh = (ImageView) view.findViewById(d.g.news_info_img);
        this.dNh.setBackgroundDrawable(aj.getDrawable(d.f.icon_frs_news));
        this.dNg = (TextView) view.findViewById(d.g.news_info_text);
        this.dNi = view.findViewById(d.g.frs_list_item_u9_top_line);
        aj.s(this.dNe, d.f.frs_star_btn_like);
        aj.r(this.dNe, d.f.frs_text_color_selector);
        axN();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bf bwr = vVar.bwr();
            bi bws = vVar.bws();
            this.top_code = bwr;
            this.news_info = bws;
            if (vVar.bwq()) {
                this.dNi.setVisibility(0);
            } else {
                this.dNi.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dMY.setVisibility(8);
                this.dNf.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dMY.setVisibility(8);
                this.dNf.setVisibility(8);
            } else {
                this.dMY.setVisibility(0);
                this.dNf.setVisibility(0);
                this.dNa.startLoad(this.top_code.ya(), 10, false);
                this.dNb.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bwr.AG())) {
                    this.dNe.setVisibility(8);
                } else {
                    this.dNe.setText(bwr.AG());
                    this.dNe.setVisibility(0);
                }
                int AD = this.top_code.AD();
                if (AD == 1 || AD == 2) {
                    if (StringUtils.isNull(this.top_code.AE())) {
                        this.dNc.setVisibility(8);
                    } else {
                        String str = this.aRG.getResources().getString(d.j.u9_shengyu) + this.top_code.AE();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.AE(), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_d)));
                        this.dNc.setText(spannableString);
                        this.dNc.setVisibility(0);
                    }
                    if (bwr.AF() <= 0) {
                        this.dNd.setVisibility(8);
                    } else {
                        String str2 = this.aRG.getResources().getString(d.j.u9_worth) + this.top_code.AF();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.AF()), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_d)));
                        this.dNd.setText(spannableString2);
                        this.dNd.setVisibility(0);
                    }
                } else {
                    this.dNd.setVisibility(8);
                    this.dNc.setText(bwr.getSubTitle());
                    this.dNc.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bws.getSummary())) {
                this.dMZ.setVisibility(8);
                return;
            }
            this.dMZ.setVisibility(0);
            this.dNg.setText(bws.getSummary());
        }
    }

    public void axN() {
        this.dMY.setOnClickListener(this.cxV);
        this.dMZ.setOnClickListener(this.cxV);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dNh, d.f.icon_frs_news);
            aj.s(this.dNe, d.f.frs_star_btn_like);
            aj.r(this.dNe, d.f.frs_text_color_selector);
            this.aRG.getLayoutMode().aQ(i == 1);
            this.aRG.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }
}
