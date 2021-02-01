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
    private int gOS;
    public ViewGroup gPi;
    public TextView gPj;
    public ImageView gPk;
    public HeadImageView gPl;
    public TextView gPm;
    public RelativeLayout gPn;
    public LinearGradientTextView gPo;
    public TextView gPp;
    public ImageView gPq;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gOS = i;
        this.gPj = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gPk = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gPi = (ViewGroup) view.findViewById(a.f.item_view);
        this.gPl = (HeadImageView) view.findViewById(a.f.photo);
        this.gPl.setIsRound(true);
        this.gPl.setAutoChangeStyle(false);
        this.gPl.setClickable(false);
        this.gPn = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gPm = (TextView) view.findViewById(a.f.ala_intro);
        this.gPo = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gPp = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gPq = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gPo.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gPo.setVisibility(8);
                this.gPi.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gPp.setVisibility(0);
                } else {
                    this.gPp.setVisibility(8);
                }
            } else {
                this.gPp.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gPo.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gPo.setVisibility(8);
                } else {
                    this.gPo.setVisibility(0);
                }
                this.gPi.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mU(aLaCharmData.follow_status != 0);
            }
            if (aLaCharmData.extInfoJson != null) {
                if (aLaCharmData.extInfoJson.optInt("is_mysterious_man") == 1) {
                    this.gPo.setVisibility(8);
                }
            }
            this.gPi.setTag(Integer.valueOf(i));
            uk(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gPm.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.gPq != null) {
            this.gPq.setVisibility(8);
            if (i == 0) {
                this.gPq.setVisibility(0);
                this.gPq.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gPq.setVisibility(0);
                this.gPq.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gPq.setVisibility(0);
                this.gPq.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gPq.setVisibility(8);
            }
        }
        m.a(this.gPl, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mU(boolean z) {
        if (z) {
            this.gPo.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gPo.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gPo.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gPo.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gPo.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gPo.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gPo.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gPo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPo.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gPo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gPo.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gPo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void uk(int i) {
        int i2 = i + 1;
        if (this.gOS == 1) {
            if (i2 == 1) {
                this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gPj.setVisibility(4);
                this.gPk.setImageResource(a.e.sdk_icon_live_list_first);
                this.gPk.setVisibility(0);
            } else if (i2 == 2) {
                this.gPj.setVisibility(4);
                this.gPk.setImageResource(a.e.sdk_icon_live_list_second);
                this.gPk.setVisibility(0);
            } else if (i2 == 3) {
                this.gPj.setVisibility(4);
                this.gPk.setImageResource(a.e.sdk_icon_live_list_third);
                this.gPk.setVisibility(0);
            } else {
                this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gPj.setVisibility(0);
                this.gPk.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gPj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gPj.setText("0" + i2);
        } else {
            this.gPj.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gPi != null && onClickListener != null) {
            this.gPi.setOnClickListener(onClickListener);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.gPo != null && onClickListener != null) {
            this.gPo.setOnClickListener(onClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.gPp != null && onClickListener != null) {
            this.gPp.setOnClickListener(onClickListener);
        }
    }
}
