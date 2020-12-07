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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes22.dex */
public class c extends af.a {
    View.OnClickListener aGQ;
    private TbPageContext eNx;
    private RelativeLayout jgH;
    private LinearLayout jgI;
    private TbImageView jgJ;
    private TextView jgK;
    private TextView jgL;
    private TextView jgM;
    private TextView jgN;
    private View jgO;
    private TextView jgP;
    private ImageView jgQ;
    private View jgR;
    private int mSkinType;
    private cd news_info;
    private ca top_code;

    public c(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.a.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(c.this.eNx.getPageActivity()) && l.isNetOk()) {
                    if (view2 == c.this.jgH) {
                        if (c.this.top_code != null && !TextUtils.isEmpty(c.this.top_code.brc())) {
                            TiebaStatic.eventStat(c.this.eNx.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bf.bua().b((TbPageContext) i.J(c.this.eNx.getPageActivity()), new String[]{c.this.top_code.brc()});
                        }
                    } else if (view2 == c.this.jgI && c.this.news_info != null && !TextUtils.isEmpty(c.this.news_info.brj())) {
                        TiebaStatic.eventStat(c.this.eNx.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bf.bua().b((TbPageContext) i.J(c.this.eNx.getPageActivity()), new String[]{c.this.news_info.brj()});
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.jgH = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.jgI = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.jgJ = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jgJ.setPageId(bdUniqueId);
        this.jgK = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jgL = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.jgM = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.jgN = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.jgO = view.findViewById(R.id.u9_top_code_divider);
        this.jgQ = (ImageView) view.findViewById(R.id.news_info_img);
        this.jgQ.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.jgP = (TextView) view.findViewById(R.id.news_info_text);
        this.jgR = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.jgN, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.jgN, (int) R.drawable.frs_text_color_selector);
        cGw();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            ca dOH = adVar.dOH();
            cd dOI = adVar.dOI();
            this.top_code = dOH;
            this.news_info = dOI;
            if (adVar.dOG()) {
                this.jgR.setVisibility(0);
            } else {
                this.jgR.setVisibility(8);
            }
            if (this.top_code == null) {
                this.jgH.setVisibility(8);
                this.jgO.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.jgH.setVisibility(8);
                this.jgO.setVisibility(8);
            } else {
                this.jgH.setVisibility(0);
                this.jgO.setVisibility(0);
                this.jgJ.startLoad(this.top_code.bmL(), 10, false);
                this.jgK.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dOH.brg())) {
                    this.jgN.setVisibility(8);
                } else {
                    this.jgN.setText(dOH.brg());
                    this.jgN.setVisibility(0);
                }
                int brd = this.top_code.brd();
                if (brd == 1 || brd == 2) {
                    if (StringUtils.isNull(this.top_code.bre())) {
                        this.jgL.setVisibility(8);
                    } else {
                        String str = this.eNx.getResources().getString(R.string.u9_shengyu) + this.top_code.bre();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bre(), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.jgL.setText(spannableString);
                        this.jgL.setVisibility(0);
                    }
                    if (dOH.brf() <= 0) {
                        this.jgM.setVisibility(8);
                    } else {
                        String str2 = this.eNx.getResources().getString(R.string.u9_worth) + this.top_code.brf();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.brf()), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.jgM.setText(spannableString2);
                        this.jgM.setVisibility(0);
                    }
                } else {
                    this.jgM.setVisibility(8);
                    this.jgL.setText(dOH.getSubTitle());
                    this.jgL.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dOI.getSummary())) {
                this.jgI.setVisibility(8);
                return;
            }
            this.jgI.setVisibility(0);
            this.jgP.setText(dOI.getSummary());
        }
    }

    public void cGw() {
        this.jgH.setOnClickListener(this.aGQ);
        this.jgI.setOnClickListener(this.aGQ);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jgQ, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.jgN, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.jgN, (int) R.drawable.frs_text_color_selector);
            this.eNx.getLayoutMode().setNightMode(i == 1);
            this.eNx.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
