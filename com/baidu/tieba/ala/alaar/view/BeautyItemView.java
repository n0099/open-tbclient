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
/* loaded from: classes10.dex */
public class BeautyItemView extends LinearLayout {
    public TextView gtI;
    public SimpleDraweeView gtK;
    public ImageView gtL;
    public FrameLayout gtM;
    public TextView gtN;
    public ImageView gtO;
    public ImageView gta;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gtK = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gtO = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gtO.setVisibility(8);
        this.gtK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gta = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gta.setVisibility(8);
        this.gtL = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gtI = (TextView) inflate.findViewById(a.f.filter_text);
        this.gtM = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gtN = (TextView) inflate.findViewById(a.f.line);
        this.gtN.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gtI.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gtL.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gtI.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gtL.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gtK.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gtK.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gtI.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gtO.setVisibility(0);
        } else {
            this.gtO.setVisibility(8);
        }
    }
}
