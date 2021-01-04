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
    protected f ioi;
    protected d irV;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e ctW;
        this.ioi = fVar;
        if (this.ioi != null && this.ioi.ctW() != null && (ctW = this.ioi.ctW()) != null) {
            int status = ctW.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.isn) {
                if (i == VoteCandidateCard.isA) {
                    this.status = a.isl;
                    this.irV = this.ioi.ctV();
                    return;
                }
                this.status = a.isi;
                List<d> ctU = this.ioi.ctU();
                if (ctU != null && ctU.size() > i) {
                    this.irV = ctU.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.iso) {
                if (i == VoteCandidateCard.isA) {
                    this.status = a.isk;
                    List<d> ctU2 = this.ioi.ctU();
                    if (ctU2 != null && ctU2.size() > 0) {
                        for (d dVar : ctU2) {
                            if (dVar.getRank() == 1) {
                                this.irV = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.isj;
                List<d> ctU3 = this.ioi.ctU();
                if (ctU3 != null && ctU3.size() > i) {
                    this.irV = ctU3.get(i);
                    if (this.irV.getRank() == 1 && i == 0) {
                        this.status = a.isk;
                    }
                }
            }
        }
    }
}
