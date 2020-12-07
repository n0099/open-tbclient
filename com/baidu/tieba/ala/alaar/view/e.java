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
    public ImageView gnT;
    private TextView gnV;
    public ImageView gnW;
    private TbImageView gnh;
    private FrameLayout gok;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gnh = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gnh.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gnh.setIsRound(true);
        this.gnh.setAutoChangeStyle(false);
        this.gnh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnh.setDrawBorder(false);
        this.gnT = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fcb = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gnV = (TextView) this.mRootView.findViewById(a.f.line);
        this.gok = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gnW = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gnW.setVisibility(8);
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
        this.gnh.startLoad(str, 10, false);
    }

    public void bRu() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnT.setVisibility(4);
    }

    public void bRv() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gnT.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gnW.setVisibility(0);
        } else {
            this.gnW.setVisibility(8);
        }
    }
}
