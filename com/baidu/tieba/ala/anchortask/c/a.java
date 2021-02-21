package com.baidu.tieba.ala.anchortask.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.legacy.widget.Space;
import com.baidu.live.sdk.a;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.b gLO;
    private Space gLP;
    private TextView gLQ;
    private FrameLayout gLR;
    private ProgressBar gLS;
    private View gLT;
    private FrameLayout gLU;
    private TextView gLV;
    private TextView gLW;
    private TextView gLX;
    private boolean gLY = true;
    private ArrayList<View> gLe = new ArrayList<>();
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bSN();
    }

    private void bSN() {
        this.gLP = (Space) this.mView.findViewById(a.f.space);
        this.gLQ = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gLR = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gLS = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gLT = this.mView.findViewById(a.f.endPoint_view);
        this.gLU = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gLV = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gLW = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gLX = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gLY = z;
    }

    public void refreshUI() {
        if (!this.gLY) {
            this.mView.setVisibility(8);
        } else if (this.gLO == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gLO);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gLO = bVar;
        if (!this.gLY) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gLC == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gLQ.setText(bVar.gLE + "%");
            int i = bVar.gLM;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gLS.setProgress(i);
            if (i < 100) {
                this.gLT.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gLT.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gLL == 1) {
                this.gLP.setVisibility(0);
                this.gLR.setVisibility(0);
                this.gLU.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gLN == 1) {
                    this.gLV.setVisibility(0);
                    this.gLV.setText(bVar.gLE + "%");
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gLX.setVisibility(0);
                    this.gLX.setText(bVar.gLF + "%");
                } else if (bVar.gLN == 2) {
                    this.gLV.setVisibility(8);
                    this.gLX.setVisibility(8);
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gLN == 3) {
                    this.gLV.setVisibility(8);
                    this.gLX.setVisibility(8);
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gLL == 2) {
                this.gLP.setVisibility(0);
                this.gLR.setVisibility(8);
                this.gLU.setVisibility(0);
                this.gLV.setVisibility(8);
                this.gLX.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gLN == 1) {
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gLN == 2) {
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gLN == 3) {
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gLL == 3) {
                this.gLR.setVisibility(8);
                if (bVar.gLE < bVar.gLF) {
                    this.gLP.setVisibility(0);
                    this.gLU.setVisibility(0);
                    this.gLX.setVisibility(0);
                    this.gLV.setVisibility(8);
                    this.gLW.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gLX.setText(bVar.gLF + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gLP.setVisibility(8);
                    this.gLU.setVisibility(8);
                    this.mView.setBackgroundResource(a.e.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
            return true;
        }
    }

    public void onDestroy() {
    }

    public void T(ArrayList<View> arrayList) {
        this.gLe = arrayList;
    }
}
