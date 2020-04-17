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
    public ImageView eMv;
    public TextView eNq;
    public ImageView eNr;
    public ImageView eNs;
    public FrameLayout eNt;
    public TextView eNu;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.eNr = (ImageView) inflate.findViewById(a.g.filter_img);
        this.eNr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eMv = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.eMv.setVisibility(8);
        this.eNs = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.eNq = (TextView) inflate.findViewById(a.g.filter_text);
        this.eNt = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.eNu = (TextView) inflate.findViewById(a.g.line);
        this.eNu.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.eNq.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.eNs.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.eNq.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.eNs.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.eNr.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.eNq.setText(str);
    }
}
