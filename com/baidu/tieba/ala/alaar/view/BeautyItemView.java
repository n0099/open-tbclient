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
    public TextView gnQ;
    public SimpleDraweeView gnS;
    public ImageView gnT;
    public FrameLayout gnU;
    public TextView gnV;
    public ImageView gnW;
    public ImageView gni;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gnS = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gnW = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gnW.setVisibility(8);
        this.gnS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gni = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gni.setVisibility(8);
        this.gnT = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gnQ = (TextView) inflate.findViewById(a.f.filter_text);
        this.gnU = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gnV = (TextView) inflate.findViewById(a.f.line);
        this.gnV.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gnQ.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnT.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gnQ.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gnT.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gnS.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gnS.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gnQ.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gnW.setVisibility(0);
        } else {
            this.gnW.setVisibility(8);
        }
    }
}
