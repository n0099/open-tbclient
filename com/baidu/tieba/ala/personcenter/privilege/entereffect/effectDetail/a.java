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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes4.dex */
public class a {
    private AlaEnterEffectData gKe;
    private InterfaceC0609a gKk;
    private TextView gKn;
    private TextView gKo;
    private TextView gKp;
    private TextView gKq;
    private TextView gKr;
    private LinearLayout gKs;
    private LinearLayout gKt;
    private TextView gKu;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0609a {
        void Hj();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.gKe = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gKn = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gKo = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gKp = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gKq = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gKr = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gKs = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gKt = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gKu = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.gKe = alaEnterEffectData;
            this.gKq.setEnabled(true);
            if (3 != this.gKe.categoryType) {
                if (2 == this.gKe.categoryType) {
                    this.gKq.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gKq.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gKs.setVisibility(0);
                    this.gKr.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gKr.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gKr.setCompoundDrawables(drawable, null, null, null);
                    this.gKt.setVisibility(0);
                    this.gKu.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gKu.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gKu.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gKp.setVisibility(0);
                    this.gKq.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gKq.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.gKe.isOwn) {
                if (this.gKe.isUsing()) {
                    this.gKq.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gKq.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gKq.setText(R.string.ala_stop_use);
                    if (2 == this.gKe.categoryType) {
                        this.gKt.setVisibility(8);
                    }
                } else {
                    this.gKq.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.gKe.categoryType) {
                this.gKq.setText(R.string.ala_nobility_open);
                this.gKo.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.gKe.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.gKe.price) {
                    this.gKq.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gKq.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gKq.setBackgroundDrawable(null);
                this.gKq.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gKq.setText(R.string.ala_enter_effect_not_own);
                this.gKq.setEnabled(false);
            }
            this.gKq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.gKk != null) {
                        a.this.gKk.Hj();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gKn.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gKo.setText(this.mContext.getResources().getString(R.string.ala_left_time, as.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gKp.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void En(String str) {
        if (this.gKe != null && 2 == this.gKe.categoryType && this.gKq != null) {
            this.gKq.setText(str);
        }
    }

    public RelativeLayout bPb() {
        return this.mRootView;
    }

    public void a(InterfaceC0609a interfaceC0609a) {
        this.gKk = interfaceC0609a;
    }
}
