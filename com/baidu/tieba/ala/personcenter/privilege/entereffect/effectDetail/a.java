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
    private TextView fxA;
    private TextView fxB;
    private TextView fxC;
    private TextView fxD;
    private LinearLayout fxE;
    private LinearLayout fxF;
    private TextView fxG;
    private AlaEnterEffectData fxq;
    private InterfaceC0484a fxw;
    private TextView fxz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0484a {
        void Bn();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.fxq = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.fxz = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.fxA = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.fxB = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.fxC = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.fxD = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.fxE = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.fxF = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.fxG = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fxq = alaEnterEffectData;
            this.fxC.setEnabled(true);
            if (3 != this.fxq.categoryType) {
                if (2 == this.fxq.categoryType) {
                    this.fxC.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fxC.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.fxE.setVisibility(0);
                    this.fxD.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.fxD.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.fxD.setCompoundDrawables(drawable, null, null, null);
                    this.fxF.setVisibility(0);
                    this.fxG.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.fxG.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.fxG.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.fxB.setVisibility(0);
                    this.fxC.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fxC.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.fxq.isOwn) {
                if (this.fxq.isUsing()) {
                    this.fxC.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fxC.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.fxC.setText(R.string.ala_stop_use);
                    if (2 == this.fxq.categoryType) {
                        this.fxF.setVisibility(8);
                    }
                } else {
                    this.fxC.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.fxq.categoryType) {
                this.fxC.setText(R.string.ala_nobility_open);
                this.fxA.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.fxq.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.fxq.price) {
                    this.fxC.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.fxC.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.fxC.setBackgroundDrawable(null);
                this.fxC.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.fxC.setText(R.string.ala_enter_effect_not_own);
                this.fxC.setEnabled(false);
            }
            this.fxC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fxw != null) {
                        a.this.fxw.Bn();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.fxz.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.fxA.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.fxB.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zH(String str) {
        if (this.fxq != null && 2 == this.fxq.categoryType && this.fxC != null) {
            this.fxC.setText(str);
        }
    }

    public RelativeLayout bsE() {
        return this.mRootView;
    }

    public void a(InterfaceC0484a interfaceC0484a) {
        this.fxw = interfaceC0484a;
    }
}
