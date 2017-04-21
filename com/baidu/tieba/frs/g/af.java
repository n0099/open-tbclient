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
    private TbPageContext ajU;
    private com.baidu.tbadk.core.view.o buV;
    private ViewGroup ced;
    private o.a cee = new ag(this);

    public af(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajU = tbPageContext;
        this.ced = viewGroup;
    }

    public void A(bi biVar) {
        int i = 0;
        if (biVar != null && this.ajU != null && this.ced != null) {
            boolean z = (biVar.getAuthor() == null || biVar.getAuthor().getUserId() == null || !biVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (biVar.tr() && biVar.rg() != null && !z) {
                if (this.buV == null) {
                    this.buV = new com.baidu.tbadk.core.view.o(this.ajU);
                    this.buV.setId(w.h.negative_feedback_view);
                    this.buV.wQ();
                    this.buV.setDefaultReasonArray(new String[]{this.ajU.getString(w.l.bad_quality), "", ""});
                    this.buV.setEventCallback(this.cee);
                    this.ced.addView(this.buV);
                }
                if (this.buV.getVisibility() != 0) {
                    this.buV.setVisibility(0);
                }
                com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                alVar.cp(biVar.getTid());
                alVar.setFid(biVar.getFid());
                alVar.a(biVar.rg());
                this.buV.setData(alVar);
            } else {
                if (this.buV != null && this.buV.getVisibility() != 8) {
                    this.buV.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds32);
            }
            if (this.ced.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ced.getLayoutParams();
                layoutParams.rightMargin = i;
                this.ced.setLayoutParams(layoutParams);
            }
            if (this.ced.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ced.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.ced.setLayoutParams(layoutParams2);
            }
            if (this.buV != null) {
                this.buV.wS();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.buV != null) {
            this.buV.onChangeSkinType();
        }
    }
}
