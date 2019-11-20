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
    View.OnClickListener ajc;
    private TbPageContext ceu;
    private TextView fFA;
    private TextView fFB;
    private View fFC;
    private TextView fFD;
    private ImageView fFE;
    private View fFF;
    private RelativeLayout fFv;
    private LinearLayout fFw;
    private TbImageView fFx;
    private TextView fFy;
    private TextView fFz;
    private int mSkinType;
    private bm news_info;
    private bj top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(c.this.ceu.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.fFv) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.akx())) {
                            TiebaStatic.eventStat(c.this.ceu.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.amO().b((TbPageContext) i.ab(c.this.ceu.getPageActivity()), new String[]{c.this.top_code.akx()});
                        }
                    } else if (view2 == c.this.fFw && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.akE())) {
                        TiebaStatic.eventStat(c.this.ceu.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.amO().b((TbPageContext) i.ab(c.this.ceu.getPageActivity()), new String[]{c.this.news_info.akE()});
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.fFv = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.fFw = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.fFx = (TbImageView) view.findViewById(R.id.top_code_img);
        this.fFx.setPageId(bdUniqueId);
        this.fFy = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.fFz = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.fFA = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.fFB = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.fFC = view.findViewById(R.id.u9_top_code_divider);
        this.fFE = (ImageView) view.findViewById(R.id.news_info_img);
        this.fFE.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.fFD = (TextView) view.findViewById(R.id.news_info_text);
        this.fFF = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.fFB, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.fFB, (int) R.drawable.frs_text_color_selector);
        bnv();
    }

    public void a(x xVar) {
        if (xVar != null) {
            bj cnJ = xVar.cnJ();
            bm cnK = xVar.cnK();
            this.top_code = cnJ;
            this.news_info = cnK;
            if (xVar.btl()) {
                this.fFF.setVisibility(0);
            } else {
                this.fFF.setVisibility(8);
            }
            if (this.top_code == null) {
                this.fFv.setVisibility(8);
                this.fFC.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.fFv.setVisibility(8);
                this.fFC.setVisibility(8);
            } else {
                this.fFv.setVisibility(0);
                this.fFC.setVisibility(0);
                this.fFx.startLoad(this.top_code.ahd(), 10, false);
                this.fFy.setText(this.top_code.getSummary());
                if (StringUtils.isNull(cnJ.akB())) {
                    this.fFB.setVisibility(8);
                } else {
                    this.fFB.setText(cnJ.akB());
                    this.fFB.setVisibility(0);
                }
                int aky = this.top_code.aky();
                if (aky == 1 || aky == 2) {
                    if (StringUtils.isNull(this.top_code.akz())) {
                        this.fFz.setVisibility(8);
                    } else {
                        String str = this.ceu.getResources().getString(R.string.u9_shengyu) + this.top_code.akz();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.akz(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fFz.setText(spannableString);
                        this.fFz.setVisibility(0);
                    }
                    if (cnJ.akA() <= 0) {
                        this.fFA.setVisibility(8);
                    } else {
                        String str2 = this.ceu.getResources().getString(R.string.u9_worth) + this.top_code.akA();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.akA()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.fFA.setText(spannableString2);
                        this.fFA.setVisibility(0);
                    }
                } else {
                    this.fFA.setVisibility(8);
                    this.fFz.setText(cnJ.getSubTitle());
                    this.fFz.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(cnK.getSummary())) {
                this.fFw.setVisibility(8);
                return;
            }
            this.fFw.setVisibility(0);
            this.fFD.setText(cnK.getSummary());
        }
    }

    public void bnv() {
        this.fFv.setOnClickListener(this.ajc);
        this.fFw.setOnClickListener(this.ajc);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.fFE, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.fFB, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.fFB, (int) R.drawable.frs_text_color_selector);
            this.ceu.getLayoutMode().setNightMode(i == 1);
            this.ceu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
