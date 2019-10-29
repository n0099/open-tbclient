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
    private HeadImageView eqH;
    private TextView eqI;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.eqH = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.eqH.setIsRound(true);
        this.eqH.setAutoChangeStyle(false);
        this.eqH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqI = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.eqH.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.eqI.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.eqI.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eqH.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.eqH.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eqI.setText(str);
    }
}
