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
    View.OnClickListener aOQ;
    private TbPageContext duK;
    private RelativeLayout hjN;
    private LinearLayout hjO;
    private TbImageView hjP;
    private TextView hjQ;
    private TextView hjR;
    private TextView hjS;
    private TextView hjT;
    private View hjU;
    private TextView hjV;
    private ImageView hjW;
    private View hjX;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.duK.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.hjN) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aMD())) {
                            TiebaStatic.eventStat(c.this.duK.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aOV().b((TbPageContext) i.G(c.this.duK.getPageActivity()), new String[]{c.this.top_code.aMD()});
                        }
                    } else if (view2 == c.this.hjO && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aMK())) {
                        TiebaStatic.eventStat(c.this.duK.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aOV().b((TbPageContext) i.G(c.this.duK.getPageActivity()), new String[]{c.this.news_info.aMK()});
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.hjN = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hjO = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hjP = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hjP.setPageId(bdUniqueId);
        this.hjQ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hjR = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hjS = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hjT = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hjU = view.findViewById(R.id.u9_top_code_divider);
        this.hjW = (ImageView) view.findViewById(R.id.news_info_img);
        this.hjW.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.hjV = (TextView) view.findViewById(R.id.news_info_text);
        this.hjX = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.hjT, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.hjT, (int) R.drawable.frs_text_color_selector);
        bSj();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bl cVQ = abVar.cVQ();
            bo cVR = abVar.cVR();
            this.top_code = cVQ;
            this.news_info = cVR;
            if (abVar.cVP()) {
                this.hjX.setVisibility(0);
            } else {
                this.hjX.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hjN.setVisibility(8);
                this.hjU.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hjN.setVisibility(8);
                this.hjU.setVisibility(8);
            } else {
                this.hjN.setVisibility(0);
                this.hjU.setVisibility(0);
                this.hjP.startLoad(this.top_code.aIU(), 10, false);
                this.hjQ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cVQ.aMH())) {
                    this.hjT.setVisibility(8);
                } else {
                    this.hjT.setText(cVQ.aMH());
                    this.hjT.setVisibility(0);
                }
                int aME = this.top_code.aME();
                if (aME == 1 || aME == 2) {
                    if (StringUtils.isNull(this.top_code.aMF())) {
                        this.hjR.setVisibility(8);
                    } else {
                        String str = this.duK.getResources().getString(R.string.u9_shengyu) + this.top_code.aMF();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aMF(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hjR.setText(spannableString);
                        this.hjR.setVisibility(0);
                    }
                    if (cVQ.aMG() <= 0) {
                        this.hjS.setVisibility(8);
                    } else {
                        String str2 = this.duK.getResources().getString(R.string.u9_worth) + this.top_code.aMG();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aMG()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hjS.setText(spannableString2);
                        this.hjS.setVisibility(0);
                    }
                } else {
                    this.hjS.setVisibility(8);
                    this.hjR.setText(cVQ.getSubTitle());
                    this.hjR.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cVR.getSummary())) {
                this.hjO.setVisibility(8);
                return;
            }
            this.hjO.setVisibility(0);
            this.hjV.setText(cVR.getSummary());
        }
    }

    public void bSj() {
        this.hjN.setOnClickListener(this.aOQ);
        this.hjO.setOnClickListener(this.aOQ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.hjW, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.hjT, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.hjT, (int) R.drawable.frs_text_color_selector);
            this.duK.getLayoutMode().setNightMode(i == 1);
            this.duK.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
