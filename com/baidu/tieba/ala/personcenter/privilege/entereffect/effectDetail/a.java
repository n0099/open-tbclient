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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes4.dex */
public class a {
    private TextView hHA;
    private AlaEnterEffectData hHk;
    private InterfaceC0704a hHq;
    private TextView hHt;
    private TextView hHu;
    private TextView hHv;
    private TextView hHw;
    private TextView hHx;
    private LinearLayout hHy;
    private LinearLayout hHz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0704a {
        void PI();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hHk = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hHt = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hHu = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hHv = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hHw = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hHx = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hHy = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hHz = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hHA = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hHk = alaEnterEffectData;
            this.hHw.setEnabled(true);
            if (3 != this.hHk.categoryType) {
                if (2 == this.hHk.categoryType) {
                    this.hHw.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hHw.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.hHy.setVisibility(0);
                    this.hHx.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hHx.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hHx.setCompoundDrawables(drawable, null, null, null);
                    this.hHz.setVisibility(0);
                    this.hHA.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hHA.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hHA.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hHv.setVisibility(0);
                    this.hHw.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hHw.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hHk.isOwn) {
                if (this.hHk.isUsing()) {
                    this.hHw.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hHw.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hHw.setText(R.string.ala_stop_use);
                    if (2 == this.hHk.categoryType) {
                        this.hHz.setVisibility(8);
                    }
                } else {
                    this.hHw.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hHk.categoryType) {
                this.hHw.setText(R.string.ala_nobility_open);
                this.hHu.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hHk.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hHk.price) {
                    this.hHw.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hHw.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hHw.setBackgroundDrawable(null);
                this.hHw.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hHw.setText(R.string.ala_enter_effect_not_own);
                this.hHw.setEnabled(false);
            }
            this.hHw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hHq != null) {
                        a.this.hHq.PI();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hHt.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hHu.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hHv.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void IK(String str) {
        if (this.hHk != null && 2 == this.hHk.categoryType && this.hHw != null) {
            this.hHw.setText(str);
        }
    }

    public RelativeLayout cka() {
        return this.mRootView;
    }

    public void a(InterfaceC0704a interfaceC0704a) {
        this.hHq = interfaceC0704a;
    }
}
