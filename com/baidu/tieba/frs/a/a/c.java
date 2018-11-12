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
    View.OnClickListener coU;
    private RelativeLayout dLK;
    private LinearLayout dLL;
    private TbImageView dLM;
    private TextView dLN;
    private TextView dLO;
    private TextView dLP;
    private TextView dLQ;
    private View dLR;
    private TextView dLS;
    private ImageView dLT;
    private View dLU;
    private TbPageContext mContext;
    private int mSkinType;
    private bg news_info;
    private bd top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bG(c.this.mContext.getPageActivity()) && l.lm()) {
                    if (view2 == c.this.dLK) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.Aj())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Db().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.Aj()});
                        }
                    } else if (view2 == c.this.dLL && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.Aq())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Db().c((TbPageContext) i.aK(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.Aq()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.dLK = (RelativeLayout) view.findViewById(e.g.u9_top_code);
        this.dLL = (LinearLayout) view.findViewById(e.g.u9_news_info);
        this.dLM = (TbImageView) view.findViewById(e.g.top_code_img);
        this.dLM.setPageId(bdUniqueId);
        this.dLN = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.dLO = (TextView) view.findViewById(e.g.top_code_detail_surplus_text);
        this.dLP = (TextView) view.findViewById(e.g.top_code_detail_giftworth_text);
        this.dLQ = (TextView) view.findViewById(e.g.top_code_getnum_btn);
        this.dLR = view.findViewById(e.g.u9_top_code_divider);
        this.dLT = (ImageView) view.findViewById(e.g.news_info_img);
        this.dLT.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dLS = (TextView) view.findViewById(e.g.news_info_text);
        this.dLU = view.findViewById(e.g.frs_list_item_u9_top_line);
        al.i(this.dLQ, e.f.frs_star_btn_like);
        al.h(this.dLQ, e.f.frs_text_color_selector);
        setOnClickListener();
    }

    public void a(v vVar) {
        if (vVar != null) {
            bd bAS = vVar.bAS();
            bg bAT = vVar.bAT();
            this.top_code = bAS;
            this.news_info = bAT;
            if (vVar.aIC()) {
                this.dLU.setVisibility(0);
            } else {
                this.dLU.setVisibility(8);
            }
            if (this.top_code == null) {
                this.dLK.setVisibility(8);
                this.dLR.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.dLK.setVisibility(8);
                this.dLR.setVisibility(8);
            } else {
                this.dLK.setVisibility(0);
                this.dLR.setVisibility(0);
                this.dLM.startLoad(this.top_code.xn(), 10, false);
                this.dLN.setText(this.top_code.getSummary());
                if (StringUtils.isNull(bAS.An())) {
                    this.dLQ.setVisibility(8);
                } else {
                    this.dLQ.setText(bAS.An());
                    this.dLQ.setVisibility(0);
                }
                int Ak = this.top_code.Ak();
                if (Ak == 1 || Ak == 2) {
                    if (StringUtils.isNull(this.top_code.Al())) {
                        this.dLO.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Al();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.Al(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dLO.setText(spannableString);
                        this.dLO.setVisibility(0);
                    }
                    if (bAS.Am() <= 0) {
                        this.dLP.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Am();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Am()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                        this.dLP.setText(spannableString2);
                        this.dLP.setVisibility(0);
                    }
                } else {
                    this.dLP.setVisibility(8);
                    this.dLO.setText(bAS.getSubTitle());
                    this.dLO.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(bAT.getSummary())) {
                this.dLL.setVisibility(8);
                return;
            }
            this.dLL.setVisibility(0);
            this.dLS.setText(bAT.getSummary());
        }
    }

    public void setOnClickListener() {
        this.dLK.setOnClickListener(this.coU);
        this.dLL.setOnClickListener(this.coU);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.i(this.dLT, e.f.icon_frs_news);
            al.i(this.dLQ, e.f.frs_star_btn_like);
            al.h(this.dLQ, e.f.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
