package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.utils.AlaStringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a {
    private AlaEnterEffectData fxD;
    private InterfaceC0484a fxJ;
    private TextView fxM;
    private TextView fxN;
    private TextView fxO;
    private TextView fxP;
    private TextView fxQ;
    private LinearLayout fxR;
    private LinearLayout fxS;
    private TextView fxT;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0484a {
        void Bn();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.fxD = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.fxM = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.fxN = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.fxO = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.fxP = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.fxQ = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.fxR = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.fxS = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.fxT = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fxD = alaEnterEffectData;
            this.fxP.setEnabled(true);
            if (3 != this.fxD.categoryType) {
                if (2 == this.fxD.categoryType) {
                    this.fxP.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fxP.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.fxR.setVisibility(0);
                    this.fxQ.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.fxQ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.fxQ.setCompoundDrawables(drawable, null, null, null);
                    this.fxS.setVisibility(0);
                    this.fxT.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.fxT.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.fxT.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.fxO.setVisibility(0);
                    this.fxP.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fxP.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.fxD.isOwn) {
                if (this.fxD.isUsing()) {
                    this.fxP.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fxP.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.fxP.setText(R.string.ala_stop_use);
                    if (2 == this.fxD.categoryType) {
                        this.fxS.setVisibility(8);
                    }
                } else {
                    this.fxP.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.fxD.categoryType) {
                this.fxP.setText(R.string.ala_nobility_open);
                this.fxN.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.fxD.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.fxD.price) {
                    this.fxP.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.fxP.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.fxP.setBackgroundDrawable(null);
                this.fxP.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.fxP.setText(R.string.ala_enter_effect_not_own);
                this.fxP.setEnabled(false);
            }
            this.fxP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fxJ != null) {
                        a.this.fxJ.Bn();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.fxM.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.fxN.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.fxO.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zI(String str) {
        if (this.fxD != null && 2 == this.fxD.categoryType && this.fxP != null) {
            this.fxP.setText(str);
        }
    }

    public RelativeLayout bsF() {
        return this.mRootView;
    }

    public void a(InterfaceC0484a interfaceC0484a) {
        this.fxJ = interfaceC0484a;
    }
}
