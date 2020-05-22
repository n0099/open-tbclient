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
    public ViewGroup fpH;
    public TextView fpI;
    public ImageView fpJ;
    public HeadImageView fpK;
    public TextView fpL;
    public RelativeLayout fpM;
    public LinearGradientTextView fpN;
    public TextView fpO;
    public ImageView fpP;
    private int fpq;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fpq = i;
        this.fpI = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fpJ = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fpH = (ViewGroup) view.findViewById(a.g.item_view);
        this.fpK = (HeadImageView) view.findViewById(a.g.photo);
        this.fpK.setIsRound(true);
        this.fpK.setAutoChangeStyle(false);
        this.fpK.setClickable(false);
        this.fpM = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fpL = (TextView) view.findViewById(a.g.ala_intro);
        this.fpN = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fpO = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fpP = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fpN.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fpN.setVisibility(8);
                this.fpH.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fpO.setVisibility(0);
                } else {
                    this.fpO.setVisibility(8);
                }
            } else {
                this.fpO.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fpN.setVisibility(8);
                } else {
                    this.fpN.setVisibility(0);
                }
                this.fpH.setBackgroundResource(a.f.sdk_list_item_selector_black);
                jH(aLaCharmData.follow_status != 0);
            }
            this.fpH.setTag(Integer.valueOf(i));
            pY(i);
            m(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fpL.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void m(String str, int i, String str2) {
        if (this.fpP != null) {
            this.fpP.setVisibility(8);
            if (i == 0) {
                this.fpP.setVisibility(0);
                this.fpP.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fpP.setVisibility(0);
                this.fpP.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fpP.setVisibility(0);
                this.fpP.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fpP.setVisibility(8);
            }
        }
        k.a(this.fpK, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void jH(boolean z) {
        if (z) {
            this.fpN.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fpN.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fpN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fpN.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fpN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fpN.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fpN.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fpN.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fpN.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fpN.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fpN.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fpN.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void pY(int i) {
        int i2 = i + 1;
        if (this.fpq == 1) {
            if (i2 == 1) {
                this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fpI.setVisibility(4);
                this.fpJ.setImageResource(a.f.sdk_icon_live_list_first);
                this.fpJ.setVisibility(0);
            } else if (i2 == 2) {
                this.fpI.setVisibility(4);
                this.fpJ.setImageResource(a.f.sdk_icon_live_list_second);
                this.fpJ.setVisibility(0);
            } else if (i2 == 3) {
                this.fpI.setVisibility(4);
                this.fpJ.setImageResource(a.f.sdk_icon_live_list_third);
                this.fpJ.setVisibility(0);
            } else {
                this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fpI.setVisibility(0);
                this.fpJ.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fpI.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fpI.setText("0" + i2);
        } else {
            this.fpI.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.fpH != null && onClickListener != null) {
            this.fpH.setOnClickListener(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.fpN != null && onClickListener != null) {
            this.fpN.setOnClickListener(onClickListener);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fpO != null && onClickListener != null) {
            this.fpO.setOnClickListener(onClickListener);
        }
    }
}
