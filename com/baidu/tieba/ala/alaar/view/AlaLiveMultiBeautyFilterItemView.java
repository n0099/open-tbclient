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
/* loaded from: classes7.dex */
public class AlaLiveMultiBeautyFilterItemView extends LinearLayout {
    private HeadImageView fBP;
    private TextView fBQ;

    public AlaLiveMultiBeautyFilterItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.ala_live_beauty_filter_item_view, (ViewGroup) this, true);
        this.fBP = (HeadImageView) inflate.findViewById(a.g.item_icon);
        this.fBP.setIsRound(true);
        this.fBP.setAutoChangeStyle(false);
        this.fBP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fBQ = (TextView) inflate.findViewById(a.g.item_text);
    }

    public void setUnselectedBackground() {
        this.fBP.setBackgroundColor(getResources().getColor(a.d.sdk_black_alpha0));
        this.fBQ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_d));
    }

    public void setSelectedBackground() {
        this.fBQ.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fBP.setBackgroundDrawable(getResources().getDrawable(a.f.ala_live_effect_item_selected));
    }

    public void setItemIcon(int i) {
        this.fBP.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fBQ.setText(str);
    }
}
