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
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes10.dex */
public class d {
    public ViewGroup gMC;
    public TextView gMD;
    public ImageView gME;
    public HeadImageView gMF;
    public TextView gMG;
    public RelativeLayout gMH;
    public LinearGradientTextView gMI;
    public TextView gMJ;
    public ImageView gMK;
    private int gMm;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gMm = i;
        this.gMD = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gME = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gMC = (ViewGroup) view.findViewById(a.f.item_view);
        this.gMF = (HeadImageView) view.findViewById(a.f.photo);
        this.gMF.setIsRound(true);
        this.gMF.setAutoChangeStyle(false);
        this.gMF.setClickable(false);
        this.gMH = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gMG = (TextView) view.findViewById(a.f.ala_intro);
        this.gMI = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gMJ = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gMK = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gMI.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gMI.setVisibility(8);
                this.gMC.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gMJ.setVisibility(0);
                } else {
                    this.gMJ.setVisibility(8);
                }
            } else {
                this.gMJ.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gMI.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gMI.setVisibility(8);
                } else {
                    this.gMI.setVisibility(0);
                }
                this.gMC.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mQ(aLaCharmData.follow_status != 0);
            }
            if (aLaCharmData.extInfoJson != null) {
                if (aLaCharmData.extInfoJson.optInt("is_mysterious_man") == 1) {
                    this.gMI.setVisibility(8);
                }
            }
            this.gMC.setTag(Integer.valueOf(i));
            ue(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gMG.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.gMK != null) {
            this.gMK.setVisibility(8);
            if (i == 0) {
                this.gMK.setVisibility(0);
                this.gMK.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gMK.setVisibility(0);
                this.gMK.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gMK.setVisibility(0);
                this.gMK.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gMK.setVisibility(8);
            }
        }
        m.a(this.gMF, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mQ(boolean z) {
        if (z) {
            this.gMI.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gMI.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gMI.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gMI.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gMI.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gMI.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gMI.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gMI.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gMI.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gMI.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gMI.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gMI.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void ue(int i) {
        int i2 = i + 1;
        if (this.gMm == 1) {
            if (i2 == 1) {
                this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gMD.setVisibility(4);
                this.gME.setImageResource(a.e.sdk_icon_live_list_first);
                this.gME.setVisibility(0);
            } else if (i2 == 2) {
                this.gMD.setVisibility(4);
                this.gME.setImageResource(a.e.sdk_icon_live_list_second);
                this.gME.setVisibility(0);
            } else if (i2 == 3) {
                this.gMD.setVisibility(4);
                this.gME.setImageResource(a.e.sdk_icon_live_list_third);
                this.gME.setVisibility(0);
            } else {
                this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gMD.setVisibility(0);
                this.gME.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gMD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gMD.setText("0" + i2);
        } else {
            this.gMD.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gMC != null && onClickListener != null) {
            this.gMC.setOnClickListener(onClickListener);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.gMI != null && onClickListener != null) {
            this.gMI.setOnClickListener(onClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.gMJ != null && onClickListener != null) {
            this.gMJ.setOnClickListener(onClickListener);
        }
    }
}
