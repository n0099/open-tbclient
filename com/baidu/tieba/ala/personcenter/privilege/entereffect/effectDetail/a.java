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
    private TextView fxA;
    private TextView fxB;
    private TextView fxC;
    private LinearLayout fxD;
    private LinearLayout fxE;
    private TextView fxF;
    private AlaEnterEffectData fxp;
    private InterfaceC0484a fxv;
    private TextView fxy;
    private TextView fxz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0484a {
        void Bl();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.fxp = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.fxy = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.fxz = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.fxA = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.fxB = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.fxC = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.fxD = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.fxE = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.fxF = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fxp = alaEnterEffectData;
            this.fxB.setEnabled(true);
            if (3 != this.fxp.categoryType) {
                if (2 == this.fxp.categoryType) {
                    this.fxB.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fxB.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.fxD.setVisibility(0);
                    this.fxC.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.fxC.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.fxC.setCompoundDrawables(drawable, null, null, null);
                    this.fxE.setVisibility(0);
                    this.fxF.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.fxF.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.fxF.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.fxA.setVisibility(0);
                    this.fxB.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fxB.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.fxp.isOwn) {
                if (this.fxp.isUsing()) {
                    this.fxB.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fxB.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.fxB.setText(R.string.ala_stop_use);
                    if (2 == this.fxp.categoryType) {
                        this.fxE.setVisibility(8);
                    }
                } else {
                    this.fxB.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.fxp.categoryType) {
                this.fxB.setText(R.string.ala_nobility_open);
                this.fxz.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.fxp.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.fxp.price) {
                    this.fxB.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.fxB.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.fxB.setBackgroundDrawable(null);
                this.fxB.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.fxB.setText(R.string.ala_enter_effect_not_own);
                this.fxB.setEnabled(false);
            }
            this.fxB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fxv != null) {
                        a.this.fxv.Bl();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.fxy.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.fxz.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.fxA.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zH(String str) {
        if (this.fxp != null && 2 == this.fxp.categoryType && this.fxB != null) {
            this.fxB.setText(str);
        }
    }

    public RelativeLayout bsC() {
        return this.mRootView;
    }

    public void a(InterfaceC0484a interfaceC0484a) {
        this.fxv = interfaceC0484a;
    }
}
