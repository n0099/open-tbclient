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
/* loaded from: classes4.dex */
public class a {
    private AlaEnterEffectData hGR;
    private InterfaceC0704a hGX;
    private TextView hHa;
    private TextView hHb;
    private TextView hHc;
    private TextView hHd;
    private TextView hHe;
    private LinearLayout hHf;
    private LinearLayout hHg;
    private TextView hHh;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0704a {
        void OZ();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hGR = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hHa = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hHb = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hHc = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hHd = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hHe = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hHf = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hHg = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hHh = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hGR = alaEnterEffectData;
            this.hHd.setEnabled(true);
            if (3 != this.hGR.categoryType) {
                if (2 == this.hGR.categoryType) {
                    this.hHd.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hHd.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.hHf.setVisibility(0);
                    this.hHe.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hHe.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hHe.setCompoundDrawables(drawable, null, null, null);
                    this.hHg.setVisibility(0);
                    this.hHh.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hHh.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hHh.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hHc.setVisibility(0);
                    this.hHd.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hHd.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hGR.isOwn) {
                if (this.hGR.isUsing()) {
                    this.hHd.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hHd.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hHd.setText(R.string.ala_stop_use);
                    if (2 == this.hGR.categoryType) {
                        this.hHg.setVisibility(8);
                    }
                } else {
                    this.hHd.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hGR.categoryType) {
                this.hHd.setText(R.string.ala_nobility_open);
                this.hHb.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hGR.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hGR.price) {
                    this.hHd.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hHd.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hHd.setBackgroundDrawable(null);
                this.hHd.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hHd.setText(R.string.ala_enter_effect_not_own);
                this.hHd.setEnabled(false);
            }
            this.hHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hGX != null) {
                        a.this.hGX.OZ();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hHa.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hHb.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hHc.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Il(String str) {
        if (this.hGR != null && 2 == this.hGR.categoryType && this.hHd != null) {
            this.hHd.setText(str);
        }
    }

    public RelativeLayout cjt() {
        return this.mRootView;
    }

    public void a(InterfaceC0704a interfaceC0704a) {
        this.hGX = interfaceC0704a;
    }
}
