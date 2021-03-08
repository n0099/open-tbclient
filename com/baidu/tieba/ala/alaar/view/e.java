package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class e {
    private TextView fkR;
    private TbImageView gxG;
    private FrameLayout gyJ;
    public ImageView gys;
    private TextView gyu;
    public ImageView gyv;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.gxG = (TbImageView) this.mRootView.findViewById(a.f.face_img);
        this.gxG.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gxG.setIsRound(true);
        this.gxG.setAutoChangeStyle(false);
        this.gxG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gxG.setDrawBorder(false);
        this.gys = (ImageView) this.mRootView.findViewById(a.f.face_bg);
        this.fkR = (TextView) this.mRootView.findViewById(a.f.face_text);
        this.gyu = (TextView) this.mRootView.findViewById(a.f.line);
        this.gyJ = (FrameLayout) this.mRootView.findViewById(a.f.fl_head);
        this.gyv = (ImageView) this.mRootView.findViewById(a.f.face_redot);
        this.gyv.setVisibility(8);
    }

    public void a(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.fkR.setText(hVar.getName());
            Ge(hVar.zz());
            if (com.baidu.live.d.xf().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.xf().getBoolean(hVar.getType(), true));
            }
        }
    }

    public void Ge(String str) {
        this.gxG.startLoad(str, 10, false);
    }

    public void bQT() {
        this.fkR.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gys.setVisibility(4);
    }

    public void bQU() {
        this.fkR.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gys.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gyv.setVisibility(0);
        } else {
            this.gyv.setVisibility(8);
        }
    }
}
