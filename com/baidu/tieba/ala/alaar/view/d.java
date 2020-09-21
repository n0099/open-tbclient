package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class d {
    private TextView euZ;
    private TbImageView fDY;
    public ImageView fFe;
    private TextView fFg;
    public ImageView fFh;
    private FrameLayout fFt;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fDY = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fDY.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fDY.setIsRound(true);
        this.fDY.setAutoChangeStyle(false);
        this.fDY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fDY.setDrawBorder(false);
        this.fFe = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.euZ = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.fFg = (TextView) this.mRootView.findViewById(a.g.line);
        this.fFt = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fFh = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fFh.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.euZ.setText(eVar.getName());
            EX(eVar.Bd());
            if (com.baidu.live.c.AR().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.AR().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void EX(String str) {
        this.fDY.startLoad(str, 10, false);
    }

    public void bGE() {
        this.euZ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fFe.setVisibility(4);
    }

    public void bGF() {
        this.euZ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fFe.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fFh.setVisibility(0);
        } else {
            this.fFh.setVisibility(8);
        }
    }
}
