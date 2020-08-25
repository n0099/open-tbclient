package com.baidu.tieba.ala.charm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.LinearGradientTextView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes7.dex */
public class d {
    public ViewGroup fRE;
    public TextView fRF;
    public ImageView fRG;
    public HeadImageView fRH;
    public TextView fRI;
    public RelativeLayout fRJ;
    public LinearGradientTextView fRK;
    public TextView fRL;
    public ImageView fRM;
    private int fRo;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fRo = i;
        this.fRF = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fRG = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fRE = (ViewGroup) view.findViewById(a.g.item_view);
        this.fRH = (HeadImageView) view.findViewById(a.g.photo);
        this.fRH.setIsRound(true);
        this.fRH.setAutoChangeStyle(false);
        this.fRH.setClickable(false);
        this.fRJ = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fRI = (TextView) view.findViewById(a.g.ala_intro);
        this.fRK = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fRL = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fRM = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fRK.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fRK.setVisibility(8);
                this.fRE.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fRL.setVisibility(0);
                } else {
                    this.fRL.setVisibility(8);
                }
            } else {
                this.fRL.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fRK.setVisibility(8);
                } else {
                    this.fRK.setVisibility(0);
                }
                this.fRE.setBackgroundResource(a.f.sdk_list_item_selector_black);
                kW(aLaCharmData.follow_status != 0);
            }
            this.fRE.setTag(Integer.valueOf(i));
            ta(i);
            m(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fRI.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void m(String str, int i, String str2) {
        if (this.fRM != null) {
            this.fRM.setVisibility(8);
            if (i == 0) {
                this.fRM.setVisibility(0);
                this.fRM.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fRM.setVisibility(0);
                this.fRM.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fRM.setVisibility(0);
                this.fRM.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fRM.setVisibility(8);
            }
        }
        k.a(this.fRH, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void kW(boolean z) {
        if (z) {
            this.fRK.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fRK.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fRK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fRK.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fRK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fRK.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fRK.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fRK.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fRK.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fRK.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fRK.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fRK.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void ta(int i) {
        int i2 = i + 1;
        if (this.fRo == 1) {
            if (i2 == 1) {
                this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fRF.setVisibility(4);
                this.fRG.setImageResource(a.f.sdk_icon_live_list_first);
                this.fRG.setVisibility(0);
            } else if (i2 == 2) {
                this.fRF.setVisibility(4);
                this.fRG.setImageResource(a.f.sdk_icon_live_list_second);
                this.fRG.setVisibility(0);
            } else if (i2 == 3) {
                this.fRF.setVisibility(4);
                this.fRG.setImageResource(a.f.sdk_icon_live_list_third);
                this.fRG.setVisibility(0);
            } else {
                this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fRF.setVisibility(0);
                this.fRG.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fRF.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fRF.setText("0" + i2);
        } else {
            this.fRF.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fRE != null && onClickListener != null) {
            this.fRE.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fRK != null && onClickListener != null) {
            this.fRK.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fRL != null && onClickListener != null) {
            this.fRL.setOnClickListener(onClickListener);
        }
    }
}
