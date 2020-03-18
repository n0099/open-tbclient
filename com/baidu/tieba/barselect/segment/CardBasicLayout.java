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
    protected f fDc;
    protected d fGM;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e buo;
        this.fDc = fVar;
        if (this.fDc != null && this.fDc.buo() != null && (buo = this.fDc.buo()) != null) {
            int status = buo.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fHf) {
                if (i == VoteCandidateCard.fHp) {
                    this.status = a.fHd;
                    this.fGM = this.fDc.bun();
                    return;
                }
                this.status = a.fHa;
                List<d> bum = this.fDc.bum();
                if (bum != null && bum.size() > i) {
                    this.fGM = bum.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fHg) {
                if (i == VoteCandidateCard.fHp) {
                    this.status = a.fHc;
                    List<d> bum2 = this.fDc.bum();
                    if (bum2 != null && bum2.size() > 0) {
                        for (d dVar : bum2) {
                            if (dVar.getRank() == 1) {
                                this.fGM = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fHb;
                List<d> bum3 = this.fDc.bum();
                if (bum3 != null && bum3.size() > i) {
                    this.fGM = bum3.get(i);
                    if (this.fGM.getRank() == 1 && i == 0) {
                        this.status = a.fHc;
                    }
                }
            }
        }
    }
}
