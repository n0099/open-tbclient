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
    private com.baidu.tieba.ala.anchortask.b.b gNA;
    private Space gNB;
    private TextView gNC;
    private FrameLayout gND;
    private ProgressBar gNE;
    private View gNF;
    private FrameLayout gNG;
    private TextView gNH;
    private TextView gNI;
    private TextView gNJ;
    private View mView;
    private boolean gNK = true;
    private ArrayList<View> gMM = new ArrayList<>();

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bVU();
    }

    private void bVU() {
        this.gNB = (Space) this.mView.findViewById(a.f.space);
        this.gNC = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gND = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gNE = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gNF = this.mView.findViewById(a.f.endPoint_view);
        this.gNG = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gNH = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gNI = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gNJ = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gNK = z;
    }

    public void refreshUI() {
        if (!this.gNK) {
            this.mView.setVisibility(8);
        } else if (this.gNA == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gNA);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gNA = bVar;
        if (!this.gNK) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gNo == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gNC.setText(bVar.gNq + "%");
            int i = bVar.gNy;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gNE.setProgress(i);
            if (i < 100) {
                this.gNF.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gNF.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gNx == 1) {
                this.gNB.setVisibility(0);
                this.gND.setVisibility(0);
                this.gNG.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gNz == 1) {
                    this.gNH.setVisibility(0);
                    this.gNH.setText(bVar.gNq + "%");
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gNJ.setVisibility(0);
                    this.gNJ.setText(bVar.gNr + "%");
                } else if (bVar.gNz == 2) {
                    this.gNH.setVisibility(8);
                    this.gNJ.setVisibility(8);
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gNz == 3) {
                    this.gNH.setVisibility(8);
                    this.gNJ.setVisibility(8);
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gNx == 2) {
                this.gNB.setVisibility(0);
                this.gND.setVisibility(8);
                this.gNG.setVisibility(0);
                this.gNH.setVisibility(8);
                this.gNJ.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gNz == 1) {
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gNz == 2) {
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gNz == 3) {
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gNx == 3) {
                this.gND.setVisibility(8);
                if (bVar.gNq < bVar.gNr) {
                    this.gNB.setVisibility(0);
                    this.gNG.setVisibility(0);
                    this.gNJ.setVisibility(0);
                    this.gNH.setVisibility(8);
                    this.gNI.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gNJ.setText(bVar.gNr + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gNB.setVisibility(8);
                    this.gNG.setVisibility(8);
                    this.mView.setBackgroundResource(a.e.bg_anchor_view_halfround);
                }
            }
            this.mView.setVisibility(0);
            return true;
        }
    }

    public void onDestroy() {
    }

    public void Z(ArrayList<View> arrayList) {
        this.gMM = arrayList;
    }
}
