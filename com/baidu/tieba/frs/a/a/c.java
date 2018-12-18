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
    View.OnClickListener csN;
    private RelativeLayout dSn;
    private LinearLayout dSo;
    private TbImageView dSp;
    private TextView dSq;
    private TextView dSr;
    private TextView dSs;
    private TextView dSt;
    private View dSu;
    private TextView dSv;
    private ImageView dSw;
    private View dSx;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(c.this.mContext.getPageActivity()) && l.ll()) {
                    if (view2 == c.this.dSn) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.Bn())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Ef().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.Bn()});
                        }
                    } else if (view2 == c.this.dSo && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.Bu())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Ef().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.Bu()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dSn = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dSo = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dSp = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dSp.setPageId(bdUniqueId);
        this.dSq = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dSr = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dSs = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dSt = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dSu = view.findViewById(e.g.u9_top_code_divider);
        this.dSw = (ImageView) view.findViewById(e.g.news_info_img);
        this.dSw.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dSv = (TextView) view.findViewById(e.g.news_info_text);
        this.dSx = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dSt, e.f.frs_star_btn_like);
        al.h(this.dSt, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bCM = vVar.bCM();
            bg bCN = vVar.bCN();
            this.top_code = bCM;
            this.news_info = bCN;
            if (vVar.aKt()) {
                this.dSx.setVisibility(0);
            } else {
                this.dSx.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dSn.setVisibility(8);
                this.dSu.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dSn.setVisibility(8);
                this.dSu.setVisibility(8);
            } else {
                this.dSn.setVisibility(0);
                this.dSu.setVisibility(0);
                this.dSp.startLoad(this.top_code.ys(), 10, false);
                this.dSq.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bCM.Br())) {
                    this.dSt.setVisibility(8);
                } else {
                    this.dSt.setText(bCM.Br());
                    this.dSt.setVisibility(0);
                }
                int Bo = this.top_code.Bo();
                if (Bo == 1 || Bo == 2) {
                    if (StringUtils.isNull(this.top_code.Bp())) {
                        this.dSr.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Bp();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.Bp(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dSr.setText(spannableString);
                        this.dSr.setVisibility(0);
                    }
                    if (bCM.Bq() <= 0) {
                        this.dSs.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Bq();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Bq()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dSs.setText(spannableString2);
                        this.dSs.setVisibility(0);
                    }
                } else {
                    this.dSs.setVisibility(8);
                    this.dSr.setText(bCM.getSubTitle());
                    this.dSr.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bCN.getSummary())) {
                this.dSo.setVisibility(8);
                return;
            }
            this.dSo.setVisibility(0);
            this.dSv.setText(bCN.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dSn.setOnClickListener(this.csN);
        this.dSo.setOnClickListener(this.csN);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dSw, e.f.icon_frs_news);
            al.i(this.dSt, e.f.frs_star_btn_like);
            al.h(this.dSt, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
