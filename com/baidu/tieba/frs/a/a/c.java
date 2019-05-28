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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener dSP;
    private TextView fzA;
    private TextView fzB;
    private View fzC;
    private TextView fzD;
    private ImageView fzE;
    private View fzF;
    private RelativeLayout fzv;
    private LinearLayout fzw;
    private TbImageView fzx;
    private TextView fzy;
    private TextView fzz;
    private TbPageContext mContext;
    private int mSkinType;
    private bl news_info;
    private bi top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(c.this.mContext.getPageActivity()) && l.ki()) {
                    if (view2 == c.this.fzv) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.afp())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aiz().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.afp()});
                        }
                    } else if (view2 == c.this.fzw && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.afw())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aiz().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.afw()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fzv = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fzw = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fzx = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fzx.setPageId(bdUniqueId);
        this.fzy = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fzz = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fzA = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fzB = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fzC = view.findViewById(R.id.u9_top_code_divider);
        this.fzE = (ImageView) view.findViewById(R.id.news_info_img);
        this.fzE.setBackgroundDrawable(al.getDrawable(R.drawable.icon_frs_news));
        this.fzD = (TextView) view.findViewById(R.id.news_info_text);
        this.fzF = view.findViewById(R.id.frs_list_item_u9_top_line);
        al.k(this.fzB, R.drawable.frs_star_btn_like);
        al.j(this.fzB, R.drawable.frs_text_color_selector);
        bns();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            bi clR = vVar.clR();
            bl clS = vVar.clS();
            this.top_code = clR;
            this.news_info = clS;
            if (vVar.bte()) {
                this.fzF.setVisibility(0);
            } else {
                this.fzF.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fzv.setVisibility(8);
                this.fzC.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fzv.setVisibility(8);
                this.fzC.setVisibility(8);
            } else {
                this.fzv.setVisibility(0);
                this.fzC.setVisibility(0);
                this.fzx.startLoad(this.top_code.abS(), 10, false);
                this.fzy.setText(this.top_code.getSummary());
                if (StringUtils.isNull(clR.aft())) {
                    this.fzB.setVisibility(8);
                } else {
                    this.fzB.setText(clR.aft());
                    this.fzB.setVisibility(0);
                }
                int afq = this.top_code.afq();
                if (afq == 1 || afq == 2) {
                    if (StringUtils.isNull(this.top_code.afr())) {
                        this.fzz.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(R.string.u9_shengyu) + this.top_code.afr();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.afr(), new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)));
                        this.fzz.setText(spannableString);
                        this.fzz.setVisibility(0);
                    }
                    if (clR.afs() <= 0) {
                        this.fzA.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(R.string.u9_worth) + this.top_code.afs();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.afs()), new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)));
                        this.fzA.setText(spannableString2);
                        this.fzA.setVisibility(0);
                    }
                } else {
                    this.fzA.setVisibility(8);
                    this.fzz.setText(clR.getSubTitle());
                    this.fzz.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(clS.getSummary())) {
                this.fzw.setVisibility(8);
                return;
            }
            this.fzw.setVisibility(0);
            this.fzD.setText(clS.getSummary());
        }
    }

    public void bns() {
        this.fzv.setOnClickListener(this.dSP);
        this.fzw.setOnClickListener(this.dSP);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fzE, R.drawable.icon_frs_news);
            al.k(this.fzB, R.drawable.frs_star_btn_like);
            al.j(this.fzB, R.drawable.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
