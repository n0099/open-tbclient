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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes9.dex */
public class c extends y.a {
    View.OnClickListener aOK;
    private TbPageContext duG;
    private RelativeLayout hjH;
    private LinearLayout hjI;
    private TbImageView hjJ;
    private TextView hjK;
    private TextView hjL;
    private TextView hjM;
    private TextView hjN;
    private View hjO;
    private TextView hjP;
    private ImageView hjQ;
    private View hjR;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.duG.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.hjH) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aMF())) {
                            TiebaStatic.eventStat(c.this.duG.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aOY().b((TbPageContext) i.T(c.this.duG.getPageActivity()), new String[]{c.this.top_code.aMF()});
                        }
                    } else if (view2 == c.this.hjI && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aMM())) {
                        TiebaStatic.eventStat(c.this.duG.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aOY().b((TbPageContext) i.T(c.this.duG.getPageActivity()), new String[]{c.this.news_info.aMM()});
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.hjH = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hjI = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hjJ = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hjJ.setPageId(bdUniqueId);
        this.hjK = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hjL = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hjM = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hjN = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hjO = view.findViewById(R.id.u9_top_code_divider);
        this.hjQ = (ImageView) view.findViewById(R.id.news_info_img);
        this.hjQ.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.hjP = (TextView) view.findViewById(R.id.news_info_text);
        this.hjR = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.hjN, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.hjN, (int) R.drawable.frs_text_color_selector);
        bSk();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bl cVS = abVar.cVS();
            bo cVT = abVar.cVT();
            this.top_code = cVS;
            this.news_info = cVT;
            if (abVar.cVR()) {
                this.hjR.setVisibility(0);
            } else {
                this.hjR.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hjH.setVisibility(8);
                this.hjO.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hjH.setVisibility(8);
                this.hjO.setVisibility(8);
            } else {
                this.hjH.setVisibility(0);
                this.hjO.setVisibility(0);
                this.hjJ.startLoad(this.top_code.aIW(), 10, false);
                this.hjK.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cVS.aMJ())) {
                    this.hjN.setVisibility(8);
                } else {
                    this.hjN.setText(cVS.aMJ());
                    this.hjN.setVisibility(0);
                }
                int aMG = this.top_code.aMG();
                if (aMG == 1 || aMG == 2) {
                    if (StringUtils.isNull(this.top_code.aMH())) {
                        this.hjL.setVisibility(8);
                    } else {
                        String str = this.duG.getResources().getString(R.string.u9_shengyu) + this.top_code.aMH();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aMH(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hjL.setText(spannableString);
                        this.hjL.setVisibility(0);
                    }
                    if (cVS.aMI() <= 0) {
                        this.hjM.setVisibility(8);
                    } else {
                        String str2 = this.duG.getResources().getString(R.string.u9_worth) + this.top_code.aMI();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aMI()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hjM.setText(spannableString2);
                        this.hjM.setVisibility(0);
                    }
                } else {
                    this.hjM.setVisibility(8);
                    this.hjL.setText(cVS.getSubTitle());
                    this.hjL.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cVT.getSummary())) {
                this.hjI.setVisibility(8);
                return;
            }
            this.hjI.setVisibility(0);
            this.hjP.setText(cVT.getSummary());
        }
    }

    public void bSk() {
        this.hjH.setOnClickListener(this.aOK);
        this.hjI.setOnClickListener(this.aOK);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.hjQ, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.hjN, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.hjN, (int) R.drawable.frs_text_color_selector);
            this.duG.getLayoutMode().setNightMode(i == 1);
            this.duG.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
