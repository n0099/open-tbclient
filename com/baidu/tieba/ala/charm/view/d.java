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
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes3.dex */
public class d {
    private int fAN;
    public ViewGroup fBd;
    public TextView fBe;
    public ImageView fBf;
    public HeadImageView fBg;
    public TextView fBh;
    public RelativeLayout fBi;
    public LinearGradientTextView fBj;
    public TextView fBk;
    public ImageView fBl;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fAN = i;
        this.fBe = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fBf = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fBd = (ViewGroup) view.findViewById(a.g.item_view);
        this.fBg = (HeadImageView) view.findViewById(a.g.photo);
        this.fBg.setIsRound(true);
        this.fBg.setAutoChangeStyle(false);
        this.fBg.setClickable(false);
        this.fBi = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fBh = (TextView) view.findViewById(a.g.ala_intro);
        this.fBj = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fBk = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fBl = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fBj.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fBj.setVisibility(8);
                this.fBd.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fBk.setVisibility(0);
                } else {
                    this.fBk.setVisibility(8);
                }
            } else {
                this.fBk.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fBj.setVisibility(8);
                } else {
                    this.fBj.setVisibility(0);
                }
                this.fBd.setBackgroundResource(a.f.sdk_list_item_selector_black);
                jU(aLaCharmData.follow_status != 0);
            }
            this.fBd.setTag(Integer.valueOf(i));
            qz(i);
            m(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fBh.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void m(String str, int i, String str2) {
        if (this.fBl != null) {
            this.fBl.setVisibility(8);
            if (i == 0) {
                this.fBl.setVisibility(0);
                this.fBl.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fBl.setVisibility(0);
                this.fBl.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fBl.setVisibility(0);
                this.fBl.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fBl.setVisibility(8);
            }
        }
        k.a(this.fBg, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void jU(boolean z) {
        if (z) {
            this.fBj.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fBj.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fBj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fBj.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fBj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fBj.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fBj.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fBj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fBj.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fBj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fBj.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fBj.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void qz(int i) {
        int i2 = i + 1;
        if (this.fAN == 1) {
            if (i2 == 1) {
                this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fBe.setVisibility(4);
                this.fBf.setImageResource(a.f.sdk_icon_live_list_first);
                this.fBf.setVisibility(0);
            } else if (i2 == 2) {
                this.fBe.setVisibility(4);
                this.fBf.setImageResource(a.f.sdk_icon_live_list_second);
                this.fBf.setVisibility(0);
            } else if (i2 == 3) {
                this.fBe.setVisibility(4);
                this.fBf.setImageResource(a.f.sdk_icon_live_list_third);
                this.fBf.setVisibility(0);
            } else {
                this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fBe.setVisibility(0);
                this.fBf.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fBe.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fBe.setText("0" + i2);
        } else {
            this.fBe.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fBd != null && onClickListener != null) {
            this.fBd.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fBj != null && onClickListener != null) {
            this.fBj.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fBk != null && onClickListener != null) {
            this.fBk.setOnClickListener(onClickListener);
        }
    }
}
