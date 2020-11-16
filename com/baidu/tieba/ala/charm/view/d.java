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
    public ViewGroup gwK;
    public TextView gwL;
    public ImageView gwM;
    public HeadImageView gwN;
    public TextView gwO;
    public RelativeLayout gwP;
    public LinearGradientTextView gwQ;
    public TextView gwR;
    public ImageView gwS;
    private int gwu;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gwu = i;
        this.gwL = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gwM = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gwK = (ViewGroup) view.findViewById(a.f.item_view);
        this.gwN = (HeadImageView) view.findViewById(a.f.photo);
        this.gwN.setIsRound(true);
        this.gwN.setAutoChangeStyle(false);
        this.gwN.setClickable(false);
        this.gwP = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gwO = (TextView) view.findViewById(a.f.ala_intro);
        this.gwQ = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gwR = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gwS = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gwQ.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gwQ.setVisibility(8);
                this.gwK.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gwR.setVisibility(0);
                } else {
                    this.gwR.setVisibility(8);
                }
            } else {
                this.gwR.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gwQ.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gwQ.setVisibility(8);
                } else {
                    this.gwQ.setVisibility(0);
                }
                this.gwK.setBackgroundResource(a.e.sdk_list_item_selector_black);
                lZ(aLaCharmData.follow_status != 0);
            }
            this.gwK.setTag(Integer.valueOf(i));
            uS(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gwO.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.gwS != null) {
            this.gwS.setVisibility(8);
            if (i == 0) {
                this.gwS.setVisibility(0);
                this.gwS.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gwS.setVisibility(0);
                this.gwS.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gwS.setVisibility(0);
                this.gwS.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gwS.setVisibility(8);
            }
        }
        l.a(this.gwN, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void lZ(boolean z) {
        if (z) {
            this.gwQ.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gwQ.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gwQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gwQ.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gwQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gwQ.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gwQ.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gwQ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gwQ.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gwQ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gwQ.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gwQ.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void uS(int i) {
        int i2 = i + 1;
        if (this.gwu == 1) {
            if (i2 == 1) {
                this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gwL.setVisibility(4);
                this.gwM.setImageResource(a.e.sdk_icon_live_list_first);
                this.gwM.setVisibility(0);
            } else if (i2 == 2) {
                this.gwL.setVisibility(4);
                this.gwM.setImageResource(a.e.sdk_icon_live_list_second);
                this.gwM.setVisibility(0);
            } else if (i2 == 3) {
                this.gwL.setVisibility(4);
                this.gwM.setImageResource(a.e.sdk_icon_live_list_third);
                this.gwM.setVisibility(0);
            } else {
                this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gwL.setVisibility(0);
                this.gwM.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gwL.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gwL.setText("0" + i2);
        } else {
            this.gwL.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.gwK != null && onClickListener != null) {
            this.gwK.setOnClickListener(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.gwQ != null && onClickListener != null) {
            this.gwQ.setOnClickListener(onClickListener);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gwR != null && onClickListener != null) {
            this.gwR.setOnClickListener(onClickListener);
        }
    }
}
