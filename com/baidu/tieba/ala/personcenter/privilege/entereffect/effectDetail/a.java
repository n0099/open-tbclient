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
/* loaded from: classes6.dex */
public class a {
    private InterfaceC0717a hQE;
    private TextView hQH;
    private TextView hQI;
    private TextView hQJ;
    private TextView hQK;
    private TextView hQL;
    private LinearLayout hQM;
    private LinearLayout hQN;
    private TextView hQO;
    private AlaEnterEffectData hQy;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0717a {
        void Rt();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.hQy = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hQH = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hQI = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hQJ = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hQK = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hQL = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hQM = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hQN = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hQO = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hQy = alaEnterEffectData;
            this.hQK.setEnabled(true);
            if (3 != this.hQy.categoryType) {
                if (2 == this.hQy.categoryType) {
                    this.hQK.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hQK.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.hQM.setVisibility(0);
                    this.hQL.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hQL.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hQL.setCompoundDrawables(drawable, null, null, null);
                    this.hQN.setVisibility(0);
                    this.hQO.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hQO.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hQO.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hQJ.setVisibility(0);
                    this.hQK.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hQK.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hQy.isOwn) {
                if (this.hQy.isUsing()) {
                    this.hQK.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hQK.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hQK.setText(R.string.ala_stop_use);
                    if (2 == this.hQy.categoryType) {
                        this.hQN.setVisibility(8);
                    }
                } else {
                    this.hQK.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hQy.categoryType) {
                this.hQK.setText(R.string.ala_nobility_open);
                this.hQI.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hQy.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hQy.price) {
                    this.hQK.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hQK.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hQK.setBackgroundDrawable(null);
                this.hQK.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hQK.setText(R.string.ala_enter_effect_not_own);
                this.hQK.setEnabled(false);
            }
            this.hQK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hQE != null) {
                        a.this.hQE.Rt();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hQH.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hQI.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hQJ.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Ja(String str) {
        if (this.hQy != null && 2 == this.hQy.categoryType && this.hQK != null) {
            this.hQK.setText(str);
        }
    }

    public RelativeLayout cnn() {
        return this.mRootView;
    }

    public void a(InterfaceC0717a interfaceC0717a) {
        this.hQE = interfaceC0717a;
    }
}
