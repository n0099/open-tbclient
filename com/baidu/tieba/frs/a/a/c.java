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
    private RelativeLayout hyB;
    private LinearLayout hyC;
    private TbImageView hyD;
    private TextView hyE;
    private TextView hyF;
    private TextView hyG;
    private TextView hyH;
    private View hyI;
    private TextView hyJ;
    private ImageView hyK;
    private View hyL;
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
                    if (view2 == c.this.hyB) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.aSE())) {
                            TiebaStatic.eventStat(c.this.dIF.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            ba.aUZ().b((TbPageContext) i.G(c.this.dIF.getPageActivity()), new String[]{c.this.top_code.aSE()});
                        }
                    } else if (view2 == c.this.hyC && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.aSL())) {
                        TiebaStatic.eventStat(c.this.dIF.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        ba.aUZ().b((TbPageContext) i.G(c.this.dIF.getPageActivity()), new String[]{c.this.news_info.aSL()});
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.hyB = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.hyC = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.hyD = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hyD.setPageId(bdUniqueId);
        this.hyE = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hyF = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.hyG = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.hyH = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.hyI = view.findViewById(R.id.u9_top_code_divider);
        this.hyK = (ImageView) view.findViewById(R.id.news_info_img);
        this.hyK.setBackgroundDrawable(am.getDrawable(R.drawable.icon_frs_news));
        this.hyJ = (TextView) view.findViewById(R.id.news_info_text);
        this.hyL = view.findViewById(R.id.frs_list_item_u9_top_line);
        am.setBackgroundResource(this.hyH, R.drawable.frs_star_btn_like);
        am.setViewTextColor(this.hyH, (int) R.drawable.frs_text_color_selector);
        bYE();
    }

    public void a(ab abVar) {
        if (abVar != null) {
            bm dcU = abVar.dcU();
            bp dcV = abVar.dcV();
            this.top_code = dcU;
            this.news_info = dcV;
            if (abVar.dcT()) {
                this.hyL.setVisibility(0);
            } else {
                this.hyL.setVisibility(8);
            }
            if (this.top_code == null) {
                this.hyB.setVisibility(8);
                this.hyI.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.hyB.setVisibility(8);
                this.hyI.setVisibility(8);
            } else {
                this.hyB.setVisibility(0);
                this.hyI.setVisibility(0);
                this.hyD.startLoad(this.top_code.aOP(), 10, false);
                this.hyE.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dcU.aSI())) {
                    this.hyH.setVisibility(8);
                } else {
                    this.hyH.setText(dcU.aSI());
                    this.hyH.setVisibility(0);
                }
                int aSF = this.top_code.aSF();
                if (aSF == 1 || aSF == 2) {
                    if (StringUtils.isNull(this.top_code.aSG())) {
                        this.hyF.setVisibility(8);
                    } else {
                        String str = this.dIF.getResources().getString(R.string.u9_shengyu) + this.top_code.aSG();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.aSG(), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hyF.setText(spannableString);
                        this.hyF.setVisibility(0);
                    }
                    if (dcU.aSH() <= 0) {
                        this.hyG.setVisibility(8);
                    } else {
                        String str2 = this.dIF.getResources().getString(R.string.u9_worth) + this.top_code.aSH();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.aSH()), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_d)));
                        this.hyG.setText(spannableString2);
                        this.hyG.setVisibility(0);
                    }
                } else {
                    this.hyG.setVisibility(8);
                    this.hyF.setText(dcU.getSubTitle());
                    this.hyF.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dcV.getSummary())) {
                this.hyC.setVisibility(8);
                return;
            }
            this.hyC.setVisibility(0);
            this.hyJ.setText(dcV.getSummary());
        }
    }

    public void bYE() {
        this.hyB.setOnClickListener(this.aUZ);
        this.hyC.setOnClickListener(this.aUZ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.hyK, R.drawable.icon_frs_news);
            am.setBackgroundResource(this.hyH, R.drawable.frs_star_btn_like);
            am.setViewTextColor(this.hyH, (int) R.drawable.frs_text_color_selector);
            this.dIF.getLayoutMode().setNightMode(i == 1);
            this.dIF.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
