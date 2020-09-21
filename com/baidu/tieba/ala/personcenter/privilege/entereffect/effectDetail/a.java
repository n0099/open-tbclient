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
    private TextView haA;
    private TextView haB;
    private TextView haC;
    private TextView haD;
    private TextView haE;
    private LinearLayout haF;
    private LinearLayout haG;
    private TextView haH;
    private AlaEnterEffectData har;
    private InterfaceC0656a hax;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0656a {
        void NF();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.har = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.haA = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.haB = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.haC = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.haD = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.haE = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.haF = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.haG = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.haH = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.har = alaEnterEffectData;
            this.haD.setEnabled(true);
            if (3 != this.har.categoryType) {
                if (2 == this.har.categoryType) {
                    this.haD.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.haD.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.haF.setVisibility(0);
                    this.haE.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.haE.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.haE.setCompoundDrawables(drawable, null, null, null);
                    this.haG.setVisibility(0);
                    this.haH.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.haH.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.haH.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.haC.setVisibility(0);
                    this.haD.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.haD.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.har.isOwn) {
                if (this.har.isUsing()) {
                    this.haD.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.haD.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.haD.setText(R.string.ala_stop_use);
                    if (2 == this.har.categoryType) {
                        this.haG.setVisibility(8);
                    }
                } else {
                    this.haD.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.har.categoryType) {
                this.haD.setText(R.string.ala_nobility_open);
                this.haB.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.har.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.har.price) {
                    this.haD.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.haD.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.haD.setBackgroundDrawable(null);
                this.haD.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.haD.setText(R.string.ala_enter_effect_not_own);
                this.haD.setEnabled(false);
            }
            this.haD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hax != null) {
                        a.this.hax.NF();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.haA.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.haB.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.haC.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Hg(String str) {
        if (this.har != null && 2 == this.har.categoryType && this.haD != null) {
            this.haD.setText(str);
        }
    }

    public RelativeLayout caY() {
        return this.mRootView;
    }

    public void a(InterfaceC0656a interfaceC0656a) {
        this.hax = interfaceC0656a;
    }
}
