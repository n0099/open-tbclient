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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes4.dex */
public class d {
    private int gwN;
    public ViewGroup gxd;
    public TextView gxe;
    public ImageView gxf;
    public HeadImageView gxg;
    public TextView gxh;
    public RelativeLayout gxi;
    public LinearGradientTextView gxj;
    public TextView gxk;
    public ImageView gxl;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gwN = i;
        this.gxe = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gxf = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gxd = (ViewGroup) view.findViewById(a.f.item_view);
        this.gxg = (HeadImageView) view.findViewById(a.f.photo);
        this.gxg.setIsRound(true);
        this.gxg.setAutoChangeStyle(false);
        this.gxg.setClickable(false);
        this.gxi = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gxh = (TextView) view.findViewById(a.f.ala_intro);
        this.gxj = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gxk = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gxl = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gxj.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gxj.setVisibility(8);
                this.gxd.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gxk.setVisibility(0);
                } else {
                    this.gxk.setVisibility(8);
                }
            } else {
                this.gxk.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gxj.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gxj.setVisibility(8);
                } else {
                    this.gxj.setVisibility(0);
                }
                this.gxd.setBackgroundResource(a.e.sdk_list_item_selector_black);
                lY(aLaCharmData.follow_status != 0);
            }
            this.gxd.setTag(Integer.valueOf(i));
            uu(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gxh.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.gxl != null) {
            this.gxl.setVisibility(8);
            if (i == 0) {
                this.gxl.setVisibility(0);
                this.gxl.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gxl.setVisibility(0);
                this.gxl.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gxl.setVisibility(0);
                this.gxl.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gxl.setVisibility(8);
            }
        }
        l.a(this.gxg, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void lY(boolean z) {
        if (z) {
            this.gxj.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gxj.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gxj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gxj.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gxj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gxj.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gxj.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gxj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gxj.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gxj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gxj.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gxj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void uu(int i) {
        int i2 = i + 1;
        if (this.gwN == 1) {
            if (i2 == 1) {
                this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gxe.setVisibility(4);
                this.gxf.setImageResource(a.e.sdk_icon_live_list_first);
                this.gxf.setVisibility(0);
            } else if (i2 == 2) {
                this.gxe.setVisibility(4);
                this.gxf.setImageResource(a.e.sdk_icon_live_list_second);
                this.gxf.setVisibility(0);
            } else if (i2 == 3) {
                this.gxe.setVisibility(4);
                this.gxf.setImageResource(a.e.sdk_icon_live_list_third);
                this.gxf.setVisibility(0);
            } else {
                this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gxe.setVisibility(0);
                this.gxf.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gxe.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gxe.setText("0" + i2);
        } else {
            this.gxe.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.gxd != null && onClickListener != null) {
            this.gxd.setOnClickListener(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.gxj != null && onClickListener != null) {
            this.gxj.setOnClickListener(onClickListener);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gxk != null && onClickListener != null) {
            this.gxk.setOnClickListener(onClickListener);
        }
    }
}
