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
    public ImageView fDZ;
    public TextView fFc;
    public ImageView fFd;
    public ImageView fFe;
    public FrameLayout fFf;
    public TextView fFg;
    public ImageView fFh;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fFd = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fFh = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fFh.setVisibility(8);
        this.fFd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fDZ = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fDZ.setVisibility(8);
        this.fFe = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fFc = (TextView) inflate.findViewById(a.g.filter_text);
        this.fFf = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fFg = (TextView) inflate.findViewById(a.g.line);
        this.fFg.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fFc.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.fFe.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fFc.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fFe.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fFd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fFc.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fFh.setVisibility(0);
        } else {
            this.fFh.setVisibility(8);
        }
    }
}
