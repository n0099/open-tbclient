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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
/* loaded from: classes10.dex */
public class a {
    private AlaEnterEffectData icX;
    private InterfaceC0693a idd;
    private TextView idg;
    private TextView idh;
    private TextView idi;
    private TextView idj;
    private TextView idk;
    private LinearLayout idm;
    private LinearLayout idn;
    private TextView ido;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0693a {
        void Qa();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.icX = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.idg = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.idh = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.idi = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.idj = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.idk = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.idm = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.idn = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.ido = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.icX = alaEnterEffectData;
            this.idj.setEnabled(true);
            if (3 != this.icX.categoryType) {
                if (2 == this.icX.categoryType) {
                    this.idj.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.idj.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.idm.setVisibility(0);
                    this.idk.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.idk.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.idk.setCompoundDrawables(drawable, null, null, null);
                    this.idn.setVisibility(0);
                    this.ido.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.ido.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.ido.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.idi.setVisibility(0);
                    this.idj.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.idj.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.icX.isOwn) {
                if (this.icX.isUsing()) {
                    this.idj.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.idj.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.idj.setText(R.string.ala_stop_use);
                    if (2 == this.icX.categoryType) {
                        this.idn.setVisibility(8);
                    }
                } else {
                    this.idj.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.icX.categoryType) {
                this.idj.setText(R.string.ala_nobility_open);
                this.idh.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.icX.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.icX.price) {
                    this.idj.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.idj.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.idj.setBackgroundDrawable(null);
                this.idj.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.idj.setText(R.string.ala_enter_effect_not_own);
                this.idj.setEnabled(false);
            }
            this.idj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.idd != null) {
                        a.this.idd.Qa();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.idg.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.idh.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.idi.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Ir(String str) {
        if (this.icX != null && 2 == this.icX.categoryType && this.idj != null) {
            this.idj.setText(str);
        }
    }

    public RelativeLayout cnu() {
        return this.mRootView;
    }

    public void a(InterfaceC0693a interfaceC0693a) {
        this.idd = interfaceC0693a;
    }
}
