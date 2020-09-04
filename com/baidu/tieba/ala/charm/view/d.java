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
/* loaded from: classes7.dex */
public class d {
    public ViewGroup fRI;
    public TextView fRJ;
    public ImageView fRK;
    public HeadImageView fRL;
    public TextView fRM;
    public RelativeLayout fRN;
    public LinearGradientTextView fRO;
    public TextView fRP;
    public ImageView fRQ;
    private int fRs;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.fRs = i;
        this.fRJ = (TextView) view.findViewById(a.g.tvGradeNum);
        this.fRK = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.fRI = (ViewGroup) view.findViewById(a.g.item_view);
        this.fRL = (HeadImageView) view.findViewById(a.g.photo);
        this.fRL.setIsRound(true);
        this.fRL.setAutoChangeStyle(false);
        this.fRL.setClickable(false);
        this.fRN = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.fRM = (TextView) view.findViewById(a.g.ala_intro);
        this.fRO = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.fRP = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.fRQ = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.fRO.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.fRO.setVisibility(8);
                this.fRI.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.fRP.setVisibility(0);
                } else {
                    this.fRP.setVisibility(8);
                }
            } else {
                this.fRP.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.fRO.setVisibility(8);
                } else {
                    this.fRO.setVisibility(0);
                }
                this.fRI.setBackgroundResource(a.f.sdk_list_item_selector_black);
                kY(aLaCharmData.follow_status != 0);
            }
            this.fRI.setTag(Integer.valueOf(i));
            ta(i);
            l(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.fRM.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void l(String str, int i, String str2) {
        if (this.fRQ != null) {
            this.fRQ.setVisibility(8);
            if (i == 0) {
                this.fRQ.setVisibility(0);
                this.fRQ.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.fRQ.setVisibility(0);
                this.fRQ.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.fRQ.setVisibility(0);
                this.fRQ.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.fRQ.setVisibility(8);
            }
        }
        k.a(this.fRL, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void kY(boolean z) {
        if (z) {
            this.fRO.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fRO.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.fRO.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.fRO.setBackgroundResource(a.f.charm_attention_s_bg);
            this.fRO.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.fRO.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fRO.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.fRO.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fRO.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.fRO.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.fRO.setBackgroundResource(a.f.charm_attention_n_bg);
            this.fRO.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void ta(int i) {
        int i2 = i + 1;
        if (this.fRs == 1) {
            if (i2 == 1) {
                this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.fRJ.setVisibility(4);
                this.fRK.setImageResource(a.f.sdk_icon_live_list_first);
                this.fRK.setVisibility(0);
            } else if (i2 == 2) {
                this.fRJ.setVisibility(4);
                this.fRK.setImageResource(a.f.sdk_icon_live_list_second);
                this.fRK.setVisibility(0);
            } else if (i2 == 3) {
                this.fRJ.setVisibility(4);
                this.fRK.setImageResource(a.f.sdk_icon_live_list_third);
                this.fRK.setVisibility(0);
            } else {
                this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.fRJ.setVisibility(0);
                this.fRK.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.fRJ.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.fRJ.setText("0" + i2);
        } else {
            this.fRJ.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.fRI != null && onClickListener != null) {
            this.fRI.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.fRO != null && onClickListener != null) {
            this.fRO.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.fRP != null && onClickListener != null) {
            this.fRP.setOnClickListener(onClickListener);
        }
    }
}
