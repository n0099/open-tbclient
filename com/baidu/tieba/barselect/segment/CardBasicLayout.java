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
    protected d eAt;
    protected f ewD;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aZv;
        this.ewD = fVar;
        if (this.ewD != null && this.ewD.aZv() != null && (aZv = this.ewD.aZv()) != null) {
            int status = aZv.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.eAM) {
                if (i == VoteCandidateCard.eAW) {
                    this.status = a.eAK;
                    this.eAt = this.ewD.aZu();
                    return;
                }
                this.status = a.eAH;
                List<d> aZt = this.ewD.aZt();
                if (aZt != null && aZt.size() > i) {
                    this.eAt = aZt.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.eAN) {
                if (i == VoteCandidateCard.eAW) {
                    this.status = a.eAJ;
                    List<d> aZt2 = this.ewD.aZt();
                    if (aZt2 != null && aZt2.size() > 0) {
                        for (d dVar : aZt2) {
                            if (dVar.getRank() == 1) {
                                this.eAt = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.eAI;
                List<d> aZt3 = this.ewD.aZt();
                if (aZt3 != null && aZt3.size() > i) {
                    this.eAt = aZt3.get(i);
                    if (this.eAt.getRank() == 1 && i == 0) {
                        this.status = a.eAJ;
                    }
                }
            }
        }
    }
}
