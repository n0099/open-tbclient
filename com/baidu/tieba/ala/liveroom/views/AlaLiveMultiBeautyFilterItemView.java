package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView epQ;
    private TextView epR;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.epQ = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.epQ.setIsRound(true);
        this.epQ.setAutoChangeStyle(false);
        this.epQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.epR = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.epQ.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.epR.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.epR.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.epQ.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.epQ.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.epR.setText(str);
    }
}
