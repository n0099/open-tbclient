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
    public ImageView gxH;
    public TextView gyp;
    public SimpleDraweeView gyr;
    public ImageView gys;
    public FrameLayout gyt;
    public TextView gyu;
    public ImageView gyv;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gyr = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gyv = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gyv.setVisibility(8);
        this.gyr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gxH = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gxH.setVisibility(8);
        this.gys = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gyp = (TextView) inflate.findViewById(a.f.filter_text);
        this.gyt = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gyu = (TextView) inflate.findViewById(a.f.line);
        this.gyu.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gyp.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gys.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gyp.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gys.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gyr.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gyr.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gyp.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gyv.setVisibility(0);
        } else {
            this.gyv.setVisibility(8);
        }
    }
}
