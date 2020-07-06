package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a fxF;
    private Space fxG;
    private TextView fxH;
    private FrameLayout fxI;
    private ProgressBar fxJ;
    private View fxK;
    private FrameLayout fxL;
    private TextView fxM;
    private TextView fxN;
    private TextView fxO;
    private boolean fxP = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bvf();
    }

    private void bvf() {
        this.fxG = (Space) this.mView.findViewById(a.g.space);
        this.fxH = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fxI = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fxJ = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fxK = this.mView.findViewById(a.g.endPoint_view);
        this.fxL = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fxM = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fxN = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fxO = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.fxP = z;
    }

    public void refreshUI() {
        if (!this.fxP) {
            this.mView.setVisibility(8);
        } else if (this.fxF == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.fxF);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fxF = aVar;
        if (!this.fxP) {
            this.mView.setVisibility(8);
        } else if (aVar.fxt == 2) {
            this.mView.setVisibility(8);
        } else {
            this.fxH.setText(aVar.fxv + "%");
            int i = aVar.fxD;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.fxJ.setProgress(i);
            if (i < 100) {
                this.fxK.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.fxK.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.fxC == 1) {
                this.fxG.setVisibility(0);
                this.fxI.setVisibility(0);
                this.fxL.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fxE == 1) {
                    this.fxM.setVisibility(0);
                    this.fxM.setText(aVar.fxv + "%");
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fxO.setVisibility(0);
                    this.fxO.setText(aVar.fxw + "%");
                } else if (aVar.fxE == 2) {
                    this.fxM.setVisibility(8);
                    this.fxO.setVisibility(8);
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fxE == 3) {
                    this.fxM.setVisibility(8);
                    this.fxO.setVisibility(8);
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fxC == 2) {
                this.fxG.setVisibility(0);
                this.fxI.setVisibility(8);
                this.fxL.setVisibility(0);
                this.fxM.setVisibility(8);
                this.fxO.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fxE == 1) {
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.fxE == 2) {
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fxE == 3) {
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fxC == 3) {
                this.fxI.setVisibility(8);
                if (aVar.fxv < aVar.fxw) {
                    this.fxG.setVisibility(0);
                    this.fxL.setVisibility(0);
                    this.fxO.setVisibility(0);
                    this.fxM.setVisibility(8);
                    this.fxN.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fxO.setText(aVar.fxw + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.fxG.setVisibility(8);
                    this.fxL.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
