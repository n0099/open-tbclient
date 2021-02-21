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
    protected f ipv;
    protected d itg;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e crw;
        this.ipv = fVar;
        if (this.ipv != null && this.ipv.crw() != null && (crw = this.ipv.crw()) != null) {
            int status = crw.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.ity) {
                if (i == VoteCandidateCard.itL) {
                    this.status = a.itw;
                    this.itg = this.ipv.crv();
                    return;
                }
                this.status = a.itt;
                List<d> cru = this.ipv.cru();
                if (cru != null && cru.size() > i) {
                    this.itg = cru.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.itz) {
                if (i == VoteCandidateCard.itL) {
                    this.status = a.itv;
                    List<d> cru2 = this.ipv.cru();
                    if (cru2 != null && cru2.size() > 0) {
                        for (d dVar : cru2) {
                            if (dVar.getRank() == 1) {
                                this.itg = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.itu;
                List<d> cru3 = this.ipv.cru();
                if (cru3 != null && cru3.size() > i) {
                    this.itg = cru3.get(i);
                    if (this.itg.getRank() == 1 && i == 0) {
                        this.status = a.itv;
                    }
                }
            }
        }
    }
}
