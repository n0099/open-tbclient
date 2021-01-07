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
        e ctX;
        this.ioi = fVar;
        if (this.ioi != null && this.ioi.ctX() != null && (ctX = this.ioi.ctX()) != null) {
            int status = ctX.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.isn) {
                if (i == VoteCandidateCard.isA) {
                    this.status = a.isl;
                    this.irV = this.ioi.ctW();
                    return;
                }
                this.status = a.isi;
                List<d> ctV = this.ioi.ctV();
                if (ctV != null && ctV.size() > i) {
                    this.irV = ctV.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.iso) {
                if (i == VoteCandidateCard.isA) {
                    this.status = a.isk;
                    List<d> ctV2 = this.ioi.ctV();
                    if (ctV2 != null && ctV2.size() > 0) {
                        for (d dVar : ctV2) {
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
                List<d> ctV3 = this.ioi.ctV();
                if (ctV3 != null && ctV3.size() > i) {
                    this.irV = ctV3.get(i);
                    if (this.irV.getRank() == 1 && i == 0) {
                        this.status = a.isk;
                    }
                }
            }
        }
    }
}
