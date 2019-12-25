package com.baidu.tieba.ala.charm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.LinearGradientTextView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes2.dex */
public class d {
    public ViewGroup erM;
    public TextView erN;
    public ImageView erO;
    public HeadImageView erP;
    public TextView erQ;
    public RelativeLayout erR;
    public LinearGradientTextView erS;
    public TextView erT;
    public ImageView erU;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.erN = (TextView) view.findViewById(a.g.tvGradeNum);
        this.erO = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.erM = (ViewGroup) view.findViewById(a.g.item_view);
        this.erP = (HeadImageView) view.findViewById(a.g.photo);
        this.erP.setIsRound(true);
        this.erP.setAutoChangeStyle(false);
        this.erP.setClickable(false);
        this.erR = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.erQ = (TextView) view.findViewById(a.g.ala_intro);
        this.erS = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.erT = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.erU = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.erS.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.erS.setVisibility(8);
                this.erM.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.erT.setVisibility(0);
                } else {
                    this.erT.setVisibility(8);
                }
            } else {
                this.erT.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.erS.setVisibility(8);
                } else {
                    this.erS.setVisibility(0);
                }
                this.erM.setBackgroundResource(a.f.sdk_list_item_selector_black);
                hU(aLaCharmData.follow_status != 0);
            }
            this.erM.setTag(Integer.valueOf(i));
            oI(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.erQ.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.erU != null) {
            this.erU.setVisibility(8);
            if (i == 0) {
                this.erU.setVisibility(0);
                this.erU.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.erU.setVisibility(0);
                this.erU.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.erU.setVisibility(0);
                this.erU.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.erU.setVisibility(8);
            }
        }
        k.a(this.erP, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void hU(boolean z) {
        if (z) {
            this.erS.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.erS.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.erS.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.erS.setBackgroundResource(a.f.charm_attention_s_bg);
            this.erS.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.erS.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.erS.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.erS.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.erS.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.erS.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.erS.setBackgroundResource(a.f.charm_attention_n_bg);
            this.erS.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void oI(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.erN.setVisibility(4);
                this.erO.setImageResource(a.f.sdk_icon_live_list_first);
                this.erO.setVisibility(0);
            } else if (i2 == 2) {
                this.erN.setVisibility(4);
                this.erO.setImageResource(a.f.sdk_icon_live_list_second);
                this.erO.setVisibility(0);
            } else if (i2 == 3) {
                this.erN.setVisibility(4);
                this.erO.setImageResource(a.f.sdk_icon_live_list_third);
                this.erO.setVisibility(0);
            } else {
                this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.erN.setVisibility(0);
                this.erO.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.erN.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.erN.setText("0" + i2);
        } else {
            this.erN.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.erM != null && onClickListener != null) {
            this.erM.setOnClickListener(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.erS != null && onClickListener != null) {
            this.erS.setOnClickListener(onClickListener);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.erT != null && onClickListener != null) {
            this.erT.setOnClickListener(onClickListener);
        }
    }
}
