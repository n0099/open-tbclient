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
    private com.baidu.tieba.ala.anchortask.b.a gti;
    private Space gtj;
    private TextView gtk;
    private FrameLayout gtl;
    private ProgressBar gtm;
    private View gtn;
    private FrameLayout gto;
    private TextView gtp;
    private TextView gtq;
    private TextView gtr;
    private boolean gts = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bPC();
    }

    private void bPC() {
        this.gtj = (Space) this.mView.findViewById(a.f.space);
        this.gtk = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gtl = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gtm = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gtn = this.mView.findViewById(a.f.endPoint_view);
        this.gto = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gtp = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gtq = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gtr = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gts = z;
    }

    public void refreshUI() {
        if (!this.gts) {
            this.mView.setVisibility(8);
        } else if (this.gti == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gti);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.gti = aVar;
        if (!this.gts) {
            this.mView.setVisibility(8);
        } else if (aVar.gsW == 2) {
            this.mView.setVisibility(8);
        } else {
            this.gtk.setText(aVar.gsY + "%");
            int i = aVar.gtg;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gtm.setProgress(i);
            if (i < 100) {
                this.gtn.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gtn.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (aVar.gtf == 1) {
                this.gtj.setVisibility(0);
                this.gtl.setVisibility(0);
                this.gto.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (aVar.gth == 1) {
                    this.gtp.setVisibility(0);
                    this.gtp.setText(aVar.gsY + "%");
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gtr.setVisibility(0);
                    this.gtr.setText(aVar.gsZ + "%");
                } else if (aVar.gth == 2) {
                    this.gtp.setVisibility(8);
                    this.gtr.setVisibility(8);
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (aVar.gth == 3) {
                    this.gtp.setVisibility(8);
                    this.gtr.setVisibility(8);
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (aVar.gtf == 2) {
                this.gtj.setVisibility(0);
                this.gtl.setVisibility(8);
                this.gto.setVisibility(0);
                this.gtp.setVisibility(8);
                this.gtr.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (aVar.gth == 1) {
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (aVar.gth == 2) {
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (aVar.gth == 3) {
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (aVar.gtf == 3) {
                this.gtl.setVisibility(8);
                if (aVar.gsY < aVar.gsZ) {
                    this.gtj.setVisibility(0);
                    this.gto.setVisibility(0);
                    this.gtr.setVisibility(0);
                    this.gtp.setVisibility(8);
                    this.gtq.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gtr.setText(aVar.gsZ + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gtj.setVisibility(8);
                    this.gto.setVisibility(8);
                    this.mView.setBackgroundResource(a.e.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
