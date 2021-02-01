package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class e {
    private TextView fjs;
    private TbImageView gvJ;
    private FrameLayout gwM;
    public ImageView gwv;
    private TextView gwx;
    public ImageView gwy;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gvJ = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gvJ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gvJ.setIsRound(true);
        this.gvJ.setAutoChangeStyle(false);
        this.gvJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvJ.setDrawBorder(false);
        this.gwv = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fjs = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gwx = (TextView) this.mRootView.findViewById(a.f.line);
        this.gwM = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gwy = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gwy.setVisibility(8);
    }

    public void a(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.fjs.setText(hVar.getName());
            FU(hVar.zw());
            if (com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.xc().getBoolean(hVar.getType(), true));
            }
        }
    }

    public void FU(String str) {
        this.gvJ.startLoad(str, 10, false);
    }

    public void bQG() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwv.setVisibility(4);
    }

    public void bQH() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gwv.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gwy.setVisibility(0);
        } else {
            this.gwy.setVisibility(8);
        }
    }
}
