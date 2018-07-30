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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class c extends q.a {
    View.OnClickListener cas;
    private RelativeLayout dvZ;
    private LinearLayout dwa;
    private TbImageView dwb;
    private TextView dwc;
    private TextView dwd;
    private TextView dwe;
    private TextView dwf;
    private View dwg;
    private TextView dwh;
    private ImageView dwi;
    private View dwj;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aV(c.this.mContext.getPageActivity()) && l.jV()) {
                    if (view2 == c.this.dvZ) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.wN())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ay.zK().c((TbPageContext) i.ad(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.wN()});
                        }
                    } else if (view2 == c.this.dwa && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.wU())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ay.zK().c((TbPageContext) i.ad(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.wU()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dvZ = (RelativeLayout) view.findViewById(d.g.u9_top_code);
        this.dwa = (LinearLayout) view.findViewById(d.g.u9_news_info);
        this.dwb = (TbImageView) view.findViewById(d.g.top_code_img);
        this.dwb.setPageId(bdUniqueId);
        this.dwc = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.dwd = (TextView) view.findViewById(d.g.top_code_detail_surplus_text);
        this.dwe = (TextView) view.findViewById(d.g.top_code_detail_giftworth_text);
        this.dwf = (TextView) view.findViewById(d.g.top_code_getnum_btn);
        this.dwg = view.findViewById(d.g.u9_top_code_divider);
        this.dwi = (ImageView) view.findViewById(d.g.news_info_img);
        this.dwi.setBackgroundDrawable(am.getDrawable(d.f.icon_frs_news));
        this.dwh = (TextView) view.findViewById(d.g.news_info_text);
        this.dwj = view.findViewById(d.g.frs_list_item_u9_top_line);
        am.i(this.dwf, d.f.frs_star_btn_like);
        am.h(this.dwf, d.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bvA = vVar.bvA();
            bg bvB = vVar.bvB();
            this.top_code = bvA;
            this.news_info = bvB;
            if (vVar.aDC()) {
                this.dwj.setVisibility(0);
            } else {
                this.dwj.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dvZ.setVisibility(8);
                this.dwg.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dvZ.setVisibility(8);
                this.dwg.setVisibility(8);
            } else {
                this.dvZ.setVisibility(0);
                this.dwg.setVisibility(0);
                this.dwb.startLoad(this.top_code.tU(), 10, false);
                this.dwc.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bvA.wR())) {
                    this.dwf.setVisibility(8);
                } else {
                    this.dwf.setText(bvA.wR());
                    this.dwf.setVisibility(0);
                }
                int wO = this.top_code.wO();
                if (wO == 1 || wO == 2) {
                    if (StringUtils.isNull(this.top_code.wP())) {
                        this.dwd.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(d.j.u9_shengyu) + this.top_code.wP();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.wP(), new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_d)));
                        this.dwd.setText(spannableString);
                        this.dwd.setVisibility(0);
                    }
                    if (bvA.wQ() <= 0) {
                        this.dwe.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(d.j.u9_worth) + this.top_code.wQ();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wQ()), new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_d)));
                        this.dwe.setText(spannableString2);
                        this.dwe.setVisibility(0);
                    }
                } else {
                    this.dwe.setVisibility(8);
                    this.dwd.setText(bvA.getSubTitle());
                    this.dwd.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bvB.getSummary())) {
                this.dwa.setVisibility(8);
                return;
            }
            this.dwa.setVisibility(0);
            this.dwh.setText(bvB.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dvZ.setOnClickListener(this.cas);
        this.dwa.setOnClickListener(this.cas);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.i(this.dwi, d.f.icon_frs_news);
            am.i(this.dwf, d.f.frs_star_btn_like);
            am.h(this.dwf, d.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
