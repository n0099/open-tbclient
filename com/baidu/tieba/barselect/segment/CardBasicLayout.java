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
    protected f fCu;
    protected d fGe;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e buj;
        this.fCu = fVar;
        if (this.fCu != null && this.fCu.buj() != null && (buj = this.fCu.buj()) != null) {
            int status = buj.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fGx) {
                if (i == VoteCandidateCard.fGH) {
                    this.status = a.fGv;
                    this.fGe = this.fCu.bui();
                    return;
                }
                this.status = a.fGs;
                List<d> buh = this.fCu.buh();
                if (buh != null && buh.size() > i) {
                    this.fGe = buh.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fGy) {
                if (i == VoteCandidateCard.fGH) {
                    this.status = a.fGu;
                    List<d> buh2 = this.fCu.buh();
                    if (buh2 != null && buh2.size() > 0) {
                        for (d dVar : buh2) {
                            if (dVar.getRank() == 1) {
                                this.fGe = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fGt;
                List<d> buh3 = this.fCu.buh();
                if (buh3 != null && buh3.size() > i) {
                    this.fGe = buh3.get(i);
                    if (this.fGe.getRank() == 1 && i == 0) {
                        this.status = a.fGu;
                    }
                }
            }
        }
    }
}
