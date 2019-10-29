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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes4.dex */
public class c extends v.a {
    View.OnClickListener aju;
    private TbPageContext cfl;
    private RelativeLayout fGm;
    private LinearLayout fGn;
    private TbImageView fGo;
    private TextView fGp;
    private TextView fGq;
    private TextView fGr;
    private TextView fGs;
    private View fGt;
    private TextView fGu;
    private ImageView fGv;
    private View fGw;
    private int mSkinType;
    private bm news_info;
    private bj top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.cfl.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.fGm) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.akz())) {
                            TiebaStatic.eventStat(c.this.cfl.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.amQ().b((TbPageContext) i.ab(c.this.cfl.getPageActivity()), new String[]{c.this.top_code.akz()});
                        }
                    } else if (view2 == c.this.fGn && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.akG())) {
                        TiebaStatic.eventStat(c.this.cfl.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.amQ().b((TbPageContext) i.ab(c.this.cfl.getPageActivity()), new String[]{c.this.news_info.akG()});
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.fGm = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fGn = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fGo = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fGo.setPageId(bdUniqueId);
        this.fGp = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fGq = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fGr = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fGs = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fGt = view.findViewById(R.id.u9_top_code_divider);
        this.fGv = (ImageView) view.findViewById(R.id.news_info_img);
        this.fGv.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.fGu = (TextView) view.findViewById(R.id.news_info_text);
        this.fGw = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.fGs, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.fGs, (int) R.drawable.frs_text_color_selector);
        bnx();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bj cnL = xVar.cnL();
            bm cnM = xVar.cnM();
            this.top_code = cnL;
            this.news_info = cnM;
            if (xVar.btn()) {
                this.fGw.setVisibility(0);
            } else {
                this.fGw.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fGm.setVisibility(8);
                this.fGt.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fGm.setVisibility(8);
                this.fGt.setVisibility(8);
            } else {
                this.fGm.setVisibility(0);
                this.fGt.setVisibility(0);
                this.fGo.startLoad(this.top_code.ahf(), 10, false);
                this.fGp.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cnL.akD())) {
                    this.fGs.setVisibility(8);
                } else {
                    this.fGs.setText(cnL.akD());
                    this.fGs.setVisibility(0);
                }
                int akA = this.top_code.akA();
                if (akA == 1 || akA == 2) {
                    if (StringUtils.isNull(this.top_code.akB())) {
                        this.fGq.setVisibility(8);
                    } else {
                        String str = this.cfl.getResources().getString(R.string.u9_shengyu) + this.top_code.akB();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.akB(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fGq.setText(spannableString);
                        this.fGq.setVisibility(0);
                    }
                    if (cnL.akC() <= 0) {
                        this.fGr.setVisibility(8);
                    } else {
                        String str2 = this.cfl.getResources().getString(R.string.u9_worth) + this.top_code.akC();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.akC()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fGr.setText(spannableString2);
                        this.fGr.setVisibility(0);
                    }
                } else {
                    this.fGr.setVisibility(8);
                    this.fGq.setText(cnL.getSubTitle());
                    this.fGq.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cnM.getSummary())) {
                this.fGn.setVisibility(8);
                return;
            }
            this.fGn.setVisibility(0);
            this.fGu.setText(cnM.getSummary());
        }
    }

    public void bnx() {
        this.fGm.setOnClickListener(this.aju);
        this.fGn.setOnClickListener(this.aju);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fGv, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.fGs, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.fGs, (int) R.drawable.frs_text_color_selector);
            this.cfl.getLayoutMode().setNightMode(i == 1);
            this.cfl.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
