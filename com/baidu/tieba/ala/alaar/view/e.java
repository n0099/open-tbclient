package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class e {
    private TextView eVu;
    private TbImageView gfs;
    public ImageView gge;
    private TextView ggg;
    public ImageView ggh;
    private FrameLayout ggu;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gfs = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gfs.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gfs.setIsRound(true);
        this.gfs.setAutoChangeStyle(false);
        this.gfs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfs.setDrawBorder(false);
        this.gge = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.eVu = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.ggg = (TextView) this.mRootView.findViewById(a.f.line);
        this.ggu = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.ggh = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.ggh.setVisibility(8);
    }

    public void a(com.baidu.live.ar.g gVar) {
        if (gVar != null) {
            this.eVu.setText(gVar.getName());
            Gv(gVar.Ct());
            if (com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.AZ().getBoolean(gVar.getType(), true));
            }
        }
    }

    public void Gv(String str) {
        this.gfs.startLoad(str, 10, false);
    }

    public void bOq() {
        this.eVu.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gge.setVisibility(4);
    }

    public void bOr() {
        this.eVu.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gge.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.ggh.setVisibility(0);
        } else {
            this.ggh.setVisibility(8);
        }
    }
}
