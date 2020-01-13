package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.support.v4.widget.Space;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.a erc;
    private Space erd;
    private TextView ere;
    private FrameLayout erf;
    private ProgressBar erg;
    private View erh;
    private FrameLayout eri;
    private TextView erj;
    private TextView erk;
    private TextView erl;
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.h.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.g.id_anchorTask_view);
        this.mView.setVisibility(8);
        bbx();
    }

    private void bbx() {
        this.erd = (Space) this.mView.findViewById(a.g.space);
        this.ere = (TextView) this.mView.findViewById(a.g.currRatio_textView);
        this.erf = (FrameLayout) this.mView.findViewById(a.g.process_layout);
        this.erg = (ProgressBar) this.mView.findViewById(a.g.proportion_progressBar);
        this.erh = this.mView.findViewById(a.g.endPoint_view);
        this.eri = (FrameLayout) this.mView.findViewById(a.g.desc_layout);
        this.erj = (TextView) this.mView.findViewById(a.g.currProgess_textView);
        this.erk = (TextView) this.mView.findViewById(a.g.desc_textView);
        this.erl = (TextView) this.mView.findViewById(a.g.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void a(com.baidu.tieba.ala.anchortask.b.a aVar) {
        this.erc = aVar;
        if (aVar.eqQ == 2) {
            this.mView.setVisibility(8);
            return;
        }
        this.ere.setText(aVar.eqS + "%");
        int i = aVar.era;
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.erg.setProgress(i);
        if (i < 100) {
            this.erh.setBackgroundResource(a.f.bg_circlepoint_393939);
        } else {
            this.erh.setBackgroundResource(a.f.bg_circlepoint_faca21);
        }
        if (aVar.eqZ == 1) {
            this.erd.setVisibility(0);
            this.erf.setVisibility(0);
            this.eri.setVisibility(0);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.erb == 1) {
                this.erj.setVisibility(0);
                this.erj.setText(aVar.eqS + "%");
                this.erk.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.erl.setVisibility(0);
                this.erl.setText(aVar.eqT + "%");
            } else if (aVar.erb == 2) {
                this.erj.setVisibility(8);
                this.erl.setVisibility(8);
                this.erk.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.erb == 3) {
                this.erj.setVisibility(8);
                this.erl.setVisibility(8);
                this.erk.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eqZ == 2) {
            this.erd.setVisibility(0);
            this.erf.setVisibility(8);
            this.eri.setVisibility(0);
            this.erj.setVisibility(8);
            this.erl.setVisibility(8);
            this.mView.setBackgroundResource(a.f.bg_anchor_view);
            if (aVar.erb == 1) {
                this.erk.setText(this.context.getText(a.i.txt_anchor_risk_reduction));
            } else if (aVar.erb == 2) {
                this.erk.setText(this.context.getText(a.i.txt_anchor_done));
            } else if (aVar.erb == 3) {
                this.erk.setText(this.context.getText(a.i.txt_anchor_not_finished));
            }
        } else if (aVar.eqZ == 3) {
            this.erf.setVisibility(8);
            if (aVar.eqS < aVar.eqT) {
                this.erd.setVisibility(0);
                this.eri.setVisibility(0);
                this.erl.setVisibility(0);
                this.erj.setVisibility(8);
                this.erk.setText(this.context.getText(a.i.txt_anchor_next_reach));
                this.erl.setText(aVar.eqT + "%");
                this.mView.setBackgroundResource(a.f.bg_anchor_view);
            } else {
                this.erd.setVisibility(8);
                this.eri.setVisibility(8);
                this.mView.setBackgroundResource(a.f.bg_anchor_view_halfround);
            }
        }
        this.mView.setVisibility(0);
    }

    public void onDestroy() {
    }
}
