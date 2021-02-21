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
/* loaded from: classes11.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView gvY;
    public TextView gwG;
    public SimpleDraweeView gwI;
    public ImageView gwJ;
    public FrameLayout gwK;
    public TextView gwL;
    public ImageView gwM;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gwI = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gwM = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gwM.setVisibility(8);
        this.gwI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvY = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gvY.setVisibility(8);
        this.gwJ = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gwG = (TextView) inflate.findViewById(a.f.filter_text);
        this.gwK = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gwL = (TextView) inflate.findViewById(a.f.line);
        this.gwL.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gwG.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwJ.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gwG.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gwJ.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gwI.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gwI.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gwG.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gwM.setVisibility(0);
        } else {
            this.gwM.setVisibility(8);
        }
    }
}
