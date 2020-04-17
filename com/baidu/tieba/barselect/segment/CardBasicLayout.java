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
    protected f ghD;
    protected d glr;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bDY;
        this.ghD = fVar;
        if (this.ghD != null && this.ghD.bDY() != null && (bDY = this.ghD.bDY()) != null) {
            int status = bDY.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.glK) {
                if (i == VoteCandidateCard.glX) {
                    this.status = a.glI;
                    this.glr = this.ghD.bDX();
                    return;
                }
                this.status = a.glF;
                List<d> bDW = this.ghD.bDW();
                if (bDW != null && bDW.size() > i) {
                    this.glr = bDW.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.glL) {
                if (i == VoteCandidateCard.glX) {
                    this.status = a.glH;
                    List<d> bDW2 = this.ghD.bDW();
                    if (bDW2 != null && bDW2.size() > 0) {
                        for (d dVar : bDW2) {
                            if (dVar.getRank() == 1) {
                                this.glr = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.glG;
                List<d> bDW3 = this.ghD.bDW();
                if (bDW3 != null && bDW3.size() > i) {
                    this.glr = bDW3.get(i);
                    if (this.glr.getRank() == 1 && i == 0) {
                        this.status = a.glH;
                    }
                }
            }
        }
    }
}
