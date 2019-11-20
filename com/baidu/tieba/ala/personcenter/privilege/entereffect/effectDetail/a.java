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
/* loaded from: classes6.dex */
public class a {
    private AlaEnterEffectData eAe;
    private InterfaceC0388a eAk;
    private TextView eAn;
    private TextView eAo;
    private TextView eAp;
    private TextView eAq;
    private TextView eAr;
    private LinearLayout eAs;
    private LinearLayout eAt;
    private TextView eAu;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0388a {
        void qy();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.eAe = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.eAn = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.eAo = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.eAp = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.eAq = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.eAr = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.eAs = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.eAt = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.eAu = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.eAe = alaEnterEffectData;
            this.eAq.setEnabled(true);
            if (3 != this.eAe.categoryType) {
                if (2 == this.eAe.categoryType) {
                    this.eAq.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.eAq.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.eAs.setVisibility(0);
                    this.eAr.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.eAr.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.eAr.setCompoundDrawables(drawable, null, null, null);
                    this.eAt.setVisibility(0);
                    this.eAu.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.eAu.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.eAu.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.eAp.setVisibility(0);
                    this.eAq.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.eAq.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.eAe.isOwn) {
                if (this.eAe.isUsing()) {
                    this.eAq.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.eAq.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.eAq.setText(R.string.ala_stop_use);
                    if (2 == this.eAe.categoryType) {
                        this.eAt.setVisibility(8);
                    }
                } else {
                    this.eAq.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.eAe.categoryType) {
                this.eAq.setText(R.string.ala_nobility_open);
                this.eAo.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.eAe.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.eAe.price) {
                    this.eAq.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.eAq.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.eAq.setBackgroundDrawable(null);
                this.eAq.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.eAq.setText(R.string.ala_enter_effect_not_own);
                this.eAq.setEnabled(false);
            }
            this.eAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eAk != null) {
                        a.this.eAk.qy();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.eAn.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.eAo.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.eAp.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void uo(String str) {
        if (this.eAe != null && 2 == this.eAe.categoryType && this.eAq != null) {
            this.eAq.setText(str);
        }
    }

    public RelativeLayout aYb() {
        return this.mRootView;
    }

    public void a(InterfaceC0388a interfaceC0388a) {
        this.eAk = interfaceC0388a;
    }
}
