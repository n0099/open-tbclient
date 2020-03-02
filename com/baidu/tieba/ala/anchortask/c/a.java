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
    private com.baidu.tieba.ala.anchortask.b.a evo;
    private Space evp;
    private TextView evq;
    private FrameLayout evr;
    private ProgressBar evs;
    private View evt;
    private FrameLayout evu;
    private TextView evv;
    private TextView evw;
    private TextView evx;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bdO();
    }

    private void bdO() {
        this.evp = (Space) this.mView.findViewById(a.g.space);
        this.evq = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.evr = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.evs = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.evt = this.mView.findViewById(a.g.endPoint_view);
        this.evu = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.evv = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.evw = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.evx = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.evo = aVar;
        if (aVar.evc == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.evq.setText(aVar.eve + "%");
        int i = aVar.evm;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.evs.setProgress(i);
        if (i < 100) {
            this.evt.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.evt.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.evl == 1) {
            this.evp.setVisibility(0);
            this.evr.setVisibility(0);
            this.evu.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evn == 1) {
                this.evv.setVisibility(0);
                this.evv.setText(aVar.eve + "%");
                this.evw.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evx.setVisibility(0);
                this.evx.setText(aVar.evf + "%");
            } else if (aVar.evn == 2) {
                this.evv.setVisibility(8);
                this.evx.setVisibility(8);
                this.evw.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evn == 3) {
                this.evv.setVisibility(8);
                this.evx.setVisibility(8);
                this.evw.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evl == 2) {
            this.evp.setVisibility(0);
            this.evr.setVisibility(8);
            this.evu.setVisibility(0);
            this.evv.setVisibility(8);
            this.evx.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.evn == 1) {
                this.evw.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.evn == 2) {
                this.evw.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.evn == 3) {
                this.evw.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.evl == 3) {
            this.evr.setVisibility(8);
            if (aVar.eve < aVar.evf) {
                this.evp.setVisibility(0);
                this.evu.setVisibility(0);
                this.evx.setVisibility(0);
                this.evv.setVisibility(8);
                this.evw.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.evx.setText(aVar.evf + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.evp.setVisibility(8);
                this.evu.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
