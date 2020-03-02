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
    protected f fCh;
    protected d fFR;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bui;
        this.fCh = fVar;
        if (this.fCh != null && this.fCh.bui() != null && (bui = this.fCh.bui()) != null) {
            int status = bui.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.fGk) {
                if (i == VoteCandidateCard.fGu) {
                    this.status = a.fGi;
                    this.fFR = this.fCh.buh();
                    return;
                }
                this.status = a.fGf;
                List<d> bug = this.fCh.bug();
                if (bug != null && bug.size() > i) {
                    this.fFR = bug.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.fGl) {
                if (i == VoteCandidateCard.fGu) {
                    this.status = a.fGh;
                    List<d> bug2 = this.fCh.bug();
                    if (bug2 != null && bug2.size() > 0) {
                        for (d dVar : bug2) {
                            if (dVar.getRank() == 1) {
                                this.fFR = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.fGg;
                List<d> bug3 = this.fCh.bug();
                if (bug3 != null && bug3.size() > i) {
                    this.fFR = bug3.get(i);
                    if (this.fFR.getRank() == 1 && i == 0) {
                        this.status = a.fGh;
                    }
                }
            }
        }
    }
}
