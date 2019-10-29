package com.baidu.tieba.ala.charm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.LinearGradientTextView;
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes6.dex */
public class d {
    public ViewGroup dGA;
    public TextView dGB;
    public ImageView dGC;
    public HeadImageView dGD;
    public TextView dGE;
    public RelativeLayout dGF;
    public LinearGradientTextView dGG;
    public TextView dGH;
    public ImageView dGI;
    private int dGm;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.dGm = i;
        this.dGB = (TextView) view.findViewById(a.g.tvGradeNum);
        this.dGC = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.dGA = (ViewGroup) view.findViewById(a.g.item_view);
        this.dGD = (HeadImageView) view.findViewById(a.g.photo);
        this.dGD.setIsRound(true);
        this.dGD.setAutoChangeStyle(false);
        this.dGD.setClickable(false);
        this.dGF = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.dGE = (TextView) view.findViewById(a.g.ala_intro);
        this.dGG = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.dGH = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.dGI = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.dGG.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.dGG.setVisibility(8);
                this.dGA.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.dGH.setVisibility(0);
                } else {
                    this.dGH.setVisibility(8);
                }
            } else {
                this.dGH.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.dGG.setVisibility(8);
                } else {
                    this.dGG.setVisibility(0);
                }
                this.dGA.setBackgroundResource(a.f.sdk_list_item_selector_black);
                gP(aLaCharmData.follow_status != 0);
            }
            this.dGA.setTag(Integer.valueOf(i));
            my(i);
            k(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.dGE.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void k(String str, int i, String str2) {
        if (this.dGI != null) {
            this.dGI.setVisibility(8);
            if (i == 0) {
                this.dGI.setVisibility(0);
                this.dGI.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.dGI.setVisibility(0);
                this.dGI.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.dGI.setVisibility(0);
                this.dGI.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.dGI.setVisibility(8);
            }
        }
        j.a(this.dGD, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void gP(boolean z) {
        if (z) {
            this.dGG.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            this.dGG.setBackgroundResource(a.f.charm_attention_s_bg);
            this.dGG.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.dGG.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        this.dGG.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.dGG.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
        } else {
            this.dGG.setBackgroundResource(a.f.charm_attention_n_bg);
        }
    }

    public void my(int i) {
        int i2 = i + 1;
        if (this.dGm == 1) {
            if (i2 == 1) {
                this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.dGB.setVisibility(4);
                this.dGC.setImageResource(a.f.sdk_icon_live_list_first);
                this.dGC.setVisibility(0);
            } else if (i2 == 2) {
                this.dGB.setVisibility(4);
                this.dGC.setImageResource(a.f.sdk_icon_live_list_second);
                this.dGC.setVisibility(0);
            } else if (i2 == 3) {
                this.dGB.setVisibility(4);
                this.dGC.setImageResource(a.f.sdk_icon_live_list_third);
                this.dGC.setVisibility(0);
            } else {
                this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.dGB.setVisibility(0);
                this.dGC.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.dGB.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.dGB.setText("0" + i2);
        } else {
            this.dGB.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.dGA != null && onClickListener != null) {
            this.dGA.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.dGG != null && onClickListener != null) {
            this.dGG.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.dGH != null && onClickListener != null) {
            this.dGH.setOnClickListener(onClickListener);
        }
    }
}
