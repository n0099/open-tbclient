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
    protected f hbV;
    protected d hfJ;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e caS;
        this.hbV = fVar;
        if (this.hbV != null && this.hbV.caS() != null && (caS = this.hbV.caS()) != null) {
            int status = caS.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hgb) {
                if (i == VoteCandidateCard.hgo) {
                    this.status = a.hfZ;
                    this.hfJ = this.hbV.caR();
                    return;
                }
                this.status = a.hfW;
                List<d> caQ = this.hbV.caQ();
                if (caQ != null && caQ.size() > i) {
                    this.hfJ = caQ.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hgc) {
                if (i == VoteCandidateCard.hgo) {
                    this.status = a.hfY;
                    List<d> caQ2 = this.hbV.caQ();
                    if (caQ2 != null && caQ2.size() > 0) {
                        for (d dVar : caQ2) {
                            if (dVar.getRank() == 1) {
                                this.hfJ = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hfX;
                List<d> caQ3 = this.hbV.caQ();
                if (caQ3 != null && caQ3.size() > i) {
                    this.hfJ = caQ3.get(i);
                    if (this.hfJ.getRank() == 1 && i == 0) {
                        this.status = a.hfY;
                    }
                }
            }
        }
    }
}
