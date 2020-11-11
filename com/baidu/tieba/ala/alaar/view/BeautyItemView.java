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
/* loaded from: classes4.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView gft;
    public TextView ggb;
    public SimpleDraweeView ggd;
    public ImageView gge;
    public FrameLayout ggf;
    public TextView ggg;
    public ImageView ggh;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.ggd = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.ggh = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.ggh.setVisibility(8);
        this.ggd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gft = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gft.setVisibility(8);
        this.gge = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.ggb = (TextView) inflate.findViewById(a.f.filter_text);
        this.ggf = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.ggg = (TextView) inflate.findViewById(a.f.line);
        this.ggg.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.ggb.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gge.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.ggb.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gge.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.ggd.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.ggd.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.ggb.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.ggh.setVisibility(0);
        } else {
            this.ggh.setVisibility(8);
        }
    }
}
