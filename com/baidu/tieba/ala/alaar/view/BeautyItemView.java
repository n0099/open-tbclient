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
/* loaded from: classes4.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView fQi;
    public TextView fRl;
    public ImageView fRm;
    public ImageView fRn;
    public FrameLayout fRo;
    public TextView fRp;
    public ImageView fRq;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fRm = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fRq = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fRq.setVisibility(8);
        this.fRm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fQi = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fQi.setVisibility(8);
        this.fRn = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fRl = (TextView) inflate.findViewById(a.g.filter_text);
        this.fRo = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fRp = (TextView) inflate.findViewById(a.g.line);
        this.fRp.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fRl.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.fRn.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fRl.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fRn.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fRm.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fRl.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fRq.setVisibility(0);
        } else {
            this.fRq.setVisibility(8);
        }
    }
}
