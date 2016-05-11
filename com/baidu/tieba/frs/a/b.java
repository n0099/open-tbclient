package com.baidu.tieba.frs.a;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.aj;
/* loaded from: classes.dex */
public class b extends y.a {
    private TbPageContext Do;
    View.OnClickListener aTj;
    private View biC;
    private RelativeLayout bnF;
    private LinearLayout bnG;
    private TbImageView bnH;
    private TextView bnI;
    private TextView bnJ;
    private TextView bnK;
    private TextView bnL;
    private View bnM;
    private TextView bnN;
    private ImageView bnO;
    private int mSkinType;
    private bc news_info;
    private az top_code;

    public b(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.aTj = new c(this);
        this.Do = tbPageContext;
        this.bnF = (RelativeLayout) view.findViewById(t.g.u9_top_code);
        this.bnG = (LinearLayout) view.findViewById(t.g.u9_news_info);
        this.bnH = (TbImageView) view.findViewById(t.g.top_code_img);
        this.bnI = (TextView) view.findViewById(t.g.top_code_detail_summary_text);
        this.bnJ = (TextView) view.findViewById(t.g.top_code_detail_surplus_text);
        this.bnK = (TextView) view.findViewById(t.g.top_code_detail_giftworth_text);
        this.bnL = (TextView) view.findViewById(t.g.top_code_getnum_btn);
        this.bnM = view.findViewById(t.g.u9_top_code_divider);
        this.bnO = (ImageView) view.findViewById(t.g.news_info_img);
        this.bnO.setBackgroundDrawable(at.getDrawable(t.f.icon_frs_news));
        this.bnN = (TextView) view.findViewById(t.g.news_info_text);
        this.biC = view.findViewById(t.g.frs_list_item_u9_top_line);
        at.k(this.bnL, t.f.frs_star_btn_like);
        at.j((View) this.bnL, t.f.frs_text_color_selector);
        Sb();
    }

    public void a(aj ajVar) {
        if (ajVar != null) {
            az aTh = ajVar.aTh();
            bc aTi = ajVar.aTi();
            this.top_code = aTh;
            this.news_info = aTi;
            if (ajVar.aTg()) {
                this.biC.setVisibility(0);
            } else {
                this.biC.setVisibility(8);
            }
            if (this.top_code == null) {
                this.bnF.setVisibility(8);
                this.bnM.setVisibility(8);
            } else if (StringUtils.isNull(this.top_code.rB())) {
                this.bnF.setVisibility(8);
                this.bnM.setVisibility(8);
            } else {
                this.bnF.setVisibility(0);
                this.bnM.setVisibility(0);
                this.bnH.c(this.top_code.qv(), 10, false);
                this.bnI.setText(this.top_code.rB());
                if (StringUtils.isNull(aTh.rG())) {
                    this.bnL.setVisibility(8);
                } else {
                    this.bnL.setText(aTh.rG());
                    this.bnL.setVisibility(0);
                }
                int rD = this.top_code.rD();
                if (rD == 1 || rD == 2) {
                    if (StringUtils.isNull(this.top_code.rE())) {
                        this.bnJ.setVisibility(8);
                    } else {
                        String str = String.valueOf(this.Do.getResources().getString(t.j.u9_shengyu)) + this.top_code.rE();
                        SpannableString spannableString = new SpannableString(str);
                        UtilHelper.setSpan(spannableString, str, this.top_code.rE(), new ForegroundColorSpan(at.getColor(t.d.cp_link_tip_d)));
                        this.bnJ.setText(spannableString);
                        this.bnJ.setVisibility(0);
                    }
                    if (aTh.rF() <= 0) {
                        this.bnK.setVisibility(8);
                    } else {
                        String str2 = String.valueOf(this.Do.getResources().getString(t.j.u9_worth)) + this.top_code.rF();
                        SpannableString spannableString2 = new SpannableString(str2);
                        UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.rF()), new ForegroundColorSpan(at.getColor(t.d.cp_link_tip_d)));
                        this.bnK.setText(spannableString2);
                        this.bnK.setVisibility(0);
                    }
                } else {
                    this.bnK.setVisibility(8);
                    this.bnJ.setText(aTh.getSubTitle());
                    this.bnJ.setVisibility(0);
                }
            }
            if (this.news_info == null || StringUtils.isNull(aTi.rB())) {
                this.bnG.setVisibility(8);
                return;
            }
            this.bnG.setVisibility(0);
            this.bnN.setText(aTi.rB());
        }
    }

    public void Sb() {
        this.bnF.setOnClickListener(this.aTj);
        this.bnG.setOnClickListener(this.aTj);
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            at.k(this.bnO, t.f.icon_frs_news);
            at.k(this.bnL, t.f.frs_star_btn_like);
            at.j((View) this.bnL, t.f.frs_text_color_selector);
            this.Do.getLayoutMode().ae(i == 1);
            this.Do.getLayoutMode().x(getView());
            this.mSkinType = i;
        }
    }
}
