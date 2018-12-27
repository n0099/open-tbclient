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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
    View.OnClickListener cts;
    private RelativeLayout dVe;
    private LinearLayout dVf;
    private TbImageView dVg;
    private TextView dVh;
    private TextView dVi;
    private TextView dVj;
    private TextView dVk;
    private View dVl;
    private TextView dVm;
    private ImageView dVn;
    private View dVo;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(c.this.mContext.getPageActivity()) && l.ll()) {
                    if (view2 == c.this.dVe) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.Bn())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Ef().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.Bn()});
                        }
                    } else if (view2 == c.this.dVf && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.Bu())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Ef().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.Bu()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dVe = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dVf = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dVg = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dVg.setPageId(bdUniqueId);
        this.dVh = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dVi = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dVj = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dVk = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dVl = view.findViewById(e.g.u9_top_code_divider);
        this.dVn = (ImageView) view.findViewById(e.g.news_info_img);
        this.dVn.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dVm = (TextView) view.findViewById(e.g.news_info_text);
        this.dVo = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dVk, e.f.frs_star_btn_like);
        al.h(this.dVk, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bDE = vVar.bDE();
            bg bDF = vVar.bDF();
            this.top_code = bDE;
            this.news_info = bDF;
            if (vVar.aLi()) {
                this.dVo.setVisibility(0);
            } else {
                this.dVo.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dVe.setVisibility(8);
                this.dVl.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dVe.setVisibility(8);
                this.dVl.setVisibility(8);
            } else {
                this.dVe.setVisibility(0);
                this.dVl.setVisibility(0);
                this.dVg.startLoad(this.top_code.ys(), 10, false);
                this.dVh.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bDE.Br())) {
                    this.dVk.setVisibility(8);
                } else {
                    this.dVk.setText(bDE.Br());
                    this.dVk.setVisibility(0);
                }
                int Bo = this.top_code.Bo();
                if (Bo == 1 || Bo == 2) {
                    if (StringUtils.isNull(this.top_code.Bp())) {
                        this.dVi.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Bp();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.Bp(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dVi.setText(spannableString);
                        this.dVi.setVisibility(0);
                    }
                    if (bDE.Bq() <= 0) {
                        this.dVj.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Bq();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Bq()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dVj.setText(spannableString2);
                        this.dVj.setVisibility(0);
                    }
                } else {
                    this.dVj.setVisibility(8);
                    this.dVi.setText(bDE.getSubTitle());
                    this.dVi.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bDF.getSummary())) {
                this.dVf.setVisibility(8);
                return;
            }
            this.dVf.setVisibility(0);
            this.dVm.setText(bDF.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dVe.setOnClickListener(this.cts);
        this.dVf.setOnClickListener(this.cts);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dVn, e.f.icon_frs_news);
            al.i(this.dVk, e.f.frs_star_btn_like);
            al.h(this.dVk, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
