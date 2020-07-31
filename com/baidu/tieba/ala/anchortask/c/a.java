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
/* loaded from: classes4.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a fCM;
    private Space fCN;
    private TextView fCO;
    private FrameLayout fCP;
    private ProgressBar fCQ;
    private View fCR;
    private FrameLayout fCS;
    private TextView fCT;
    private TextView fCU;
    private TextView fCV;
    private boolean fCW = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        byo();
    }

    private void byo() {
        this.fCN = (Space) this.mView.findViewById(a.g.space);
        this.fCO = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fCP = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fCQ = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fCR = this.mView.findViewById(a.g.endPoint_view);
        this.fCS = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fCT = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fCU = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fCV = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.fCW = z;
    }

    public void refreshUI() {
        if (!this.fCW) {
            this.mView.setVisibility(8);
        } else if (this.fCM == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.fCM);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fCM = aVar;
        if (!this.fCW) {
            this.mView.setVisibility(8);
        } else if (aVar.fCA == 2) {
            this.mView.setVisibility(8);
        } else {
            this.fCO.setText(aVar.fCC + "%");
            int i = aVar.fCK;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.fCQ.setProgress(i);
            if (i < 100) {
                this.fCR.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.fCR.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.fCJ == 1) {
                this.fCN.setVisibility(0);
                this.fCP.setVisibility(0);
                this.fCS.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fCL == 1) {
                    this.fCT.setVisibility(0);
                    this.fCT.setText(aVar.fCC + "%");
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fCV.setVisibility(0);
                    this.fCV.setText(aVar.fCD + "%");
                } else if (aVar.fCL == 2) {
                    this.fCT.setVisibility(8);
                    this.fCV.setVisibility(8);
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fCL == 3) {
                    this.fCT.setVisibility(8);
                    this.fCV.setVisibility(8);
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fCJ == 2) {
                this.fCN.setVisibility(0);
                this.fCP.setVisibility(8);
                this.fCS.setVisibility(0);
                this.fCT.setVisibility(8);
                this.fCV.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fCL == 1) {
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.fCL == 2) {
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fCL == 3) {
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fCJ == 3) {
                this.fCP.setVisibility(8);
                if (aVar.fCC < aVar.fCD) {
                    this.fCN.setVisibility(0);
                    this.fCS.setVisibility(0);
                    this.fCV.setVisibility(0);
                    this.fCT.setVisibility(8);
                    this.fCU.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fCV.setText(aVar.fCD + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.fCN.setVisibility(8);
                    this.fCS.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
