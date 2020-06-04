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
    private AlaEnterEffectData grT;
    private InterfaceC0591a grZ;
    private TextView gsc;
    private TextView gsd;
    private TextView gse;
    private TextView gsf;
    private TextView gsg;
    private LinearLayout gsh;
    private LinearLayout gsi;
    private TextView gsj;
    private Context mContext;
    private RelativeLayout mRootView;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0591a {
        void Jq();
    }

    public a(Context context, AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null && context != null) {
            this.mContext = context;
            this.grT = alaEnterEffectData;
            this.mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ala_enter_effect_detail_view, (ViewGroup) null);
            this.gsc = (TextView) this.mRootView.findViewById(R.id.effet_name_tv);
            this.gsd = (TextView) this.mRootView.findViewById(R.id.left_time_tv);
            this.gse = (TextView) this.mRootView.findViewById(R.id.live_room_tv);
            this.gsf = (TextView) this.mRootView.findViewById(R.id.confirm_button_tv);
            this.gsg = (TextView) this.mRootView.findViewById(R.id.t_dou_price);
            this.gsh = (LinearLayout) this.mRootView.findViewById(R.id.t_dou_price_layout);
            this.gsi = (LinearLayout) this.mRootView.findViewById(R.id.cur_t_dou_layout);
            this.gsj = (TextView) this.mRootView.findViewById(R.id.cur_t_dou);
            d(alaEnterEffectData);
        }
    }

    public void d(AlaEnterEffectData alaEnterEffectData) {
        if (alaEnterEffectData != null) {
            this.grT = alaEnterEffectData;
            this.gsf.setEnabled(true);
            if (3 != this.grT.categoryType) {
                if (2 == this.grT.categoryType) {
                    this.gsf.setBackgroundResource(R.drawable.ala_enter_effect_tdou_bg);
                    this.gsf.setTextColor(this.mContext.getResources().getColor(R.color.cp_bg_line_d));
                    this.gsh.setVisibility(0);
                    this.gsg.setText(AlaStringHelper.formatLowercasekDou(alaEnterEffectData.price));
                    Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds36);
                    drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                    this.gsg.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12));
                    this.gsg.setCompoundDrawables(drawable, null, null, null);
                    this.gsi.setVisibility(0);
                    this.gsj.setText(AlaStringHelper.formatLowercasekDou(TbadkCoreApplication.getInst().currentAccountTdouNum));
                    Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou);
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds24);
                    drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
                    this.gsj.setCompoundDrawablePadding(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds4));
                    this.gsj.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    this.gse.setVisibility(0);
                    this.gsf.setBackgroundResource(R.drawable.mark_ops_btn_bg_wear_selector);
                    this.gsf.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_wear_color));
                }
            }
            if (this.grT.isOwn) {
                if (this.grT.isUsing()) {
                    this.gsf.setBackgroundResource(R.drawable.mark_ops_btn_bg_unwear_selector);
                    this.gsf.setTextColor(this.mContext.getResources().getColorStateList(R.color.mark_ops_btn_txt_unwear_color));
                    this.gsf.setText(R.string.ala_stop_use);
                    if (2 == this.grT.categoryType) {
                        this.gsi.setVisibility(8);
                    }
                } else {
                    this.gsf.setText(R.string.ala_immediate_use);
                }
            } else if (3 == this.grT.categoryType) {
                this.gsf.setText(R.string.ala_nobility_open);
                this.gsd.setText(this.mContext.getString(R.string.ala_enter_effect_nobility_open_tip, alaEnterEffectData.nobilityName));
            } else if (2 == this.grT.categoryType) {
                if (TbadkCoreApplication.getInst().currentAccountTdouNum >= this.grT.price) {
                    this.gsf.setText(R.string.ala_enter_effect_tdou_buy);
                } else {
                    this.gsf.setText(R.string.ala_enter_effect_get_t_dou);
                }
            } else {
                this.gsf.setBackgroundDrawable(null);
                this.gsf.setTextColor(this.mContext.getResources().getColor(R.color.white_alpha60));
                this.gsf.setText(R.string.ala_enter_effect_not_own);
                this.gsf.setEnabled(false);
            }
            this.gsf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.grZ != null) {
                        a.this.grZ.Jq();
                    }
                }
            });
            if (!StringUtils.isNull(alaEnterEffectData.name)) {
                this.gsc.setText(alaEnterEffectData.name);
            }
            long currentTimeMillis = (alaEnterEffectData.end_time * 1000) - System.currentTimeMillis();
            if (currentTimeMillis >= 0) {
                this.gsd.setText(this.mContext.getResources().getString(R.string.ala_left_time, aq.formatDayOrHourTime(currentTimeMillis)));
            }
            if (!StringUtils.isNull(alaEnterEffectData.effect_range_name)) {
                this.gse.setText(alaEnterEffectData.effect_range_name);
            }
        }
    }

    public void Db(String str) {
        if (this.grT != null && 2 == this.grT.categoryType && this.gsf != null) {
            this.gsf.setText(str);
        }
    }

    public RelativeLayout bIN() {
        return this.mRootView;
    }

    public void a(InterfaceC0591a interfaceC0591a) {
        this.grZ = interfaceC0591a;
    }
}
