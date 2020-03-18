package com.baidu.tieba.ala.charm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.LinearGradientTextView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes3.dex */
public class d {
    public ViewGroup exS;
    public TextView exT;
    public ImageView exU;
    public HeadImageView exV;
    public TextView exW;
    public RelativeLayout exX;
    public LinearGradientTextView exY;
    public TextView exZ;
    public ImageView eya;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.exT = (TextView) view.findViewById(a.g.tvGradeNum);
        this.exU = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.exS = (ViewGroup) view.findViewById(a.g.item_view);
        this.exV = (HeadImageView) view.findViewById(a.g.photo);
        this.exV.setIsRound(true);
        this.exV.setAutoChangeStyle(false);
        this.exV.setClickable(false);
        this.exX = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.exW = (TextView) view.findViewById(a.g.ala_intro);
        this.exY = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.exZ = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.eya = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.exY.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.exY.setVisibility(8);
                this.exS.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.exZ.setVisibility(0);
                } else {
                    this.exZ.setVisibility(8);
                }
            } else {
                this.exZ.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.exY.setVisibility(8);
                } else {
                    this.exY.setVisibility(0);
                }
                this.exS.setBackgroundResource(a.f.sdk_list_item_selector_black);
                in(aLaCharmData.follow_status != 0);
            }
            this.exS.setTag(Integer.valueOf(i));
            pc(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.exW.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.eya != null) {
            this.eya.setVisibility(8);
            if (i == 0) {
                this.eya.setVisibility(0);
                this.eya.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.eya.setVisibility(0);
                this.eya.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.eya.setVisibility(0);
                this.eya.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.eya.setVisibility(8);
            }
        }
        k.a(this.exV, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void in(boolean z) {
        if (z) {
            this.exY.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.exY.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.exY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.exY.setBackgroundResource(a.f.charm_attention_s_bg);
            this.exY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.exY.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.exY.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.exY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.exY.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.exY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.exY.setBackgroundResource(a.f.charm_attention_n_bg);
            this.exY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void pc(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.exT.setVisibility(4);
                this.exU.setImageResource(a.f.sdk_icon_live_list_first);
                this.exU.setVisibility(0);
            } else if (i2 == 2) {
                this.exT.setVisibility(4);
                this.exU.setImageResource(a.f.sdk_icon_live_list_second);
                this.exU.setVisibility(0);
            } else if (i2 == 3) {
                this.exT.setVisibility(4);
                this.exU.setImageResource(a.f.sdk_icon_live_list_third);
                this.exU.setVisibility(0);
            } else {
                this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.exT.setVisibility(0);
                this.exU.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.exT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.exT.setText("0" + i2);
        } else {
            this.exT.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exS != null && onClickListener != null) {
            this.exS.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.exY != null && onClickListener != null) {
            this.exY.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.exZ != null && onClickListener != null) {
            this.exZ.setOnClickListener(onClickListener);
        }
    }
}
