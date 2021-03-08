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
    private FrameLayout gNA;
    private ProgressBar gNB;
    private View gNC;
    private FrameLayout gND;
    private TextView gNE;
    private TextView gNF;
    private TextView gNG;
    private com.baidu.tieba.ala.anchortask.b.b gNx;
    private Space gNy;
    private TextView gNz;
    private View mView;
    private boolean gNH = true;
    private ArrayList<View> gMN = new ArrayList<>();

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bST();
    }

    private void bST() {
        this.gNy = (Space) this.mView.findViewById(a.f.space);
        this.gNz = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gNA = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gNB = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gNC = this.mView.findViewById(a.f.endPoint_view);
        this.gND = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gNE = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gNF = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gNG = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gNH = z;
    }

    public void refreshUI() {
        if (!this.gNH) {
            this.mView.setVisibility(8);
        } else if (this.gNx == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gNx);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gNx = bVar;
        if (!this.gNH) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gNl == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gNz.setText(bVar.gNn + "%");
            int i = bVar.gNv;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gNB.setProgress(i);
            if (i < 100) {
                this.gNC.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gNC.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gNu == 1) {
                this.gNy.setVisibility(0);
                this.gNA.setVisibility(0);
                this.gND.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gNw == 1) {
                    this.gNE.setVisibility(0);
                    this.gNE.setText(bVar.gNn + "%");
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gNG.setVisibility(0);
                    this.gNG.setText(bVar.gNo + "%");
                } else if (bVar.gNw == 2) {
                    this.gNE.setVisibility(8);
                    this.gNG.setVisibility(8);
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gNw == 3) {
                    this.gNE.setVisibility(8);
                    this.gNG.setVisibility(8);
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gNu == 2) {
                this.gNy.setVisibility(0);
                this.gNA.setVisibility(8);
                this.gND.setVisibility(0);
                this.gNE.setVisibility(8);
                this.gNG.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gNw == 1) {
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gNw == 2) {
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gNw == 3) {
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gNu == 3) {
                this.gNA.setVisibility(8);
                if (bVar.gNn < bVar.gNo) {
                    this.gNy.setVisibility(0);
                    this.gND.setVisibility(0);
                    this.gNG.setVisibility(0);
                    this.gNE.setVisibility(8);
                    this.gNF.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gNG.setText(bVar.gNo + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gNy.setVisibility(8);
                    this.gND.setVisibility(8);
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
        this.gMN = arrayList;
    }
}
