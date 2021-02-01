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
    protected f iph;
    protected d isS;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e crp;
        this.iph = fVar;
        if (this.iph != null && this.iph.crp() != null && (crp = this.iph.crp()) != null) {
            int status = crp.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.itk) {
                if (i == VoteCandidateCard.itx) {
                    this.status = a.iti;
                    this.isS = this.iph.cro();
                    return;
                }
                this.status = a.itf;
                List<d> crn = this.iph.crn();
                if (crn != null && crn.size() > i) {
                    this.isS = crn.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.itl) {
                if (i == VoteCandidateCard.itx) {
                    this.status = a.ith;
                    List<d> crn2 = this.iph.crn();
                    if (crn2 != null && crn2.size() > 0) {
                        for (d dVar : crn2) {
                            if (dVar.getRank() == 1) {
                                this.isS = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.itg;
                List<d> crn3 = this.iph.crn();
                if (crn3 != null && crn3.size() > i) {
                    this.isS = crn3.get(i);
                    if (this.isS.getRank() == 1 && i == 0) {
                        this.status = a.ith;
                    }
                }
            }
        }
    }
}
