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
    private AlaEnterEffectData gWK;
    private InterfaceC0659a gWQ;
    private TextView gWT;
    private TextView gWU;
    private TextView gWV;
    private TextView gWW;
    private TextView gWX;
    private LinearLayout gWY;
    private LinearLayout gWZ;
    private TextView gXa;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0659a {
        void Nb();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.gWK = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gWT = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gWU = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gWV = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gWW = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gWX = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gWY = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gWZ = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gXa = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gWK = alaEnterEffectData;
            this.gWW.setEnabled(true);
            if (3 != this.gWK.categoryType) {
                if (2 == this.gWK.categoryType) {
                    this.gWW.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gWW.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gWY.setVisibility(0);
                    this.gWX.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gWX.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gWX.setCompoundDrawables(drawable, null, null, null);
                    this.gWZ.setVisibility(0);
                    this.gXa.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gXa.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gXa.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gWV.setVisibility(0);
                    this.gWW.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gWW.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gWK.isOwn) {
                if (this.gWK.isUsing()) {
                    this.gWW.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gWW.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gWW.setText(R.string.ala_stop_use);
                    if (2 == this.gWK.categoryType) {
                        this.gWZ.setVisibility(8);
                    }
                } else {
                    this.gWW.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gWK.categoryType) {
                this.gWW.setText(R.string.ala_nobility_open);
                this.gWU.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gWK.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gWK.price) {
                    this.gWW.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gWW.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gWW.setBackgroundDrawable(null);
                this.gWW.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gWW.setText(R.string.ala_enter_effect_not_own);
                this.gWW.setEnabled(false);
            }
            this.gWW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gWQ != null) {
                        a.this.gWQ.Nb();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gWT.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gWU.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gWV.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void GN(String str) {
        if (this.gWK != null && 2 == this.gWK.categoryType && this.gWW != null) {
            this.gWW.setText(str);
        }
    }

    public RelativeLayout bZc() {
        return this.mRootView;
    }

    public void a(InterfaceC0659a interfaceC0659a) {
        this.gWQ = interfaceC0659a;
    }
}
