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
    private AlaEnterEffectData fyj;
    private InterfaceC0484a fyp;
    private TextView fys;
    private TextView fyt;
    private TextView fyu;
    private TextView fyv;
    private TextView fyw;
    private LinearLayout fyx;
    private LinearLayout fyy;
    private TextView fyz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0484a {
        void Bu();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.fyj = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.fys = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.fyt = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.fyu = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.fyv = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.fyw = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.fyx = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.fyy = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.fyz = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.fyj = alaEnterEffectData;
            this.fyv.setEnabled(true);
            if (3 != this.fyj.categoryType) {
                if (2 == this.fyj.categoryType) {
                    this.fyv.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.fyv.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.fyx.setVisibility(0);
                    this.fyw.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.fyw.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.fyw.setCompoundDrawables(drawable, null, null, null);
                    this.fyy.setVisibility(0);
                    this.fyz.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.fyz.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.fyz.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.fyu.setVisibility(0);
                    this.fyv.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.fyv.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.fyj.isOwn) {
                if (this.fyj.isUsing()) {
                    this.fyv.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.fyv.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.fyv.setText(R.string.ala_stop_use);
                    if (2 == this.fyj.categoryType) {
                        this.fyy.setVisibility(8);
                    }
                } else {
                    this.fyv.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.fyj.categoryType) {
                this.fyv.setText(R.string.ala_nobility_open);
                this.fyt.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.fyj.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.fyj.price) {
                    this.fyv.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.fyv.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.fyv.setBackgroundDrawable(null);
                this.fyv.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.fyv.setText(R.string.ala_enter_effect_not_own);
                this.fyv.setEnabled(false);
            }
            this.fyv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.fyp != null) {
                        a.this.fyp.Bu();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.fys.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.fyt.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.fyu.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void zK(String str) {
        if (this.fyj != null && 2 == this.fyj.categoryType && this.fyv != null) {
            this.fyv.setText(str);
        }
    }

    public RelativeLayout bsL() {
        return this.mRootView;
    }

    public void a(InterfaceC0484a interfaceC0484a) {
        this.fyp = interfaceC0484a;
    }
}
