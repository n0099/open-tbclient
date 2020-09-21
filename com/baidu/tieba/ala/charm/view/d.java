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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes4.dex */
public class d {
    private int fUD;
    public ViewGroup fUT;
    public TextView fUU;
    public ImageView fUV;
    public HeadImageView fUW;
    public TextView fUX;
    public RelativeLayout fUY;
    public LinearGradientTextView fUZ;
    public TextView fVa;
    public ImageView fVb;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fUD = i;
        this.fUU = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fUV = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fUT = (ViewGroup) view.findViewById(a.g.item_view);
        this.fUW = (HeadImageView) view.findViewById(a.g.photo);
        this.fUW.setIsRound(true);
        this.fUW.setAutoChangeStyle(false);
        this.fUW.setClickable(false);
        this.fUY = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fUX = (TextView) view.findViewById(a.g.ala_intro);
        this.fUZ = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fVa = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fVb = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fUZ.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fUZ.setVisibility(8);
                this.fUT.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fVa.setVisibility(0);
                } else {
                    this.fVa.setVisibility(8);
                }
            } else {
                this.fVa.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fUZ.setVisibility(8);
                } else {
                    this.fUZ.setVisibility(0);
                }
                this.fUT.setBackgroundResource(a.f.sdk_list_item_selector_black);
                la(aLaCharmData.follow_status != 0);
            }
            this.fUT.setTag(Integer.valueOf(i));
            tt(i);
            l(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fUX.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void l(String str, int i, String str2) {
        if (this.fVb != null) {
            this.fVb.setVisibility(8);
            if (i == 0) {
                this.fVb.setVisibility(0);
                this.fVb.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fVb.setVisibility(0);
                this.fVb.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fVb.setVisibility(0);
                this.fVb.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fVb.setVisibility(8);
            }
        }
        l.a(this.fUW, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void la(boolean z) {
        if (z) {
            this.fUZ.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fUZ.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fUZ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fUZ.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fUZ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fUZ.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fUZ.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fUZ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fUZ.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fUZ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fUZ.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fUZ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void tt(int i) {
        int i2 = i + 1;
        if (this.fUD == 1) {
            if (i2 == 1) {
                this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fUU.setVisibility(4);
                this.fUV.setImageResource(a.f.sdk_icon_live_list_first);
                this.fUV.setVisibility(0);
            } else if (i2 == 2) {
                this.fUU.setVisibility(4);
                this.fUV.setImageResource(a.f.sdk_icon_live_list_second);
                this.fUV.setVisibility(0);
            } else if (i2 == 3) {
                this.fUU.setVisibility(4);
                this.fUV.setImageResource(a.f.sdk_icon_live_list_third);
                this.fUV.setVisibility(0);
            } else {
                this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fUU.setVisibility(0);
                this.fUV.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fUU.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fUU.setText("0" + i2);
        } else {
            this.fUU.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fUT != null && onClickListener != null) {
            this.fUT.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fUZ != null && onClickListener != null) {
            this.fUZ.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fVa != null && onClickListener != null) {
            this.fVa.setOnClickListener(onClickListener);
        }
    }
}
