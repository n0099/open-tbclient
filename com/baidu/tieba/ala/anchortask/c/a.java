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
/* loaded from: classes7.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a fOd;
    private Space fOe;
    private TextView fOf;
    private FrameLayout fOg;
    private ProgressBar fOh;
    private View fOi;
    private FrameLayout fOj;
    private TextView fOk;
    private TextView fOl;
    private TextView fOm;
    private boolean fOn = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bHo();
    }

    private void bHo() {
        this.fOe = (Space) this.mView.findViewById(a.g.space);
        this.fOf = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fOg = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fOh = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fOi = this.mView.findViewById(a.g.endPoint_view);
        this.fOj = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fOk = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fOl = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fOm = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.fOn = z;
    }

    public void refreshUI() {
        if (!this.fOn) {
            this.mView.setVisibility(8);
        } else if (this.fOd == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.fOd);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fOd = aVar;
        if (!this.fOn) {
            this.mView.setVisibility(8);
        } else if (aVar.fNR == 2) {
            this.mView.setVisibility(8);
        } else {
            this.fOf.setText(aVar.fNT + "%");
            int i = aVar.fOb;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.fOh.setProgress(i);
            if (i < 100) {
                this.fOi.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.fOi.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.fOa == 1) {
                this.fOe.setVisibility(0);
                this.fOg.setVisibility(0);
                this.fOj.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fOc == 1) {
                    this.fOk.setVisibility(0);
                    this.fOk.setText(aVar.fNT + "%");
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fOm.setVisibility(0);
                    this.fOm.setText(aVar.fNU + "%");
                } else if (aVar.fOc == 2) {
                    this.fOk.setVisibility(8);
                    this.fOm.setVisibility(8);
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fOc == 3) {
                    this.fOk.setVisibility(8);
                    this.fOm.setVisibility(8);
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fOa == 2) {
                this.fOe.setVisibility(0);
                this.fOg.setVisibility(8);
                this.fOj.setVisibility(0);
                this.fOk.setVisibility(8);
                this.fOm.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fOc == 1) {
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.fOc == 2) {
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fOc == 3) {
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fOa == 3) {
                this.fOg.setVisibility(8);
                if (aVar.fNT < aVar.fNU) {
                    this.fOe.setVisibility(0);
                    this.fOj.setVisibility(0);
                    this.fOm.setVisibility(0);
                    this.fOk.setVisibility(8);
                    this.fOl.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fOm.setText(aVar.fNU + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.fOe.setVisibility(8);
                    this.fOj.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
