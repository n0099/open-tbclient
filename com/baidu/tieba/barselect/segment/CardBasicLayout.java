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
    protected f eEy;
    protected d eIk;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e aZw;
        this.eEy = fVar;
        if (this.eEy != null && this.eEy.aZw() != null && (aZw = this.eEy.aZw()) != null) {
            int status = aZw.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.eID) {
                if (i == VoteCandidateCard.eIN) {
                    this.status = a.eIB;
                    this.eIk = this.eEy.aZv();
                    return;
                }
                this.status = a.eIy;
                List<d> aZu = this.eEy.aZu();
                if (aZu != null && aZu.size() > i) {
                    this.eIk = aZu.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.eIE) {
                if (i == VoteCandidateCard.eIN) {
                    this.status = a.eIA;
                    List<d> aZu2 = this.eEy.aZu();
                    if (aZu2 != null && aZu2.size() > 0) {
                        for (d dVar : aZu2) {
                            if (dVar.getRank() == 1) {
                                this.eIk = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.eIz;
                List<d> aZu3 = this.eEy.aZu();
                if (aZu3 != null && aZu3.size() > i) {
                    this.eIk = aZu3.get(i);
                    if (this.eIk.getRank() == 1 && i == 0) {
                        this.status = a.eIA;
                    }
                }
            }
        }
    }
}
