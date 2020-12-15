package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class e {
    private TextView fcb;
    public ImageView gnV;
    private TextView gnX;
    public ImageView gnY;
    private TbImageView gnj;
    private FrameLayout gom;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gnj = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gnj.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gnj.setIsRound(true);
        this.gnj.setAutoChangeStyle(false);
        this.gnj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnj.setDrawBorder(false);
        this.gnV = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fcb = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gnX = (TextView) this.mRootView.findViewById(a.f.line);
        this.gom = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gnY = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gnY.setVisibility(8);
    }

    public void a(com.baidu.live.ar.g gVar) {
        if (gVar != null) {
            this.fcb.setText(gVar.getName());
            GK(gVar.Du());
            if (com.baidu.live.d.BM().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.BM().getBoolean(gVar.getType(), true));
            }
        }
    }

    public void GK(String str) {
        this.gnj.startLoad(str, 10, false);
    }

    public void bRv() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnV.setVisibility(4);
    }

    public void bRw() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gnV.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gnY.setVisibility(0);
        } else {
            this.gnY.setVisibility(8);
        }
    }
}
