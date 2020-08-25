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
    public ImageView fAJ;
    public TextView fBM;
    public ImageView fBN;
    public ImageView fBO;
    public FrameLayout fBP;
    public TextView fBQ;
    public ImageView fBR;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.fBN = (ImageView) inflate.findViewById(a.g.filter_img);
        this.fBR = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.fBR.setVisibility(8);
        this.fBN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAJ = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fAJ.setVisibility(8);
        this.fBO = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.fBM = (TextView) inflate.findViewById(a.g.filter_text);
        this.fBP = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.fBQ = (TextView) inflate.findViewById(a.g.line);
        this.fBQ.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.fBM.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBO.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.fBM.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.fBO.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.fBN.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemText(String str) {
        this.fBM.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fBR.setVisibility(0);
        } else {
            this.fBR.setVisibility(8);
        }
    }
}
