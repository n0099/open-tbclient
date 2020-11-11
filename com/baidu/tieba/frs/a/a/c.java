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
/* loaded from: classes22.dex */
public class c extends af.a {
    View.OnClickListener aFV;
    private TbPageContext eIc;
    private RelativeLayout iUZ;
    private LinearLayout iVa;
    private TbImageView iVb;
    private TextView iVc;
    private TextView iVd;
    private TextView iVe;
    private TextView iVf;
    private View iVg;
    private TextView iVh;
    private ImageView iVi;
    private View iVj;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.eIc.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.iUZ) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.boJ())) {
                            TiebaStatic.eventStat(c.this.eIc.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.brr().b((TbPageContext) i.I(c.this.eIc.getPageActivity()), new String[]{c.this.top_code.boJ()});
                        }
                    } else if (view2 == c.this.iVa && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.boQ())) {
                        TiebaStatic.eventStat(c.this.eIc.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.brr().b((TbPageContext) i.I(c.this.eIc.getPageActivity()), new String[]{c.this.news_info.boQ()});
                    }
                }
            }
        };
        this.eIc = tbPageContext;
        this.iUZ = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.iVa = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.iVb = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iVb.setPageId(bdUniqueId);
        this.iVc = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iVd = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.iVe = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.iVf = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.iVg = view.findViewById(R.id.u9_top_code_divider);
        this.iVi = (ImageView) view.findViewById(R.id.news_info_img);
        this.iVi.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.iVh = (TextView) view.findViewById(R.id.news_info_text);
        this.iVj = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.iVf, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.iVf, (int) R.drawable.frs_text_color_selector);
        cCz();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dJz = acVar.dJz();
            cb dJA = acVar.dJA();
            this.top_code = dJz;
            this.news_info = dJA;
            if (acVar.dJy()) {
                this.iVj.setVisibility(0);
            } else {
                this.iVj.setVisibility(8);
            }
            if (this.top_code == null) {
                this.iUZ.setVisibility(8);
                this.iVg.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.iUZ.setVisibility(8);
                this.iVg.setVisibility(8);
            } else {
                this.iUZ.setVisibility(0);
                this.iVg.setVisibility(0);
                this.iVb.startLoad(this.top_code.bkw(), 10, false);
                this.iVc.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dJz.boN())) {
                    this.iVf.setVisibility(8);
                } else {
                    this.iVf.setText(dJz.boN());
                    this.iVf.setVisibility(0);
                }
                int boK = this.top_code.boK();
                if (boK == 1 || boK == 2) {
                    if (StringUtils.isNull(this.top_code.boL())) {
                        this.iVd.setVisibility(8);
                    } else {
                        String str = this.eIc.getResources().getString(R.string.u9_shengyu) + this.top_code.boL();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.boL(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iVd.setText(spannableString);
                        this.iVd.setVisibility(0);
                    }
                    if (dJz.boM() <= 0) {
                        this.iVe.setVisibility(8);
                    } else {
                        String str2 = this.eIc.getResources().getString(R.string.u9_worth) + this.top_code.boM();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.boM()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iVe.setText(spannableString2);
                        this.iVe.setVisibility(0);
                    }
                } else {
                    this.iVe.setVisibility(8);
                    this.iVd.setText(dJz.getSubTitle());
                    this.iVd.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dJA.getSummary())) {
                this.iVa.setVisibility(8);
                return;
            }
            this.iVa.setVisibility(0);
            this.iVh.setText(dJA.getSummary());
        }
    }

    public void cCz() {
        this.iUZ.setOnClickListener(this.aFV);
        this.iVa.setOnClickListener(this.aFV);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.iVi, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.iVf, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.iVf, (int) R.drawable.frs_text_color_selector);
            this.eIc.getLayoutMode().setNightMode(i == 1);
            this.eIc.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
