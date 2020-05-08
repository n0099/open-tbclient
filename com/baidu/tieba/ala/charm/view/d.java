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
    private int fbO;
    public ViewGroup fce;
    public TextView fcf;
    public ImageView fcg;
    public HeadImageView fch;
    public TextView fci;
    public RelativeLayout fcj;
    public LinearGradientTextView fck;
    public TextView fcl;
    public ImageView fcm;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fbO = i;
        this.fcf = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fcg = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fce = (ViewGroup) view.findViewById(a.g.item_view);
        this.fch = (HeadImageView) view.findViewById(a.g.photo);
        this.fch.setIsRound(true);
        this.fch.setAutoChangeStyle(false);
        this.fch.setClickable(false);
        this.fcj = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fci = (TextView) view.findViewById(a.g.ala_intro);
        this.fck = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fcl = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fcm = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fck.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fck.setVisibility(8);
                this.fce.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fcl.setVisibility(0);
                } else {
                    this.fcl.setVisibility(8);
                }
            } else {
                this.fcl.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fck.setVisibility(8);
                } else {
                    this.fck.setVisibility(0);
                }
                this.fce.setBackgroundResource(a.f.sdk_list_item_selector_black);
                jo(aLaCharmData.follow_status != 0);
            }
            this.fce.setTag(Integer.valueOf(i));
            px(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fci.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.fcm != null) {
            this.fcm.setVisibility(8);
            if (i == 0) {
                this.fcm.setVisibility(0);
                this.fcm.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fcm.setVisibility(0);
                this.fcm.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fcm.setVisibility(0);
                this.fcm.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fcm.setVisibility(8);
            }
        }
        k.a(this.fch, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void jo(boolean z) {
        if (z) {
            this.fck.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fck.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fck.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fck.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fck.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fck.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fck.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fck.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fck.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fck.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fck.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fck.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void px(int i) {
        int i2 = i + 1;
        if (this.fbO == 1) {
            if (i2 == 1) {
                this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fcf.setVisibility(4);
                this.fcg.setImageResource(a.f.sdk_icon_live_list_first);
                this.fcg.setVisibility(0);
            } else if (i2 == 2) {
                this.fcf.setVisibility(4);
                this.fcg.setImageResource(a.f.sdk_icon_live_list_second);
                this.fcg.setVisibility(0);
            } else if (i2 == 3) {
                this.fcf.setVisibility(4);
                this.fcg.setImageResource(a.f.sdk_icon_live_list_third);
                this.fcg.setVisibility(0);
            } else {
                this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fcf.setVisibility(0);
                this.fcg.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fcf.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fcf.setText("0" + i2);
        } else {
            this.fcf.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fce != null && onClickListener != null) {
            this.fce.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fck != null && onClickListener != null) {
            this.fck.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fcl != null && onClickListener != null) {
            this.fcl.setOnClickListener(onClickListener);
        }
    }
}
