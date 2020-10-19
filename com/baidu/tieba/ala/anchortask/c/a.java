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
    private com.baidu.tieba.ala.anchortask.b.a gdK;
    private Space gdL;
    private TextView gdM;
    private FrameLayout gdN;
    private ProgressBar gdO;
    private View gdP;
    private FrameLayout gdQ;
    private TextView gdR;
    private TextView gdS;
    private TextView gdT;
    private boolean gdU = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bLh();
    }

    private void bLh() {
        this.gdL = (Space) this.mView.findViewById(a.g.space);
        this.gdM = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.gdN = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.gdO = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.gdP = this.mView.findViewById(a.g.endPoint_view);
        this.gdQ = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.gdR = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.gdS = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.gdT = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gdU = z;
    }

    public void refreshUI() {
        if (!this.gdU) {
            this.mView.setVisibility(8);
        } else if (this.gdK == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gdK);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.gdK = aVar;
        if (!this.gdU) {
            this.mView.setVisibility(8);
        } else if (aVar.gdy == 2) {
            this.mView.setVisibility(8);
        } else {
            this.gdM.setText(aVar.gdA + "%");
            int i = aVar.gdI;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gdO.setProgress(i);
            if (i < 100) {
                this.gdP.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.gdP.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.gdH == 1) {
                this.gdL.setVisibility(0);
                this.gdN.setVisibility(0);
                this.gdQ.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.gdJ == 1) {
                    this.gdR.setVisibility(0);
                    this.gdR.setText(aVar.gdA + "%");
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.gdT.setVisibility(0);
                    this.gdT.setText(aVar.gdB + "%");
                } else if (aVar.gdJ == 2) {
                    this.gdR.setVisibility(8);
                    this.gdT.setVisibility(8);
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.gdJ == 3) {
                    this.gdR.setVisibility(8);
                    this.gdT.setVisibility(8);
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.gdH == 2) {
                this.gdL.setVisibility(0);
                this.gdN.setVisibility(8);
                this.gdQ.setVisibility(0);
                this.gdR.setVisibility(8);
                this.gdT.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.gdJ == 1) {
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.gdJ == 2) {
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.gdJ == 3) {
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.gdH == 3) {
                this.gdN.setVisibility(8);
                if (aVar.gdA < aVar.gdB) {
                    this.gdL.setVisibility(0);
                    this.gdQ.setVisibility(0);
                    this.gdT.setVisibility(0);
                    this.gdR.setVisibility(8);
                    this.gdS.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.gdT.setText(aVar.gdB + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.gdL.setVisibility(8);
                    this.gdQ.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
