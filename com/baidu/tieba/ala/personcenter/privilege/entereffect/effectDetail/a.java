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
    private TextView hpB;
    private TextView hpC;
    private TextView hpD;
    private TextView hpE;
    private TextView hpF;
    private LinearLayout hpG;
    private LinearLayout hpH;
    private TextView hpI;
    private AlaEnterEffectData hps;
    private InterfaceC0674a hpy;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0674a {
        void OK();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hps = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hpB = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hpC = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hpD = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hpE = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hpF = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hpG = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hpH = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hpI = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hps = alaEnterEffectData;
            this.hpE.setEnabled(true);
            if (3 != this.hps.categoryType) {
                if (2 == this.hps.categoryType) {
                    this.hpE.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hpE.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.hpG.setVisibility(0);
                    this.hpF.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hpF.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hpF.setCompoundDrawables(drawable, null, null, null);
                    this.hpH.setVisibility(0);
                    this.hpI.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hpI.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hpI.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hpD.setVisibility(0);
                    this.hpE.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hpE.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hps.isOwn) {
                if (this.hps.isUsing()) {
                    this.hpE.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hpE.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hpE.setText(R.string.ala_stop_use);
                    if (2 == this.hps.categoryType) {
                        this.hpH.setVisibility(8);
                    }
                } else {
                    this.hpE.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hps.categoryType) {
                this.hpE.setText(R.string.ala_nobility_open);
                this.hpC.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hps.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hps.price) {
                    this.hpE.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hpE.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hpE.setBackgroundDrawable(null);
                this.hpE.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hpE.setText(R.string.ala_enter_effect_not_own);
                this.hpE.setEnabled(false);
            }
            this.hpE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hpy != null) {
                        a.this.hpy.OK();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hpB.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hpC.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hpD.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void HU(String str) {
        if (this.hps != null && 2 == this.hps.categoryType && this.hpE != null) {
            this.hpE.setText(str);
        }
    }

    public RelativeLayout cew() {
        return this.mRootView;
    }

    public void a(InterfaceC0674a interfaceC0674a) {
        this.hpy = interfaceC0674a;
    }
}
