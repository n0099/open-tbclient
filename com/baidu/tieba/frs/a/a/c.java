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
/* loaded from: classes21.dex */
public class c extends af.a {
    View.OnClickListener aBS;
    private TbPageContext ehG;
    private RelativeLayout inN;
    private LinearLayout inO;
    private TbImageView inP;
    private TextView inQ;
    private TextView inR;
    private TextView inS;
    private TextView inT;
    private View inU;
    private TextView inV;
    private ImageView inW;
    private View inX;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.ehG.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.inN) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bhH())) {
                            TiebaStatic.eventStat(c.this.ehG.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bkp().b((TbPageContext) i.I(c.this.ehG.getPageActivity()), new String[]{c.this.top_code.bhH()});
                        }
                    } else if (view2 == c.this.inO && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bhO())) {
                        TiebaStatic.eventStat(c.this.ehG.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bkp().b((TbPageContext) i.I(c.this.ehG.getPageActivity()), new String[]{c.this.news_info.bhO()});
                    }
                }
            }
        };
        this.ehG = tbPageContext;
        this.inN = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.inO = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.inP = (TbImageView) view.findViewById(R.id.top_code_img);
        this.inP.setPageId(bdUniqueId);
        this.inQ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.inR = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.inS = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.inT = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.inU = view.findViewById(R.id.u9_top_code_divider);
        this.inW = (ImageView) view.findViewById(R.id.news_info_img);
        this.inW.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.inV = (TextView) view.findViewById(R.id.news_info_text);
        this.inX = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.inT, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.inT, (int) R.drawable.frs_text_color_selector);
        ctu();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dAd = acVar.dAd();
            cb dAe = acVar.dAe();
            this.top_code = dAd;
            this.news_info = dAe;
            if (acVar.dAc()) {
                this.inX.setVisibility(0);
            } else {
                this.inX.setVisibility(8);
            }
            if (this.top_code == null) {
                this.inN.setVisibility(8);
                this.inU.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.inN.setVisibility(8);
                this.inU.setVisibility(8);
            } else {
                this.inN.setVisibility(0);
                this.inU.setVisibility(0);
                this.inP.startLoad(this.top_code.bdu(), 10, false);
                this.inQ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dAd.bhL())) {
                    this.inT.setVisibility(8);
                } else {
                    this.inT.setText(dAd.bhL());
                    this.inT.setVisibility(0);
                }
                int bhI = this.top_code.bhI();
                if (bhI == 1 || bhI == 2) {
                    if (StringUtils.isNull(this.top_code.bhJ())) {
                        this.inR.setVisibility(8);
                    } else {
                        String str = this.ehG.getResources().getString(R.string.u9_shengyu) + this.top_code.bhJ();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bhJ(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.inR.setText(spannableString);
                        this.inR.setVisibility(0);
                    }
                    if (dAd.bhK() <= 0) {
                        this.inS.setVisibility(8);
                    } else {
                        String str2 = this.ehG.getResources().getString(R.string.u9_worth) + this.top_code.bhK();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bhK()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.inS.setText(spannableString2);
                        this.inS.setVisibility(0);
                    }
                } else {
                    this.inS.setVisibility(8);
                    this.inR.setText(dAd.getSubTitle());
                    this.inR.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dAe.getSummary())) {
                this.inO.setVisibility(8);
                return;
            }
            this.inO.setVisibility(0);
            this.inV.setText(dAe.getSummary());
        }
    }

    public void ctu() {
        this.inN.setOnClickListener(this.aBS);
        this.inO.setOnClickListener(this.aBS);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.inW, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.inT, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.inT, (int) R.drawable.frs_text_color_selector);
            this.ehG.getLayoutMode().setNightMode(i == 1);
            this.ehG.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
