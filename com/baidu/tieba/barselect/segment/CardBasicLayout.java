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
    protected f ibG;
    protected d ify;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e crc;
        this.ibG = fVar;
        if (this.ibG != null && this.ibG.crc() != null && (crc = this.ibG.crc()) != null) {
            int status = crc.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.ifQ) {
                if (i == VoteCandidateCard.igd) {
                    this.status = a.ifO;
                    this.ify = this.ibG.crb();
                    return;
                }
                this.status = a.ifL;
                List<d> cra = this.ibG.cra();
                if (cra != null && cra.size() > i) {
                    this.ify = cra.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.ifR) {
                if (i == VoteCandidateCard.igd) {
                    this.status = a.ifN;
                    List<d> cra2 = this.ibG.cra();
                    if (cra2 != null && cra2.size() > 0) {
                        for (d dVar : cra2) {
                            if (dVar.getRank() == 1) {
                                this.ify = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.ifM;
                List<d> cra3 = this.ibG.cra();
                if (cra3 != null && cra3.size() > i) {
                    this.ify = cra3.get(i);
                    if (this.ify.getRank() == 1 && i == 0) {
                        this.status = a.ifN;
                    }
                }
            }
        }
    }
}
