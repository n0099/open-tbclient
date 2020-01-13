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
/* loaded from: classes6.dex */
public class CardBasicLayout extends LinearLayout {
    protected d fDs;
    protected f fzH;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bsC;
        this.fzH = fVar;
        if (this.fzH != null && this.fzH.bsC() != null && (bsC = this.fzH.bsC()) != null) {
            int status = bsC.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fDL) {
                if (i == VoteCandidateCard.fDV) {
                    this.status = a.fDJ;
                    this.fDs = this.fzH.bsB();
                    return;
                }
                this.status = a.fDG;
                List<d> bsA = this.fzH.bsA();
                if (bsA != null && bsA.size() > i) {
                    this.fDs = bsA.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fDM) {
                if (i == VoteCandidateCard.fDV) {
                    this.status = a.fDI;
                    List<d> bsA2 = this.fzH.bsA();
                    if (bsA2 != null && bsA2.size() > 0) {
                        for (d dVar : bsA2) {
                            if (dVar.getRank() == 1) {
                                this.fDs = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fDH;
                List<d> bsA3 = this.fzH.bsA();
                if (bsA3 != null && bsA3.size() > i) {
                    this.fDs = bsA3.get(i);
                    if (this.fDs.getRank() == 1 && i == 0) {
                        this.status = a.fDI;
                    }
                }
            }
        }
    }
}
