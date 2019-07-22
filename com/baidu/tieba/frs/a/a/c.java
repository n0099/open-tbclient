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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener dWK;
    private View fEA;
    private TextView fEB;
    private ImageView fEC;
    private View fED;
    private RelativeLayout fEt;
    private LinearLayout fEu;
    private TbImageView fEv;
    private TextView fEw;
    private TextView fEx;
    private TextView fEy;
    private TextView fEz;
    private TbPageContext mContext;
    private int mSkinType;
    private bl news_info;
    private bi top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(c.this.mContext.getPageActivity()) && l.kt()) {
                    if (view2 == c.this.fEt) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.agr())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bb.ajC().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.agr()});
                        }
                    } else if (view2 == c.this.fEu && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.agy())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bb.ajC().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.agy()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fEt = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fEu = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fEv = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fEv.setPageId(bdUniqueId);
        this.fEw = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fEx = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fEy = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fEz = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fEA = view.findViewById(R.id.u9_top_code_divider);
        this.fEC = (ImageView) view.findViewById(R.id.news_info_img);
        this.fEC.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.fEB = (TextView) view.findViewById(R.id.news_info_text);
        this.fED = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.k(this.fEz, R.drawable.frs_star_btn_like);
        am.j(this.fEz, R.drawable.frs_text_color_selector);
        bpt();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            bi coK = vVar.coK();
            bl coL = vVar.coL();
            this.top_code = coK;
            this.news_info = coL;
            if (vVar.bvh()) {
                this.fED.setVisibility(0);
            } else {
                this.fED.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fEt.setVisibility(8);
                this.fEA.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fEt.setVisibility(8);
                this.fEA.setVisibility(8);
            } else {
                this.fEt.setVisibility(0);
                this.fEA.setVisibility(0);
                this.fEv.startLoad(this.top_code.acU(), 10, false);
                this.fEw.setText(this.top_code.getSummary());
                if (StringUtils.isNull(coK.agv())) {
                    this.fEz.setVisibility(8);
                } else {
                    this.fEz.setText(coK.agv());
                    this.fEz.setVisibility(0);
                }
                int ags = this.top_code.ags();
                if (ags == 1 || ags == 2) {
                    if (StringUtils.isNull(this.top_code.agt())) {
                        this.fEx.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(R.string.u9_shengyu) + this.top_code.agt();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.agt(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fEx.setText(spannableString);
                        this.fEx.setVisibility(0);
                    }
                    if (coK.agu() <= 0) {
                        this.fEy.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(R.string.u9_worth) + this.top_code.agu();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.agu()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fEy.setText(spannableString2);
                        this.fEy.setVisibility(0);
                    }
                } else {
                    this.fEy.setVisibility(8);
                    this.fEx.setText(coK.getSubTitle());
                    this.fEx.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(coL.getSummary())) {
                this.fEu.setVisibility(8);
                return;
            }
            this.fEu.setVisibility(0);
            this.fEB.setText(coL.getSummary());
        }
    }

    public void bpt() {
        this.fEt.setOnClickListener(this.dWK);
        this.fEu.setOnClickListener(this.dWK);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.k(this.fEC, R.drawable.icon_frs_news);
            am.k(this.fEz, R.drawable.frs_star_btn_like);
            am.j(this.fEz, R.drawable.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
