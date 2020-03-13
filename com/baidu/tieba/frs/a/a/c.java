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
import com.baidu.adp.widget.ListView.v;
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
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes9.dex */
public class c extends v.a {
    View.OnClickListener auY;
    private TbPageContext cVi;
    private RelativeLayout gzn;
    private LinearLayout gzo;
    private TbImageView gzp;
    private TextView gzq;
    private TextView gzr;
    private TextView gzs;
    private TextView gzt;
    private View gzu;
    private TextView gzv;
    private ImageView gzw;
    private View gzx;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cVi.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gzn) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aEn())) {
                            TiebaStatic.eventStat(c.this.cVi.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aGG().b((TbPageContext) i.ab(c.this.cVi.getPageActivity()), new String[]{c.this.top_code.aEn()});
                        }
                    } else if (view2 == c.this.gzo && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aEu())) {
                        TiebaStatic.eventStat(c.this.cVi.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aGG().b((TbPageContext) i.ab(c.this.cVi.getPageActivity()), new String[]{c.this.news_info.aEu()});
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.gzn = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gzo = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gzp = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gzp.setPageId(bdUniqueId);
        this.gzq = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gzr = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gzs = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gzt = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gzu = view.findViewById(R.id.u9_top_code_divider);
        this.gzw = (ImageView) view.findViewById(R.id.news_info_img);
        this.gzw.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gzv = (TextView) view.findViewById(R.id.news_info_text);
        this.gzx = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gzt, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gzt, (int) R.drawable.frs_text_color_selector);
        bHz();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bl cKC = xVar.cKC();
            bo cKD = xVar.cKD();
            this.top_code = cKC;
            this.news_info = cKD;
            if (xVar.cKB()) {
                this.gzx.setVisibility(0);
            } else {
                this.gzx.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gzn.setVisibility(8);
                this.gzu.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gzn.setVisibility(8);
                this.gzu.setVisibility(8);
            } else {
                this.gzn.setVisibility(0);
                this.gzu.setVisibility(0);
                this.gzp.startLoad(this.top_code.aAG(), 10, false);
                this.gzq.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cKC.aEr())) {
                    this.gzt.setVisibility(8);
                } else {
                    this.gzt.setText(cKC.aEr());
                    this.gzt.setVisibility(0);
                }
                int aEo = this.top_code.aEo();
                if (aEo == 1 || aEo == 2) {
                    if (StringUtils.isNull(this.top_code.aEp())) {
                        this.gzr.setVisibility(8);
                    } else {
                        String str = this.cVi.getResources().getString(R.string.u9_shengyu) + this.top_code.aEp();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aEp(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gzr.setText(spannableString);
                        this.gzr.setVisibility(0);
                    }
                    if (cKC.aEq() <= 0) {
                        this.gzs.setVisibility(8);
                    } else {
                        String str2 = this.cVi.getResources().getString(R.string.u9_worth) + this.top_code.aEq();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aEq()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gzs.setText(spannableString2);
                        this.gzs.setVisibility(0);
                    }
                } else {
                    this.gzs.setVisibility(8);
                    this.gzr.setText(cKC.getSubTitle());
                    this.gzr.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cKD.getSummary())) {
                this.gzo.setVisibility(8);
                return;
            }
            this.gzo.setVisibility(0);
            this.gzv.setText(cKD.getSummary());
        }
    }

    public void bHz() {
        this.gzn.setOnClickListener(this.auY);
        this.gzo.setOnClickListener(this.auY);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gzw, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gzt, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gzt, (int) R.drawable.frs_text_color_selector);
            this.cVi.getLayoutMode().setNightMode(i == 1);
            this.cVi.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
