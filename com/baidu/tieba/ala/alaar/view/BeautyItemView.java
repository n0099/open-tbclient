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
    public ImageView eZi;
    public TextView fad;
    public ImageView fae;
    public ImageView faf;
    public FrameLayout fag;
    public TextView fah;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fae = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fae.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZi = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.eZi.setVisibility(8);
        this.faf = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fad = (TextView) inflate.findViewById(a.g.filter_text);
        this.fag = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fah = (TextView) inflate.findViewById(a.g.line);
        this.fah.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fad.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.faf.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fad.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.faf.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fae.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fad.setText(str);
    }
}
