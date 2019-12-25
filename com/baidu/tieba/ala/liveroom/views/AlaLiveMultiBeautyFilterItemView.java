package com.baidu.tieba.ala.liveroom.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView fgk;
    private TextView fgl;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fgk = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fgk.setIsRound(true);
        this.fgk.setAutoChangeStyle(false);
        this.fgk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fgl = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fgk.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fgl.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fgl.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fgk.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fgk.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fgl.setText(str);
    }
}
