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
    private AlaEnterEffectData fuO;
    private InterfaceC0476a fuU;
    private TextView fuX;
    private TextView fuY;
    private TextView fuZ;
    private TextView fva;
    private TextView fvb;
    private LinearLayout fvc;
    private LinearLayout fvd;
    private TextView fve;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0476a {
        void yV();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.fuO = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.fuX = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.fuY = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.fuZ = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.fva = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.fvb = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.fvc = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.fvd = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.fve = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fuO = alaEnterEffectData;
            this.fva.setEnabled(true);
            if (3 != this.fuO.categoryType) {
                if (2 == this.fuO.categoryType) {
                    this.fva.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fva.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.fvc.setVisibility(0);
                    this.fvb.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.fvb.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.fvb.setCompoundDrawables(drawable, null, null, null);
                    this.fvd.setVisibility(0);
                    this.fve.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.fve.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.fve.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.fuZ.setVisibility(0);
                    this.fva.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fva.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.fuO.isOwn) {
                if (this.fuO.isUsing()) {
                    this.fva.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fva.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.fva.setText(R.string.ala_stop_use);
                    if (2 == this.fuO.categoryType) {
                        this.fvd.setVisibility(8);
                    }
                } else {
                    this.fva.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.fuO.categoryType) {
                this.fva.setText(R.string.ala_nobility_open);
                this.fuY.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.fuO.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.fuO.price) {
                    this.fva.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.fva.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.fva.setBackgroundDrawable(null);
                this.fva.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.fva.setText(R.string.ala_enter_effect_not_own);
                this.fva.setEnabled(false);
            }
            this.fva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fuU != null) {
                        a.this.fuU.yV();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.fuX.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.fuY.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.fuZ.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zq(String str) {
        if (this.fuO != null && 2 == this.fuO.categoryType && this.fva != null) {
            this.fva.setText(str);
        }
    }

    public RelativeLayout bqY() {
        return this.mRootView;
    }

    public void a(InterfaceC0476a interfaceC0476a) {
        this.fuU = interfaceC0476a;
    }
}
