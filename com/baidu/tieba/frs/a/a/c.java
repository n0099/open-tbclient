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
    View.OnClickListener dSO;
    private TextView fzA;
    private View fzB;
    private TextView fzC;
    private ImageView fzD;
    private View fzE;
    private RelativeLayout fzu;
    private LinearLayout fzv;
    private TbImageView fzw;
    private TextView fzx;
    private TextView fzy;
    private TextView fzz;
    private TbPageContext mContext;
    private int mSkinType;
    private bl news_info;
    private bi top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(c.this.mContext.getPageActivity()) && l.ki()) {
                    if (view2 == c.this.fzu) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.afp())) {
                            TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aiz().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.top_code.afp()});
                        }
                    } else if (view2 == c.this.fzv && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.afw())) {
                        TiebaStatic.eventStat(c.this.mContext.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aiz().c((TbPageContext) i.ab(c.this.mContext.getPageActivity()), new String[]{c.this.news_info.afw()});
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fzu = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fzv = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fzw = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fzw.setPageId(bdUniqueId);
        this.fzx = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fzy = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fzz = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fzA = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fzB = view.findViewById(R.id.u9_top_code_divider);
        this.fzD = (ImageView) view.findViewById(R.id.news_info_img);
        this.fzD.setBackgroundDrawable(al.getDrawable(R.drawable.icon_frs_news));
        this.fzC = (TextView) view.findViewById(R.id.news_info_text);
        this.fzE = view.findViewById(R.id.frs_list_item_u9_top_line);
        al.k(this.fzA, R.drawable.frs_star_btn_like);
        al.j(this.fzA, R.drawable.frs_text_color_selector);
        bnp();
    }

    public void a(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            bi clP = vVar.clP();
            bl clQ = vVar.clQ();
            this.top_code = clP;
            this.news_info = clQ;
            if (vVar.btb()) {
                this.fzE.setVisibility(0);
            } else {
                this.fzE.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fzu.setVisibility(8);
                this.fzB.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fzu.setVisibility(8);
                this.fzB.setVisibility(8);
            } else {
                this.fzu.setVisibility(0);
                this.fzB.setVisibility(0);
                this.fzw.startLoad(this.top_code.abS(), 10, false);
                this.fzx.setText(this.top_code.getSummary());
                if (StringUtils.isNull(clP.aft())) {
                    this.fzA.setVisibility(8);
                } else {
                    this.fzA.setText(clP.aft());
                    this.fzA.setVisibility(0);
                }
                int afq = this.top_code.afq();
                if (afq == 1 || afq == 2) {
                    if (StringUtils.isNull(this.top_code.afr())) {
                        this.fzy.setVisibility(8);
                    } else {
                        String str = this.mContext.getResources().getString(R.string.u9_shengyu) + this.top_code.afr();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.afr(), new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)));
                        this.fzy.setText(spannableString);
                        this.fzy.setVisibility(0);
                    }
                    if (clP.afs() <= 0) {
                        this.fzz.setVisibility(8);
                    } else {
                        String str2 = this.mContext.getResources().getString(R.string.u9_worth) + this.top_code.afs();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.afs()), new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_d)));
                        this.fzz.setText(spannableString2);
                        this.fzz.setVisibility(0);
                    }
                } else {
                    this.fzz.setVisibility(8);
                    this.fzy.setText(clP.getSubTitle());
                    this.fzy.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(clQ.getSummary())) {
                this.fzv.setVisibility(8);
                return;
            }
            this.fzv.setVisibility(0);
            this.fzC.setText(clQ.getSummary());
        }
    }

    public void bnp() {
        this.fzu.setOnClickListener(this.dSO);
        this.fzv.setOnClickListener(this.dSO);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.k(this.fzD, R.drawable.icon_frs_news);
            al.k(this.fzA, R.drawable.frs_star_btn_like);
            al.j(this.fzA, R.drawable.frs_text_color_selector);
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
