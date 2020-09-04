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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes16.dex */
public class c extends af.a {
    View.OnClickListener aBm;
    private TbPageContext efr;
    private RelativeLayout igL;
    private LinearLayout igM;
    private TbImageView igN;
    private TextView igO;
    private TextView igP;
    private TextView igQ;
    private TextView igR;
    private View igS;
    private TextView igT;
    private ImageView igU;
    private View igV;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.efr.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.igL) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bgN())) {
                            TiebaStatic.eventStat(c.this.efr.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bju().b((TbPageContext) i.I(c.this.efr.getPageActivity()), new String[]{c.this.top_code.bgN()});
                        }
                    } else if (view2 == c.this.igM && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bgU())) {
                        TiebaStatic.eventStat(c.this.efr.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bju().b((TbPageContext) i.I(c.this.efr.getPageActivity()), new String[]{c.this.news_info.bgU()});
                    }
                }
            }
        };
        this.efr = tbPageContext;
        this.igL = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.igM = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.igN = (TbImageView) view.findViewById(R.id.top_code_img);
        this.igN.setPageId(bdUniqueId);
        this.igO = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.igP = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.igQ = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.igR = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.igS = view.findViewById(R.id.u9_top_code_divider);
        this.igU = (ImageView) view.findViewById(R.id.news_info_img);
        this.igU.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.igT = (TextView) view.findViewById(R.id.news_info_text);
        this.igV = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.igR, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.igR, (int) R.drawable.frs_text_color_selector);
        cqh();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dwk = acVar.dwk();
            cb dwl = acVar.dwl();
            this.top_code = dwk;
            this.news_info = dwl;
            if (acVar.dwj()) {
                this.igV.setVisibility(0);
            } else {
                this.igV.setVisibility(8);
            }
            if (this.top_code == null) {
                this.igL.setVisibility(8);
                this.igS.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.igL.setVisibility(8);
                this.igS.setVisibility(8);
            } else {
                this.igL.setVisibility(0);
                this.igS.setVisibility(0);
                this.igN.startLoad(this.top_code.bcA(), 10, false);
                this.igO.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dwk.bgR())) {
                    this.igR.setVisibility(8);
                } else {
                    this.igR.setText(dwk.bgR());
                    this.igR.setVisibility(0);
                }
                int bgO = this.top_code.bgO();
                if (bgO == 1 || bgO == 2) {
                    if (StringUtils.isNull(this.top_code.bgP())) {
                        this.igP.setVisibility(8);
                    } else {
                        String str = this.efr.getResources().getString(R.string.u9_shengyu) + this.top_code.bgP();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bgP(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.igP.setText(spannableString);
                        this.igP.setVisibility(0);
                    }
                    if (dwk.bgQ() <= 0) {
                        this.igQ.setVisibility(8);
                    } else {
                        String str2 = this.efr.getResources().getString(R.string.u9_worth) + this.top_code.bgQ();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bgQ()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.igQ.setText(spannableString2);
                        this.igQ.setVisibility(0);
                    }
                } else {
                    this.igQ.setVisibility(8);
                    this.igP.setText(dwk.getSubTitle());
                    this.igP.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dwl.getSummary())) {
                this.igM.setVisibility(8);
                return;
            }
            this.igM.setVisibility(0);
            this.igT.setText(dwl.getSummary());
        }
    }

    public void cqh() {
        this.igL.setOnClickListener(this.aBm);
        this.igM.setOnClickListener(this.aBm);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.igU, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.igR, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.igR, (int) R.drawable.frs_text_color_selector);
            this.efr.getLayoutMode().setNightMode(i == 1);
            this.efr.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
