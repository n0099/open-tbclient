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
    private com.baidu.tieba.ala.anchortask.b.a evX;
    private Space evY;
    private TextView evZ;
    private FrameLayout ewa;
    private ProgressBar ewb;
    private View ewc;
    private FrameLayout ewd;
    private TextView ewe;
    private TextView ewf;
    private TextView ewg;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bdU();
    }

    private void bdU() {
        this.evY = (Space) this.mView.findViewById(a.g.space);
        this.evZ = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.ewa = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.ewb = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.ewc = this.mView.findViewById(a.g.endPoint_view);
        this.ewd = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.ewe = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.ewf = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.ewg = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.evX = aVar;
        if (aVar.evL == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.evZ.setText(aVar.evN + "%");
        int i = aVar.evV;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.ewb.setProgress(i);
        if (i < 100) {
            this.ewc.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.ewc.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.evU == 1) {
            this.evY.setVisibility(0);
            this.ewa.setVisibility(0);
            this.ewd.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evW == 1) {
                this.ewe.setVisibility(0);
                this.ewe.setText(aVar.evN + "%");
                this.ewf.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.ewg.setVisibility(0);
                this.ewg.setText(aVar.evO + "%");
            } else if (aVar.evW == 2) {
                this.ewe.setVisibility(8);
                this.ewg.setVisibility(8);
                this.ewf.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evW == 3) {
                this.ewe.setVisibility(8);
                this.ewg.setVisibility(8);
                this.ewf.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evU == 2) {
            this.evY.setVisibility(0);
            this.ewa.setVisibility(8);
            this.ewd.setVisibility(0);
            this.ewe.setVisibility(8);
            this.ewg.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evW == 1) {
                this.ewf.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.evW == 2) {
                this.ewf.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evW == 3) {
                this.ewf.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evU == 3) {
            this.ewa.setVisibility(8);
            if (aVar.evN < aVar.evO) {
                this.evY.setVisibility(0);
                this.ewd.setVisibility(0);
                this.ewg.setVisibility(0);
                this.ewe.setVisibility(8);
                this.ewf.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.ewg.setText(aVar.evO + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.evY.setVisibility(8);
                this.ewd.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
