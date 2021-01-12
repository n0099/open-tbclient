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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.ce;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes2.dex */
public class FrsU9ViewHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aCu;
    private TbPageContext eSJ;
    private RelativeLayout joD;
    private LinearLayout joE;
    private TbImageView joF;
    private TextView joG;
    private TextView joH;
    private TextView joI;
    private TextView joJ;
    private View joK;
    private TextView joL;
    private ImageView joM;
    private View joN;
    private int mSkinType;
    private ce news_info;
    private cb top_code;

    public FrsU9ViewHolder(TbPageContext tbPageContext, View view, BdUniqueId bdUniqueId) {
        super(view);
        this.mSkinType = 3;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.extra.adapter.FrsU9ViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(FrsU9ViewHolder.this.eSJ.getPageActivity()) && l.isNetOk()) {
                    if (view2 == FrsU9ViewHolder.this.joD) {
                        if (FrsU9ViewHolder.this.top_code != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.top_code.bpL())) {
                            TiebaStatic.eventStat(FrsU9ViewHolder.this.eSJ.getPageActivity(), "num_click", "click", 1, new Object[0]);
                            be.bsB().b((TbPageContext) j.K(FrsU9ViewHolder.this.eSJ.getPageActivity()), new String[]{FrsU9ViewHolder.this.top_code.bpL()});
                        }
                    } else if (view2 == FrsU9ViewHolder.this.joE && FrsU9ViewHolder.this.news_info != null && !TextUtils.isEmpty(FrsU9ViewHolder.this.news_info.bpS())) {
                        TiebaStatic.eventStat(FrsU9ViewHolder.this.eSJ.getPageActivity(), "info_click", "click", 1, "page", "frs");
                        be.bsB().b((TbPageContext) j.K(FrsU9ViewHolder.this.eSJ.getPageActivity()), new String[]{FrsU9ViewHolder.this.news_info.bpS()});
                    }
                }
            }
        };
        this.eSJ = tbPageContext;
        this.joD = (RelativeLayout) view.findViewById(R.id.u9_top_code);
        this.joE = (LinearLayout) view.findViewById(R.id.u9_news_info);
        this.joF = (TbImageView) view.findViewById(R.id.top_code_img);
        this.joF.setPageId(bdUniqueId);
        this.joG = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.joH = (TextView) view.findViewById(R.id.top_code_detail_surplus_text);
        this.joI = (TextView) view.findViewById(R.id.top_code_detail_giftworth_text);
        this.joJ = (TextView) view.findViewById(R.id.top_code_getnum_btn);
        this.joK = view.findViewById(R.id.u9_top_code_divider);
        this.joM = (ImageView) view.findViewById(R.id.news_info_img);
        this.joM.setBackgroundDrawable(ao.getDrawable(R.drawable.icon_frs_news));
        this.joL = (TextView) view.findViewById(R.id.news_info_text);
        this.joN = view.findViewById(R.id.frs_list_item_u9_top_line);
        ao.setBackgroundResource(this.joJ, R.drawable.frs_star_btn_like);
        ao.setViewTextColor(this.joJ, R.drawable.frs_text_color_selector);
        cFF();
    }

    public void a(ad adVar) {
        if (adVar != null) {
            cb dKJ = adVar.dKJ();
            ce dKK = adVar.dKK();
            this.top_code = dKJ;
            this.news_info = dKK;
            if (adVar.dKI()) {
                this.joN.setVisibility(0);
            } else {
                this.joN.setVisibility(8);
            }
            if (this.top_code == null) {
                this.joD.setVisibility(8);
                this.joK.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.getSummary())) {
                this.joD.setVisibility(8);
                this.joK.setVisibility(8);
            } else {
                this.joD.setVisibility(0);
                this.joK.setVisibility(0);
                this.joF.startLoad(this.top_code.getImgUrl(), 10, false);
                this.joG.setText(this.top_code.getSummary());
                if (StringUtils.isNull(dKJ.bpP())) {
                    this.joJ.setVisibility(8);
                } else {
                    this.joJ.setText(dKJ.bpP());
                    this.joJ.setVisibility(0);
                }
                int bpM = this.top_code.bpM();
                if (bpM == 1 || bpM == 2) {
                    if (StringUtils.isNull(this.top_code.bpN())) {
                        this.joH.setVisibility(8);
                    } else {
                        String str = this.eSJ.getResources().getString(R.string.u9_shengyu) + this.top_code.bpN();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.bpN(), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
                        this.joH.setText(spannableString);
                        this.joH.setVisibility(0);
                    }
                    if (dKJ.bpO() <= 0) {
                        this.joI.setVisibility(8);
                    } else {
                        String str2 = this.eSJ.getResources().getString(R.string.u9_worth) + this.top_code.bpO();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.bpO()), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0305)));
                        this.joI.setText(spannableString2);
                        this.joI.setVisibility(0);
                    }
                } else {
                    this.joI.setVisibility(8);
                    this.joH.setText(dKJ.getSubTitle());
                    this.joH.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(dKK.getSummary())) {
                this.joE.setVisibility(8);
                return;
            }
            this.joE.setVisibility(0);
            this.joL.setText(dKK.getSummary());
        }
    }

    public void cFF() {
        this.joD.setOnClickListener(this.aCu);
        this.joE.setOnClickListener(this.aCu);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.joM, R.drawable.icon_frs_news);
            ao.setBackgroundResource(this.joJ, R.drawable.frs_star_btn_like);
            ao.setViewTextColor(this.joJ, R.drawable.frs_text_color_selector);
            this.eSJ.getLayoutMode().setNightMode(i == 1);
            this.eSJ.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }
}
