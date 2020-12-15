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
    private AlaEnterEffectData hQA;
    private InterfaceC0717a hQG;
    private TextView hQJ;
    private TextView hQK;
    private TextView hQL;
    private TextView hQM;
    private TextView hQN;
    private LinearLayout hQO;
    private LinearLayout hQP;
    private TextView hQQ;
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
            this.hQA = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.hQJ = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.hQK = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.hQL = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.hQM = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.hQN = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.hQO = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.hQP = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.hQQ = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.hQA = alaEnterEffectData;
            this.hQM.setEnabled(true);
            if (3 != this.hQA.categoryType) {
                if (2 == this.hQA.categoryType) {
                    this.hQM.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.hQM.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0201));
                    this.hQO.setVisibility(0);
                    this.hQN.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.hQN.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.hQN.setCompoundDrawables(drawable, null, null, null);
                    this.hQP.setVisibility(0);
                    this.hQQ.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.hQQ.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.hQQ.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.hQL.setVisibility(0);
                    this.hQM.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.hQM.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.hQA.isOwn) {
                if (this.hQA.isUsing()) {
                    this.hQM.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.hQM.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.hQM.setText(R.string.ala_stop_use);
                    if (2 == this.hQA.categoryType) {
                        this.hQP.setVisibility(8);
                    }
                } else {
                    this.hQM.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.hQA.categoryType) {
                this.hQM.setText(R.string.ala_nobility_open);
                this.hQK.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.hQA.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.hQA.price) {
                    this.hQM.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.hQM.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.hQM.setBackgroundDrawable(null);
                this.hQM.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.hQM.setText(R.string.ala_enter_effect_not_own);
                this.hQM.setEnabled(false);
            }
            this.hQM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.hQG != null) {
                        a.this.hQG.Rt();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.hQJ.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.hQK.setText(this.mContext.getResources().getString(R.string.ala_left_time, au.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.hQL.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Ja(String str) {
        if (this.hQA != null && 2 == this.hQA.categoryType && this.hQM != null) {
            this.hQM.setText(str);
        }
    }

    public RelativeLayout cno() {
        return this.mRootView;
    }

    public void a(InterfaceC0717a interfaceC0717a) {
        this.hQG = interfaceC0717a;
    }
}
