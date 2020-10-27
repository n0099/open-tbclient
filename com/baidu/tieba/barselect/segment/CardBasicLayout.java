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
/* loaded from: classes21.dex */
public class CardBasicLayout extends LinearLayout {
    protected f hKp;
    protected d hOe;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e ckL;
        this.hKp = fVar;
        if (this.hKp != null && this.hKp.ckL() != null && (ckL = this.hKp.ckL()) != null) {
            int status = ckL.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hOw) {
                if (i == VoteCandidateCard.hOJ) {
                    this.status = a.hOu;
                    this.hOe = this.hKp.ckK();
                    return;
                }
                this.status = a.hOr;
                List<d> ckJ = this.hKp.ckJ();
                if (ckJ != null && ckJ.size() > i) {
                    this.hOe = ckJ.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hOx) {
                if (i == VoteCandidateCard.hOJ) {
                    this.status = a.hOt;
                    List<d> ckJ2 = this.hKp.ckJ();
                    if (ckJ2 != null && ckJ2.size() > 0) {
                        for (d dVar : ckJ2) {
                            if (dVar.getRank() == 1) {
                                this.hOe = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hOs;
                List<d> ckJ3 = this.hKp.ckJ();
                if (ckJ3 != null && ckJ3.size() > i) {
                    this.hOe = ckJ3.get(i);
                    if (this.hOe.getRank() == 1 && i == 0) {
                        this.status = a.hOt;
                    }
                }
            }
        }
    }
}
