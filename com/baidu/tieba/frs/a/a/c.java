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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener dWR;
    private RelativeLayout fFh;
    private LinearLayout fFi;
    private TbImageView fFj;
    private TextView fFk;
    private TextView fFl;
    private TextView fFm;
    private TextView fFn;
    private View fFo;
    private TextView fFp;
    private ImageView fFq;
    private View fFr;
    private TbPageContext mContext;
    private int mSkinType;
    private bm news_info;
    private bj top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(c.this.mContext.getPageActivity()) && l.kt()) {
                    if (view2 == c.this.fFh) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.agt())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bb.ajE().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.agt()});
                        }
                    } else if (view2 == c.this.fFi && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.agA())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bb.ajE().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.agA()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fFh = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fFi = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fFj = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fFj.setPageId(bdUniqueId);
        this.fFk = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fFl = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fFm = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fFn = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fFo = view.findViewById(R.id.u9_top_code_divider);
        this.fFq = (ImageView) view.findViewById(R.id.news_info_img);
        this.fFq.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.fFp = (TextView) view.findViewById(R.id.news_info_text);
        this.fFr = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.k(this.fFn, R.drawable.frs_star_btn_like);
        am.j(this.fFn, R.drawable.frs_text_color_selector);
        bpG();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bj cpg = xVar.cpg();
            bm cph = xVar.cph();
            this.top_code = cpg;
            this.news_info = cph;
            if (xVar.bvu()) {
                this.fFr.setVisibility(0);
            } else {
                this.fFr.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fFh.setVisibility(8);
                this.fFo.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fFh.setVisibility(8);
                this.fFo.setVisibility(8);
            } else {
                this.fFh.setVisibility(0);
                this.fFo.setVisibility(0);
                this.fFj.startLoad(this.top_code.acV(), 10, false);
                this.fFk.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cpg.agx())) {
                    this.fFn.setVisibility(8);
                } else {
                    this.fFn.setText(cpg.agx());
                    this.fFn.setVisibility(0);
                }
                int agu = this.top_code.agu();
                if (agu == 1 || agu == 2) {
                    if (StringUtils.isNull(this.top_code.agv())) {
                        this.fFl.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(R.string.u9_shengyu) + this.top_code.agv();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.agv(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fFl.setText(spannableString);
                        this.fFl.setVisibility(0);
                    }
                    if (cpg.agw() <= 0) {
                        this.fFm.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(R.string.u9_worth) + this.top_code.agw();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.agw()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fFm.setText(spannableString2);
                        this.fFm.setVisibility(0);
                    }
                } else {
                    this.fFm.setVisibility(8);
                    this.fFl.setText(cpg.getSubTitle());
                    this.fFl.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cph.getSummary())) {
                this.fFi.setVisibility(8);
                return;
            }
            this.fFi.setVisibility(0);
            this.fFp.setText(cph.getSummary());
        }
    }

    public void bpG() {
        this.fFh.setOnClickListener(this.dWR);
        this.fFi.setOnClickListener(this.dWR);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fFq, R.drawable.icon_frs_news);
            am.k(this.fFn, R.drawable.frs_star_btn_like);
            am.j(this.fFn, R.drawable.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
