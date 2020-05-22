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
    public ImageView eYX;
    public TextView eZS;
    public ImageView eZT;
    public ImageView eZU;
    public FrameLayout eZV;
    public TextView eZW;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.eZT = (ImageView) inflate.findViewById(a.g.filter_img);
        this.eZT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eYX = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.eYX.setVisibility(8);
        this.eZU = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.eZS = (TextView) inflate.findViewById(a.g.filter_text);
        this.eZV = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.eZW = (TextView) inflate.findViewById(a.g.line);
        this.eZW.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.eZS.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.eZU.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.eZS.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eZU.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.eZT.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eZS.setText(str);
    }
}
