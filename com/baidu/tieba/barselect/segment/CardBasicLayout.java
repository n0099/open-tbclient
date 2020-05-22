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
/* loaded from: classes8.dex */
public class CardBasicLayout extends LinearLayout {
    protected d gAn;
    protected f gwA;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bKo;
        this.gwA = fVar;
        if (this.gwA != null && this.gwA.bKo() != null && (bKo = this.gwA.bKo()) != null) {
            int status = bKo.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.gAG) {
                if (i == VoteCandidateCard.gAT) {
                    this.status = a.gAE;
                    this.gAn = this.gwA.bKn();
                    return;
                }
                this.status = a.gAB;
                List<d> bKm = this.gwA.bKm();
                if (bKm != null && bKm.size() > i) {
                    this.gAn = bKm.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.gAH) {
                if (i == VoteCandidateCard.gAT) {
                    this.status = a.gAD;
                    List<d> bKm2 = this.gwA.bKm();
                    if (bKm2 != null && bKm2.size() > 0) {
                        for (d dVar : bKm2) {
                            if (dVar.getRank() == 1) {
                                this.gAn = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.gAC;
                List<d> bKm3 = this.gwA.bKm();
                if (bKm3 != null && bKm3.size() > i) {
                    this.gAn = bKm3.get(i);
                    if (this.gAn.getRank() == 1 && i == 0) {
                        this.status = a.gAD;
                    }
                }
            }
        }
    }
}
