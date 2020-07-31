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
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes16.dex */
public class c extends ad.a {
    View.OnClickListener awi;
    private TbPageContext dVN;
    private TextView hSA;
    private TextView hSB;
    private View hSC;
    private TextView hSD;
    private ImageView hSE;
    private View hSF;
    private RelativeLayout hSv;
    private LinearLayout hSw;
    private TbImageView hSx;
    private TextView hSy;
    private TextView hSz;
    private int mSkinType;
    private ca news_info;
    private bx top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bf.checkUpIsLogin(c.this.dVN.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.hSv) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aYs())) {
                            TiebaStatic.eventStat(c.this.dVN.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bd.baV().b((TbPageContext) i.G(c.this.dVN.getPageActivity()), new String[]{c.this.top_code.aYs()});
                        }
                    } else if (view2 == c.this.hSw && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aYz())) {
                        TiebaStatic.eventStat(c.this.dVN.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bd.baV().b((TbPageContext) i.G(c.this.dVN.getPageActivity()), new String[]{c.this.news_info.aYz()});
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.hSv = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hSw = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hSx = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hSx.setPageId(bdUniqueId);
        this.hSy = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hSz = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hSA = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hSB = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hSC = view.findViewById(R.id.u9_top_code_divider);
        this.hSE = (ImageView) view.findViewById(R.id.news_info_img);
        this.hSE.setBackgroundDrawable(ao.getDrawable(R.drawable.icon_frs_news));
        this.hSD = (TextView) view.findViewById(R.id.news_info_text);
        this.hSF = view.findViewById(R.id.frs_list_item_u9_top_line);
        ao.setBackgroundResource(this.hSB, R.drawable.frs_star_btn_like);
        ao.setViewTextColor(this.hSB, R.drawable.frs_text_color_selector);
        cfB();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bx dkH = abVar.dkH();
            ca dkI = abVar.dkI();
            this.top_code = dkH;
            this.news_info = dkI;
            if (abVar.dkG()) {
                this.hSF.setVisibility(0);
            } else {
                this.hSF.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hSv.setVisibility(8);
                this.hSC.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hSv.setVisibility(8);
                this.hSC.setVisibility(8);
            } else {
                this.hSv.setVisibility(0);
                this.hSC.setVisibility(0);
                this.hSx.startLoad(this.top_code.aUh(), 10, false);
                this.hSy.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dkH.aYw())) {
                    this.hSB.setVisibility(8);
                } else {
                    this.hSB.setText(dkH.aYw());
                    this.hSB.setVisibility(0);
                }
                int aYt = this.top_code.aYt();
                if (aYt == 1 || aYt == 2) {
                    if (StringUtils.isNull(this.top_code.aYu())) {
                        this.hSz.setVisibility(8);
                    } else {
                        String str = this.dVN.getResources().getString(R.string.u9_shengyu) + this.top_code.aYu();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aYu(), new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_d)));
                        this.hSz.setText(spannableString);
                        this.hSz.setVisibility(0);
                    }
                    if (dkH.aYv() <= 0) {
                        this.hSA.setVisibility(8);
                    } else {
                        String str2 = this.dVN.getResources().getString(R.string.u9_worth) + this.top_code.aYv();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aYv()), new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_d)));
                        this.hSA.setText(spannableString2);
                        this.hSA.setVisibility(0);
                    }
                } else {
                    this.hSA.setVisibility(8);
                    this.hSz.setText(dkH.getSubTitle());
                    this.hSz.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dkI.getSummary())) {
                this.hSw.setVisibility(8);
                return;
            }
            this.hSw.setVisibility(0);
            this.hSD.setText(dkI.getSummary());
        }
    }

    public void cfB() {
        this.hSv.setOnClickListener(this.awi);
        this.hSw.setOnClickListener(this.awi);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hSE, R.drawable.icon_frs_news);
            ao.setBackgroundResource(this.hSB, R.drawable.frs_star_btn_like);
            ao.setViewTextColor(this.hSB, R.drawable.frs_text_color_selector);
            this.dVN.getLayoutMode().setNightMode(i == 1);
            this.dVN.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
