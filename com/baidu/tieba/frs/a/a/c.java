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
    View.OnClickListener aEX;
    private TbPageContext etO;
    private RelativeLayout iCG;
    private LinearLayout iCH;
    private TbImageView iCI;
    private TextView iCJ;
    private TextView iCK;
    private TextView iCL;
    private TextView iCM;
    private View iCN;
    private TextView iCO;
    private ImageView iCP;
    private View iCQ;
    private int mSkinType;
    private cb news_info;
    private by top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(c.this.etO.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.iCG) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.bkq())) {
                            TiebaStatic.eventStat(c.this.etO.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bmY().b((TbPageContext) i.I(c.this.etO.getPageActivity()), new String[]{c.this.top_code.bkq()});
                        }
                    } else if (view2 == c.this.iCH && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.bkx())) {
                        TiebaStatic.eventStat(c.this.etO.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bmY().b((TbPageContext) i.I(c.this.etO.getPageActivity()), new String[]{c.this.news_info.bkx()});
                    }
                }
            }
        };
        this.etO = tbPageContext;
        this.iCG = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.iCH = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.iCI = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iCI.setPageId(bdUniqueId);
        this.iCJ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iCK = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.iCL = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.iCM = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.iCN = view.findViewById(R.id.u9_top_code_divider);
        this.iCP = (ImageView) view.findViewById(R.id.news_info_img);
        this.iCP.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.iCO = (TextView) view.findViewById(R.id.news_info_text);
        this.iCQ = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.iCM, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.iCM, (int) R.drawable.frs_text_color_selector);
        cwR();
    }

    public void a(ac acVar) {
        if (acVar != null) {
            by dDP = acVar.dDP();
            cb dDQ = acVar.dDQ();
            this.top_code = dDP;
            this.news_info = dDQ;
            if (acVar.dDO()) {
                this.iCQ.setVisibility(0);
            } else {
                this.iCQ.setVisibility(8);
            }
            if (this.top_code == null) {
                this.iCG.setVisibility(8);
                this.iCN.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.iCG.setVisibility(8);
                this.iCN.setVisibility(8);
            } else {
                this.iCG.setVisibility(0);
                this.iCN.setVisibility(0);
                this.iCI.startLoad(this.top_code.bgd(), 10, false);
                this.iCJ.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dDP.bku())) {
                    this.iCM.setVisibility(8);
                } else {
                    this.iCM.setText(dDP.bku());
                    this.iCM.setVisibility(0);
                }
                int bkr = this.top_code.bkr();
                if (bkr == 1 || bkr == 2) {
                    if (StringUtils.isNull(this.top_code.bks())) {
                        this.iCK.setVisibility(8);
                    } else {
                        String str = this.etO.getResources().getString(R.string.u9_shengyu) + this.top_code.bks();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bks(), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iCK.setText(spannableString);
                        this.iCK.setVisibility(0);
                    }
                    if (dDP.bkt() <= 0) {
                        this.iCL.setVisibility(8);
                    } else {
                        String str2 = this.etO.getResources().getString(R.string.u9_worth) + this.top_code.bkt();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bkt()), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_d)));
                        this.iCL.setText(spannableString2);
                        this.iCL.setVisibility(0);
                    }
                } else {
                    this.iCL.setVisibility(8);
                    this.iCK.setText(dDP.getSubTitle());
                    this.iCK.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dDQ.getSummary())) {
                this.iCH.setVisibility(8);
                return;
            }
            this.iCH.setVisibility(0);
            this.iCO.setText(dDQ.getSummary());
        }
    }

    public void cwR() {
        this.iCG.setOnClickListener(this.aEX);
        this.iCH.setOnClickListener(this.aEX);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.iCP, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.iCM, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.iCM, (int) R.drawable.frs_text_color_selector);
            this.etO.getLayoutMode().setNightMode(i == 1);
            this.etO.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
