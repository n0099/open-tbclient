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
    private com.baidu.tieba.ala.anchortask.b.a evn;
    private Space evo;
    private TextView evp;
    private FrameLayout evq;
    private ProgressBar evr;
    private View evs;
    private FrameLayout evt;
    private TextView evu;
    private TextView evv;
    private TextView evw;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bdM();
    }

    private void bdM() {
        this.evo = (Space) this.mView.findViewById(a.g.space);
        this.evp = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.evq = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.evr = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.evs = this.mView.findViewById(a.g.endPoint_view);
        this.evt = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.evu = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.evv = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.evw = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.evn = aVar;
        if (aVar.evb == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.evp.setText(aVar.evd + "%");
        int i = aVar.evl;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.evr.setProgress(i);
        if (i < 100) {
            this.evs.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.evs.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.evk == 1) {
            this.evo.setVisibility(0);
            this.evq.setVisibility(0);
            this.evt.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evm == 1) {
                this.evu.setVisibility(0);
                this.evu.setText(aVar.evd + "%");
                this.evv.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evw.setVisibility(0);
                this.evw.setText(aVar.eve + "%");
            } else if (aVar.evm == 2) {
                this.evu.setVisibility(8);
                this.evw.setVisibility(8);
                this.evv.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evm == 3) {
                this.evu.setVisibility(8);
                this.evw.setVisibility(8);
                this.evv.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evk == 2) {
            this.evo.setVisibility(0);
            this.evq.setVisibility(8);
            this.evt.setVisibility(0);
            this.evu.setVisibility(8);
            this.evw.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evm == 1) {
                this.evv.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.evm == 2) {
                this.evv.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evm == 3) {
                this.evv.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evk == 3) {
            this.evq.setVisibility(8);
            if (aVar.evd < aVar.eve) {
                this.evo.setVisibility(0);
                this.evt.setVisibility(0);
                this.evw.setVisibility(0);
                this.evu.setVisibility(8);
                this.evv.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evw.setText(aVar.eve + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.evo.setVisibility(8);
                this.evt.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
