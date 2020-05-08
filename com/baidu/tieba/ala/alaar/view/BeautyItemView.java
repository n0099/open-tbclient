package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView eMA;
    public TextView eNv;
    public ImageView eNw;
    public ImageView eNx;
    public FrameLayout eNy;
    public TextView eNz;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.eNw = (ImageView) inflate.findViewById(a.g.filter_img);
        this.eNw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eMA = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.eMA.setVisibility(8);
        this.eNx = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.eNv = (TextView) inflate.findViewById(a.g.filter_text);
        this.eNy = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.eNz = (TextView) inflate.findViewById(a.g.line);
        this.eNz.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.eNv.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.eNx.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.eNv.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eNx.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.eNw.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eNv.setText(str);
    }
}
