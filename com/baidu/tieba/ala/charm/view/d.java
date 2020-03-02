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
    public ViewGroup exi;
    public TextView exj;
    public ImageView exk;
    public HeadImageView exl;
    public TextView exm;
    public RelativeLayout exn;
    public LinearGradientTextView exo;
    public TextView exp;
    public ImageView exq;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.exj = (TextView) view.findViewById(a.g.tvGradeNum);
        this.exk = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.exi = (ViewGroup) view.findViewById(a.g.item_view);
        this.exl = (HeadImageView) view.findViewById(a.g.photo);
        this.exl.setIsRound(true);
        this.exl.setAutoChangeStyle(false);
        this.exl.setClickable(false);
        this.exn = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.exm = (TextView) view.findViewById(a.g.ala_intro);
        this.exo = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.exp = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.exq = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.exo.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.exo.setVisibility(8);
                this.exi.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.exp.setVisibility(0);
                } else {
                    this.exp.setVisibility(8);
                }
            } else {
                this.exp.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.exo.setVisibility(8);
                } else {
                    this.exo.setVisibility(0);
                }
                this.exi.setBackgroundResource(a.f.sdk_list_item_selector_black);
                il(aLaCharmData.follow_status != 0);
            }
            this.exi.setTag(Integer.valueOf(i));
            pa(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.exm.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.exq != null) {
            this.exq.setVisibility(8);
            if (i == 0) {
                this.exq.setVisibility(0);
                this.exq.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.exq.setVisibility(0);
                this.exq.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.exq.setVisibility(0);
                this.exq.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.exq.setVisibility(8);
            }
        }
        k.a(this.exl, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void il(boolean z) {
        if (z) {
            this.exo.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.exo.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.exo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.exo.setBackgroundResource(a.f.charm_attention_s_bg);
            this.exo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.exo.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.exo.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.exo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.exo.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.exo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.exo.setBackgroundResource(a.f.charm_attention_n_bg);
            this.exo.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void pa(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.exj.setVisibility(4);
                this.exk.setImageResource(a.f.sdk_icon_live_list_first);
                this.exk.setVisibility(0);
            } else if (i2 == 2) {
                this.exj.setVisibility(4);
                this.exk.setImageResource(a.f.sdk_icon_live_list_second);
                this.exk.setVisibility(0);
            } else if (i2 == 3) {
                this.exj.setVisibility(4);
                this.exk.setImageResource(a.f.sdk_icon_live_list_third);
                this.exk.setVisibility(0);
            } else {
                this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.exj.setVisibility(0);
                this.exk.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.exj.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.exj.setText("0" + i2);
        } else {
            this.exj.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exi != null && onClickListener != null) {
            this.exi.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.exo != null && onClickListener != null) {
            this.exo.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.exp != null && onClickListener != null) {
            this.exp.setOnClickListener(onClickListener);
        }
    }
}
