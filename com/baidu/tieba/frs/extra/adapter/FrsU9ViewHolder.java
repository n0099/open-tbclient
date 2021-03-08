package com.baidu.tieba.frs.extra.adapter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.cd;
import com.baidu.tbadk.core.data.cg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes2.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aFH;
    private TbPageContext eWx;
    private RelativeLayout jwg;
    private LinearLayout jwh;
    private TbImageView jwi;
    private TextView jwj;
    private TextView jwk;
    private TextView jwl;
    private TextView jwm;
    private View jwn;
    private TextView jwo;
    private ImageView jwp;
    private View jwq;
    private int mSkinType;
    private cg news_info;
    private cd top_code;

    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(FrsU9ViewHolder.this.eWx.getPageActivity()) && l.isNetOk()) {
                    if (view2 == FrsU9ViewHolder.this.jwg) {
                        if (FrsU9ViewHolder.this.top_code != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.top_code.bqf())) {
                            TiebaStatic.eventStat(FrsU9ViewHolder.this.eWx.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bf.bsY().b((TbPageContext) j.J(FrsU9ViewHolder.this.eWx.getPageActivity()), new String[]{FrsU9ViewHolder.this.top_code.bqf()});
                        }
                    } else if (view2 == FrsU9ViewHolder.this.jwh && FrsU9ViewHolder.this.news_info != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.news_info.bqm())) {
                        TiebaStatic.eventStat(FrsU9ViewHolder.this.eWx.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bf.bsY().b((TbPageContext) j.J(FrsU9ViewHolder.this.eWx.getPageActivity()), new String[]{FrsU9ViewHolder.this.news_info.bqm()});
                    }
                }
            }
        };
        this.eWx = tbPageContext;
        this.jwg = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.jwh = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.jwi = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jwi.setPageId(bdUniqueId);
        this.jwj = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jwk = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.jwl = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.jwm = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.jwn = view.findViewById(R.id.u9_top_code_divider);
        this.jwp = (ImageView) view.findViewById(R.id.news_info_img);
        this.jwp.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.jwo = (TextView) view.findViewById(R.id.news_info_text);
        this.jwq = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.jwm, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.jwm, R.drawable.frs_text_color_selector);
        cHf();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            cd dNk = adVar.dNk();
            cg dNl = adVar.dNl();
            this.top_code = dNk;
            this.news_info = dNl;
            if (adVar.dNj()) {
                this.jwq.setVisibility(0);
            } else {
                this.jwq.setVisibility(8);
            }
            if (this.top_code == null) {
                this.jwg.setVisibility(8);
                this.jwn.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.jwg.setVisibility(8);
                this.jwn.setVisibility(8);
            } else {
                this.jwg.setVisibility(0);
                this.jwn.setVisibility(0);
                this.jwi.startLoad(this.top_code.getImgUrl(), 10, false);
                this.jwj.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dNk.bqj())) {
                    this.jwm.setVisibility(8);
                } else {
                    this.jwm.setText(dNk.bqj());
                    this.jwm.setVisibility(0);
                }
                int bqg = this.top_code.bqg();
                if (bqg == 1 || bqg == 2) {
                    if (StringUtils.isNull(this.top_code.bqh())) {
                        this.jwk.setVisibility(8);
                    } else {
                        String str = this.eWx.getResources().getString(R.string.u9_shengyu) + this.top_code.bqh();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bqh(), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.jwk.setText(spannableString);
                        this.jwk.setVisibility(0);
                    }
                    if (dNk.bqi() <= 0) {
                        this.jwl.setVisibility(8);
                    } else {
                        String str2 = this.eWx.getResources().getString(R.string.u9_worth) + this.top_code.bqi();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bqi()), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.jwl.setText(spannableString2);
                        this.jwl.setVisibility(0);
                    }
                } else {
                    this.jwl.setVisibility(8);
                    this.jwk.setText(dNk.getSubTitle());
                    this.jwk.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dNl.getSummary())) {
                this.jwh.setVisibility(8);
                return;
            }
            this.jwh.setVisibility(0);
            this.jwo.setText(dNl.getSummary());
        }
    }

    public void cHf() {
        this.jwg.setOnClickListener(this.aFH);
        this.jwh.setOnClickListener(this.aFH);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jwp, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.jwm, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.jwm, R.drawable.frs_text_color_selector);
            this.eWx.getLayoutMode().setNightMode(i == 1);
            this.eWx.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
