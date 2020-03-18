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
    private HeadImageView fnc;
    private TextView fnd;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fnc = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fnc.setIsRound(true);
        this.fnc.setAutoChangeStyle(false);
        this.fnc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fnd = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fnc.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fnd.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fnd.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fnc.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fnc.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fnd.setText(str);
    }
}
