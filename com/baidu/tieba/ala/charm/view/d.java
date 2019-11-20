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
    public ViewGroup dFJ;
    public TextView dFK;
    public ImageView dFL;
    public HeadImageView dFM;
    public TextView dFN;
    public RelativeLayout dFO;
    public LinearGradientTextView dFP;
    public TextView dFQ;
    public ImageView dFR;
    private int dFv;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.dFv = i;
        this.dFK = (TextView) view.findViewById(a.g.tvGradeNum);
        this.dFL = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.dFJ = (ViewGroup) view.findViewById(a.g.item_view);
        this.dFM = (HeadImageView) view.findViewById(a.g.photo);
        this.dFM.setIsRound(true);
        this.dFM.setAutoChangeStyle(false);
        this.dFM.setClickable(false);
        this.dFO = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.dFN = (TextView) view.findViewById(a.g.ala_intro);
        this.dFP = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.dFQ = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.dFR = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.dFP.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.dFP.setVisibility(8);
                this.dFJ.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.dFQ.setVisibility(0);
                } else {
                    this.dFQ.setVisibility(8);
                }
            } else {
                this.dFQ.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.dFP.setVisibility(8);
                } else {
                    this.dFP.setVisibility(0);
                }
                this.dFJ.setBackgroundResource(a.f.sdk_list_item_selector_black);
                gP(aLaCharmData.follow_status != 0);
            }
            this.dFJ.setTag(Integer.valueOf(i));
            mx(i);
            k(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.dFN.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void k(String str, int i, String str2) {
        if (this.dFR != null) {
            this.dFR.setVisibility(8);
            if (i == 0) {
                this.dFR.setVisibility(0);
                this.dFR.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.dFR.setVisibility(0);
                this.dFR.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.dFR.setVisibility(0);
                this.dFR.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.dFR.setVisibility(8);
            }
        }
        j.a(this.dFM, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void gP(boolean z) {
        if (z) {
            this.dFP.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            this.dFP.setBackgroundResource(a.f.charm_attention_s_bg);
            this.dFP.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.dFP.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        this.dFP.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.dFP.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
        } else {
            this.dFP.setBackgroundResource(a.f.charm_attention_n_bg);
        }
    }

    public void mx(int i) {
        int i2 = i + 1;
        if (this.dFv == 1) {
            if (i2 == 1) {
                this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.dFK.setVisibility(4);
                this.dFL.setImageResource(a.f.sdk_icon_live_list_first);
                this.dFL.setVisibility(0);
            } else if (i2 == 2) {
                this.dFK.setVisibility(4);
                this.dFL.setImageResource(a.f.sdk_icon_live_list_second);
                this.dFL.setVisibility(0);
            } else if (i2 == 3) {
                this.dFK.setVisibility(4);
                this.dFL.setImageResource(a.f.sdk_icon_live_list_third);
                this.dFL.setVisibility(0);
            } else {
                this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.dFK.setVisibility(0);
                this.dFL.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.dFK.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.dFK.setText("0" + i2);
        } else {
            this.dFK.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.dFJ != null && onClickListener != null) {
            this.dFJ.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.dFP != null && onClickListener != null) {
            this.dFP.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.dFQ != null && onClickListener != null) {
            this.dFQ.setOnClickListener(onClickListener);
        }
    }
}
