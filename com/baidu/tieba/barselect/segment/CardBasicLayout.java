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
    protected f hbZ;
    protected d hfN;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e caT;
        this.hbZ = fVar;
        if (this.hbZ != null && this.hbZ.caT() != null && (caT = this.hbZ.caT()) != null) {
            int status = caT.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hgf) {
                if (i == VoteCandidateCard.hgs) {
                    this.status = a.hgd;
                    this.hfN = this.hbZ.caS();
                    return;
                }
                this.status = a.hga;
                List<d> caR = this.hbZ.caR();
                if (caR != null && caR.size() > i) {
                    this.hfN = caR.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hgg) {
                if (i == VoteCandidateCard.hgs) {
                    this.status = a.hgc;
                    List<d> caR2 = this.hbZ.caR();
                    if (caR2 != null && caR2.size() > 0) {
                        for (d dVar : caR2) {
                            if (dVar.getRank() == 1) {
                                this.hfN = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hgb;
                List<d> caR3 = this.hbZ.caR();
                if (caR3 != null && caR3.size() > i) {
                    this.hfN = caR3.get(i);
                    if (this.hfN.getRank() == 1 && i == 0) {
                        this.status = a.hgc;
                    }
                }
            }
        }
    }
}
