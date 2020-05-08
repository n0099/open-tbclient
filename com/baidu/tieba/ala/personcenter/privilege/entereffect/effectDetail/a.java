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
    private AlaEnterEffectData gcO;
    private InterfaceC0541a gcU;
    private TextView gcX;
    private TextView gcY;
    private TextView gcZ;
    private TextView gda;
    private TextView gdb;
    private LinearLayout gdc;
    private LinearLayout gdd;
    private TextView gde;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0541a {
        void Hx();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.gcO = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gcX = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gcY = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gcZ = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gda = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gdb = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gdc = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gdd = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gde = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gcO = alaEnterEffectData;
            this.gda.setEnabled(true);
            if (3 != this.gcO.categoryType) {
                if (2 == this.gcO.categoryType) {
                    this.gda.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gda.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gdc.setVisibility(0);
                    this.gdb.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gdb.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gdb.setCompoundDrawables(drawable, null, null, null);
                    this.gdd.setVisibility(0);
                    this.gde.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gde.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gde.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gcZ.setVisibility(0);
                    this.gda.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gda.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gcO.isOwn) {
                if (this.gcO.isUsing()) {
                    this.gda.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gda.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gda.setText(R.string.ala_stop_use);
                    if (2 == this.gcO.categoryType) {
                        this.gdd.setVisibility(8);
                    }
                } else {
                    this.gda.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gcO.categoryType) {
                this.gda.setText(R.string.ala_nobility_open);
                this.gcY.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gcO.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gcO.price) {
                    this.gda.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gda.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gda.setBackgroundDrawable(null);
                this.gda.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gda.setText(R.string.ala_enter_effect_not_own);
                this.gda.setEnabled(false);
            }
            this.gda.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gcU != null) {
                        a.this.gcU.Hx();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gcX.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gcY.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gcZ.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Bs(String str) {
        if (this.gcO != null && 2 == this.gcO.categoryType && this.gda != null) {
            this.gda.setText(str);
        }
    }

    public RelativeLayout bCr() {
        return this.mRootView;
    }

    public void a(InterfaceC0541a interfaceC0541a) {
        this.gcU = interfaceC0541a;
    }
}
