package com.baidu.tieba.barselect.segment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.barselect.a.a;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.e;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import java.util.List;
/* loaded from: classes15.dex */
public class CardBasicLayout extends LinearLayout {
    protected f gPf;
    protected d gSQ;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bQH;
        this.gPf = fVar;
        if (this.gPf != null && this.gPf.bQH() != null && (bQH = this.gPf.bQH()) != null) {
            int status = bQH.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.gTi) {
                if (i == VoteCandidateCard.gTv) {
                    this.status = a.gTg;
                    this.gSQ = this.gPf.bQG();
                    return;
                }
                this.status = a.gTd;
                List<d> bQF = this.gPf.bQF();
                if (bQF != null && bQF.size() > i) {
                    this.gSQ = bQF.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.gTj) {
                if (i == VoteCandidateCard.gTv) {
                    this.status = a.gTf;
                    List<d> bQF2 = this.gPf.bQF();
                    if (bQF2 != null && bQF2.size() > 0) {
                        for (d dVar : bQF2) {
                            if (dVar.getRank() == 1) {
                                this.gSQ = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.gTe;
                List<d> bQF3 = this.gPf.bQF();
                if (bQF3 != null && bQF3.size() > i) {
                    this.gSQ = bQF3.get(i);
                    if (this.gSQ.getRank() == 1 && i == 0) {
                        this.status = a.gTf;
                    }
                }
            }
        }
    }
}
