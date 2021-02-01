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
    public ImageView gvK;
    public TextView gws;
    public SimpleDraweeView gwu;
    public ImageView gwv;
    public FrameLayout gww;
    public TextView gwx;
    public ImageView gwy;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gwu = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gwy = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gwy.setVisibility(8);
        this.gwu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvK = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gvK.setVisibility(8);
        this.gwv = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gws = (TextView) inflate.findViewById(a.f.filter_text);
        this.gww = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gwx = (TextView) inflate.findViewById(a.f.line);
        this.gwx.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gws.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwv.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gws.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gwv.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gwu.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gwu.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gws.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gwy.setVisibility(0);
        } else {
            this.gwy.setVisibility(8);
        }
    }
}
