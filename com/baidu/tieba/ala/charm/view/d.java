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
/* loaded from: classes11.dex */
public class d {
    private int gQS;
    public ViewGroup gRi;
    public TextView gRj;
    public ImageView gRk;
    public HeadImageView gRl;
    public TextView gRm;
    public RelativeLayout gRn;
    public LinearGradientTextView gRo;
    public TextView gRp;
    public ImageView gRq;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gQS = i;
        this.gRj = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gRk = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gRi = (ViewGroup) view.findViewById(a.f.item_view);
        this.gRl = (HeadImageView) view.findViewById(a.f.photo);
        this.gRl.setIsRound(true);
        this.gRl.setAutoChangeStyle(false);
        this.gRl.setClickable(false);
        this.gRn = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gRm = (TextView) view.findViewById(a.f.ala_intro);
        this.gRo = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gRp = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gRq = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gRo.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gRo.setVisibility(8);
                this.gRi.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gRp.setVisibility(0);
                } else {
                    this.gRp.setVisibility(8);
                }
            } else {
                this.gRp.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gRo.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gRo.setVisibility(8);
                } else {
                    this.gRo.setVisibility(0);
                }
                this.gRi.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mU(aLaCharmData.follow_status != 0);
            }
            if (aLaCharmData.extInfoJson != null) {
                if (aLaCharmData.extInfoJson.optInt("is_mysterious_man") == 1) {
                    this.gRo.setVisibility(8);
                }
            }
            this.gRi.setTag(Integer.valueOf(i));
            vK(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gRm.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.gRq != null) {
            this.gRq.setVisibility(8);
            if (i == 0) {
                this.gRq.setVisibility(0);
                this.gRq.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gRq.setVisibility(0);
                this.gRq.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gRq.setVisibility(0);
                this.gRq.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gRq.setVisibility(8);
            }
        }
        m.a(this.gRl, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mU(boolean z) {
        if (z) {
            this.gRo.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gRo.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gRo.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gRo.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gRo.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gRo.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gRo.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gRo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gRo.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gRo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gRo.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gRo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void vK(int i) {
        int i2 = i + 1;
        if (this.gQS == 1) {
            if (i2 == 1) {
                this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gRj.setVisibility(4);
                this.gRk.setImageResource(a.e.sdk_icon_live_list_first);
                this.gRk.setVisibility(0);
            } else if (i2 == 2) {
                this.gRj.setVisibility(4);
                this.gRk.setImageResource(a.e.sdk_icon_live_list_second);
                this.gRk.setVisibility(0);
            } else if (i2 == 3) {
                this.gRj.setVisibility(4);
                this.gRk.setImageResource(a.e.sdk_icon_live_list_third);
                this.gRk.setVisibility(0);
            } else {
                this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gRj.setVisibility(0);
                this.gRk.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gRj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gRj.setText("0" + i2);
        } else {
            this.gRj.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gRi != null && onClickListener != null) {
            this.gRi.setOnClickListener(onClickListener);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.gRo != null && onClickListener != null) {
            this.gRo.setOnClickListener(onClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.gRp != null && onClickListener != null) {
            this.gRp.setOnClickListener(onClickListener);
        }
    }
}
