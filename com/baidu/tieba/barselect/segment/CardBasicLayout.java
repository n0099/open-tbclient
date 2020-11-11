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
    protected f hQm;
    protected d hUb;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e cnn;
        this.hQm = fVar;
        if (this.hQm != null && this.hQm.cnn() != null && (cnn = this.hQm.cnn()) != null) {
            int status = cnn.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.hUt) {
                if (i == VoteCandidateCard.hUG) {
                    this.status = a.hUr;
                    this.hUb = this.hQm.cnm();
                    return;
                }
                this.status = a.hUo;
                List<d> cnl = this.hQm.cnl();
                if (cnl != null && cnl.size() > i) {
                    this.hUb = cnl.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.hUu) {
                if (i == VoteCandidateCard.hUG) {
                    this.status = a.hUq;
                    List<d> cnl2 = this.hQm.cnl();
                    if (cnl2 != null && cnl2.size() > 0) {
                        for (d dVar : cnl2) {
                            if (dVar.getRank() == 1) {
                                this.hUb = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.hUp;
                List<d> cnl3 = this.hQm.cnl();
                if (cnl3 != null && cnl3.size() > i) {
                    this.hUb = cnl3.get(i);
                    if (this.hUb.getRank() == 1 && i == 0) {
                        this.status = a.hUq;
                    }
                }
            }
        }
    }
}
