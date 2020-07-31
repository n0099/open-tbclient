package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class d {
    private TextView eiX;
    private TbImageView fpl;
    private FrameLayout fqH;
    public ImageView fqs;
    private TextView fqu;
    public ImageView fqv;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fpl = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fpl.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fpl.setIsRound(true);
        this.fpl.setAutoChangeStyle(false);
        this.fpl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fpl.setDrawBorder(false);
        this.fqs = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.eiX = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.fqu = (TextView) this.mRootView.findViewById(a.g.line);
        this.fqH = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fqv = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fqv.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.eiX.setText(eVar.getName());
            Ce(eVar.vq());
            if (com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.vf().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void Ce(String str) {
        this.fpl.startLoad(str, 10, false);
    }

    public void bwo() {
        this.eiX.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fqs.setVisibility(4);
    }

    public void bwp() {
        this.eiX.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fqs.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fqv.setVisibility(0);
        } else {
            this.fqv.setVisibility(8);
        }
    }
}
