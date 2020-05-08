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
    private HeadImageView eNu;
    private TextView eNv;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.eNu = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.eNu.setIsRound(true);
        this.eNu.setAutoChangeStyle(false);
        this.eNu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eNv = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.eNu.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.eNv.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.eNv.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eNu.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.eNu.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eNv.setText(str);
    }
}
