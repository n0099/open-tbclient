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
/* loaded from: classes5.dex */
public class CardBasicLayout extends LinearLayout {
    protected d fAh;
    protected f fww;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e brA;
        this.fww = fVar;
        if (this.fww != null && this.fww.brA() != null && (brA = this.fww.brA()) != null) {
            int status = brA.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fAA) {
                if (i == VoteCandidateCard.fAK) {
                    this.status = a.fAy;
                    this.fAh = this.fww.brz();
                    return;
                }
                this.status = a.fAv;
                List<d> bry = this.fww.bry();
                if (bry != null && bry.size() > i) {
                    this.fAh = bry.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fAB) {
                if (i == VoteCandidateCard.fAK) {
                    this.status = a.fAx;
                    List<d> bry2 = this.fww.bry();
                    if (bry2 != null && bry2.size() > 0) {
                        for (d dVar : bry2) {
                            if (dVar.getRank() == 1) {
                                this.fAh = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fAw;
                List<d> bry3 = this.fww.bry();
                if (bry3 != null && bry3.size() > i) {
                    this.fAh = bry3.get(i);
                    if (this.fAh.getRank() == 1 && i == 0) {
                        this.status = a.fAx;
                    }
                }
            }
        }
    }
}
