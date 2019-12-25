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
/* loaded from: classes2.dex */
public class a {
    private AlaEnterEffectData frF;
    private InterfaceC0472a frL;
    private TextView frO;
    private TextView frP;
    private TextView frQ;
    private TextView frR;
    private TextView frS;
    private LinearLayout frT;
    private LinearLayout frU;
    private TextView frV;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0472a {
        void yC();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.frF = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.frO = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.frP = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.frQ = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.frR = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.frS = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.frT = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.frU = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.frV = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.frF = alaEnterEffectData;
            this.frR.setEnabled(true);
            if (3 != this.frF.categoryType) {
                if (2 == this.frF.categoryType) {
                    this.frR.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.frR.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.frT.setVisibility(0);
                    this.frS.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.frS.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.frS.setCompoundDrawables(drawable, null, null, null);
                    this.frU.setVisibility(0);
                    this.frV.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.frV.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.frV.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.frQ.setVisibility(0);
                    this.frR.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.frR.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.frF.isOwn) {
                if (this.frF.isUsing()) {
                    this.frR.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.frR.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.frR.setText(R.string.ala_stop_use);
                    if (2 == this.frF.categoryType) {
                        this.frU.setVisibility(8);
                    }
                } else {
                    this.frR.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.frF.categoryType) {
                this.frR.setText(R.string.ala_nobility_open);
                this.frP.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.frF.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.frF.price) {
                    this.frR.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.frR.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.frR.setBackgroundDrawable(null);
                this.frR.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.frR.setText(R.string.ala_enter_effect_not_own);
                this.frR.setEnabled(false);
            }
            this.frR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.frL != null) {
                        a.this.frL.yC();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.frO.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.frP.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.frQ.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zh(String str) {
        if (this.frF != null && 2 == this.frF.categoryType && this.frR != null) {
            this.frR.setText(str);
        }
    }

    public RelativeLayout bpX() {
        return this.mRootView;
    }

    public void a(InterfaceC0472a interfaceC0472a) {
        this.frL = interfaceC0472a;
    }
}
