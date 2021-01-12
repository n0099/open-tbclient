package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class e {
    private TextView fgZ;
    private TbImageView gsZ;
    public ImageView gtL;
    private TextView gtN;
    public ImageView gtO;
    private FrameLayout guc;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gsZ = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gsZ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gsZ.setIsRound(true);
        this.gsZ.setAutoChangeStyle(false);
        this.gsZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsZ.setDrawBorder(false);
        this.gtL = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fgZ = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gtN = (TextView) this.mRootView.findViewById(a.f.line);
        this.guc = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gtO = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gtO.setVisibility(8);
    }

    public void a(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.fgZ.setText(hVar.getName());
            Fw(hVar.yP());
            if (com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.xf().getBoolean(hVar.getType(), true));
            }
        }
    }

    public void Fw(String str) {
        this.gsZ.startLoad(str, 10, false);
    }

    public void bQc() {
        this.fgZ.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gtL.setVisibility(4);
    }

    public void bQd() {
        this.fgZ.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gtL.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gtO.setVisibility(0);
        } else {
            this.gtO.setVisibility(8);
        }
    }
}
