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
/* loaded from: classes8.dex */
public class CardBasicLayout extends LinearLayout {
    protected f fCf;
    protected d fFP;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bug;
        this.fCf = fVar;
        if (this.fCf != null && this.fCf.bug() != null && (bug = this.fCf.bug()) != null) {
            int status = bug.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fGi) {
                if (i == VoteCandidateCard.fGs) {
                    this.status = a.fGg;
                    this.fFP = this.fCf.buf();
                    return;
                }
                this.status = a.fGd;
                List<d> bue = this.fCf.bue();
                if (bue != null && bue.size() > i) {
                    this.fFP = bue.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fGj) {
                if (i == VoteCandidateCard.fGs) {
                    this.status = a.fGf;
                    List<d> bue2 = this.fCf.bue();
                    if (bue2 != null && bue2.size() > 0) {
                        for (d dVar : bue2) {
                            if (dVar.getRank() == 1) {
                                this.fFP = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fGe;
                List<d> bue3 = this.fCf.bue();
                if (bue3 != null && bue3.size() > i) {
                    this.fFP = bue3.get(i);
                    if (this.fFP.getRank() == 1 && i == 0) {
                        this.status = a.fGf;
                    }
                }
            }
        }
    }
}
