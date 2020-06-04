package com.baidu.tieba.ala.alaar.view;

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
    private HeadImageView fac;
    private TextView fad;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fac = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fac.setIsRound(true);
        this.fac.setAutoChangeStyle(false);
        this.fac.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fad = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fac.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fad.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fad.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fac.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fac.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fad.setText(str);
    }
}
