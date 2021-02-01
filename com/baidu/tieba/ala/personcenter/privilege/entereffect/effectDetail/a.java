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
    private AlaEnterEffectData icJ;
    private InterfaceC0692a icP;
    private TextView icS;
    private TextView icT;
    private TextView icU;
    private TextView icV;
    private TextView icW;
    private LinearLayout icX;
    private LinearLayout icY;
    private TextView icZ;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0692a {
        void Qa();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.icJ = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.icS = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.icT = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.icU = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.icV = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.icW = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.icX = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.icY = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.icZ = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.icJ = alaEnterEffectData;
            this.icV.setEnabled(true);
            if (3 != this.icJ.categoryType) {
                if (2 == this.icJ.categoryType) {
                    this.icV.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.icV.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.icX.setVisibility(0);
                    this.icW.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.icW.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.icW.setCompoundDrawables(drawable, null, null, null);
                    this.icY.setVisibility(0);
                    this.icZ.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.icZ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.icZ.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.icU.setVisibility(0);
                    this.icV.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.icV.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.icJ.isOwn) {
                if (this.icJ.isUsing()) {
                    this.icV.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.icV.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.icV.setText(R.string.ala_stop_use);
                    if (2 == this.icJ.categoryType) {
                        this.icY.setVisibility(8);
                    }
                } else {
                    this.icV.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.icJ.categoryType) {
                this.icV.setText(R.string.ala_nobility_open);
                this.icT.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.icJ.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.icJ.price) {
                    this.icV.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.icV.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.icV.setBackgroundDrawable(null);
                this.icV.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.icV.setText(R.string.ala_enter_effect_not_own);
                this.icV.setEnabled(false);
            }
            this.icV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.icP != null) {
                        a.this.icP.Qa();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.icS.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.icT.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.icU.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Iq(String str) {
        if (this.icJ != null && 2 == this.icJ.categoryType && this.icV != null) {
            this.icV.setText(str);
        }
    }

    public RelativeLayout cnn() {
        return this.mRootView;
    }

    public void a(InterfaceC0692a interfaceC0692a) {
        this.icP = interfaceC0692a;
    }
}
