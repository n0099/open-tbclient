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
/* loaded from: classes20.dex */
public class CardBasicLayout extends LinearLayout {
    protected f hQM;
    protected d hUB;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e cmP;
        this.hQM = fVar;
        if (this.hQM != null && this.hQM.cmP() != null && (cmP = this.hQM.cmP()) != null) {
            int status = cmP.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hUT) {
                if (i == VoteCandidateCard.hVg) {
                    this.status = a.hUR;
                    this.hUB = this.hQM.cmO();
                    return;
                }
                this.status = a.hUO;
                List<d> cmN = this.hQM.cmN();
                if (cmN != null && cmN.size() > i) {
                    this.hUB = cmN.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hUU) {
                if (i == VoteCandidateCard.hVg) {
                    this.status = a.hUQ;
                    List<d> cmN2 = this.hQM.cmN();
                    if (cmN2 != null && cmN2.size() > 0) {
                        for (d dVar : cmN2) {
                            if (dVar.getRank() == 1) {
                                this.hUB = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hUP;
                List<d> cmN3 = this.hQM.cmN();
                if (cmN3 != null && cmN3.size() > i) {
                    this.hUB = cmN3.get(i);
                    if (this.hUB.getRank() == 1 && i == 0) {
                        this.status = a.hUQ;
                    }
                }
            }
        }
    }
}
