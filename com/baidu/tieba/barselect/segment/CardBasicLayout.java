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
    protected d gAy;
    protected f gwL;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bKq;
        this.gwL = fVar;
        if (this.gwL != null && this.gwL.bKq() != null && (bKq = this.gwL.bKq()) != null) {
            int status = bKq.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.gAR) {
                if (i == VoteCandidateCard.gBe) {
                    this.status = a.gAP;
                    this.gAy = this.gwL.bKp();
                    return;
                }
                this.status = a.gAM;
                List<d> bKo = this.gwL.bKo();
                if (bKo != null && bKo.size() > i) {
                    this.gAy = bKo.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.gAS) {
                if (i == VoteCandidateCard.gBe) {
                    this.status = a.gAO;
                    List<d> bKo2 = this.gwL.bKo();
                    if (bKo2 != null && bKo2.size() > 0) {
                        for (d dVar : bKo2) {
                            if (dVar.getRank() == 1) {
                                this.gAy = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.gAN;
                List<d> bKo3 = this.gwL.bKo();
                if (bKo3 != null && bKo3.size() > i) {
                    this.gAy = bKo3.get(i);
                    if (this.gAy.getRank() == 1 && i == 0) {
                        this.status = a.gAO;
                    }
                }
            }
        }
    }
}
