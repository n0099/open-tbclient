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
    private com.baidu.tieba.ala.anchortask.b.a fOh;
    private Space fOi;
    private TextView fOj;
    private FrameLayout fOk;
    private ProgressBar fOl;
    private View fOm;
    private FrameLayout fOn;
    private TextView fOo;
    private TextView fOp;
    private TextView fOq;
    private boolean fOr = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bHp();
    }

    private void bHp() {
        this.fOi = (Space) this.mView.findViewById(a.g.space);
        this.fOj = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.fOk = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.fOl = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.fOm = this.mView.findViewById(a.g.endPoint_view);
        this.fOn = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.fOo = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.fOp = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.fOq = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.fOr = z;
    }

    public void refreshUI() {
        if (!this.fOr) {
            this.mView.setVisibility(8);
        } else if (this.fOh == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.fOh);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.fOh = aVar;
        if (!this.fOr) {
            this.mView.setVisibility(8);
        } else if (aVar.fNV == 2) {
            this.mView.setVisibility(8);
        } else {
            this.fOj.setText(aVar.fNX + "%");
            int i = aVar.fOf;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.fOl.setProgress(i);
            if (i < 100) {
                this.fOm.setBackgroundResource(a.f.bg_circlepoint_393939);
            } else {
                this.fOm.setBackgroundResource(a.f.bg_circlepoint_faca21);
            }
            if (aVar.fOe == 1) {
                this.fOi.setVisibility(0);
                this.fOk.setVisibility(0);
                this.fOn.setVisibility(0);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fOg == 1) {
                    this.fOo.setVisibility(0);
                    this.fOo.setText(aVar.fNX + "%");
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fOq.setVisibility(0);
                    this.fOq.setText(aVar.fNY + "%");
                } else if (aVar.fOg == 2) {
                    this.fOo.setVisibility(8);
                    this.fOq.setVisibility(8);
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fOg == 3) {
                    this.fOo.setVisibility(8);
                    this.fOq.setVisibility(8);
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fOe == 2) {
                this.fOi.setVisibility(0);
                this.fOk.setVisibility(8);
                this.fOn.setVisibility(0);
                this.fOo.setVisibility(8);
                this.fOq.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
                if (aVar.fOg == 1) {
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
                } else if (aVar.fOg == 2) {
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_done));
                } else if (aVar.fOg == 3) {
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_not_finished));
                }
            } else if (aVar.fOe == 3) {
                this.fOk.setVisibility(8);
                if (aVar.fNX < aVar.fNY) {
                    this.fOi.setVisibility(0);
                    this.fOn.setVisibility(0);
                    this.fOq.setVisibility(0);
                    this.fOo.setVisibility(8);
                    this.fOp.setText(this.context.getText(a.i.txt_anchor_next_reach));
                    this.fOq.setText(aVar.fNY + "%");
                    this.mView.setBackgroundResource(a.f.bg_anchor_view);
                } else {
                    this.fOi.setVisibility(8);
                    this.fOn.setVisibility(8);
                    this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
