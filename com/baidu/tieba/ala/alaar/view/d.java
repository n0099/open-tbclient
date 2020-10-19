package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class d {
    private TextView eHj;
    private TbImageView fQh;
    private FrameLayout fRC;
    public ImageView fRn;
    private TextView fRp;
    public ImageView fRq;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fQh = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fQh.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fQh.setIsRound(true);
        this.fQh.setAutoChangeStyle(false);
        this.fQh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fQh.setDrawBorder(false);
        this.fRn = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.eHj = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.fRp = (TextView) this.mRootView.findViewById(a.g.line);
        this.fRC = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fRq = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fRq.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.eHj.setText(eVar.getName());
            FI(eVar.Ca());
            if (com.baidu.live.c.AZ().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.AZ().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void FI(String str) {
        this.fQh.startLoad(str, 10, false);
    }

    public void bJq() {
        this.eHj.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fRn.setVisibility(4);
    }

    public void bJr() {
        this.eHj.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fRn.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fRq.setVisibility(0);
        } else {
            this.fRq.setVisibility(8);
        }
    }
}
