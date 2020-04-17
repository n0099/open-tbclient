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
    private int fbJ;
    public ViewGroup fbZ;
    public TextView fca;
    public ImageView fcb;
    public HeadImageView fcc;
    public TextView fcd;
    public RelativeLayout fce;
    public LinearGradientTextView fcf;
    public TextView fcg;
    public ImageView fch;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fbJ = i;
        this.fca = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fcb = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fbZ = (ViewGroup) view.findViewById(a.g.item_view);
        this.fcc = (HeadImageView) view.findViewById(a.g.photo);
        this.fcc.setIsRound(true);
        this.fcc.setAutoChangeStyle(false);
        this.fcc.setClickable(false);
        this.fce = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fcd = (TextView) view.findViewById(a.g.ala_intro);
        this.fcf = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fcg = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fch = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fcf.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fcf.setVisibility(8);
                this.fbZ.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fcg.setVisibility(0);
                } else {
                    this.fcg.setVisibility(8);
                }
            } else {
                this.fcg.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fcf.setVisibility(8);
                } else {
                    this.fcf.setVisibility(0);
                }
                this.fbZ.setBackgroundResource(a.f.sdk_list_item_selector_black);
                jo(aLaCharmData.follow_status != 0);
            }
            this.fbZ.setTag(Integer.valueOf(i));
            px(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fcd.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.fch != null) {
            this.fch.setVisibility(8);
            if (i == 0) {
                this.fch.setVisibility(0);
                this.fch.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fch.setVisibility(0);
                this.fch.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fch.setVisibility(0);
                this.fch.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fch.setVisibility(8);
            }
        }
        k.a(this.fcc, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void jo(boolean z) {
        if (z) {
            this.fcf.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fcf.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fcf.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fcf.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fcf.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fcf.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fcf.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fcf.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fcf.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fcf.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void px(int i) {
        int i2 = i + 1;
        if (this.fbJ == 1) {
            if (i2 == 1) {
                this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fca.setVisibility(4);
                this.fcb.setImageResource(a.f.sdk_icon_live_list_first);
                this.fcb.setVisibility(0);
            } else if (i2 == 2) {
                this.fca.setVisibility(4);
                this.fcb.setImageResource(a.f.sdk_icon_live_list_second);
                this.fcb.setVisibility(0);
            } else if (i2 == 3) {
                this.fca.setVisibility(4);
                this.fcb.setImageResource(a.f.sdk_icon_live_list_third);
                this.fcb.setVisibility(0);
            } else {
                this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fca.setVisibility(0);
                this.fcb.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fca.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fca.setText("0" + i2);
        } else {
            this.fca.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fbZ != null && onClickListener != null) {
            this.fbZ.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fcf != null && onClickListener != null) {
            this.fcf.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fcg != null && onClickListener != null) {
            this.fcg.setOnClickListener(onClickListener);
        }
    }
}
