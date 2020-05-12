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
    protected f ghJ;
    protected d glx;
    public int status;

    public CardBasicLayout(Context context) {
        this(context, null);
    }

    public CardBasicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
    }

    public void setData(int i, f fVar) {
        e bDX;
        this.ghJ = fVar;
        if (this.ghJ != null && this.ghJ.bDX() != null && (bDX = this.ghJ.bDX()) != null) {
            int status = bDX.getStatus();
            if (status == com.baidu.tieba.barselect.a.d.glQ) {
                if (i == VoteCandidateCard.gmd) {
                    this.status = a.glO;
                    this.glx = this.ghJ.bDW();
                    return;
                }
                this.status = a.glL;
                List<d> bDV = this.ghJ.bDV();
                if (bDV != null && bDV.size() > i) {
                    this.glx = bDV.get(i);
                }
            } else if (status == com.baidu.tieba.barselect.a.d.glR) {
                if (i == VoteCandidateCard.gmd) {
                    this.status = a.glN;
                    List<d> bDV2 = this.ghJ.bDV();
                    if (bDV2 != null && bDV2.size() > 0) {
                        for (d dVar : bDV2) {
                            if (dVar.getRank() == 1) {
                                this.glx = dVar;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.status = a.glM;
                List<d> bDV3 = this.ghJ.bDV();
                if (bDV3 != null && bDV3.size() > i) {
                    this.glx = bDV3.get(i);
                    if (this.glx.getRank() == 1 && i == 0) {
                        this.status = a.glN;
                    }
                }
            }
        }
    }
}
