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
    private int ggW;
    public ViewGroup ghm;
    public TextView ghn;
    public ImageView gho;
    public HeadImageView ghp;
    public TextView ghq;
    public RelativeLayout ghr;
    public LinearGradientTextView ghs;
    public TextView ght;
    public ImageView ghu;
    public TextView mName;
    public View mRootView;

    public d(View view, int i) {
        this.mRootView = view;
        this.ggW = i;
        this.ghn = (TextView) view.findViewById(a.g.tvGradeNum);
        this.gho = (ImageView) view.findViewById(a.g.gradeNum_imageView);
        this.ghm = (ViewGroup) view.findViewById(a.g.item_view);
        this.ghp = (HeadImageView) view.findViewById(a.g.photo);
        this.ghp.setIsRound(true);
        this.ghp.setAutoChangeStyle(false);
        this.ghp.setClickable(false);
        this.ghr = (RelativeLayout) view.findViewById(a.g.info);
        this.mName = (TextView) view.findViewById(a.g.ala_name);
        this.ghq = (TextView) view.findViewById(a.g.ala_intro);
        this.ghs = (LinearGradientTextView) view.findViewById(a.g.attention_btn);
        this.ght = (TextView) view.findViewById(a.g.improve_rink_btn);
        this.ghu = (ImageView) view.findViewById(a.g.photo_pendant);
    }

    public void a(int i, ALaCharmData aLaCharmData, int i2) {
        if (aLaCharmData != null) {
            this.ghs.setTag(Integer.valueOf(i));
            if (aLaCharmData.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                this.ghs.setVisibility(8);
                this.ghm.setBackgroundResource(a.f.sdk_online_item_bg);
                if (i > 0) {
                    this.ght.setVisibility(0);
                } else {
                    this.ght.setVisibility(8);
                }
            } else {
                this.ght.setVisibility(8);
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    this.ghs.setVisibility(8);
                } else {
                    this.ghs.setVisibility(0);
                }
                this.ghm.setBackgroundResource(a.f.sdk_list_item_selector_black);
                ly(aLaCharmData.follow_status != 0);
            }
            this.ghm.setTag(Integer.valueOf(i));
            tR(i);
            n(aLaCharmData.portrait, i, aLaCharmData.appId);
            this.mName.setText(aLaCharmData.user_name);
            this.ghq.setText(this.mRootView.getContext().getResources().getString(a.i.ala_pay_gift_name, aLaCharmData.total_price));
            onSkinTypeChanged(i2);
        }
    }

    private void n(String str, int i, String str2) {
        if (this.ghu != null) {
            this.ghu.setVisibility(8);
            if (i == 0) {
                this.ghu.setVisibility(0);
                this.ghu.setImageResource(a.f.pic_live_list_top1);
            } else if (i == 1) {
                this.ghu.setVisibility(0);
                this.ghu.setImageResource(a.f.pic_live_list_top2);
            } else if (i == 2) {
                this.ghu.setVisibility(0);
                this.ghu.setImageResource(a.f.pic_live_list_top3);
            } else {
                this.ghu.setVisibility(8);
            }
        }
        l.a(this.ghp, str, true, StringUtils.isNull(str2) ? false : true);
    }

    private void ly(boolean z) {
        if (z) {
            this.ghs.setText(this.mRootView.getContext().getString(a.i.ala_had_attention));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ghs.setBackgroundResource(a.f.charm_attention_s_bg_bd);
                this.ghs.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
                return;
            }
            this.ghs.setBackgroundResource(a.f.charm_attention_s_bg);
            this.ghs.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha20));
            return;
        }
        this.ghs.setText(this.mRootView.getContext().getString(a.i.ala_attention));
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ghs.setBackgroundResource(a.f.sdk_person_follow_btn_bg_seletor);
            this.ghs.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ghs.setBackgroundResource(a.f.charm_attention_bg_bd_selector);
            this.ghs.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70), this.mRootView.getContext().getResources().getColor(a.d.sdk_white_alpha70));
        } else {
            this.ghs.setBackgroundResource(a.f.charm_attention_n_bg);
            this.ghs.setGradientColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff1e66), this.mRootView.getContext().getResources().getColor(a.d.sdk_color_ff6619));
        }
    }

    public void tR(int i) {
        int i2 = i + 1;
        if (this.ggW == 1) {
            if (i2 == 1) {
                this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
                this.ghn.setVisibility(4);
                this.gho.setImageResource(a.f.sdk_icon_live_list_first);
                this.gho.setVisibility(0);
            } else if (i2 == 2) {
                this.ghn.setVisibility(4);
                this.gho.setImageResource(a.f.sdk_icon_live_list_second);
                this.gho.setVisibility(0);
            } else if (i2 == 3) {
                this.ghn.setVisibility(4);
                this.gho.setImageResource(a.f.sdk_icon_live_list_third);
                this.gho.setVisibility(0);
            } else {
                this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
                this.ghn.setVisibility(0);
                this.gho.setVisibility(8);
            }
        } else if (i2 == 1) {
            this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10261));
        } else if (i2 == 2) {
            this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10264));
        } else if (i2 == 3) {
            this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_common_color_10265));
        } else {
            this.ghn.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
        }
        if (i2 < 10) {
            this.ghn.setText("0" + i2);
        } else {
            this.ghn.setText(String.valueOf(i2));
        }
    }

    public void onSkinTypeChanged(int i) {
    }

    public void p(View.OnClickListener onClickListener) {
        if (this.ghm != null && onClickListener != null) {
            this.ghm.setOnClickListener(onClickListener);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.ghs != null && onClickListener != null) {
            this.ghs.setOnClickListener(onClickListener);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        if (this.ght != null && onClickListener != null) {
            this.ght.setOnClickListener(onClickListener);
        }
    }
}
