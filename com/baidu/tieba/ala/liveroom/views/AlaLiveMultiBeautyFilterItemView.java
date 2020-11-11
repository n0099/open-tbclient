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
/* loaded from: classes4.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView gga;
    private TextView ggb;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.gga = (HeadImageView) inflate.findViewById(a.f.item_icon);
        this.gga.setIsRound(true);
        this.gga.setAutoChangeStyle(false);
        this.gga.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ggb = (TextView) inflate.findViewById(a.f.item_text);
    }

    public void setUnselectedBackground() {
        this.gga.setBackgroundColor(getResources().getColor(a.c.sdk_black_alpha0));
        this.ggb.setTextColor(getResources().getColor(a.c.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.ggb.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gga.setBackgroundDrawable(getResources().getDrawable(a.e.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.gga.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.ggb.setText(str);
    }
}
