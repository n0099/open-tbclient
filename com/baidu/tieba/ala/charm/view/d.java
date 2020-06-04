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
    private int fpC;
    public ViewGroup fpS;
    public TextView fpT;
    public ImageView fpU;
    public HeadImageView fpV;
    public TextView fpW;
    public RelativeLayout fpX;
    public LinearGradientTextView fpY;
    public TextView fpZ;
    public ImageView fqa;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fpC = i;
        this.fpT = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fpU = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fpS = (ViewGroup) view.findViewById(a.g.item_view);
        this.fpV = (HeadImageView) view.findViewById(a.g.photo);
        this.fpV.setIsRound(true);
        this.fpV.setAutoChangeStyle(false);
        this.fpV.setClickable(false);
        this.fpX = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fpW = (TextView) view.findViewById(a.g.ala_intro);
        this.fpY = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fpZ = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fqa = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fpY.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fpY.setVisibility(8);
                this.fpS.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fpZ.setVisibility(0);
                } else {
                    this.fpZ.setVisibility(8);
                }
            } else {
                this.fpZ.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fpY.setVisibility(8);
                } else {
                    this.fpY.setVisibility(0);
                }
                this.fpS.setBackgroundResource(a.f.sdk_list_item_selector_black);
                jH(aLaCharmData.follow_status != 0);
            }
            this.fpS.setTag(Integer.valueOf(i));
            qa(i);
            m(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fpW.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void m(String str, int i, String str2) {
        if (this.fqa != null) {
            this.fqa.setVisibility(8);
            if (i == 0) {
                this.fqa.setVisibility(0);
                this.fqa.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fqa.setVisibility(0);
                this.fqa.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fqa.setVisibility(0);
                this.fqa.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fqa.setVisibility(8);
            }
        }
        k.a(this.fpV, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void jH(boolean z) {
        if (z) {
            this.fpY.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fpY.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fpY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fpY.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fpY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fpY.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fpY.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fpY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fpY.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fpY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fpY.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fpY.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void qa(int i) {
        int i2 = i + 1;
        if (this.fpC == 1) {
            if (i2 == 1) {
                this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fpT.setVisibility(4);
                this.fpU.setImageResource(a.f.sdk_icon_live_list_first);
                this.fpU.setVisibility(0);
            } else if (i2 == 2) {
                this.fpT.setVisibility(4);
                this.fpU.setImageResource(a.f.sdk_icon_live_list_second);
                this.fpU.setVisibility(0);
            } else if (i2 == 3) {
                this.fpT.setVisibility(4);
                this.fpU.setImageResource(a.f.sdk_icon_live_list_third);
                this.fpU.setVisibility(0);
            } else {
                this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fpT.setVisibility(0);
                this.fpU.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fpT.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fpT.setText("0" + i2);
        } else {
            this.fpT.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.fpS != null && onClickListener != null) {
            this.fpS.setOnClickListener(onClickListener);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.fpY != null && onClickListener != null) {
            this.fpY.setOnClickListener(onClickListener);
        }
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fpZ != null && onClickListener != null) {
            this.fpZ.setOnClickListener(onClickListener);
        }
    }
}
