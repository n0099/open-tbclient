package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView fAN;
    public TextView fBQ;
    public ImageView fBR;
    public ImageView fBS;
    public FrameLayout fBT;
    public TextView fBU;
    public ImageView fBV;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fBR = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fBV = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fBV.setVisibility(8);
        this.fBR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAN = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fAN.setVisibility(8);
        this.fBS = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fBQ = (TextView) inflate.findViewById(a.g.filter_text);
        this.fBT = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fBU = (TextView) inflate.findViewById(a.g.line);
        this.fBU.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fBQ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBS.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fBQ.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fBS.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fBR.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fBQ.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fBV.setVisibility(0);
        } else {
            this.fBV.setVisibility(8);
        }
    }
}
