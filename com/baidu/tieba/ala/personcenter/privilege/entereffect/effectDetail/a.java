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
    private AlaEnterEffectData gWG;
    private InterfaceC0659a gWM;
    private TextView gWP;
    private TextView gWQ;
    private TextView gWR;
    private TextView gWS;
    private TextView gWT;
    private LinearLayout gWU;
    private LinearLayout gWV;
    private TextView gWW;
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
            this.gWG = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gWP = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gWQ = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gWR = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gWS = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gWT = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gWU = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gWV = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gWW = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gWG = alaEnterEffectData;
            this.gWS.setEnabled(true);
            if (3 != this.gWG.categoryType) {
                if (2 == this.gWG.categoryType) {
                    this.gWS.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gWS.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gWU.setVisibility(0);
                    this.gWT.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gWT.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gWT.setCompoundDrawables(drawable, null, null, null);
                    this.gWV.setVisibility(0);
                    this.gWW.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gWW.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gWW.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gWR.setVisibility(0);
                    this.gWS.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gWS.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gWG.isOwn) {
                if (this.gWG.isUsing()) {
                    this.gWS.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gWS.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gWS.setText(R.string.ala_stop_use);
                    if (2 == this.gWG.categoryType) {
                        this.gWV.setVisibility(8);
                    }
                } else {
                    this.gWS.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gWG.categoryType) {
                this.gWS.setText(R.string.ala_nobility_open);
                this.gWQ.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gWG.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gWG.price) {
                    this.gWS.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gWS.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gWS.setBackgroundDrawable(null);
                this.gWS.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gWS.setText(R.string.ala_enter_effect_not_own);
                this.gWS.setEnabled(false);
            }
            this.gWS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gWM != null) {
                        a.this.gWM.Nb();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gWP.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gWQ.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gWR.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void GM(String str) {
        if (this.gWG != null && 2 == this.gWG.categoryType && this.gWS != null) {
            this.gWS.setText(str);
        }
    }

    public RelativeLayout bZb() {
        return this.mRootView;
    }

    public void a(InterfaceC0659a interfaceC0659a) {
        this.gWM = interfaceC0659a;
    }
}
