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
    public ImageView fpm;
    public TextView fqq;
    public ImageView fqr;
    public ImageView fqs;
    public FrameLayout fqt;
    public TextView fqu;
    public ImageView fqv;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fqr = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fqv = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fqv.setVisibility(8);
        this.fqr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fpm = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fpm.setVisibility(8);
        this.fqs = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fqq = (TextView) inflate.findViewById(a.g.filter_text);
        this.fqt = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fqu = (TextView) inflate.findViewById(a.g.line);
        this.fqu.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fqq.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.fqs.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fqq.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fqs.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fqr.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fqq.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fqv.setVisibility(0);
        } else {
            this.fqv.setVisibility(8);
        }
    }
}
