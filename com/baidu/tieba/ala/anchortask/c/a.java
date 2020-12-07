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
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private Context context;
    private com.baidu.tieba.ala.anchortask.b.b gBM;
    private Space gBN;
    private TextView gBO;
    private FrameLayout gBP;
    private ProgressBar gBQ;
    private View gBR;
    private FrameLayout gBS;
    private TextView gBT;
    private TextView gBU;
    private TextView gBV;
    private boolean gBW = true;
    private ArrayList<View> gBa = new ArrayList<>();
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bTo();
    }

    private void bTo() {
        this.gBN = (Space) this.mView.findViewById(a.f.space);
        this.gBO = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gBP = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gBQ = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gBR = this.mView.findViewById(a.f.endPoint_view);
        this.gBS = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gBT = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gBU = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gBV = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gBW = z;
    }

    public void refreshUI() {
        if (!this.gBW) {
            this.mView.setVisibility(8);
        } else if (this.gBM == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gBM);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gBM = bVar;
        if (!this.gBW) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gBA == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gBO.setText(bVar.gBC + "%");
            int i = bVar.gBK;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gBQ.setProgress(i);
            if (i < 100) {
                this.gBR.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gBR.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gBJ == 1) {
                this.gBN.setVisibility(0);
                this.gBP.setVisibility(0);
                this.gBS.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gBL == 1) {
                    this.gBT.setVisibility(0);
                    this.gBT.setText(bVar.gBC + "%");
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gBV.setVisibility(0);
                    this.gBV.setText(bVar.gBD + "%");
                } else if (bVar.gBL == 2) {
                    this.gBT.setVisibility(8);
                    this.gBV.setVisibility(8);
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gBL == 3) {
                    this.gBT.setVisibility(8);
                    this.gBV.setVisibility(8);
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gBJ == 2) {
                this.gBN.setVisibility(0);
                this.gBP.setVisibility(8);
                this.gBS.setVisibility(0);
                this.gBT.setVisibility(8);
                this.gBV.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gBL == 1) {
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gBL == 2) {
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gBL == 3) {
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gBJ == 3) {
                this.gBP.setVisibility(8);
                if (bVar.gBC < bVar.gBD) {
                    this.gBN.setVisibility(0);
                    this.gBS.setVisibility(0);
                    this.gBV.setVisibility(0);
                    this.gBT.setVisibility(8);
                    this.gBU.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gBV.setText(bVar.gBD + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gBN.setVisibility(8);
                    this.gBS.setVisibility(8);
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
        this.gBa = arrayList;
    }
}
