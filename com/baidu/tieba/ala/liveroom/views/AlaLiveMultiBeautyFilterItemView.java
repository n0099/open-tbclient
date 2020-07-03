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
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView flh;
    private TextView fli;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.flh = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.flh.setIsRound(true);
        this.flh.setAutoChangeStyle(false);
        this.flh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fli = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.flh.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fli.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fli.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.flh.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.flh.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fli.setText(str);
    }
}
