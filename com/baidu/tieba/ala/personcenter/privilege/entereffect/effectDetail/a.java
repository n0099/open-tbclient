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
    private TextView hBA;
    private LinearLayout hBB;
    private LinearLayout hBC;
    private TextView hBD;
    private AlaEnterEffectData hBn;
    private InterfaceC0690a hBt;
    private TextView hBw;
    private TextView hBx;
    private TextView hBy;
    private TextView hBz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0690a {
        void Pi();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hBn = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hBw = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hBx = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hBy = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hBz = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hBA = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hBB = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hBC = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hBD = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hBn = alaEnterEffectData;
            this.hBz.setEnabled(true);
            if (3 != this.hBn.categoryType) {
                if (2 == this.hBn.categoryType) {
                    this.hBz.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hBz.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.hBB.setVisibility(0);
                    this.hBA.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hBA.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hBA.setCompoundDrawables(drawable, null, null, null);
                    this.hBC.setVisibility(0);
                    this.hBD.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hBD.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hBD.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hBy.setVisibility(0);
                    this.hBz.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hBz.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hBn.isOwn) {
                if (this.hBn.isUsing()) {
                    this.hBz.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hBz.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hBz.setText(R.string.ala_stop_use);
                    if (2 == this.hBn.categoryType) {
                        this.hBC.setVisibility(8);
                    }
                } else {
                    this.hBz.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hBn.categoryType) {
                this.hBz.setText(R.string.ala_nobility_open);
                this.hBx.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hBn.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hBn.price) {
                    this.hBz.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hBz.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hBz.setBackgroundDrawable(null);
                this.hBz.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hBz.setText(R.string.ala_enter_effect_not_own);
                this.hBz.setEnabled(false);
            }
            this.hBz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hBt != null) {
                        a.this.hBt.Pi();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hBw.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hBx.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hBy.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void It(String str) {
        if (this.hBn != null && 2 == this.hBn.categoryType && this.hBz != null) {
            this.hBz.setText(str);
        }
    }

    public RelativeLayout chy() {
        return this.mRootView;
    }

    public void a(InterfaceC0690a interfaceC0690a) {
        this.hBt = interfaceC0690a;
    }
}
