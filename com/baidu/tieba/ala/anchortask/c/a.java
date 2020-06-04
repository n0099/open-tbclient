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
    private TextView fmA;
    private TextView fmB;
    private com.baidu.tieba.ala.anchortask.b.a fms;
    private Space fmt;
    private TextView fmu;
    private FrameLayout fmv;
    private ProgressBar fmw;
    private View fmx;
    private FrameLayout fmy;
    private TextView fmz;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bsj();
    }

    private void bsj() {
        this.fmt = (Space) this.mView.findViewById(a.g.space);
        this.fmu = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fmv = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fmw = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fmx = this.mView.findViewById(a.g.endPoint_view);
        this.fmy = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fmz = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fmA = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fmB = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fms = aVar;
        if (aVar.fmg == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.fmu.setText(aVar.fmi + "%");
        int i = aVar.fmq;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.fmw.setProgress(i);
        if (i < 100) {
            this.fmx.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.fmx.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.fmp == 1) {
            this.fmt.setVisibility(0);
            this.fmv.setVisibility(0);
            this.fmy.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.fmr == 1) {
                this.fmz.setVisibility(0);
                this.fmz.setText(aVar.fmi + "%");
                this.fmA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.fmB.setVisibility(0);
                this.fmB.setText(aVar.fmj + "%");
            } else if (aVar.fmr == 2) {
                this.fmz.setVisibility(8);
                this.fmB.setVisibility(8);
                this.fmA.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.fmr == 3) {
                this.fmz.setVisibility(8);
                this.fmB.setVisibility(8);
                this.fmA.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.fmp == 2) {
            this.fmt.setVisibility(0);
            this.fmv.setVisibility(8);
            this.fmy.setVisibility(0);
            this.fmz.setVisibility(8);
            this.fmB.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.fmr == 1) {
                this.fmA.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.fmr == 2) {
                this.fmA.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.fmr == 3) {
                this.fmA.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.fmp == 3) {
            this.fmv.setVisibility(8);
            if (aVar.fmi < aVar.fmj) {
                this.fmt.setVisibility(0);
                this.fmy.setVisibility(0);
                this.fmB.setVisibility(0);
                this.fmz.setVisibility(8);
                this.fmA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.fmB.setText(aVar.fmj + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.fmt.setVisibility(8);
                this.fmy.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
