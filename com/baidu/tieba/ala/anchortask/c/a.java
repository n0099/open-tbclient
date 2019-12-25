package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a epQ;
    private Space epR;
    private TextView epS;
    private FrameLayout epT;
    private ProgressBar epU;
    private View epV;
    private FrameLayout epW;
    private TextView epX;
    private TextView epY;
    private TextView epZ;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bbc();
    }

    private void bbc() {
        this.epR = (Space) this.mView.findViewById(a.g.space);
        this.epS = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.epT = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.epU = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.epV = this.mView.findViewById(a.g.endPoint_view);
        this.epW = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.epX = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.epY = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.epZ = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.epQ = aVar;
        if (aVar.epE == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.epS.setText(aVar.epG + "%");
        int i = aVar.epO;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.epU.setProgress(i);
        if (i < 100) {
            this.epV.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.epV.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.epN == 1) {
            this.epR.setVisibility(0);
            this.epT.setVisibility(0);
            this.epW.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.epP == 1) {
                this.epX.setVisibility(0);
                this.epX.setText(i + "%");
                this.epY.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.epZ.setVisibility(0);
                this.epZ.setText(aVar.epH + "%");
            } else if (aVar.epP == 2) {
                this.epX.setVisibility(8);
                this.epZ.setVisibility(8);
                this.epY.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.epP == 3) {
                this.epX.setVisibility(8);
                this.epZ.setVisibility(8);
                this.epY.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.epN == 2) {
            this.epR.setVisibility(0);
            this.epT.setVisibility(8);
            this.epW.setVisibility(0);
            this.epX.setVisibility(8);
            this.epZ.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.epP == 1) {
                this.epY.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.epP == 2) {
                this.epY.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.epP == 3) {
                this.epY.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.epN == 3) {
            this.epT.setVisibility(8);
            if (aVar.epG < aVar.epH) {
                this.epR.setVisibility(0);
                this.epW.setVisibility(0);
                this.epZ.setVisibility(0);
                this.epX.setVisibility(8);
                this.epY.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.epZ.setText(aVar.epH + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.epR.setVisibility(8);
                this.epW.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
