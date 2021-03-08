package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView gyo;
    private TextView gyp;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.gyo = (HeadImageView) inflate.findViewById(a.f.item_icon);
        this.gyo.setIsRound(true);
        this.gyo.setAutoChangeStyle(false);
        this.gyo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gyp = (TextView) inflate.findViewById(a.f.item_text);
    }

    public void setUnselectedBackground() {
        this.gyo.setBackgroundColor(getResources().getColor(a.c.sdk_black_alpha0));
        this.gyp.setTextColor(getResources().getColor(a.c.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.gyp.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gyo.setBackgroundDrawable(getResources().getDrawable(a.e.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.gyo.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.gyp.setText(str);
    }
}
