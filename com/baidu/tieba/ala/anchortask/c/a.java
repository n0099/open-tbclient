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
    private TextView eZA;
    private TextView eZB;
    private com.baidu.tieba.ala.anchortask.b.a eZs;
    private Space eZt;
    private TextView eZu;
    private FrameLayout eZv;
    private ProgressBar eZw;
    private View eZx;
    private FrameLayout eZy;
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
        bmL();
    }

    private void bmL() {
        this.eZt = (Space) this.mView.findViewById(a.g.space);
        this.eZu = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.eZv = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.eZw = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.eZx = this.mView.findViewById(a.g.endPoint_view);
        this.eZy = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.eZz = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.eZA = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.eZB = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.eZs = aVar;
        if (aVar.eZg == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.eZu.setText(aVar.eZi + "%");
        int i = aVar.eZq;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.eZw.setProgress(i);
        if (i < 100) {
            this.eZx.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.eZx.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.eZp == 1) {
            this.eZt.setVisibility(0);
            this.eZv.setVisibility(0);
            this.eZy.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.eZr == 1) {
                this.eZz.setVisibility(0);
                this.eZz.setText(aVar.eZi + "%");
                this.eZA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.eZB.setVisibility(0);
                this.eZB.setText(aVar.eZj + "%");
            } else if (aVar.eZr == 2) {
                this.eZz.setVisibility(8);
                this.eZB.setVisibility(8);
                this.eZA.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.eZr == 3) {
                this.eZz.setVisibility(8);
                this.eZB.setVisibility(8);
                this.eZA.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eZp == 2) {
            this.eZt.setVisibility(0);
            this.eZv.setVisibility(8);
            this.eZy.setVisibility(0);
            this.eZz.setVisibility(8);
            this.eZB.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.eZr == 1) {
                this.eZA.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.eZr == 2) {
                this.eZA.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.eZr == 3) {
                this.eZA.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eZp == 3) {
            this.eZv.setVisibility(8);
            if (aVar.eZi < aVar.eZj) {
                this.eZt.setVisibility(0);
                this.eZy.setVisibility(0);
                this.eZB.setVisibility(0);
                this.eZz.setVisibility(8);
                this.eZA.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.eZB.setText(aVar.eZj + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.eZt.setVisibility(8);
                this.eZy.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
