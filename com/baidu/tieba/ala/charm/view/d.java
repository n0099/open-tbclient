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
    private int gQP;
    public ViewGroup gRf;
    public TextView gRg;
    public ImageView gRh;
    public HeadImageView gRi;
    public TextView gRj;
    public RelativeLayout gRk;
    public LinearGradientTextView gRl;
    public TextView gRm;
    public ImageView gRn;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gQP = i;
        this.gRg = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gRh = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gRf = (ViewGroup) view.findViewById(a.f.item_view);
        this.gRi = (HeadImageView) view.findViewById(a.f.photo);
        this.gRi.setIsRound(true);
        this.gRi.setAutoChangeStyle(false);
        this.gRi.setClickable(false);
        this.gRk = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gRj = (TextView) view.findViewById(a.f.ala_intro);
        this.gRl = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gRm = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gRn = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gRl.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gRl.setVisibility(8);
                this.gRf.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gRm.setVisibility(0);
                } else {
                    this.gRm.setVisibility(8);
                }
            } else {
                this.gRm.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gRl.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gRl.setVisibility(8);
                } else {
                    this.gRl.setVisibility(0);
                }
                this.gRf.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mU(aLaCharmData.follow_status != 0);
            }
            if (aLaCharmData.extInfoJson != null) {
                if (aLaCharmData.extInfoJson.optInt("is_mysterious_man") == 1) {
                    this.gRl.setVisibility(8);
                }
            }
            this.gRf.setTag(Integer.valueOf(i));
            um(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gRj.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.gRn != null) {
            this.gRn.setVisibility(8);
            if (i == 0) {
                this.gRn.setVisibility(0);
                this.gRn.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gRn.setVisibility(0);
                this.gRn.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gRn.setVisibility(0);
                this.gRn.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gRn.setVisibility(8);
            }
        }
        m.a(this.gRi, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mU(boolean z) {
        if (z) {
            this.gRl.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gRl.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gRl.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gRl.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gRl.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gRl.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gRl.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gRl.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gRl.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gRl.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gRl.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gRl.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void um(int i) {
        int i2 = i + 1;
        if (this.gQP == 1) {
            if (i2 == 1) {
                this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gRg.setVisibility(4);
                this.gRh.setImageResource(a.e.sdk_icon_live_list_first);
                this.gRh.setVisibility(0);
            } else if (i2 == 2) {
                this.gRg.setVisibility(4);
                this.gRh.setImageResource(a.e.sdk_icon_live_list_second);
                this.gRh.setVisibility(0);
            } else if (i2 == 3) {
                this.gRg.setVisibility(4);
                this.gRh.setImageResource(a.e.sdk_icon_live_list_third);
                this.gRh.setVisibility(0);
            } else {
                this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gRg.setVisibility(0);
                this.gRh.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gRg.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gRg.setText("0" + i2);
        } else {
            this.gRg.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gRf != null && onClickListener != null) {
            this.gRf.setOnClickListener(onClickListener);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.gRl != null && onClickListener != null) {
            this.gRl.setOnClickListener(onClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.gRm != null && onClickListener != null) {
            this.gRm.setOnClickListener(onClickListener);
        }
    }
}
