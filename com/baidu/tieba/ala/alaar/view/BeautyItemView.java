package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
/* loaded from: classes4.dex */
public class BeautyItemView extends LinearLayout {
    public TextView gnS;
    public SimpleDraweeView gnU;
    public ImageView gnV;
    public FrameLayout gnW;
    public TextView gnX;
    public ImageView gnY;
    public ImageView gnk;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gnU = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gnY = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gnY.setVisibility(8);
        this.gnU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnk = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gnk.setVisibility(8);
        this.gnV = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gnS = (TextView) inflate.findViewById(a.f.filter_text);
        this.gnW = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gnX = (TextView) inflate.findViewById(a.f.line);
        this.gnX.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gnS.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnV.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gnS.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gnV.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gnU.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gnU.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gnS.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gnY.setVisibility(0);
        } else {
            this.gnY.setVisibility(8);
        }
    }
}
