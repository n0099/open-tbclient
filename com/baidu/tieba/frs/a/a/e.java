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
import com.baidu.tieba.tbadkCore.w;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes3.dex */
public class e extends r.a {
    private TbPageContext aRI;
    View.OnClickListener cxY;
    private RelativeLayout dNd;
    private LinearLayout dNe;
    private TbImageView dNf;
    private TextView dNg;
    private TextView dNh;
    private TextView dNi;
    private TextView dNj;
    private View dNk;
    private TextView dNl;
    private ImageView dNm;
    private View dNn;
    private int mSkinType;
    private bi news_info;
    private bf top_code;

    public e(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(e.this.aRI.getPageActivity()) && l.pa()) {
                    if (view2 == e.this.dNd) {
                        if (e.this.top_code != null && !TextUtils.isEmpty(e.this.top_code.AD())) {
                            TiebaStatic.eventStat(e.this.aRI.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            aw.Du().c((TbPageContext) i.ak(e.this.aRI.getPageActivity()), new String[]{e.this.top_code.AD()});
                        }
                    } else if (view2 == e.this.dNe && e.this.news_info != null && !TextUtils.isEmpty(e.this.news_info.AK())) {
                        TiebaStatic.eventStat(e.this.aRI.getPageActivity(), "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        aw.Du().c((TbPageContext) i.ak(e.this.aRI.getPageActivity()), new String[]{e.this.news_info.AK()});
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        this.dNd = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dNe = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dNf = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dNf.setPageId(bdUniqueId);
        this.dNg = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dNh = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dNi = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dNj = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dNk = view.findViewById(d.g.u9_top_code_divider);
        this.dNm = (ImageView) view.findViewById(d.g.news_info_img);
        this.dNm.setBackgroundDrawable(aj.getDrawable(d.f.icon_frs_news));
        this.dNl = (TextView) view.findViewById(d.g.news_info_text);
        this.dNn = view.findViewById(d.g.frs_list_item_u9_top_line);
        aj.s(this.dNj, d.f.frs_star_btn_like);
        aj.r(this.dNj, d.f.frs_text_color_selector);
        axP();
    }

    public void a(w wVar) {
        if (wVar != null) {
            bf bww = wVar.bww();
            bi bwx = wVar.bwx();
            this.top_code = bww;
            this.news_info = bwx;
            if (wVar.bwv()) {
                this.dNn.setVisibility(0);
            } else {
                this.dNn.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dNd.setVisibility(8);
                this.dNk.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dNd.setVisibility(8);
                this.dNk.setVisibility(8);
            } else {
                this.dNd.setVisibility(0);
                this.dNk.setVisibility(0);
                this.dNf.startLoad(this.top_code.ya(), 10, false);
                this.dNg.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bww.AH())) {
                    this.dNj.setVisibility(8);
                } else {
                    this.dNj.setText(bww.AH());
                    this.dNj.setVisibility(0);
                }
                int AE = this.top_code.AE();
                if (AE == 1 || AE == 2) {
                    if (StringUtils.isNull(this.top_code.AF())) {
                        this.dNh.setVisibility(8);
                    } else {
                        String str = this.aRI.getResources().getString(d.j.u9_shengyu) + this.top_code.AF();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.AF(), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_d)));
                        this.dNh.setText(spannableString);
                        this.dNh.setVisibility(0);
                    }
                    if (bww.AG() <= 0) {
                        this.dNi.setVisibility(8);
                    } else {
                        String str2 = this.aRI.getResources().getString(d.j.u9_worth) + this.top_code.AG();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.AG()), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_d)));
                        this.dNi.setText(spannableString2);
                        this.dNi.setVisibility(0);
                    }
                } else {
                    this.dNi.setVisibility(8);
                    this.dNh.setText(bww.getSubTitle());
                    this.dNh.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bwx.getSummary())) {
                this.dNe.setVisibility(8);
                return;
            }
            this.dNe.setVisibility(0);
            this.dNl.setText(bwx.getSummary());
        }
    }

    public void axP() {
        this.dNd.setOnClickListener(this.cxY);
        this.dNe.setOnClickListener(this.cxY);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.s(this.dNm, d.f.icon_frs_news);
            aj.s(this.dNj, d.f.frs_star_btn_like);
            aj.r(this.dNj, d.f.frs_text_color_selector);
            this.aRI.getLayoutMode().aQ(i == 1);
            this.aRI.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }
}
