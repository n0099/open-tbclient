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
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    protected f euT;
    protected d eyK;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aYR;
        this.euT = fVar;
        if (this.euT != null && this.euT.aYR() != null && (aYR = this.euT.aYR()) != null) {
            int status = aYR.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.ezd) {
                if (i == VoteCandidateCard.ezn) {
                    this.status = a.ezb;
                    this.eyK = this.euT.aYQ();
                    return;
                }
                this.status = a.eyY;
                List<d> aYP = this.euT.aYP();
                if (aYP != null && aYP.size() > i) {
                    this.eyK = aYP.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.eze) {
                if (i == VoteCandidateCard.ezn) {
                    this.status = a.eza;
                    List<d> aYP2 = this.euT.aYP();
                    if (aYP2 != null && aYP2.size() > 0) {
                        for (d dVar : aYP2) {
                            if (dVar.getRank() == 1) {
                                this.eyK = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.eyZ;
                List<d> aYP3 = this.euT.aYP();
                if (aYP3 != null && aYP3.size() > i) {
                    this.eyK = aYP3.get(i);
                    if (this.eyK.getRank() == 1 && i == 0) {
                        this.status = a.eza;
                    }
                }
            }
        }
    }
}
