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
/* loaded from: classes3.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView fkf;
    public TextView fli;
    public ImageView flj;
    public ImageView flk;
    public FrameLayout fll;
    public TextView flm;
    public ImageView fln;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.flj = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fln = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fln.setVisibility(8);
        this.flj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fkf = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fkf.setVisibility(8);
        this.flk = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fli = (TextView) inflate.findViewById(a.g.filter_text);
        this.fll = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.flm = (TextView) inflate.findViewById(a.g.line);
        this.flm.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fli.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.flk.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fli.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.flk.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.flj.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fli.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fln.setVisibility(0);
        } else {
            this.fln.setVisibility(8);
        }
    }
}
