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
    private com.baidu.tieba.ala.anchortask.b.a gtB;
    private Space gtC;
    private TextView gtD;
    private FrameLayout gtE;
    private ProgressBar gtF;
    private View gtG;
    private FrameLayout gtH;
    private TextView gtI;
    private TextView gtJ;
    private TextView gtK;
    private boolean gtL = true;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bQj();
    }

    private void bQj() {
        this.gtC = (Space) this.mView.findViewById(a.f.space);
        this.gtD = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gtE = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gtF = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gtG = this.mView.findViewById(a.f.endPoint_view);
        this.gtH = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gtI = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gtJ = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gtK = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gtL = z;
    }

    public void refreshUI() {
        if (!this.gtL) {
            this.mView.setVisibility(8);
        } else if (this.gtB == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gtB);
        }
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.gtB = aVar;
        if (!this.gtL) {
            this.mView.setVisibility(8);
        } else if (aVar.gtp == 2) {
            this.mView.setVisibility(8);
        } else {
            this.gtD.setText(aVar.gtr + "%");
            int i = aVar.gtz;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gtF.setProgress(i);
            if (i < 100) {
                this.gtG.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gtG.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (aVar.gty == 1) {
                this.gtC.setVisibility(0);
                this.gtE.setVisibility(0);
                this.gtH.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (aVar.gtA == 1) {
                    this.gtI.setVisibility(0);
                    this.gtI.setText(aVar.gtr + "%");
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gtK.setVisibility(0);
                    this.gtK.setText(aVar.gts + "%");
                } else if (aVar.gtA == 2) {
                    this.gtI.setVisibility(8);
                    this.gtK.setVisibility(8);
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (aVar.gtA == 3) {
                    this.gtI.setVisibility(8);
                    this.gtK.setVisibility(8);
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (aVar.gty == 2) {
                this.gtC.setVisibility(0);
                this.gtE.setVisibility(8);
                this.gtH.setVisibility(0);
                this.gtI.setVisibility(8);
                this.gtK.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (aVar.gtA == 1) {
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (aVar.gtA == 2) {
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (aVar.gtA == 3) {
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (aVar.gty == 3) {
                this.gtE.setVisibility(8);
                if (aVar.gtr < aVar.gts) {
                    this.gtC.setVisibility(0);
                    this.gtH.setVisibility(0);
                    this.gtK.setVisibility(0);
                    this.gtI.setVisibility(8);
                    this.gtJ.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gtK.setText(aVar.gts + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gtC.setVisibility(8);
                    this.gtH.setVisibility(8);
                    this.mView.setBackgroundResource(a.e.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
        }
    }

    public void onDestroy() {
    }
}
