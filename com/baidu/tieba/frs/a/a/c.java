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
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes9.dex */
public class c extends aa.a {
    View.OnClickListener aUZ;
    private TbPageContext dIF;
    private RelativeLayout hzo;
    private LinearLayout hzp;
    private TbImageView hzq;
    private TextView hzr;
    private TextView hzs;
    private TextView hzt;
    private TextView hzu;
    private View hzv;
    private TextView hzw;
    private ImageView hzx;
    private View hzy;
    private int mSkinType;
    private bp news_info;
    private bm top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.dIF.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.hzo) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aSE())) {
                            TiebaStatic.eventStat(c.this.dIF.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aVa().b((TbPageContext) i.G(c.this.dIF.getPageActivity()), new String[]{c.this.top_code.aSE()});
                        }
                    } else if (view2 == c.this.hzp && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aSL())) {
                        TiebaStatic.eventStat(c.this.dIF.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aVa().b((TbPageContext) i.G(c.this.dIF.getPageActivity()), new String[]{c.this.news_info.aSL()});
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.hzo = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hzp = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hzq = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hzq.setPageId(bdUniqueId);
        this.hzr = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hzs = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hzt = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hzu = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hzv = view.findViewById(R.id.u9_top_code_divider);
        this.hzx = (ImageView) view.findViewById(R.id.news_info_img);
        this.hzx.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.hzw = (TextView) view.findViewById(R.id.news_info_text);
        this.hzy = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.hzu, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.hzu, (int) R.drawable.frs_text_color_selector);
        bYM();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bm ddj = abVar.ddj();
            bp ddk = abVar.ddk();
            this.top_code = ddj;
            this.news_info = ddk;
            if (abVar.ddi()) {
                this.hzy.setVisibility(0);
            } else {
                this.hzy.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hzo.setVisibility(8);
                this.hzv.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hzo.setVisibility(8);
                this.hzv.setVisibility(8);
            } else {
                this.hzo.setVisibility(0);
                this.hzv.setVisibility(0);
                this.hzq.startLoad(this.top_code.aOP(), 10, false);
                this.hzr.setText(this.top_code.getSummary());
                if (StringUtils.isNull(ddj.aSI())) {
                    this.hzu.setVisibility(8);
                } else {
                    this.hzu.setText(ddj.aSI());
                    this.hzu.setVisibility(0);
                }
                int aSF = this.top_code.aSF();
                if (aSF == 1 || aSF == 2) {
                    if (StringUtils.isNull(this.top_code.aSG())) {
                        this.hzs.setVisibility(8);
                    } else {
                        String str = this.dIF.getResources().getString(R.string.u9_shengyu) + this.top_code.aSG();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aSG(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hzs.setText(spannableString);
                        this.hzs.setVisibility(0);
                    }
                    if (ddj.aSH() <= 0) {
                        this.hzt.setVisibility(8);
                    } else {
                        String str2 = this.dIF.getResources().getString(R.string.u9_worth) + this.top_code.aSH();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aSH()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hzt.setText(spannableString2);
                        this.hzt.setVisibility(0);
                    }
                } else {
                    this.hzt.setVisibility(8);
                    this.hzs.setText(ddj.getSubTitle());
                    this.hzs.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(ddk.getSummary())) {
                this.hzp.setVisibility(8);
                return;
            }
            this.hzp.setVisibility(0);
            this.hzw.setText(ddk.getSummary());
        }
    }

    public void bYM() {
        this.hzo.setOnClickListener(this.aUZ);
        this.hzp.setOnClickListener(this.aUZ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.hzx, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.hzu, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.hzu, (int) R.drawable.frs_text_color_selector);
            this.dIF.getLayoutMode().setNightMode(i == 1);
            this.dIF.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
