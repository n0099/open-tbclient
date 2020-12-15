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
    protected f ibI;
    protected d ifA;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e crd;
        this.ibI = fVar;
        if (this.ibI != null && this.ibI.crd() != null && (crd = this.ibI.crd()) != null) {
            int status = crd.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.ifS) {
                if (i == VoteCandidateCard.igf) {
                    this.status = a.ifQ;
                    this.ifA = this.ibI.crc();
                    return;
                }
                this.status = a.ifN;
                List<d> crb = this.ibI.crb();
                if (crb != null && crb.size() > i) {
                    this.ifA = crb.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.ifT) {
                if (i == VoteCandidateCard.igf) {
                    this.status = a.ifP;
                    List<d> crb2 = this.ibI.crb();
                    if (crb2 != null && crb2.size() > 0) {
                        for (d dVar : crb2) {
                            if (dVar.getRank() == 1) {
                                this.ifA = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.ifO;
                List<d> crb3 = this.ibI.crb();
                if (crb3 != null && crb3.size() > i) {
                    this.ifA = crb3.get(i);
                    if (this.ifA.getRank() == 1 && i == 0) {
                        this.status = a.ifP;
                    }
                }
            }
        }
    }
}
