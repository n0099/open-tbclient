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
    protected f hiY;
    protected d hmO;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e cei;
        this.hiY = fVar;
        if (this.hiY != null && this.hiY.cei() != null && (cei = this.hiY.cei()) != null) {
            int status = cei.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hng) {
                if (i == VoteCandidateCard.hnt) {
                    this.status = a.hne;
                    this.hmO = this.hiY.ceh();
                    return;
                }
                this.status = a.hnb;
                List<d> ceg = this.hiY.ceg();
                if (ceg != null && ceg.size() > i) {
                    this.hmO = ceg.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hnh) {
                if (i == VoteCandidateCard.hnt) {
                    this.status = a.hnd;
                    List<d> ceg2 = this.hiY.ceg();
                    if (ceg2 != null && ceg2.size() > 0) {
                        for (d dVar : ceg2) {
                            if (dVar.getRank() == 1) {
                                this.hmO = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hnc;
                List<d> ceg3 = this.hiY.ceg();
                if (ceg3 != null && ceg3.size() > i) {
                    this.hmO = ceg3.get(i);
                    if (this.hmO.getRank() == 1 && i == 0) {
                        this.status = a.hnd;
                    }
                }
            }
        }
    }
}
