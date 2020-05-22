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
    private com.baidu.tieba.ala.anchortask.b.a fmh;
    private Space fmi;
    private TextView fmj;
    private FrameLayout fmk;
    private ProgressBar fml;
    private View fmm;
    private FrameLayout fmn;
    private TextView fmo;
    private TextView fmp;
    private TextView fmq;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bsh();
    }

    private void bsh() {
        this.fmi = (Space) this.mView.findViewById(a.g.space);
        this.fmj = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fmk = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fml = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fmm = this.mView.findViewById(a.g.endPoint_view);
        this.fmn = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fmo = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fmp = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fmq = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fmh = aVar;
        if (aVar.flV == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.fmj.setText(aVar.flX + "%");
        int i = aVar.fmf;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.fml.setProgress(i);
        if (i < 100) {
            this.fmm.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.fmm.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.fme == 1) {
            this.fmi.setVisibility(0);
            this.fmk.setVisibility(0);
            this.fmn.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.fmg == 1) {
                this.fmo.setVisibility(0);
                this.fmo.setText(aVar.flX + "%");
                this.fmp.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.fmq.setVisibility(0);
                this.fmq.setText(aVar.flY + "%");
            } else if (aVar.fmg == 2) {
                this.fmo.setVisibility(8);
                this.fmq.setVisibility(8);
                this.fmp.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.fmg == 3) {
                this.fmo.setVisibility(8);
                this.fmq.setVisibility(8);
                this.fmp.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.fme == 2) {
            this.fmi.setVisibility(0);
            this.fmk.setVisibility(8);
            this.fmn.setVisibility(0);
            this.fmo.setVisibility(8);
            this.fmq.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.fmg == 1) {
                this.fmp.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.fmg == 2) {
                this.fmp.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.fmg == 3) {
                this.fmp.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.fme == 3) {
            this.fmk.setVisibility(8);
            if (aVar.flX < aVar.flY) {
                this.fmi.setVisibility(0);
                this.fmn.setVisibility(0);
                this.fmq.setVisibility(0);
                this.fmo.setVisibility(8);
                this.fmp.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.fmq.setText(aVar.flY + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.fmi.setVisibility(8);
                this.fmn.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
