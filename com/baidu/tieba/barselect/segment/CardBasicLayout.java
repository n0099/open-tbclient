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
    protected f euM;
    protected d eyD;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aYP;
        this.euM = fVar;
        if (this.euM != null && this.euM.aYP() != null && (aYP = this.euM.aYP()) != null) {
            int status = aYP.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.eyW) {
                if (i == VoteCandidateCard.ezg) {
                    this.status = a.eyU;
                    this.eyD = this.euM.aYO();
                    return;
                }
                this.status = a.eyR;
                List<d> aYN = this.euM.aYN();
                if (aYN != null && aYN.size() > i) {
                    this.eyD = aYN.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.eyX) {
                if (i == VoteCandidateCard.ezg) {
                    this.status = a.eyT;
                    List<d> aYN2 = this.euM.aYN();
                    if (aYN2 != null && aYN2.size() > 0) {
                        for (d dVar : aYN2) {
                            if (dVar.getRank() == 1) {
                                this.eyD = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.eyS;
                List<d> aYN3 = this.euM.aYN();
                if (aYN3 != null && aYN3.size() > i) {
                    this.eyD = aYN3.get(i);
                    if (this.eyD.getRank() == 1 && i == 0) {
                        this.status = a.eyT;
                    }
                }
            }
        }
    }
}
