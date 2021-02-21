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
    public TextView gPA;
    public RelativeLayout gPB;
    public LinearGradientTextView gPC;
    public TextView gPD;
    public ImageView gPE;
    private int gPg;
    public ViewGroup gPw;
    public TextView gPx;
    public ImageView gPy;
    public HeadImageView gPz;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gPg = i;
        this.gPx = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gPy = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gPw = (ViewGroup) view.findViewById(a.f.item_view);
        this.gPz = (HeadImageView) view.findViewById(a.f.photo);
        this.gPz.setIsRound(true);
        this.gPz.setAutoChangeStyle(false);
        this.gPz.setClickable(false);
        this.gPB = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gPA = (TextView) view.findViewById(a.f.ala_intro);
        this.gPC = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gPD = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gPE = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gPC.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gPC.setVisibility(8);
                this.gPw.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gPD.setVisibility(0);
                } else {
                    this.gPD.setVisibility(8);
                }
            } else {
                this.gPD.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gPC.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gPC.setVisibility(8);
                } else {
                    this.gPC.setVisibility(0);
                }
                this.gPw.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mU(aLaCharmData.follow_status != 0);
            }
            if (aLaCharmData.extInfoJson != null) {
                if (aLaCharmData.extInfoJson.optInt("is_mysterious_man") == 1) {
                    this.gPC.setVisibility(8);
                }
            }
            this.gPw.setTag(Integer.valueOf(i));
            uk(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gPA.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.gPE != null) {
            this.gPE.setVisibility(8);
            if (i == 0) {
                this.gPE.setVisibility(0);
                this.gPE.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gPE.setVisibility(0);
                this.gPE.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gPE.setVisibility(0);
                this.gPE.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gPE.setVisibility(8);
            }
        }
        m.a(this.gPz, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mU(boolean z) {
        if (z) {
            this.gPC.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gPC.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gPC.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gPC.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gPC.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gPC.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gPC.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gPC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gPC.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gPC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gPC.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gPC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void uk(int i) {
        int i2 = i + 1;
        if (this.gPg == 1) {
            if (i2 == 1) {
                this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gPx.setVisibility(4);
                this.gPy.setImageResource(a.e.sdk_icon_live_list_first);
                this.gPy.setVisibility(0);
            } else if (i2 == 2) {
                this.gPx.setVisibility(4);
                this.gPy.setImageResource(a.e.sdk_icon_live_list_second);
                this.gPy.setVisibility(0);
            } else if (i2 == 3) {
                this.gPx.setVisibility(4);
                this.gPy.setImageResource(a.e.sdk_icon_live_list_third);
                this.gPy.setVisibility(0);
            } else {
                this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gPx.setVisibility(0);
                this.gPy.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gPx.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gPx.setText("0" + i2);
        } else {
            this.gPx.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gPw != null && onClickListener != null) {
            this.gPw.setOnClickListener(onClickListener);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        if (this.gPC != null && onClickListener != null) {
            this.gPC.setOnClickListener(onClickListener);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        if (this.gPD != null && onClickListener != null) {
            this.gPD.setOnClickListener(onClickListener);
        }
    }
}
