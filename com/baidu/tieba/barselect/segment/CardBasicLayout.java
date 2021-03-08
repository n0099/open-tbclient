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
/* loaded from: classes7.dex */
public class CardBasicLayout extends LinearLayout {
    protected f ire;
    protected d iuP;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e crC;
        this.ire = fVar;
        if (this.ire != null && this.ire.crC() != null && (crC = this.ire.crC()) != null) {
            int status = crC.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.ivh) {
                if (i == VoteCandidateCard.ivu) {
                    this.status = a.ivf;
                    this.iuP = this.ire.crB();
                    return;
                }
                this.status = a.ivc;
                List<d> crA = this.ire.crA();
                if (crA != null && crA.size() > i) {
                    this.iuP = crA.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.ivi) {
                if (i == VoteCandidateCard.ivu) {
                    this.status = a.ive;
                    List<d> crA2 = this.ire.crA();
                    if (crA2 != null && crA2.size() > 0) {
                        for (d dVar : crA2) {
                            if (dVar.getRank() == 1) {
                                this.iuP = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.ivd;
                List<d> crA3 = this.ire.crA();
                if (crA3 != null && crA3.size() > i) {
                    this.iuP = crA3.get(i);
                    if (this.iuP.getRank() == 1 && i == 0) {
                        this.status = a.ive;
                    }
                }
            }
        }
    }
}
