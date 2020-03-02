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
    View.OnClickListener auX;
    private TbPageContext cVh;
    private RelativeLayout gzb;
    private LinearLayout gzc;
    private TbImageView gzd;
    private TextView gze;
    private TextView gzf;
    private TextView gzg;
    private TextView gzh;
    private View gzi;
    private TextView gzj;
    private ImageView gzk;
    private View gzl;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cVh.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gzb) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aEn())) {
                            TiebaStatic.eventStat(c.this.cVh.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aGG().b((TbPageContext) i.ab(c.this.cVh.getPageActivity()), new String[]{c.this.top_code.aEn()});
                        }
                    } else if (view2 == c.this.gzc && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aEu())) {
                        TiebaStatic.eventStat(c.this.cVh.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aGG().b((TbPageContext) i.ab(c.this.cVh.getPageActivity()), new String[]{c.this.news_info.aEu()});
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.gzb = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gzc = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gzd = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gzd.setPageId(bdUniqueId);
        this.gze = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gzf = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gzg = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gzh = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gzi = view.findViewById(R.id.u9_top_code_divider);
        this.gzk = (ImageView) view.findViewById(R.id.news_info_img);
        this.gzk.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gzj = (TextView) view.findViewById(R.id.news_info_text);
        this.gzl = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gzh, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gzh, (int) R.drawable.frs_text_color_selector);
        bHy();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bl cKB = xVar.cKB();
            bo cKC = xVar.cKC();
            this.top_code = cKB;
            this.news_info = cKC;
            if (xVar.cKA()) {
                this.gzl.setVisibility(0);
            } else {
                this.gzl.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gzb.setVisibility(8);
                this.gzi.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gzb.setVisibility(8);
                this.gzi.setVisibility(8);
            } else {
                this.gzb.setVisibility(0);
                this.gzi.setVisibility(0);
                this.gzd.startLoad(this.top_code.aAG(), 10, false);
                this.gze.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cKB.aEr())) {
                    this.gzh.setVisibility(8);
                } else {
                    this.gzh.setText(cKB.aEr());
                    this.gzh.setVisibility(0);
                }
                int aEo = this.top_code.aEo();
                if (aEo == 1 || aEo == 2) {
                    if (StringUtils.isNull(this.top_code.aEp())) {
                        this.gzf.setVisibility(8);
                    } else {
                        String str = this.cVh.getResources().getString(R.string.u9_shengyu) + this.top_code.aEp();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aEp(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gzf.setText(spannableString);
                        this.gzf.setVisibility(0);
                    }
                    if (cKB.aEq() <= 0) {
                        this.gzg.setVisibility(8);
                    } else {
                        String str2 = this.cVh.getResources().getString(R.string.u9_worth) + this.top_code.aEq();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aEq()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gzg.setText(spannableString2);
                        this.gzg.setVisibility(0);
                    }
                } else {
                    this.gzg.setVisibility(8);
                    this.gzf.setText(cKB.getSubTitle());
                    this.gzf.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cKC.getSummary())) {
                this.gzc.setVisibility(8);
                return;
            }
            this.gzc.setVisibility(0);
            this.gzj.setText(cKC.getSummary());
        }
    }

    public void bHy() {
        this.gzb.setOnClickListener(this.auX);
        this.gzc.setOnClickListener(this.auX);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gzk, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gzh, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gzh, (int) R.drawable.frs_text_color_selector);
            this.cVh.getLayoutMode().setNightMode(i == 1);
            this.cVh.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
