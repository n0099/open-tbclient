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
    public RelativeLayout gFA;
    public LinearGradientTextView gFB;
    public TextView gFC;
    public ImageView gFD;
    private int gFf;
    public ViewGroup gFv;
    public TextView gFw;
    public ImageView gFx;
    public HeadImageView gFy;
    public TextView gFz;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gFf = i;
        this.gFw = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gFx = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gFv = (ViewGroup) view.findViewById(a.f.item_view);
        this.gFy = (HeadImageView) view.findViewById(a.f.photo);
        this.gFy.setIsRound(true);
        this.gFy.setAutoChangeStyle(false);
        this.gFy.setClickable(false);
        this.gFA = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gFz = (TextView) view.findViewById(a.f.ala_intro);
        this.gFB = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gFC = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gFD = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gFB.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gFB.setVisibility(8);
                this.gFv.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gFC.setVisibility(0);
                } else {
                    this.gFC.setVisibility(8);
                }
            } else {
                this.gFC.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gFB.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gFB.setVisibility(8);
                } else {
                    this.gFB.setVisibility(0);
                }
                this.gFv.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mu(aLaCharmData.follow_status != 0);
            }
            this.gFv.setTag(Integer.valueOf(i));
            vz(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gFz.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.gFD != null) {
            this.gFD.setVisibility(8);
            if (i == 0) {
                this.gFD.setVisibility(0);
                this.gFD.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gFD.setVisibility(0);
                this.gFD.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gFD.setVisibility(0);
                this.gFD.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gFD.setVisibility(8);
            }
        }
        l.a(this.gFy, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mu(boolean z) {
        if (z) {
            this.gFB.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFB.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gFB.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gFB.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gFB.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gFB.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gFB.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gFB.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gFB.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gFB.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gFB.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gFB.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void vz(int i) {
        int i2 = i + 1;
        if (this.gFf == 1) {
            if (i2 == 1) {
                this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gFw.setVisibility(4);
                this.gFx.setImageResource(a.e.sdk_icon_live_list_first);
                this.gFx.setVisibility(0);
            } else if (i2 == 2) {
                this.gFw.setVisibility(4);
                this.gFx.setImageResource(a.e.sdk_icon_live_list_second);
                this.gFx.setVisibility(0);
            } else if (i2 == 3) {
                this.gFw.setVisibility(4);
                this.gFx.setImageResource(a.e.sdk_icon_live_list_third);
                this.gFx.setVisibility(0);
            } else {
                this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gFw.setVisibility(0);
                this.gFx.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gFw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gFw.setText("0" + i2);
        } else {
            this.gFw.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.gFv != null && onClickListener != null) {
            this.gFv.setOnClickListener(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.gFB != null && onClickListener != null) {
            this.gFB.setOnClickListener(onClickListener);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gFC != null && onClickListener != null) {
            this.gFC.setOnClickListener(onClickListener);
        }
    }
}
