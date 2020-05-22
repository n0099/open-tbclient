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
    private AlaEnterEffectData grI;
    private InterfaceC0591a grO;
    private TextView grR;
    private TextView grS;
    private TextView grT;
    private TextView grU;
    private TextView grV;
    private LinearLayout grW;
    private LinearLayout grX;
    private TextView grY;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0591a {
        void Jq();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.grI = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.grR = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.grS = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.grT = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.grU = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.grV = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.grW = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.grX = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.grY = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.grI = alaEnterEffectData;
            this.grU.setEnabled(true);
            if (3 != this.grI.categoryType) {
                if (2 == this.grI.categoryType) {
                    this.grU.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.grU.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.grW.setVisibility(0);
                    this.grV.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.grV.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.grV.setCompoundDrawables(drawable, null, null, null);
                    this.grX.setVisibility(0);
                    this.grY.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.grY.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.grY.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.grT.setVisibility(0);
                    this.grU.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.grU.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.grI.isOwn) {
                if (this.grI.isUsing()) {
                    this.grU.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.grU.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.grU.setText(R.string.ala_stop_use);
                    if (2 == this.grI.categoryType) {
                        this.grX.setVisibility(8);
                    }
                } else {
                    this.grU.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.grI.categoryType) {
                this.grU.setText(R.string.ala_nobility_open);
                this.grS.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.grI.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.grI.price) {
                    this.grU.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.grU.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.grU.setBackgroundDrawable(null);
                this.grU.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.grU.setText(R.string.ala_enter_effect_not_own);
                this.grU.setEnabled(false);
            }
            this.grU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.grO != null) {
                        a.this.grO.Jq();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.grR.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.grS.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.grT.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Db(String str) {
        if (this.grI != null && 2 == this.grI.categoryType && this.grU != null) {
            this.grU.setText(str);
        }
    }

    public RelativeLayout bIL() {
        return this.mRootView;
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.grO = interfaceC0591a;
    }
}
