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
/* loaded from: classes9.dex */
public class a {
    private TextView hYA;
    private TextView hYB;
    private TextView hYC;
    private LinearLayout hYD;
    private LinearLayout hYE;
    private TextView hYF;
    private AlaEnterEffectData hYp;
    private InterfaceC0692a hYv;
    private TextView hYy;
    private TextView hYz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0692a {
        void OB();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hYp = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hYy = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hYz = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hYA = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hYB = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hYC = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hYD = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hYE = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hYF = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hYp = alaEnterEffectData;
            this.hYB.setEnabled(true);
            if (3 != this.hYp.categoryType) {
                if (2 == this.hYp.categoryType) {
                    this.hYB.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hYB.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.hYD.setVisibility(0);
                    this.hYC.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hYC.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hYC.setCompoundDrawables(drawable, null, null, null);
                    this.hYE.setVisibility(0);
                    this.hYF.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hYF.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hYF.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hYA.setVisibility(0);
                    this.hYB.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hYB.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hYp.isOwn) {
                if (this.hYp.isUsing()) {
                    this.hYB.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hYB.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hYB.setText(R.string.ala_stop_use);
                    if (2 == this.hYp.categoryType) {
                        this.hYE.setVisibility(8);
                    }
                } else {
                    this.hYB.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hYp.categoryType) {
                this.hYB.setText(R.string.ala_nobility_open);
                this.hYz.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hYp.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hYp.price) {
                    this.hYB.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hYB.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hYB.setBackgroundDrawable(null);
                this.hYB.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hYB.setText(R.string.ala_enter_effect_not_own);
                this.hYB.setEnabled(false);
            }
            this.hYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hYv != null) {
                        a.this.hYv.OB();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hYy.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hYz.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hYA.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void HM(String str) {
        if (this.hYp != null && 2 == this.hYp.categoryType && this.hYB != null) {
            this.hYB.setText(str);
        }
    }

    public RelativeLayout cmp() {
        return this.mRootView;
    }

    public void a(InterfaceC0692a interfaceC0692a) {
        this.hYv = interfaceC0692a;
    }
}
