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
/* loaded from: classes10.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.b gIU;
    private Space gIV;
    private TextView gIW;
    private FrameLayout gIX;
    private ProgressBar gIY;
    private View gIZ;
    private FrameLayout gJa;
    private TextView gJb;
    private TextView gJc;
    private TextView gJd;
    private View mView;
    private boolean gJe = true;
    private ArrayList<View> gIg = new ArrayList<>();

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bSd();
    }

    private void bSd() {
        this.gIV = (Space) this.mView.findViewById(a.f.space);
        this.gIW = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gIX = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gIY = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gIZ = this.mView.findViewById(a.f.endPoint_view);
        this.gJa = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gJb = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gJc = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gJd = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gJe = z;
    }

    public void refreshUI() {
        if (!this.gJe) {
            this.mView.setVisibility(8);
        } else if (this.gIU == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gIU);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gIU = bVar;
        if (!this.gJe) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gII == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gIW.setText(bVar.gIK + "%");
            int i = bVar.gIS;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gIY.setProgress(i);
            if (i < 100) {
                this.gIZ.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gIZ.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gIR == 1) {
                this.gIV.setVisibility(0);
                this.gIX.setVisibility(0);
                this.gJa.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gIT == 1) {
                    this.gJb.setVisibility(0);
                    this.gJb.setText(bVar.gIK + "%");
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gJd.setVisibility(0);
                    this.gJd.setText(bVar.gIL + "%");
                } else if (bVar.gIT == 2) {
                    this.gJb.setVisibility(8);
                    this.gJd.setVisibility(8);
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gIT == 3) {
                    this.gJb.setVisibility(8);
                    this.gJd.setVisibility(8);
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gIR == 2) {
                this.gIV.setVisibility(0);
                this.gIX.setVisibility(8);
                this.gJa.setVisibility(0);
                this.gJb.setVisibility(8);
                this.gJd.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gIT == 1) {
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gIT == 2) {
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gIT == 3) {
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gIR == 3) {
                this.gIX.setVisibility(8);
                if (bVar.gIK < bVar.gIL) {
                    this.gIV.setVisibility(0);
                    this.gJa.setVisibility(0);
                    this.gJd.setVisibility(0);
                    this.gJb.setVisibility(8);
                    this.gJc.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gJd.setText(bVar.gIL + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gIV.setVisibility(8);
                    this.gJa.setVisibility(8);
                    this.mView.setBackgroundResource(a.e.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
            return true;
        }
    }

    public void onDestroy() {
    }

    public void U(ArrayList<View> arrayList) {
        this.gIg = arrayList;
    }
}
