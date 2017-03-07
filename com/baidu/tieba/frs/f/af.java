package com.baidu.tieba.frs.f;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class af {
    private TbPageContext ajF;
    private com.baidu.tbadk.core.view.o bsK;
    private ViewGroup cdl;
    private o.a cdm = new ag(this);

    public af(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajF = tbPageContext;
        this.cdl = viewGroup;
    }

    public void D(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.ajF != null && this.cdl != null) {
            boolean z = (bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null || !bjVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.sT() && bjVar.qJ() != null && !z) {
                if (this.bsK == null) {
                    this.bsK = new com.baidu.tbadk.core.view.o(this.ajF);
                    this.bsK.setId(w.h.negative_feedback_view);
                    this.bsK.wu();
                    this.bsK.setDefaultReasonArray(new String[]{this.ajF.getString(w.l.bad_quality), "", ""});
                    this.bsK.setEventCallback(this.cdm);
                    this.cdl.addView(this.bsK);
                }
                if (this.bsK.getVisibility() != 0) {
                    this.bsK.setVisibility(0);
                }
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.ci(bjVar.getTid());
                amVar.setFid(bjVar.getFid());
                amVar.a(bjVar.qJ());
                this.bsK.setData(amVar);
            } else {
                if (this.bsK != null && this.bsK.getVisibility() != 8) {
                    this.bsK.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds32);
            }
            if (this.cdl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdl.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cdl.setLayoutParams(layoutParams);
            }
            if (this.cdl.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cdl.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cdl.setLayoutParams(layoutParams2);
            }
            if (this.bsK != null) {
                this.bsK.ww();
            }
        }
    }

    public void tD() {
        if (this.bsK != null) {
            this.bsK.tD();
        }
    }
}
