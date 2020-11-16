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
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes21.dex */
public class c extends af.a {
    View.OnClickListener aEk;
    private TbPageContext eGu;
    private RelativeLayout iVL;
    private LinearLayout iVM;
    private TbImageView iVN;
    private TextView iVO;
    private TextView iVP;
    private TextView iVQ;
    private TextView iVR;
    private View iVS;
    private TextView iVT;
    private ImageView iVU;
    private View iVV;
    private int mSkinType;
    private cc news_info;
    private bz top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(c.this.eGu.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.iVL) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bnN())) {
                            TiebaStatic.eventStat(c.this.eGu.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bf.bqF().b((TbPageContext) i.I(c.this.eGu.getPageActivity()), new String[]{c.this.top_code.bnN()});
                        }
                    } else if (view2 == c.this.iVM && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bnU())) {
                        TiebaStatic.eventStat(c.this.eGu.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bf.bqF().b((TbPageContext) i.I(c.this.eGu.getPageActivity()), new String[]{c.this.news_info.bnU()});
                    }
                }
            }
        };
        this.eGu = tbPageContext;
        this.iVL = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.iVM = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.iVN = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iVN.setPageId(bdUniqueId);
        this.iVO = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iVP = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.iVQ = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.iVR = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.iVS = view.findViewById(R.id.u9_top_code_divider);
        this.iVU = (ImageView) view.findViewById(R.id.news_info_img);
        this.iVU.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.iVT = (TextView) view.findViewById(R.id.news_info_text);
        this.iVV = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.iVR, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.iVR, (int) R.drawable.frs_text_color_selector);
        cCd();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            bz dJq = acVar.dJq();
            cc dJr = acVar.dJr();
            this.top_code = dJq;
            this.news_info = dJr;
            if (acVar.dJp()) {
                this.iVV.setVisibility(0);
            } else {
                this.iVV.setVisibility(8);
            }
            if (this.top_code == null) {
                this.iVL.setVisibility(8);
                this.iVS.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.iVL.setVisibility(8);
                this.iVS.setVisibility(8);
            } else {
                this.iVL.setVisibility(0);
                this.iVS.setVisibility(0);
                this.iVN.startLoad(this.top_code.bjy(), 10, false);
                this.iVO.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dJq.bnR())) {
                    this.iVR.setVisibility(8);
                } else {
                    this.iVR.setText(dJq.bnR());
                    this.iVR.setVisibility(0);
                }
                int bnO = this.top_code.bnO();
                if (bnO == 1 || bnO == 2) {
                    if (StringUtils.isNull(this.top_code.bnP())) {
                        this.iVP.setVisibility(8);
                    } else {
                        String str = this.eGu.getResources().getString(R.string.u9_shengyu) + this.top_code.bnP();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bnP(), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.iVP.setText(spannableString);
                        this.iVP.setVisibility(0);
                    }
                    if (dJq.bnQ() <= 0) {
                        this.iVQ.setVisibility(8);
                    } else {
                        String str2 = this.eGu.getResources().getString(R.string.u9_worth) + this.top_code.bnQ();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bnQ()), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.iVQ.setText(spannableString2);
                        this.iVQ.setVisibility(0);
                    }
                } else {
                    this.iVQ.setVisibility(8);
                    this.iVP.setText(dJq.getSubTitle());
                    this.iVP.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dJr.getSummary())) {
                this.iVM.setVisibility(8);
                return;
            }
            this.iVM.setVisibility(0);
            this.iVT.setText(dJr.getSummary());
        }
    }

    public void cCd() {
        this.iVL.setOnClickListener(this.aEk);
        this.iVM.setOnClickListener(this.aEk);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.iVU, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.iVR, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.iVR, (int) R.drawable.frs_text_color_selector);
            this.eGu.getLayoutMode().setNightMode(i == 1);
            this.eGu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
