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
    private com.baidu.tieba.ala.anchortask.b.b gLA;
    private Space gLB;
    private TextView gLC;
    private FrameLayout gLD;
    private ProgressBar gLE;
    private View gLF;
    private FrameLayout gLG;
    private TextView gLH;
    private TextView gLI;
    private TextView gLJ;
    private View mView;
    private boolean gLK = true;
    private ArrayList<View> gKQ = new ArrayList<>();

    public a(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_view, (ViewGroup) null);
        this.mView.setId(a.f.id_anchorTask_view);
        this.mView.setVisibility(8);
        bSG();
    }

    private void bSG() {
        this.gLB = (Space) this.mView.findViewById(a.f.space);
        this.gLC = (TextView) this.mView.findViewById(a.f.currRatio_textView);
        this.gLD = (FrameLayout) this.mView.findViewById(a.f.process_layout);
        this.gLE = (ProgressBar) this.mView.findViewById(a.f.proportion_progressBar);
        this.gLF = this.mView.findViewById(a.f.endPoint_view);
        this.gLG = (FrameLayout) this.mView.findViewById(a.f.desc_layout);
        this.gLH = (TextView) this.mView.findViewById(a.f.currProgess_textView);
        this.gLI = (TextView) this.mView.findViewById(a.f.desc_textView);
        this.gLJ = (TextView) this.mView.findViewById(a.f.nextRatio_textView);
    }

    public View getView() {
        return this.mView;
    }

    public void setCanVisible(boolean z) {
        this.gLK = z;
    }

    public void refreshUI() {
        if (!this.gLK) {
            this.mView.setVisibility(8);
        } else if (this.gLA == null) {
            this.mView.setVisibility(8);
        } else {
            a(this.gLA);
        }
    }

    public boolean a(com.baidu.tieba.ala.anchortask.b.b bVar) {
        this.gLA = bVar;
        if (!this.gLK) {
            this.mView.setVisibility(8);
            return false;
        } else if (bVar.gLo == 2) {
            this.mView.setVisibility(8);
            return false;
        } else {
            this.gLC.setText(bVar.gLq + "%");
            int i = bVar.gLy;
            if (i < 0) {
                i = 0;
            }
            if (i > 100) {
                i = 100;
            }
            this.gLE.setProgress(i);
            if (i < 100) {
                this.gLF.setBackgroundResource(a.e.bg_circlepoint_393939);
            } else {
                this.gLF.setBackgroundResource(a.e.bg_circlepoint_faca21);
            }
            if (bVar.gLx == 1) {
                this.gLB.setVisibility(0);
                this.gLD.setVisibility(0);
                this.gLG.setVisibility(0);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gLz == 1) {
                    this.gLH.setVisibility(0);
                    this.gLH.setText(bVar.gLq + "%");
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gLJ.setVisibility(0);
                    this.gLJ.setText(bVar.gLr + "%");
                } else if (bVar.gLz == 2) {
                    this.gLH.setVisibility(8);
                    this.gLJ.setVisibility(8);
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gLz == 3) {
                    this.gLH.setVisibility(8);
                    this.gLJ.setVisibility(8);
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gLx == 2) {
                this.gLB.setVisibility(0);
                this.gLD.setVisibility(8);
                this.gLG.setVisibility(0);
                this.gLH.setVisibility(8);
                this.gLJ.setVisibility(8);
                this.mView.setBackgroundResource(a.e.bg_anchor_view);
                if (bVar.gLz == 1) {
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_risk_reduction));
                } else if (bVar.gLz == 2) {
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_done));
                } else if (bVar.gLz == 3) {
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_not_finished));
                }
            } else if (bVar.gLx == 3) {
                this.gLD.setVisibility(8);
                if (bVar.gLq < bVar.gLr) {
                    this.gLB.setVisibility(0);
                    this.gLG.setVisibility(0);
                    this.gLJ.setVisibility(0);
                    this.gLH.setVisibility(8);
                    this.gLI.setText(this.context.getText(a.h.txt_anchor_next_reach));
                    this.gLJ.setText(bVar.gLr + "%");
                    this.mView.setBackgroundResource(a.e.bg_anchor_view);
                } else {
                    this.gLB.setVisibility(8);
                    this.gLG.setVisibility(8);
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
        this.gKQ = arrayList;
    }
}
