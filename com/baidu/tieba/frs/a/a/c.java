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
    private TextView hSC;
    private TextView hSD;
    private View hSE;
    private TextView hSF;
    private ImageView hSG;
    private View hSH;
    private RelativeLayout hSx;
    private LinearLayout hSy;
    private TbImageView hSz;
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
                    if (view2 == c.this.hSx) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aYs())) {
                            TiebaStatic.eventStat(c.this.dVN.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bd.baV().b((TbPageContext) i.G(c.this.dVN.getPageActivity()), new String[]{c.this.top_code.aYs()});
                        }
                    } else if (view2 == c.this.hSy && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aYz())) {
                        TiebaStatic.eventStat(c.this.dVN.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bd.baV().b((TbPageContext) i.G(c.this.dVN.getPageActivity()), new String[]{c.this.news_info.aYz()});
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.hSx = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hSy = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hSz = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hSz.setPageId(bdUniqueId);
        this.hSA = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hSB = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hSC = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hSD = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hSE = view.findViewById(R.id.u9_top_code_divider);
        this.hSG = (ImageView) view.findViewById(R.id.news_info_img);
        this.hSG.setBackgroundDrawable(ao.getDrawable(R.drawable.icon_frs_news));
        this.hSF = (TextView) view.findViewById(R.id.news_info_text);
        this.hSH = view.findViewById(R.id.frs_list_item_u9_top_line);
        ao.setBackgroundResource(this.hSD, R.drawable.frs_star_btn_like);
        ao.setViewTextColor(this.hSD, R.drawable.frs_text_color_selector);
        cfB();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bx dkI = abVar.dkI();
            ca dkJ = abVar.dkJ();
            this.top_code = dkI;
            this.news_info = dkJ;
            if (abVar.dkH()) {
                this.hSH.setVisibility(0);
            } else {
                this.hSH.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hSx.setVisibility(8);
                this.hSE.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hSx.setVisibility(8);
                this.hSE.setVisibility(8);
            } else {
                this.hSx.setVisibility(0);
                this.hSE.setVisibility(0);
                this.hSz.startLoad(this.top_code.aUh(), 10, false);
                this.hSA.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dkI.aYw())) {
                    this.hSD.setVisibility(8);
                } else {
                    this.hSD.setText(dkI.aYw());
                    this.hSD.setVisibility(0);
                }
                int aYt = this.top_code.aYt();
                if (aYt == 1 || aYt == 2) {
                    if (StringUtils.isNull(this.top_code.aYu())) {
                        this.hSB.setVisibility(8);
                    } else {
                        String str = this.dVN.getResources().getString(R.string.u9_shengyu) + this.top_code.aYu();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aYu(), new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_d)));
                        this.hSB.setText(spannableString);
                        this.hSB.setVisibility(0);
                    }
                    if (dkI.aYv() <= 0) {
                        this.hSC.setVisibility(8);
                    } else {
                        String str2 = this.dVN.getResources().getString(R.string.u9_worth) + this.top_code.aYv();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aYv()), new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_d)));
                        this.hSC.setText(spannableString2);
                        this.hSC.setVisibility(0);
                    }
                } else {
                    this.hSC.setVisibility(8);
                    this.hSB.setText(dkI.getSubTitle());
                    this.hSB.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dkJ.getSummary())) {
                this.hSy.setVisibility(8);
                return;
            }
            this.hSy.setVisibility(0);
            this.hSF.setText(dkJ.getSummary());
        }
    }

    public void cfB() {
        this.hSx.setOnClickListener(this.awi);
        this.hSy.setOnClickListener(this.awi);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.hSG, R.drawable.icon_frs_news);
            ao.setBackgroundResource(this.hSD, R.drawable.frs_star_btn_like);
            ao.setViewTextColor(this.hSD, R.drawable.frs_text_color_selector);
            this.dVN.getLayoutMode().setNightMode(i == 1);
            this.dVN.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
