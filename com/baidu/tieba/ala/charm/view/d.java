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
    public HeadImageView gFA;
    public TextView gFB;
    public RelativeLayout gFC;
    public LinearGradientTextView gFD;
    public TextView gFE;
    public ImageView gFF;
    private int gFh;
    public ViewGroup gFx;
    public TextView gFy;
    public ImageView gFz;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gFh = i;
        this.gFy = (TextView) view.findViewById(a.f.tvGradeNum);
        this.gFz = (ImageView) view.findViewById(a.f.gradeNum_imageView);
        this.gFx = (ViewGroup) view.findViewById(a.f.item_view);
        this.gFA = (HeadImageView) view.findViewById(a.f.photo);
        this.gFA.setIsRound(true);
        this.gFA.setAutoChangeStyle(false);
        this.gFA.setClickable(false);
        this.gFC = (RelativeLayout) view.findViewById(a.f.info);
        this.mName = (TextView) view.findViewById(a.f.ala_name);
        this.gFB = (TextView) view.findViewById(a.f.ala_intro);
        this.gFD = (LinearGradientTextView) view.findViewById(a.f.attention_btn);
        this.gFE = (TextView) view.findViewById(a.f.improve_rink_btn);
        this.gFF = (ImageView) view.findViewById(a.f.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.gFD.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.gFD.setVisibility(8);
                this.gFx.setBackgroundResource(a.e.sdk_online_item_bg);
                if (i > 0) {
                    this.gFE.setVisibility(0);
                } else {
                    this.gFE.setVisibility(8);
                }
            } else {
                this.gFE.setVisibility(8);
                if (aLaCharmData.isPrivacy == 1) {
                    this.gFD.setVisibility(8);
                } else if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.gFD.setVisibility(8);
                } else {
                    this.gFD.setVisibility(0);
                }
                this.gFx.setBackgroundResource(a.e.sdk_list_item_selector_black);
                mu(aLaCharmData.follow_status != 0);
            }
            this.gFx.setTag(Integer.valueOf(i));
            vz(i);
            o(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.gFB.setText(this.mRootView.getContext().getResources().getString(a.h.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void o(String str, int i, String str2) {
        if (this.gFF != null) {
            this.gFF.setVisibility(8);
            if (i == 0) {
                this.gFF.setVisibility(0);
                this.gFF.setImageResource(a.e.pic_live_list_top1);
            } else if (i == 1) {
                this.gFF.setVisibility(0);
                this.gFF.setImageResource(a.e.pic_live_list_top2);
            } else if (i == 2) {
                this.gFF.setVisibility(0);
                this.gFF.setImageResource(a.e.pic_live_list_top3);
            } else {
                this.gFF.setVisibility(8);
            }
        }
        l.a(this.gFA, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void mu(boolean z) {
        if (z) {
            this.gFD.setText(this.mRootView.getContext().getString(a.h.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFD.setBackgroundResource(a.e.charm_attention_s_bg_bd);
                this.gFD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
                return;
            }
            this.gFD.setBackgroundResource(a.e.charm_attention_s_bg);
            this.gFD.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha20));
            return;
        }
        this.gFD.setText(this.mRootView.getContext().getString(a.h.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gFD.setBackgroundResource(a.e.sdk_person_follow_btn_bg_seletor);
            this.gFD.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gFD.setBackgroundResource(a.e.charm_attention_bg_bd_selector);
            this.gFD.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.c.sdk_white_alpha70));
        } else {
            this.gFD.setBackgroundResource(a.e.charm_attention_n_bg);
            this.gFD.setGradientColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.c.sdk_color_ff6619));
        }
    }

    public void vz(int i) {
        int i2 = i + 1;
        if (this.gFh == 1) {
            if (i2 == 1) {
                this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
                this.gFy.setVisibility(4);
                this.gFz.setImageResource(a.e.sdk_icon_live_list_first);
                this.gFz.setVisibility(0);
            } else if (i2 == 2) {
                this.gFy.setVisibility(4);
                this.gFz.setImageResource(a.e.sdk_icon_live_list_second);
                this.gFz.setVisibility(0);
            } else if (i2 == 3) {
                this.gFy.setVisibility(4);
                this.gFz.setImageResource(a.e.sdk_icon_live_list_third);
                this.gFz.setVisibility(0);
            } else {
                this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
                this.gFy.setVisibility(0);
                this.gFz.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_common_color_10265));
        } else {
            this.gFy.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.gFy.setText("0" + i2);
        } else {
            this.gFy.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.gFx != null && onClickListener != null) {
            this.gFx.setOnClickListener(onClickListener);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        if (this.gFD != null && onClickListener != null) {
            this.gFD.setOnClickListener(onClickListener);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        if (this.gFE != null && onClickListener != null) {
            this.gFE.setOnClickListener(onClickListener);
        }
    }
}
