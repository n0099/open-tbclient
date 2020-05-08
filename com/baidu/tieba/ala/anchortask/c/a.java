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
    private FrameLayout eZA;
    private ProgressBar eZB;
    private View eZC;
    private FrameLayout eZD;
    private TextView eZE;
    private TextView eZF;
    private TextView eZG;
    private com.baidu.tieba.ala.anchortask.b.a eZx;
    private Space eZy;
    private TextView eZz;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bmJ();
    }

    private void bmJ() {
        this.eZy = (Space) this.mView.findViewById(a.g.space);
        this.eZz = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.eZA = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.eZB = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.eZC = this.mView.findViewById(a.g.endPoint_view);
        this.eZD = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.eZE = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.eZF = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.eZG = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.eZx = aVar;
        if (aVar.eZl == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.eZz.setText(aVar.eZn + "%");
        int i = aVar.eZv;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.eZB.setProgress(i);
        if (i < 100) {
            this.eZC.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.eZC.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.eZu == 1) {
            this.eZy.setVisibility(0);
            this.eZA.setVisibility(0);
            this.eZD.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.eZw == 1) {
                this.eZE.setVisibility(0);
                this.eZE.setText(aVar.eZn + "%");
                this.eZF.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.eZG.setVisibility(0);
                this.eZG.setText(aVar.eZo + "%");
            } else if (aVar.eZw == 2) {
                this.eZE.setVisibility(8);
                this.eZG.setVisibility(8);
                this.eZF.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.eZw == 3) {
                this.eZE.setVisibility(8);
                this.eZG.setVisibility(8);
                this.eZF.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eZu == 2) {
            this.eZy.setVisibility(0);
            this.eZA.setVisibility(8);
            this.eZD.setVisibility(0);
            this.eZE.setVisibility(8);
            this.eZG.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.eZw == 1) {
                this.eZF.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.eZw == 2) {
                this.eZF.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.eZw == 3) {
                this.eZF.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eZu == 3) {
            this.eZA.setVisibility(8);
            if (aVar.eZn < aVar.eZo) {
                this.eZy.setVisibility(0);
                this.eZD.setVisibility(0);
                this.eZG.setVisibility(0);
                this.eZE.setVisibility(8);
                this.eZF.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.eZG.setText(aVar.eZo + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.eZy.setVisibility(8);
                this.eZD.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
