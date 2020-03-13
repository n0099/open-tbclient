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
    public TextView exA;
    public RelativeLayout exB;
    public LinearGradientTextView exC;
    public TextView exD;
    public ImageView exE;
    public ViewGroup exw;
    public TextView exx;
    public ImageView exy;
    public HeadImageView exz;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.exx = (TextView) view.findViewById(a.g.tvGradeNum);
        this.exy = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.exw = (ViewGroup) view.findViewById(a.g.item_view);
        this.exz = (HeadImageView) view.findViewById(a.g.photo);
        this.exz.setIsRound(true);
        this.exz.setAutoChangeStyle(false);
        this.exz.setClickable(false);
        this.exB = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.exA = (TextView) view.findViewById(a.g.ala_intro);
        this.exC = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.exD = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.exE = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.exC.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.exC.setVisibility(8);
                this.exw.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.exD.setVisibility(0);
                } else {
                    this.exD.setVisibility(8);
                }
            } else {
                this.exD.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.exC.setVisibility(8);
                } else {
                    this.exC.setVisibility(0);
                }
                this.exw.setBackgroundResource(a.f.sdk_list_item_selector_black);
                il(aLaCharmData.follow_status != 0);
            }
            this.exw.setTag(Integer.valueOf(i));
            pa(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.exA.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.exE != null) {
            this.exE.setVisibility(8);
            if (i == 0) {
                this.exE.setVisibility(0);
                this.exE.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.exE.setVisibility(0);
                this.exE.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.exE.setVisibility(0);
                this.exE.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.exE.setVisibility(8);
            }
        }
        k.a(this.exz, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void il(boolean z) {
        if (z) {
            this.exC.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.exC.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.exC.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.exC.setBackgroundResource(a.f.charm_attention_s_bg);
            this.exC.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.exC.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.exC.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.exC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.exC.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.exC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.exC.setBackgroundResource(a.f.charm_attention_n_bg);
            this.exC.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void pa(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.exx.setVisibility(4);
                this.exy.setImageResource(a.f.sdk_icon_live_list_first);
                this.exy.setVisibility(0);
            } else if (i2 == 2) {
                this.exx.setVisibility(4);
                this.exy.setImageResource(a.f.sdk_icon_live_list_second);
                this.exy.setVisibility(0);
            } else if (i2 == 3) {
                this.exx.setVisibility(4);
                this.exy.setImageResource(a.f.sdk_icon_live_list_third);
                this.exy.setVisibility(0);
            } else {
                this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.exx.setVisibility(0);
                this.exy.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.exx.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.exx.setText("0" + i2);
        } else {
            this.exx.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.exw != null && onClickListener != null) {
            this.exw.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.exC != null && onClickListener != null) {
            this.exC.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.exD != null && onClickListener != null) {
            this.exD.setOnClickListener(onClickListener);
        }
    }
}
