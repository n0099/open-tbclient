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
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes9.dex */
public class c extends v.a {
    View.OnClickListener avi;
    private TbPageContext cVv;
    private RelativeLayout gAl;
    private LinearLayout gAm;
    private TbImageView gAn;
    private TextView gAo;
    private TextView gAp;
    private TextView gAq;
    private TextView gAr;
    private View gAs;
    private TextView gAt;
    private ImageView gAu;
    private View gAv;
    private int mSkinType;
    private bo news_info;
    private bl top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cVv.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.gAl) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aEr())) {
                            TiebaStatic.eventStat(c.this.cVv.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aGK().b((TbPageContext) i.ab(c.this.cVv.getPageActivity()), new String[]{c.this.top_code.aEr()});
                        }
                    } else if (view2 == c.this.gAm && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aEy())) {
                        TiebaStatic.eventStat(c.this.cVv.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aGK().b((TbPageContext) i.ab(c.this.cVv.getPageActivity()), new String[]{c.this.news_info.aEy()});
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.gAl = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.gAm = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.gAn = (TbImageView) view.findViewById(R.id.top_code_img);
        this.gAn.setPageId(bdUniqueId);
        this.gAo = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.gAp = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.gAq = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.gAr = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.gAs = view.findViewById(R.id.u9_top_code_divider);
        this.gAu = (ImageView) view.findViewById(R.id.news_info_img);
        this.gAu.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.gAt = (TextView) view.findViewById(R.id.news_info_text);
        this.gAv = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.gAr, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.gAr, (int) R.drawable.frs_text_color_selector);
        bHL();
    }

    public void a(y yVar) {
        if (yVar != null) {
            bl cKW = yVar.cKW();
            bo cKX = yVar.cKX();
            this.top_code = cKW;
            this.news_info = cKX;
            if (yVar.cKV()) {
                this.gAv.setVisibility(0);
            } else {
                this.gAv.setVisibility(8);
            }
            if (this.top_code == null) {
                this.gAl.setVisibility(8);
                this.gAs.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.gAl.setVisibility(8);
                this.gAs.setVisibility(8);
            } else {
                this.gAl.setVisibility(0);
                this.gAs.setVisibility(0);
                this.gAn.startLoad(this.top_code.aAJ(), 10, false);
                this.gAo.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cKW.aEv())) {
                    this.gAr.setVisibility(8);
                } else {
                    this.gAr.setText(cKW.aEv());
                    this.gAr.setVisibility(0);
                }
                int aEs = this.top_code.aEs();
                if (aEs == 1 || aEs == 2) {
                    if (StringUtils.isNull(this.top_code.aEt())) {
                        this.gAp.setVisibility(8);
                    } else {
                        String str = this.cVv.getResources().getString(R.string.u9_shengyu) + this.top_code.aEt();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aEt(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gAp.setText(spannableString);
                        this.gAp.setVisibility(0);
                    }
                    if (cKW.aEu() <= 0) {
                        this.gAq.setVisibility(8);
                    } else {
                        String str2 = this.cVv.getResources().getString(R.string.u9_worth) + this.top_code.aEu();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aEu()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.gAq.setText(spannableString2);
                        this.gAq.setVisibility(0);
                    }
                } else {
                    this.gAq.setVisibility(8);
                    this.gAp.setText(cKW.getSubTitle());
                    this.gAp.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cKX.getSummary())) {
                this.gAm.setVisibility(8);
                return;
            }
            this.gAm.setVisibility(0);
            this.gAt.setText(cKX.getSummary());
        }
    }

    public void bHL() {
        this.gAl.setOnClickListener(this.avi);
        this.gAm.setOnClickListener(this.avi);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.gAu, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.gAr, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.gAr, (int) R.drawable.frs_text_color_selector);
            this.cVv.getLayoutMode().setNightMode(i == 1);
            this.cVv.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
