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
/* loaded from: classes10.dex */
public class a {
    private AlaEnterEffectData icW;
    private InterfaceC0709a idc;
    private TextView idf;
    private TextView idg;
    private TextView idh;
    private TextView idi;
    private TextView idj;
    private LinearLayout idk;
    private LinearLayout idm;
    private TextView idn;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0709a {
        void Sw();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.icW = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.idf = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.idg = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.idh = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.idi = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.idj = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.idk = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.idm = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.idn = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.icW = alaEnterEffectData;
            this.idi.setEnabled(true);
            if (3 != this.icW.categoryType) {
                if (2 == this.icW.categoryType) {
                    this.idi.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.idi.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.idk.setVisibility(0);
                    this.idj.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.idj.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.idj.setCompoundDrawables(drawable, null, null, null);
                    this.idm.setVisibility(0);
                    this.idn.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.idn.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.idn.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.idh.setVisibility(0);
                    this.idi.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.idi.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.icW.isOwn) {
                if (this.icW.isUsing()) {
                    this.idi.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.idi.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.idi.setText(R.string.ala_stop_use);
                    if (2 == this.icW.categoryType) {
                        this.idm.setVisibility(8);
                    }
                } else {
                    this.idi.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.icW.categoryType) {
                this.idi.setText(R.string.ala_nobility_open);
                this.idg.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.icW.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.icW.price) {
                    this.idi.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.idi.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.idi.setBackgroundDrawable(null);
                this.idi.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.idi.setText(R.string.ala_enter_effect_not_own);
                this.idi.setEnabled(false);
            }
            this.idi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.idc != null) {
                        a.this.idc.Sw();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.idf.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.idg.setText(this.mContext.getResources().getString(R.string.ala_left_time, at.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.idh.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void IX(String str) {
        if (this.icW != null && 2 == this.icW.categoryType && this.idi != null) {
            this.idi.setText(str);
        }
    }

    public RelativeLayout cqh() {
        return this.mRootView;
    }

    public void a(InterfaceC0709a interfaceC0709a) {
        this.idc = interfaceC0709a;
    }
}
