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
    protected f ijz;
    protected d inn;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e cqf;
        this.ijz = fVar;
        if (this.ijz != null && this.ijz.cqf() != null && (cqf = this.ijz.cqf()) != null) {
            int status = cqf.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.inG) {
                if (i == VoteCandidateCard.inT) {
                    this.status = a.inE;
                    this.inn = this.ijz.cqe();
                    return;
                }
                this.status = a.inB;
                List<d> cqd = this.ijz.cqd();
                if (cqd != null && cqd.size() > i) {
                    this.inn = cqd.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.inH) {
                if (i == VoteCandidateCard.inT) {
                    this.status = a.inD;
                    List<d> cqd2 = this.ijz.cqd();
                    if (cqd2 != null && cqd2.size() > 0) {
                        for (d dVar : cqd2) {
                            if (dVar.getRank() == 1) {
                                this.inn = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.inC;
                List<d> cqd3 = this.ijz.cqd();
                if (cqd3 != null && cqd3.size() > i) {
                    this.inn = cqd3.get(i);
                    if (this.inn.getRank() == 1 && i == 0) {
                        this.status = a.inD;
                    }
                }
            }
        }
    }
}
