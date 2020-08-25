package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes7.dex */
public class d {
    private TextView esQ;
    private TbImageView fAI;
    public ImageView fBO;
    private TextView fBQ;
    public ImageView fBR;
    private FrameLayout fCd;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fAI = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fAI.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fAI.setIsRound(true);
        this.fAI.setAutoChangeStyle(false);
        this.fAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAI.setDrawBorder(false);
        this.fBO = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.esQ = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.fBQ = (TextView) this.mRootView.findViewById(a.g.line);
        this.fCd = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fBR = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fBR.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.esQ.setText(eVar.getName());
            Ey(eVar.AO());
            if (com.baidu.live.c.AD().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.AD().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void Ey(String str) {
        this.fAI.startLoad(str, 10, false);
    }

    public void bFn() {
        this.esQ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBO.setVisibility(4);
    }

    public void bFo() {
        this.esQ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fBO.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fBR.setVisibility(0);
        } else {
            this.fBR.setVisibility(8);
        }
    }
}
