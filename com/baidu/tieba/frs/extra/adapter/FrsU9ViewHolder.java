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
    View.OnClickListener aEh;
    private TbPageContext eUY;
    private RelativeLayout juj;
    private LinearLayout juk;
    private TbImageView jul;
    private TextView jum;
    private TextView jun;
    private TextView juo;
    private TextView jup;
    private View juq;
    private TextView jur;
    private ImageView jus;
    private View jut;
    private int mSkinType;
    private cg news_info;
    private cd top_code;

    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(FrsU9ViewHolder.this.eUY.getPageActivity()) && l.isNetOk()) {
                    if (view2 == FrsU9ViewHolder.this.juj) {
                        if (FrsU9ViewHolder.this.top_code != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.top_code.bqd())) {
                            TiebaStatic.eventStat(FrsU9ViewHolder.this.eUY.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bf.bsV().b((TbPageContext) j.K(FrsU9ViewHolder.this.eUY.getPageActivity()), new String[]{FrsU9ViewHolder.this.top_code.bqd()});
                        }
                    } else if (view2 == FrsU9ViewHolder.this.juk && FrsU9ViewHolder.this.news_info != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.news_info.bqk())) {
                        TiebaStatic.eventStat(FrsU9ViewHolder.this.eUY.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bf.bsV().b((TbPageContext) j.K(FrsU9ViewHolder.this.eUY.getPageActivity()), new String[]{FrsU9ViewHolder.this.news_info.bqk()});
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.juj = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.juk = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.jul = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jul.setPageId(bdUniqueId);
        this.jum = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jun = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.juo = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.jup = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.juq = view.findViewById(R.id.u9_top_code_divider);
        this.jus = (ImageView) view.findViewById(R.id.news_info_img);
        this.jus.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.jur = (TextView) view.findViewById(R.id.news_info_text);
        this.jut = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.jup, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.jup, R.drawable.frs_text_color_selector);
        cGS();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            cd dMU = adVar.dMU();
            cg dMV = adVar.dMV();
            this.top_code = dMU;
            this.news_info = dMV;
            if (adVar.dMT()) {
                this.jut.setVisibility(0);
            } else {
                this.jut.setVisibility(8);
            }
            if (this.top_code == null) {
                this.juj.setVisibility(8);
                this.juq.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.juj.setVisibility(8);
                this.juq.setVisibility(8);
            } else {
                this.juj.setVisibility(0);
                this.juq.setVisibility(0);
                this.jul.startLoad(this.top_code.getImgUrl(), 10, false);
                this.jum.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dMU.bqh())) {
                    this.jup.setVisibility(8);
                } else {
                    this.jup.setText(dMU.bqh());
                    this.jup.setVisibility(0);
                }
                int bqe = this.top_code.bqe();
                if (bqe == 1 || bqe == 2) {
                    if (StringUtils.isNull(this.top_code.bqf())) {
                        this.jun.setVisibility(8);
                    } else {
                        String str = this.eUY.getResources().getString(R.string.u9_shengyu) + this.top_code.bqf();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bqf(), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.jun.setText(spannableString);
                        this.jun.setVisibility(0);
                    }
                    if (dMU.bqg() <= 0) {
                        this.juo.setVisibility(8);
                    } else {
                        String str2 = this.eUY.getResources().getString(R.string.u9_worth) + this.top_code.bqg();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bqg()), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.juo.setText(spannableString2);
                        this.juo.setVisibility(0);
                    }
                } else {
                    this.juo.setVisibility(8);
                    this.jun.setText(dMU.getSubTitle());
                    this.jun.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dMV.getSummary())) {
                this.juk.setVisibility(8);
                return;
            }
            this.juk.setVisibility(0);
            this.jur.setText(dMV.getSummary());
        }
    }

    public void cGS() {
        this.juj.setOnClickListener(this.aEh);
        this.juk.setOnClickListener(this.aEh);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.jus, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.jup, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.jup, R.drawable.frs_text_color_selector);
            this.eUY.getLayoutMode().setNightMode(i == 1);
            this.eUY.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
