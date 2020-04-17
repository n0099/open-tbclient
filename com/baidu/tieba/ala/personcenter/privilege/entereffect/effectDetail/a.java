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
    private AlaEnterEffectData gcJ;
    private InterfaceC0520a gcP;
    private TextView gcS;
    private TextView gcT;
    private TextView gcU;
    private TextView gcV;
    private TextView gcW;
    private LinearLayout gcX;
    private LinearLayout gcY;
    private TextView gcZ;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0520a {
        void Hy();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.gcJ = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gcS = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gcT = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gcU = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gcV = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gcW = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gcX = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gcY = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gcZ = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gcJ = alaEnterEffectData;
            this.gcV.setEnabled(true);
            if (3 != this.gcJ.categoryType) {
                if (2 == this.gcJ.categoryType) {
                    this.gcV.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gcV.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gcX.setVisibility(0);
                    this.gcW.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gcW.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gcW.setCompoundDrawables(drawable, null, null, null);
                    this.gcY.setVisibility(0);
                    this.gcZ.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gcZ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gcZ.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gcU.setVisibility(0);
                    this.gcV.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gcV.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gcJ.isOwn) {
                if (this.gcJ.isUsing()) {
                    this.gcV.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gcV.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gcV.setText(R.string.ala_stop_use);
                    if (2 == this.gcJ.categoryType) {
                        this.gcY.setVisibility(8);
                    }
                } else {
                    this.gcV.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gcJ.categoryType) {
                this.gcV.setText(R.string.ala_nobility_open);
                this.gcT.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gcJ.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gcJ.price) {
                    this.gcV.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gcV.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gcV.setBackgroundDrawable(null);
                this.gcV.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gcV.setText(R.string.ala_enter_effect_not_own);
                this.gcV.setEnabled(false);
            }
            this.gcV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gcP != null) {
                        a.this.gcP.Hy();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gcS.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gcT.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gcU.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Bp(String str) {
        if (this.gcJ != null && 2 == this.gcJ.categoryType && this.gcV != null) {
            this.gcV.setText(str);
        }
    }

    public RelativeLayout bCt() {
        return this.mRootView;
    }

    public void a(InterfaceC0520a interfaceC0520a) {
        this.gcP = interfaceC0520a;
    }
}
