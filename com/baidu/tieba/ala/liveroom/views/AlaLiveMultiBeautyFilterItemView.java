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
    private HeadImageView eZR;
    private TextView eZS;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.eZR = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.eZR.setIsRound(true);
        this.eZR.setAutoChangeStyle(false);
        this.eZR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZS = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.eZR.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.eZS.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.eZS.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eZR.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.eZR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eZS.setText(str);
    }
}
