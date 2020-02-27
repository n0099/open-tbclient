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
    public ViewGroup exh;
    public TextView exi;
    public ImageView exj;
    public HeadImageView exk;
    public TextView exl;
    public RelativeLayout exm;
    public LinearGradientTextView exn;
    public TextView exo;
    public ImageView exp;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.exi = (TextView) view.findViewById(a.g.tvGradeNum);
        this.exj = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.exh = (ViewGroup) view.findViewById(a.g.item_view);
        this.exk = (HeadImageView) view.findViewById(a.g.photo);
        this.exk.setIsRound(true);
        this.exk.setAutoChangeStyle(false);
        this.exk.setClickable(false);
        this.exm = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.exl = (TextView) view.findViewById(a.g.ala_intro);
        this.exn = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.exo = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.exp = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.exn.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.exn.setVisibility(8);
                this.exh.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.exo.setVisibility(0);
                } else {
                    this.exo.setVisibility(8);
                }
            } else {
                this.exo.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.exn.setVisibility(8);
                } else {
                    this.exn.setVisibility(0);
                }
                this.exh.setBackgroundResource(a.f.sdk_list_item_selector_black);
                il(aLaCharmData.follow_status != 0);
            }
            this.exh.setTag(Integer.valueOf(i));
            pa(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.exl.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.exp != null) {
            this.exp.setVisibility(8);
            if (i == 0) {
                this.exp.setVisibility(0);
                this.exp.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.exp.setVisibility(0);
                this.exp.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.exp.setVisibility(0);
                this.exp.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.exp.setVisibility(8);
            }
        }
        k.a(this.exk, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void il(boolean z) {
        if (z) {
            this.exn.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.exn.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.exn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.exn.setBackgroundResource(a.f.charm_attention_s_bg);
            this.exn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.exn.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.exn.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.exn.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.exn.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.exn.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.exn.setBackgroundResource(a.f.charm_attention_n_bg);
            this.exn.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void pa(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.exi.setVisibility(4);
                this.exj.setImageResource(a.f.sdk_icon_live_list_first);
                this.exj.setVisibility(0);
            } else if (i2 == 2) {
                this.exi.setVisibility(4);
                this.exj.setImageResource(a.f.sdk_icon_live_list_second);
                this.exj.setVisibility(0);
            } else if (i2 == 3) {
                this.exi.setVisibility(4);
                this.exj.setImageResource(a.f.sdk_icon_live_list_third);
                this.exj.setVisibility(0);
            } else {
                this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.exi.setVisibility(0);
                this.exj.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.exi.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.exi.setText("0" + i2);
        } else {
            this.exi.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exh != null && onClickListener != null) {
            this.exh.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.exn != null && onClickListener != null) {
            this.exn.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.exo != null && onClickListener != null) {
            this.exo.setOnClickListener(onClickListener);
        }
    }
}
