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
    private TextView fRA;
    private TextView fRB;
    private boolean fRC = true;
    private com.baidu.tieba.ala.anchortask.b.a fRs;
    private Space fRt;
    private TextView fRu;
    private FrameLayout fRv;
    private ProgressBar fRw;
    private View fRx;
    private FrameLayout fRy;
    private TextView fRz;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bIx();
    }

    private void bIx() {
        this.fRt = (Space) this.mView.findViewById(a.g.space);
        this.fRu = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fRv = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fRw = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fRx = this.mView.findViewById(a.g.endPoint_view);
        this.fRy = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fRz = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fRA = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fRB = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.fRC = z;
    }

    public void refreshUI() {
        if (!this.fRC) {
            this.mView.setVisibility(8);
        } else if (this.fRs == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.fRs);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fRs = aVar;
        if (!this.fRC) {
            this.mView.setVisibility(8);
        } else if (aVar.fRg == 2) {
            this.mView.setVisibility(8);
        } else {
            this.fRu.setText(aVar.fRi + "%");
            int i = aVar.fRq;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.fRw.setProgress(i);
            if (i < 100) {
                this.fRx.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.fRx.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.fRp == 1) {
                this.fRt.setVisibility(0);
                this.fRv.setVisibility(0);
                this.fRy.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fRr == 1) {
                    this.fRz.setVisibility(0);
                    this.fRz.setText(aVar.fRi + "%");
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fRB.setVisibility(0);
                    this.fRB.setText(aVar.fRj + "%");
                } else if (aVar.fRr == 2) {
                    this.fRz.setVisibility(8);
                    this.fRB.setVisibility(8);
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fRr == 3) {
                    this.fRz.setVisibility(8);
                    this.fRB.setVisibility(8);
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fRp == 2) {
                this.fRt.setVisibility(0);
                this.fRv.setVisibility(8);
                this.fRy.setVisibility(0);
                this.fRz.setVisibility(8);
                this.fRB.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fRr == 1) {
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.fRr == 2) {
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fRr == 3) {
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fRp == 3) {
                this.fRv.setVisibility(8);
                if (aVar.fRi < aVar.fRj) {
                    this.fRt.setVisibility(0);
                    this.fRy.setVisibility(0);
                    this.fRB.setVisibility(0);
                    this.fRz.setVisibility(8);
                    this.fRA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fRB.setText(aVar.fRj + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.fRt.setVisibility(8);
                    this.fRy.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
