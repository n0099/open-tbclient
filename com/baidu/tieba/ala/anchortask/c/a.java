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
    private com.baidu.tieba.ala.anchortask.b.b gBO;
    private Space gBP;
    private TextView gBQ;
    private FrameLayout gBR;
    private ProgressBar gBS;
    private View gBT;
    private FrameLayout gBU;
    private TextView gBV;
    private TextView gBW;
    private TextView gBX;
    private boolean gBY = true;
    private ArrayList<View> gBc = new ArrayList<>();
    private View mView;

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bTp();
    }

    private void bTp() {
        this.gBP = (Space) this.mView.findViewById(a.f.space);
        this.gBQ = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gBR = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gBS = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gBT = this.mView.findViewById(a.f.endPoint_view);
        this.gBU = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gBV = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gBW = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gBX = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gBY = z;
    }

    public void refreshUI() {
        if (!this.gBY) {
            this.mView.setVisibility(8);
        } else if (this.gBO == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gBO);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gBO = bVar;
        if (!this.gBY) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gBC == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gBQ.setText(bVar.gBE + "%");
            int i = bVar.gBM;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gBS.setProgress(i);
            if (i < 100) {
                this.gBT.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gBT.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gBL == 1) {
                this.gBP.setVisibility(0);
                this.gBR.setVisibility(0);
                this.gBU.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gBN == 1) {
                    this.gBV.setVisibility(0);
                    this.gBV.setText(bVar.gBE + "%");
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gBX.setVisibility(0);
                    this.gBX.setText(bVar.gBF + "%");
                } else if (bVar.gBN == 2) {
                    this.gBV.setVisibility(8);
                    this.gBX.setVisibility(8);
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gBN == 3) {
                    this.gBV.setVisibility(8);
                    this.gBX.setVisibility(8);
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gBL == 2) {
                this.gBP.setVisibility(0);
                this.gBR.setVisibility(8);
                this.gBU.setVisibility(0);
                this.gBV.setVisibility(8);
                this.gBX.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gBN == 1) {
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gBN == 2) {
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gBN == 3) {
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gBL == 3) {
                this.gBR.setVisibility(8);
                if (bVar.gBE < bVar.gBF) {
                    this.gBP.setVisibility(0);
                    this.gBU.setVisibility(0);
                    this.gBX.setVisibility(0);
                    this.gBV.setVisibility(8);
                    this.gBW.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gBX.setText(bVar.gBF + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gBP.setVisibility(8);
                    this.gBU.setVisibility(8);
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
        this.gBc = arrayList;
    }
}
