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
    protected f gJz;
    protected d gNk;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bNw;
        this.gJz = fVar;
        if (this.gJz != null && this.gJz.bNw() != null && (bNw = this.gJz.bNw()) != null) {
            int status = bNw.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.gNC) {
                if (i == VoteCandidateCard.gNP) {
                    this.status = a.gNA;
                    this.gNk = this.gJz.bNv();
                    return;
                }
                this.status = a.gNx;
                List<d> bNu = this.gJz.bNu();
                if (bNu != null && bNu.size() > i) {
                    this.gNk = bNu.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.gND) {
                if (i == VoteCandidateCard.gNP) {
                    this.status = a.gNz;
                    List<d> bNu2 = this.gJz.bNu();
                    if (bNu2 != null && bNu2.size() > 0) {
                        for (d dVar : bNu2) {
                            if (dVar.getRank() == 1) {
                                this.gNk = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.gNy;
                List<d> bNu3 = this.gJz.bNu();
                if (bNu3 != null && bNu3.size() > i) {
                    this.gNk = bNu3.get(i);
                    if (this.gNk.getRank() == 1 && i == 0) {
                        this.status = a.gNz;
                    }
                }
            }
        }
    }
}
