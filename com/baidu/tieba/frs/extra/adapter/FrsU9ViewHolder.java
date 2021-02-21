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
    private TextView juA;
    private TextView juB;
    private TextView juC;
    private TextView juD;
    private View juE;
    private TextView juF;
    private ImageView juG;
    private View juH;
    private RelativeLayout jux;
    private LinearLayout juy;
    private TbImageView juz;
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
                    if (view2 == FrsU9ViewHolder.this.jux) {
                        if (FrsU9ViewHolder.this.top_code != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.top_code.bqd())) {
                            TiebaStatic.eventStat(FrsU9ViewHolder.this.eUY.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            bf.bsV().b((TbPageContext) j.K(FrsU9ViewHolder.this.eUY.getPageActivity()), new String[]{FrsU9ViewHolder.this.top_code.bqd()});
                        }
                    } else if (view2 == FrsU9ViewHolder.this.juy && FrsU9ViewHolder.this.news_info != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.news_info.bqk())) {
                        TiebaStatic.eventStat(FrsU9ViewHolder.this.eUY.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        bf.bsV().b((TbPageContext) j.K(FrsU9ViewHolder.this.eUY.getPageActivity()), new String[]{FrsU9ViewHolder.this.news_info.bqk()});
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.jux = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.juy = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.juz = (TbImageView) view.findViewById(R.id.top_code_img);
        this.juz.setPageId(bdUniqueId);
        this.juA = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.juB = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.juC = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.juD = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.juE = view.findViewById(R.id.u9_top_code_divider);
        this.juG = (ImageView) view.findViewById(R.id.news_info_img);
        this.juG.setBackgroundDrawable(ap.getDrawable(R.drawable.icon_frs_news));
        this.juF = (TextView) view.findViewById(R.id.news_info_text);
        this.juH = view.findViewById(R.id.frs_list_item_u9_top_line);
        ap.setBackgroundResource(this.juD, R.drawable.frs_star_btn_like);
        ap.setViewTextColor(this.juD, R.drawable.frs_text_color_selector);
        cGZ();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            cd dNc = adVar.dNc();
            cg dNd = adVar.dNd();
            this.top_code = dNc;
            this.news_info = dNd;
            if (adVar.dNb()) {
                this.juH.setVisibility(0);
            } else {
                this.juH.setVisibility(8);
            }
            if (this.top_code == null) {
                this.jux.setVisibility(8);
                this.juE.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.jux.setVisibility(8);
                this.juE.setVisibility(8);
            } else {
                this.jux.setVisibility(0);
                this.juE.setVisibility(0);
                this.juz.startLoad(this.top_code.getImgUrl(), 10, false);
                this.juA.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dNc.bqh())) {
                    this.juD.setVisibility(8);
                } else {
                    this.juD.setText(dNc.bqh());
                    this.juD.setVisibility(0);
                }
                int bqe = this.top_code.bqe();
                if (bqe == 1 || bqe == 2) {
                    if (StringUtils.isNull(this.top_code.bqf())) {
                        this.juB.setVisibility(8);
                    } else {
                        String str = this.eUY.getResources().getString(R.string.u9_shengyu) + this.top_code.bqf();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bqf(), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.juB.setText(spannableString);
                        this.juB.setVisibility(0);
                    }
                    if (dNc.bqg() <= 0) {
                        this.juC.setVisibility(8);
                    } else {
                        String str2 = this.eUY.getResources().getString(R.string.u9_worth) + this.top_code.bqg();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bqg()), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0305)));
                        this.juC.setText(spannableString2);
                        this.juC.setVisibility(0);
                    }
                } else {
                    this.juC.setVisibility(8);
                    this.juB.setText(dNc.getSubTitle());
                    this.juB.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dNd.getSummary())) {
                this.juy.setVisibility(8);
                return;
            }
            this.juy.setVisibility(0);
            this.juF.setText(dNd.getSummary());
        }
    }

    public void cGZ() {
        this.jux.setOnClickListener(this.aEh);
        this.juy.setOnClickListener(this.aEh);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.juG, R.drawable.icon_frs_news);
            ap.setBackgroundResource(this.juD, R.drawable.frs_star_btn_like);
            ap.setViewTextColor(this.juD, R.drawable.frs_text_color_selector);
            this.eUY.getLayoutMode().setNightMode(i == 1);
            this.eUY.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
