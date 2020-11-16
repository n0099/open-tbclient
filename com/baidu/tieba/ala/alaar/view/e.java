package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class e {
    private TextView eUF;
    private TbImageView geZ;
    public ImageView gfL;
    private TextView gfN;
    public ImageView gfO;
    private FrameLayout ggb;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.geZ = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.geZ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.geZ.setIsRound(true);
        this.geZ.setAutoChangeStyle(false);
        this.geZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.geZ.setDrawBorder(false);
        this.gfL = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.eUF = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gfN = (TextView) this.mRootView.findViewById(a.f.line);
        this.ggb = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gfO = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gfO.setVisibility(8);
    }

    public void a(com.baidu.live.ar.g gVar) {
        if (gVar != null) {
            this.eUF.setText(gVar.getName());
            FW(gVar.BK());
            if (com.baidu.live.d.Aq().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.Aq().getBoolean(gVar.getType(), true));
            }
        }
    }

    public void FW(String str) {
        this.geZ.startLoad(str, 10, false);
    }

    public void bNJ() {
        this.eUF.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gfL.setVisibility(4);
    }

    public void bNK() {
        this.eUF.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gfL.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gfO.setVisibility(0);
        } else {
            this.gfO.setVisibility(8);
        }
    }
}
