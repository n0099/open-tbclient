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
/* loaded from: classes21.dex */
public class CardBasicLayout extends LinearLayout {
    protected d hBI;
    protected f hxT;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e chE;
        this.hxT = fVar;
        if (this.hxT != null && this.hxT.chE() != null && (chE = this.hxT.chE()) != null) {
            int status = chE.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hCa) {
                if (i == VoteCandidateCard.hCn) {
                    this.status = a.hBY;
                    this.hBI = this.hxT.chD();
                    return;
                }
                this.status = a.hBV;
                List<d> chC = this.hxT.chC();
                if (chC != null && chC.size() > i) {
                    this.hBI = chC.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hCb) {
                if (i == VoteCandidateCard.hCn) {
                    this.status = a.hBX;
                    List<d> chC2 = this.hxT.chC();
                    if (chC2 != null && chC2.size() > 0) {
                        for (d dVar : chC2) {
                            if (dVar.getRank() == 1) {
                                this.hBI = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hBW;
                List<d> chC3 = this.hxT.chC();
                if (chC3 != null && chC3.size() > i) {
                    this.hBI = chC3.get(i);
                    if (this.hBI.getRank() == 1 && i == 0) {
                        this.status = a.hBX;
                    }
                }
            }
        }
    }
}
