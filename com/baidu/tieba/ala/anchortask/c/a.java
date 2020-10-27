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
    private com.baidu.tieba.ala.anchortask.b.a gnO;
    private Space gnP;
    private TextView gnQ;
    private FrameLayout gnR;
    private ProgressBar gnS;
    private View gnT;
    private FrameLayout gnU;
    private TextView gnV;
    private TextView gnW;
    private TextView gnX;
    private boolean gnY = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bNJ();
    }

    private void bNJ() {
        this.gnP = (Space) this.mView.findViewById(a.g.space);
        this.gnQ = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.gnR = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.gnS = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.gnT = this.mView.findViewById(a.g.endPoint_view);
        this.gnU = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.gnV = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.gnW = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.gnX = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gnY = z;
    }

    public void refreshUI() {
        if (!this.gnY) {
            this.mView.setVisibility(8);
        } else if (this.gnO == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gnO);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.gnO = aVar;
        if (!this.gnY) {
            this.mView.setVisibility(8);
        } else if (aVar.gnC == 2) {
            this.mView.setVisibility(8);
        } else {
            this.gnQ.setText(aVar.gnE + "%");
            int i = aVar.gnM;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gnS.setProgress(i);
            if (i < 100) {
                this.gnT.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.gnT.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.gnL == 1) {
                this.gnP.setVisibility(0);
                this.gnR.setVisibility(0);
                this.gnU.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.gnN == 1) {
                    this.gnV.setVisibility(0);
                    this.gnV.setText(aVar.gnE + "%");
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.gnX.setVisibility(0);
                    this.gnX.setText(aVar.gnF + "%");
                } else if (aVar.gnN == 2) {
                    this.gnV.setVisibility(8);
                    this.gnX.setVisibility(8);
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.gnN == 3) {
                    this.gnV.setVisibility(8);
                    this.gnX.setVisibility(8);
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.gnL == 2) {
                this.gnP.setVisibility(0);
                this.gnR.setVisibility(8);
                this.gnU.setVisibility(0);
                this.gnV.setVisibility(8);
                this.gnX.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.gnN == 1) {
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.gnN == 2) {
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.gnN == 3) {
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.gnL == 3) {
                this.gnR.setVisibility(8);
                if (aVar.gnE < aVar.gnF) {
                    this.gnP.setVisibility(0);
                    this.gnU.setVisibility(0);
                    this.gnX.setVisibility(0);
                    this.gnV.setVisibility(8);
                    this.gnW.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.gnX.setText(aVar.gnF + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.gnP.setVisibility(8);
                    this.gnU.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
