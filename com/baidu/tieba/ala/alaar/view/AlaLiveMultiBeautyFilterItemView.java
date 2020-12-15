package com.baidu.tieba.ala.alaar.view;

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
    private HeadImageView gnR;
    private TextView gnS;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.gnR = (HeadImageView) inflate.findViewById(a.f.item_icon);
        this.gnR.setIsRound(true);
        this.gnR.setAutoChangeStyle(false);
        this.gnR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnS = (TextView) inflate.findViewById(a.f.item_text);
    }

    public void setUnselectedBackground() {
        this.gnR.setBackgroundColor(getResources().getColor(a.c.sdk_black_alpha0));
        this.gnS.setTextColor(getResources().getColor(a.c.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.gnS.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gnR.setBackgroundDrawable(getResources().getDrawable(a.e.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.gnR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.gnS.setText(str);
    }
}
