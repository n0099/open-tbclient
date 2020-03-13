package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a evB;
    private Space evC;
    private TextView evD;
    private FrameLayout evE;
    private ProgressBar evF;
    private View evG;
    private FrameLayout evH;
    private TextView evI;
    private TextView evJ;
    private TextView evK;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bdP();
    }

    private void bdP() {
        this.evC = (Space) this.mView.findViewById(a.g.space);
        this.evD = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.evE = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.evF = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.evG = this.mView.findViewById(a.g.endPoint_view);
        this.evH = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.evI = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.evJ = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.evK = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.evB = aVar;
        if (aVar.evp == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.evD.setText(aVar.evr + "%");
        int i = aVar.evz;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.evF.setProgress(i);
        if (i < 100) {
            this.evG.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.evG.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.evy == 1) {
            this.evC.setVisibility(0);
            this.evE.setVisibility(0);
            this.evH.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evA == 1) {
                this.evI.setVisibility(0);
                this.evI.setText(aVar.evr + "%");
                this.evJ.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evK.setVisibility(0);
                this.evK.setText(aVar.evs + "%");
            } else if (aVar.evA == 2) {
                this.evI.setVisibility(8);
                this.evK.setVisibility(8);
                this.evJ.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evA == 3) {
                this.evI.setVisibility(8);
                this.evK.setVisibility(8);
                this.evJ.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evy == 2) {
            this.evC.setVisibility(0);
            this.evE.setVisibility(8);
            this.evH.setVisibility(0);
            this.evI.setVisibility(8);
            this.evK.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evA == 1) {
                this.evJ.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.evA == 2) {
                this.evJ.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evA == 3) {
                this.evJ.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evy == 3) {
            this.evE.setVisibility(8);
            if (aVar.evr < aVar.evs) {
                this.evC.setVisibility(0);
                this.evH.setVisibility(0);
                this.evK.setVisibility(0);
                this.evI.setVisibility(8);
                this.evJ.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evK.setText(aVar.evs + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.evC.setVisibility(8);
                this.evH.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
