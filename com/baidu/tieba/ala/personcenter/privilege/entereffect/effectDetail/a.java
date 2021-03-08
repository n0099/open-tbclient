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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes9.dex */
public class a {
    private AlaEnterEffectData ieK;
    private InterfaceC0699a ieQ;
    private TextView ieT;
    private TextView ieU;
    private TextView ieV;
    private TextView ieW;
    private TextView ieX;
    private LinearLayout ieY;
    private LinearLayout ieZ;
    private TextView ifa;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0699a {
        void Qd();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.ieK = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.ieT = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.ieU = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.ieV = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.ieW = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.ieX = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.ieY = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.ieZ = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.ifa = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.ieK = alaEnterEffectData;
            this.ieW.setEnabled(true);
            if (3 != this.ieK.categoryType) {
                if (2 == this.ieK.categoryType) {
                    this.ieW.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.ieW.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.ieY.setVisibility(0);
                    this.ieX.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.ieX.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.ieX.setCompoundDrawables(drawable, null, null, null);
                    this.ieZ.setVisibility(0);
                    this.ifa.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.ifa.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.ifa.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.ieV.setVisibility(0);
                    this.ieW.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.ieW.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.ieK.isOwn) {
                if (this.ieK.isUsing()) {
                    this.ieW.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.ieW.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.ieW.setText(R.string.ala_stop_use);
                    if (2 == this.ieK.categoryType) {
                        this.ieZ.setVisibility(8);
                    }
                } else {
                    this.ieW.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.ieK.categoryType) {
                this.ieW.setText(R.string.ala_nobility_open);
                this.ieU.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.ieK.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.ieK.price) {
                    this.ieW.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.ieW.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.ieW.setBackgroundDrawable(null);
                this.ieW.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.ieW.setText(R.string.ala_enter_effect_not_own);
                this.ieW.setEnabled(false);
            }
            this.ieW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.ieQ != null) {
                        a.this.ieQ.Qd();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.ieT.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.ieU.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.ieV.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void IA(String str) {
        if (this.ieK != null && 2 == this.ieK.categoryType && this.ieW != null) {
            this.ieW.setText(str);
        }
    }

    public RelativeLayout cnA() {
        return this.mRootView;
    }

    public void a(InterfaceC0699a interfaceC0699a) {
        this.ieQ = interfaceC0699a;
    }
}
