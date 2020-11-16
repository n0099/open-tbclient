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
    public TextView gfI;
    public SimpleDraweeView gfK;
    public ImageView gfL;
    public FrameLayout gfM;
    public TextView gfN;
    public ImageView gfO;
    public ImageView gfa;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.g.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gfK = (SimpleDraweeView) inflate.findViewById(a.f.filter_img);
        this.gfO = (ImageView) inflate.findViewById(a.f.filter_redot);
        this.gfO.setVisibility(8);
        this.gfK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfa = (ImageView) inflate.findViewById(a.f.filter_unload);
        this.gfa.setVisibility(8);
        this.gfL = (ImageView) inflate.findViewById(a.f.filter_bg);
        this.gfI = (TextView) inflate.findViewById(a.f.filter_text);
        this.gfM = (FrameLayout) inflate.findViewById(a.f.fl_head);
        this.gfN = (TextView) inflate.findViewById(a.f.line);
        this.gfN.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gfI.setTextColor(getResources().getColor(a.c.sdk_cp_cont_i));
        this.gfL.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gfI.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
        this.gfL.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gfK.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gfK.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gfI.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gfO.setVisibility(0);
        } else {
            this.gfO.setVisibility(8);
        }
    }
}
