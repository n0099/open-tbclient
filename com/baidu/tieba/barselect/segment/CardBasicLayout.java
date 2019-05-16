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
    protected f epN;
    protected d etD;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aWQ;
        this.epN = fVar;
        if (this.epN != null && this.epN.aWQ() != null && (aWQ = this.epN.aWQ()) != null) {
            int status = aWQ.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.etW) {
                if (i == VoteCandidateCard.eug) {
                    this.status = a.etU;
                    this.etD = this.epN.aWP();
                    return;
                }
                this.status = a.etR;
                List<d> aWO = this.epN.aWO();
                if (aWO != null && aWO.size() > i) {
                    this.etD = aWO.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.etX) {
                if (i == VoteCandidateCard.eug) {
                    this.status = a.etT;
                    List<d> aWO2 = this.epN.aWO();
                    if (aWO2 != null && aWO2.size() > 0) {
                        for (d dVar : aWO2) {
                            if (dVar.getRank() == 1) {
                                this.etD = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.etS;
                List<d> aWO3 = this.epN.aWO();
                if (aWO3 != null && aWO3.size() > i) {
                    this.etD = aWO3.get(i);
                    if (this.etD.getRank() == 1 && i == 0) {
                        this.status = a.etT;
                    }
                }
            }
        }
    }
}
