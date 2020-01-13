package com.baidu.tieba.ala.charm.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.LinearGradientTextView;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
/* loaded from: classes2.dex */
public class d {
    public ViewGroup esX;
    public TextView esY;
    public ImageView esZ;
    public HeadImageView eta;
    public TextView etb;
    public RelativeLayout etd;
    public LinearGradientTextView ete;
    public TextView etf;
    public ImageView etg;
    private int mFromType;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.mFromType = i;
        this.esY = (TextView) view.findViewById(a.g.tvGradeNum);
        this.esZ = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.esX = (ViewGroup) view.findViewById(a.g.item_view);
        this.eta = (HeadImageView) view.findViewById(a.g.photo);
        this.eta.setIsRound(true);
        this.eta.setAutoChangeStyle(false);
        this.eta.setClickable(false);
        this.etd = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.etb = (TextView) view.findViewById(a.g.ala_intro);
        this.ete = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.etf = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.etg = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.ete.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ete.setVisibility(8);
                this.esX.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.etf.setVisibility(0);
                } else {
                    this.etf.setVisibility(8);
                }
            } else {
                this.etf.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ete.setVisibility(8);
                } else {
                    this.ete.setVisibility(0);
                }
                this.esX.setBackgroundResource(a.f.sdk_list_item_selector_black);
                ie(aLaCharmData.follow_status != 0);
            }
            this.esX.setTag(Integer.valueOf(i));
            oJ(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.etb.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.etg != null) {
            this.etg.setVisibility(8);
            if (i == 0) {
                this.etg.setVisibility(0);
                this.etg.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.etg.setVisibility(0);
                this.etg.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.etg.setVisibility(0);
                this.etg.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.etg.setVisibility(8);
            }
        }
        k.a(this.eta, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void ie(boolean z) {
        if (z) {
            this.ete.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ete.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.ete.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.ete.setBackgroundResource(a.f.charm_attention_s_bg);
            this.ete.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.ete.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ete.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.ete.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ete.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.ete.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.ete.setBackgroundResource(a.f.charm_attention_n_bg);
            this.ete.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void oJ(int i) {
        int i2 = i + 1;
        if (this.mFromType == 1) {
            if (i2 == 1) {
                this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.esY.setVisibility(4);
                this.esZ.setImageResource(a.f.sdk_icon_live_list_first);
                this.esZ.setVisibility(0);
            } else if (i2 == 2) {
                this.esY.setVisibility(4);
                this.esZ.setImageResource(a.f.sdk_icon_live_list_second);
                this.esZ.setVisibility(0);
            } else if (i2 == 3) {
                this.esY.setVisibility(4);
                this.esZ.setImageResource(a.f.sdk_icon_live_list_third);
                this.esZ.setVisibility(0);
            } else {
                this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.esY.setVisibility(0);
                this.esZ.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.esY.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.esY.setText("0" + i2);
        } else {
            this.esY.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.esX != null && onClickListener != null) {
            this.esX.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.ete != null && onClickListener != null) {
            this.ete.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.etf != null && onClickListener != null) {
            this.etf.setOnClickListener(onClickListener);
        }
    }
}
