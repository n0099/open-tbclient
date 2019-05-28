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
    protected f epO;
    protected d etE;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aWT;
        this.epO = fVar;
        if (this.epO != null && this.epO.aWT() != null && (aWT = this.epO.aWT()) != null) {
            int status = aWT.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.etX) {
                if (i == VoteCandidateCard.euh) {
                    this.status = a.etV;
                    this.etE = this.epO.aWS();
                    return;
                }
                this.status = a.etS;
                List<d> aWR = this.epO.aWR();
                if (aWR != null && aWR.size() > i) {
                    this.etE = aWR.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.etY) {
                if (i == VoteCandidateCard.euh) {
                    this.status = a.etU;
                    List<d> aWR2 = this.epO.aWR();
                    if (aWR2 != null && aWR2.size() > 0) {
                        for (d dVar : aWR2) {
                            if (dVar.getRank() == 1) {
                                this.etE = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.etT;
                List<d> aWR3 = this.epO.aWR();
                if (aWR3 != null && aWR3.size() > i) {
                    this.etE = aWR3.get(i);
                    if (this.etE.getRank() == 1 && i == 0) {
                        this.status = a.etU;
                    }
                }
            }
        }
    }
}
