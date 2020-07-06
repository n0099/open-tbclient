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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes3.dex */
public class a {
    private AlaEnterEffectData gEH;
    private InterfaceC0600a gEN;
    private TextView gEQ;
    private TextView gER;
    private TextView gES;
    private TextView gET;
    private TextView gEU;
    private LinearLayout gEV;
    private LinearLayout gEW;
    private TextView gEX;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0600a {
        void Hd();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.gEH = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gEQ = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gER = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gES = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gET = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gEU = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gEV = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gEW = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gEX = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gEH = alaEnterEffectData;
            this.gET.setEnabled(true);
            if (3 != this.gEH.categoryType) {
                if (2 == this.gEH.categoryType) {
                    this.gET.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gET.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gEV.setVisibility(0);
                    this.gEU.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gEU.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gEU.setCompoundDrawables(drawable, null, null, null);
                    this.gEW.setVisibility(0);
                    this.gEX.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gEX.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gEX.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gES.setVisibility(0);
                    this.gET.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gET.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gEH.isOwn) {
                if (this.gEH.isUsing()) {
                    this.gET.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gET.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gET.setText(R.string.ala_stop_use);
                    if (2 == this.gEH.categoryType) {
                        this.gEW.setVisibility(8);
                    }
                } else {
                    this.gET.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gEH.categoryType) {
                this.gET.setText(R.string.ala_nobility_open);
                this.gER.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gEH.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gEH.price) {
                    this.gET.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gET.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gET.setBackgroundDrawable(null);
                this.gET.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gET.setText(R.string.ala_enter_effect_not_own);
                this.gET.setEnabled(false);
            }
            this.gET.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gEN != null) {
                        a.this.gEN.Hd();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gEQ.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gER.setText(this.mContext.getResources().getString(R.string.ala_left_time, ar.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gES.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void DC(String str) {
        if (this.gEH != null && 2 == this.gEH.categoryType && this.gET != null) {
            this.gET.setText(str);
        }
    }

    public RelativeLayout bLT() {
        return this.mRootView;
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.gEN = interfaceC0600a;
    }
}
