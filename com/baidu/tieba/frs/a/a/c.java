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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes9.dex */
public class c extends ad.a {
    View.OnClickListener aXG;
    private TbPageContext dPv;
    private TextView hMA;
    private TextView hMB;
    private TextView hMC;
    private View hMD;
    private TextView hME;
    private ImageView hMF;
    private View hMG;
    private RelativeLayout hMw;
    private LinearLayout hMx;
    private TbImageView hMy;
    private TextView hMz;
    private int mSkinType;
    private bz news_info;
    private bw top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (be.checkUpIsLogin(c.this.dPv.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.hMw) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aUy())) {
                            TiebaStatic.eventStat(c.this.dPv.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bc.aWU().b((TbPageContext) i.G(c.this.dPv.getPageActivity()), new String[]{c.this.top_code.aUy()});
                        }
                    } else if (view2 == c.this.hMx && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aUF())) {
                        TiebaStatic.eventStat(c.this.dPv.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bc.aWU().b((TbPageContext) i.G(c.this.dPv.getPageActivity()), new String[]{c.this.news_info.aUF()});
                    }
                }
            }
        };
        this.dPv = tbPageContext;
        this.hMw = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hMx = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hMy = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hMy.setPageId(bdUniqueId);
        this.hMz = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hMA = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hMB = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hMC = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hMD = view.findViewById(R.id.u9_top_code_divider);
        this.hMF = (ImageView) view.findViewById(R.id.news_info_img);
        this.hMF.setBackgroundDrawable(an.getDrawable(R.drawable.icon_frs_news));
        this.hME = (TextView) view.findViewById(R.id.news_info_text);
        this.hMG = view.findViewById(R.id.frs_list_item_u9_top_line);
        an.setBackgroundResource(this.hMC, R.drawable.frs_star_btn_like);
        an.setViewTextColor(this.hMC, (int) R.drawable.frs_text_color_selector);
        ccc();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bw dhy = abVar.dhy();
            bz dhz = abVar.dhz();
            this.top_code = dhy;
            this.news_info = dhz;
            if (abVar.dhx()) {
                this.hMG.setVisibility(0);
            } else {
                this.hMG.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hMw.setVisibility(8);
                this.hMD.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hMw.setVisibility(8);
                this.hMD.setVisibility(8);
            } else {
                this.hMw.setVisibility(0);
                this.hMD.setVisibility(0);
                this.hMy.startLoad(this.top_code.aQl(), 10, false);
                this.hMz.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dhy.aUC())) {
                    this.hMC.setVisibility(8);
                } else {
                    this.hMC.setText(dhy.aUC());
                    this.hMC.setVisibility(0);
                }
                int aUz = this.top_code.aUz();
                if (aUz == 1 || aUz == 2) {
                    if (StringUtils.isNull(this.top_code.aUA())) {
                        this.hMA.setVisibility(8);
                    } else {
                        String str = this.dPv.getResources().getString(R.string.u9_shengyu) + this.top_code.aUA();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aUA(), new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_d)));
                        this.hMA.setText(spannableString);
                        this.hMA.setVisibility(0);
                    }
                    if (dhy.aUB() <= 0) {
                        this.hMB.setVisibility(8);
                    } else {
                        String str2 = this.dPv.getResources().getString(R.string.u9_worth) + this.top_code.aUB();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aUB()), new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_d)));
                        this.hMB.setText(spannableString2);
                        this.hMB.setVisibility(0);
                    }
                } else {
                    this.hMB.setVisibility(8);
                    this.hMA.setText(dhy.getSubTitle());
                    this.hMA.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dhz.getSummary())) {
                this.hMx.setVisibility(8);
                return;
            }
            this.hMx.setVisibility(0);
            this.hME.setText(dhz.getSummary());
        }
    }

    public void ccc() {
        this.hMw.setOnClickListener(this.aXG);
        this.hMx.setOnClickListener(this.aXG);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.hMF, R.drawable.icon_frs_news);
            an.setBackgroundResource(this.hMC, R.drawable.frs_star_btn_like);
            an.setViewTextColor(this.hMC, (int) R.drawable.frs_text_color_selector);
            this.dPv.getLayoutMode().setNightMode(i == 1);
            this.dPv.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
