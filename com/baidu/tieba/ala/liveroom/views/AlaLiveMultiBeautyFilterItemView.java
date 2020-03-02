package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView fmq;
    private TextView fmr;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fmq = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fmq.setIsRound(true);
        this.fmq.setAutoChangeStyle(false);
        this.fmq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fmr = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fmq.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fmr.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fmr.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fmq.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fmq.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fmr.setText(str);
    }
}
