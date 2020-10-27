package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class e {
    private TextView ePF;
    private TbImageView fZA;
    private FrameLayout gaE;
    public ImageView gan;
    private TextView gaq;
    public ImageView gar;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fZA = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fZA.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fZA.setIsRound(true);
        this.fZA.setAutoChangeStyle(false);
        this.fZA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZA.setDrawBorder(false);
        this.gan = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.ePF = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.gaq = (TextView) this.mRootView.findViewById(a.g.line);
        this.gaE = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.gar = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.gar.setVisibility(8);
    }

    public void a(com.baidu.live.ar.f fVar) {
        if (fVar != null) {
            this.ePF.setText(fVar.getName());
            Gh(fVar.Cb());
            if (com.baidu.live.d.AZ().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.d.AZ().getBoolean(fVar.getType(), true));
            }
        }
    }

    public void Gh(String str) {
        this.fZA.startLoad(str, 10, false);
    }

    public void bLQ() {
        this.ePF.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.gan.setVisibility(4);
    }

    public void bLR() {
        this.ePF.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.gan.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.gar.setVisibility(0);
        } else {
            this.gar.setVisibility(8);
        }
    }
}
