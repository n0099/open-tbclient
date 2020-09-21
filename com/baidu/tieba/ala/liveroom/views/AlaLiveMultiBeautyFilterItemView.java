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
    private HeadImageView fFb;
    private TextView fFc;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fFb = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fFb.setIsRound(true);
        this.fFb.setAutoChangeStyle(false);
        this.fFb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fFc = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fFb.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fFc.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fFc.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fFb.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fFb.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fFc.setText(str);
    }
}
