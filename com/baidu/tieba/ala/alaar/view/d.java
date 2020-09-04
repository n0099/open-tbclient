package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class d {
    private TextView esU;
    private TbImageView fAM;
    public ImageView fBS;
    private TextView fBU;
    public ImageView fBV;
    private FrameLayout fCh;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fAM = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fAM.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fAM.setIsRound(true);
        this.fAM.setAutoChangeStyle(false);
        this.fAM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAM.setDrawBorder(false);
        this.fBS = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.esU = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.fBU = (TextView) this.mRootView.findViewById(a.g.line);
        this.fCh = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fBV = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fBV.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.esU.setText(eVar.getName());
            Ez(eVar.AO());
            if (com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.AD().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void Ez(String str) {
        this.fAM.startLoad(str, 10, false);
    }

    public void bFo() {
        this.esU.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBS.setVisibility(4);
    }

    public void bFp() {
        this.esU.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fBS.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fBV.setVisibility(0);
        } else {
            this.fBV.setVisibility(8);
        }
    }
}
