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
    View.OnClickListener cue;
    private RelativeLayout dVL;
    private LinearLayout dVM;
    private TbImageView dVN;
    private TextView dVO;
    private TextView dVP;
    private TextView dVQ;
    private TextView dVR;
    private View dVS;
    private TextView dVT;
    private ImageView dVU;
    private View dVV;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(c.this.mContext.getPageActivity()) && l.ll()) {
                    if (view2 == c.this.dVL) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.BA())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Es().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.BA()});
                        }
                    } else if (view2 == c.this.dVM && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.BH())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Es().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.BH()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dVL = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dVM = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dVN = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dVN.setPageId(bdUniqueId);
        this.dVO = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dVP = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dVQ = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dVR = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dVS = view.findViewById(e.g.u9_top_code_divider);
        this.dVU = (ImageView) view.findViewById(e.g.news_info_img);
        this.dVU.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dVT = (TextView) view.findViewById(e.g.news_info_text);
        this.dVV = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dVR, e.f.frs_star_btn_like);
        al.h(this.dVR, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bEn = vVar.bEn();
            bg bEo = vVar.bEo();
            this.top_code = bEn;
            this.news_info = bEo;
            if (vVar.aLG()) {
                this.dVV.setVisibility(0);
            } else {
                this.dVV.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dVL.setVisibility(8);
                this.dVS.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dVL.setVisibility(8);
                this.dVS.setVisibility(8);
            } else {
                this.dVL.setVisibility(0);
                this.dVS.setVisibility(0);
                this.dVN.startLoad(this.top_code.yF(), 10, false);
                this.dVO.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bEn.BE())) {
                    this.dVR.setVisibility(8);
                } else {
                    this.dVR.setText(bEn.BE());
                    this.dVR.setVisibility(0);
                }
                int BB = this.top_code.BB();
                if (BB == 1 || BB == 2) {
                    if (StringUtils.isNull(this.top_code.BC())) {
                        this.dVP.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.BC();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.BC(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dVP.setText(spannableString);
                        this.dVP.setVisibility(0);
                    }
                    if (bEn.BD() <= 0) {
                        this.dVQ.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.BD();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.BD()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dVQ.setText(spannableString2);
                        this.dVQ.setVisibility(0);
                    }
                } else {
                    this.dVQ.setVisibility(8);
                    this.dVP.setText(bEn.getSubTitle());
                    this.dVP.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bEo.getSummary())) {
                this.dVM.setVisibility(8);
                return;
            }
            this.dVM.setVisibility(0);
            this.dVT.setText(bEo.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dVL.setOnClickListener(this.cue);
        this.dVM.setOnClickListener(this.cue);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dVU, e.f.icon_frs_news);
            al.i(this.dVR, e.f.frs_star_btn_like);
            al.h(this.dVR, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
