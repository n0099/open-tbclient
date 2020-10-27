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
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes4.dex */
public class BeautyItemView extends LinearLayout {
    public ImageView fZB;
    public TextView gak;
    public SimpleDraweeView gam;
    public ImageView gan;
    public FrameLayout gao;
    public TextView gaq;
    public ImageView gar;

    public BeautyItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.beauty_ar_item_layout, (ViewGroup) this, true);
        this.gam = (SimpleDraweeView) inflate.findViewById(a.g.filter_img);
        this.gar = (ImageView) inflate.findViewById(a.g.filter_redot);
        this.gar.setVisibility(8);
        this.gam.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZB = (ImageView) inflate.findViewById(a.g.filter_unload);
        this.fZB.setVisibility(8);
        this.gan = (ImageView) inflate.findViewById(a.g.filter_bg);
        this.gak = (TextView) inflate.findViewById(a.g.filter_text);
        this.gao = (FrameLayout) inflate.findViewById(a.g.fl_head);
        this.gaq = (TextView) inflate.findViewById(a.g.line);
        this.gaq.setVisibility(8);
    }

    public void setUnselectedBackground() {
        this.gak.setTextColor(getResources().getColor(a.d.sdk_cp_cont_i));
        this.gan.setVisibility(4);
    }

    public void setSelectedBackground() {
        this.gak.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
        this.gan.setVisibility(0);
    }

    public void setItemIcon(int i) {
        this.gam.setImageDrawable(getResources().getDrawable(i));
    }

    public void setItemIcon(String str) {
        this.gam.setImageURI(Uri.parse(str));
    }

    public void setItemText(String str) {
        this.gak.setText(str);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gar.setVisibility(0);
        } else {
            this.gar.setVisibility(8);
        }
    }
}
