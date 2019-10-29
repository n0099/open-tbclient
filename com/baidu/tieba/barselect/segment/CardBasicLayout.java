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
/* loaded from: classes3.dex */
public class CardBasicLayout extends LinearLayout {
    protected f eFp;
    protected d eJb;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aZy;
        this.eFp = fVar;
        if (this.eFp != null && this.eFp.aZy() != null && (aZy = this.eFp.aZy()) != null) {
            int status = aZy.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.eJu) {
                if (i == VoteCandidateCard.eJE) {
                    this.status = a.eJs;
                    this.eJb = this.eFp.aZx();
                    return;
                }
                this.status = a.eJp;
                List<d> aZw = this.eFp.aZw();
                if (aZw != null && aZw.size() > i) {
                    this.eJb = aZw.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.eJv) {
                if (i == VoteCandidateCard.eJE) {
                    this.status = a.eJr;
                    List<d> aZw2 = this.eFp.aZw();
                    if (aZw2 != null && aZw2.size() > 0) {
                        for (d dVar : aZw2) {
                            if (dVar.getRank() == 1) {
                                this.eJb = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.eJq;
                List<d> aZw3 = this.eFp.aZw();
                if (aZw3 != null && aZw3.size() > i) {
                    this.eJb = aZw3.get(i);
                    if (this.eJb.getRank() == 1 && i == 0) {
                        this.status = a.eJr;
                    }
                }
            }
        }
    }
}
