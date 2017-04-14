package com.baidu.tieba.frs.g;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class af {
    private TbPageContext ajT;
    private com.baidu.tbadk.core.view.o bsC;
    private ViewGroup cbM;
    private o.a cbN = new ag(this);

    public af(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajT = tbPageContext;
        this.cbM = viewGroup;
    }

    public void A(bi biVar) {
        int i = 0;
        if (biVar != null && this.ajT != null && this.cbM != null) {
            boolean z = (biVar.getAuthor() == null || biVar.getAuthor().getUserId() == null || !biVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (biVar.tr() && biVar.rg() != null && !z) {
                if (this.bsC == null) {
                    this.bsC = new com.baidu.tbadk.core.view.o(this.ajT);
                    this.bsC.setId(w.h.negative_feedback_view);
                    this.bsC.wQ();
                    this.bsC.setDefaultReasonArray(new String[]{this.ajT.getString(w.l.bad_quality), "", ""});
                    this.bsC.setEventCallback(this.cbN);
                    this.cbM.addView(this.bsC);
                }
                if (this.bsC.getVisibility() != 0) {
                    this.bsC.setVisibility(0);
                }
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.cp(biVar.getTid());
                alVar.setFid(biVar.getFid());
                alVar.a(biVar.rg());
                this.bsC.setData(alVar);
            } else {
                if (this.bsC != null && this.bsC.getVisibility() != 8) {
                    this.bsC.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds32);
            }
            if (this.cbM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbM.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cbM.setLayoutParams(layoutParams);
            }
            if (this.cbM.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cbM.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cbM.setLayoutParams(layoutParams2);
            }
            if (this.bsC != null) {
                this.bsC.wS();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bsC != null) {
            this.bsC.onChangeSkinType();
        }
    }
}
