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
    private int gqZ;
    public ViewGroup grp;
    public TextView grq;
    public ImageView grr;
    public HeadImageView grs;
    public TextView grt;
    public RelativeLayout gru;
    public LinearGradientTextView grv;
    public TextView grw;
    public ImageView grx;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.gqZ = i;
        this.grq = (TextView) view.findViewById(a.g.tvGradeNum);
        this.grr = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.grp = (ViewGroup) view.findViewById(a.g.item_view);
        this.grs = (HeadImageView) view.findViewById(a.g.photo);
        this.grs.setIsRound(true);
        this.grs.setAutoChangeStyle(false);
        this.grs.setClickable(false);
        this.gru = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.grt = (TextView) view.findViewById(a.g.ala_intro);
        this.grv = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.grw = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.grx = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.grv.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.grv.setVisibility(8);
                this.grp.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.grw.setVisibility(0);
                } else {
                    this.grw.setVisibility(8);
                }
            } else {
                this.grw.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.grv.setVisibility(8);
                } else {
                    this.grv.setVisibility(0);
                }
                this.grp.setBackgroundResource(a.f.sdk_list_item_selector_black);
                lP(aLaCharmData.follow_status != 0);
            }
            this.grp.setTag(Integer.valueOf(i));
            uk(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.grt.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.grx != null) {
            this.grx.setVisibility(8);
            if (i == 0) {
                this.grx.setVisibility(0);
                this.grx.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.grx.setVisibility(0);
                this.grx.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.grx.setVisibility(0);
                this.grx.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.grx.setVisibility(8);
            }
        }
        l.a(this.grs, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void lP(boolean z) {
        if (z) {
            this.grv.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.grv.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.grv.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.grv.setBackgroundResource(a.f.charm_attention_s_bg);
            this.grv.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.grv.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.grv.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.grv.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.grv.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.grv.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.grv.setBackgroundResource(a.f.charm_attention_n_bg);
            this.grv.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void uk(int i) {
        int i2 = i + 1;
        if (this.gqZ == 1) {
            if (i2 == 1) {
                this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.grq.setVisibility(4);
                this.grr.setImageResource(a.f.sdk_icon_live_list_first);
                this.grr.setVisibility(0);
            } else if (i2 == 2) {
                this.grq.setVisibility(4);
                this.grr.setImageResource(a.f.sdk_icon_live_list_second);
                this.grr.setVisibility(0);
            } else if (i2 == 3) {
                this.grq.setVisibility(4);
                this.grr.setImageResource(a.f.sdk_icon_live_list_third);
                this.grr.setVisibility(0);
            } else {
                this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.grq.setVisibility(0);
                this.grr.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.grq.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.grq.setText("0" + i2);
        } else {
            this.grq.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.grp != null && onClickListener != null) {
            this.grp.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.grv != null && onClickListener != null) {
            this.grv.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.grw != null && onClickListener != null) {
            this.grw.setOnClickListener(onClickListener);
        }
    }
}
