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
    private AlaEnterEffectData eAV;
    private InterfaceC0388a eBb;
    private TextView eBe;
    private TextView eBf;
    private TextView eBg;
    private TextView eBh;
    private TextView eBi;
    private LinearLayout eBj;
    private LinearLayout eBk;
    private TextView eBl;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0388a {
        void qx();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.eAV = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.eBe = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.eBf = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.eBg = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.eBh = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.eBi = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.eBj = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.eBk = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.eBl = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.eAV = alaEnterEffectData;
            this.eBh.setEnabled(true);
            if (3 != this.eAV.categoryType) {
                if (2 == this.eAV.categoryType) {
                    this.eBh.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.eBh.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.eBj.setVisibility(0);
                    this.eBi.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.eBi.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.eBi.setCompoundDrawables(drawable, null, null, null);
                    this.eBk.setVisibility(0);
                    this.eBl.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.eBl.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.eBl.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.eBg.setVisibility(0);
                    this.eBh.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.eBh.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.eAV.isOwn) {
                if (this.eAV.isUsing()) {
                    this.eBh.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.eBh.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.eBh.setText(R.string.ala_stop_use);
                    if (2 == this.eAV.categoryType) {
                        this.eBk.setVisibility(8);
                    }
                } else {
                    this.eBh.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.eAV.categoryType) {
                this.eBh.setText(R.string.ala_nobility_open);
                this.eBf.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.eAV.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.eAV.price) {
                    this.eBh.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.eBh.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.eBh.setBackgroundDrawable(null);
                this.eBh.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.eBh.setText(R.string.ala_enter_effect_not_own);
                this.eBh.setEnabled(false);
            }
            this.eBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.eBb != null) {
                        a.this.eBb.qx();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.eBe.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.eBf.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.eBg.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void uo(String str) {
        if (this.eAV != null && 2 == this.eAV.categoryType && this.eBh != null) {
            this.eBh.setText(str);
        }
    }

    public RelativeLayout aYd() {
        return this.mRootView;
    }

    public void a(InterfaceC0388a interfaceC0388a) {
        this.eBb = interfaceC0388a;
    }
}
