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
/* loaded from: classes4.dex */
public class d {
    private int fFX;
    public ViewGroup fGn;
    public TextView fGo;
    public ImageView fGp;
    public HeadImageView fGq;
    public TextView fGr;
    public RelativeLayout fGs;
    public LinearGradientTextView fGt;
    public TextView fGu;
    public ImageView fGv;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fFX = i;
        this.fGo = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fGp = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fGn = (ViewGroup) view.findViewById(a.g.item_view);
        this.fGq = (HeadImageView) view.findViewById(a.g.photo);
        this.fGq.setIsRound(true);
        this.fGq.setAutoChangeStyle(false);
        this.fGq.setClickable(false);
        this.fGs = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fGr = (TextView) view.findViewById(a.g.ala_intro);
        this.fGt = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fGu = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fGv = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fGt.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fGt.setVisibility(8);
                this.fGn.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fGu.setVisibility(0);
                } else {
                    this.fGu.setVisibility(8);
                }
            } else {
                this.fGu.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fGt.setVisibility(8);
                } else {
                    this.fGt.setVisibility(0);
                }
                this.fGn.setBackgroundResource(a.f.sdk_list_item_selector_black);
                ky(aLaCharmData.follow_status != 0);
            }
            this.fGn.setTag(Integer.valueOf(i));
            qO(i);
            m(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fGr.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void m(String str, int i, String str2) {
        if (this.fGv != null) {
            this.fGv.setVisibility(8);
            if (i == 0) {
                this.fGv.setVisibility(0);
                this.fGv.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fGv.setVisibility(0);
                this.fGv.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fGv.setVisibility(0);
                this.fGv.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fGv.setVisibility(8);
            }
        }
        k.a(this.fGq, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void ky(boolean z) {
        if (z) {
            this.fGt.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fGt.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fGt.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fGt.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fGt.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fGt.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fGt.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fGt.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fGt.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fGt.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fGt.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fGt.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void qO(int i) {
        int i2 = i + 1;
        if (this.fFX == 1) {
            if (i2 == 1) {
                this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fGo.setVisibility(4);
                this.fGp.setImageResource(a.f.sdk_icon_live_list_first);
                this.fGp.setVisibility(0);
            } else if (i2 == 2) {
                this.fGo.setVisibility(4);
                this.fGp.setImageResource(a.f.sdk_icon_live_list_second);
                this.fGp.setVisibility(0);
            } else if (i2 == 3) {
                this.fGo.setVisibility(4);
                this.fGp.setImageResource(a.f.sdk_icon_live_list_third);
                this.fGp.setVisibility(0);
            } else {
                this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fGo.setVisibility(0);
                this.fGp.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fGo.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fGo.setText("0" + i2);
        } else {
            this.fGo.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fGn != null && onClickListener != null) {
            this.fGn.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fGt != null && onClickListener != null) {
            this.fGt.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fGu != null && onClickListener != null) {
            this.fGu.setOnClickListener(onClickListener);
        }
    }
}
