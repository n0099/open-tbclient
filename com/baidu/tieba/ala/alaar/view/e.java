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
    private TbImageView gvX;
    public ImageView gwJ;
    private TextView gwL;
    public ImageView gwM;
    private FrameLayout gxa;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gvX = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gvX.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gvX.setIsRound(true);
        this.gvX.setAutoChangeStyle(false);
        this.gvX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvX.setDrawBorder(false);
        this.gwJ = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fjs = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gwL = (TextView) this.mRootView.findViewById(a.f.line);
        this.gxa = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gwM = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gwM.setVisibility(8);
    }

    public void a(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.fjs.setText(hVar.getName());
            FV(hVar.zw());
            if (com.baidu.live.d.xc().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.xc().getBoolean(hVar.getType(), true));
            }
        }
    }

    public void FV(String str) {
        this.gvX.startLoad(str, 10, false);
    }

    public void bQN() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwJ.setVisibility(4);
    }

    public void bQO() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gwJ.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gwM.setVisibility(0);
        } else {
            this.gwM.setVisibility(8);
        }
    }
}
