package com.baidu.tieba.frs.e;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ae {
    private TbPageContext ajr;
    private com.baidu.tbadk.core.view.o buS;
    private ViewGroup cbM;
    private o.a cbN = new af(this);
    private BdUniqueId mBdUniqueId;

    public ae(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajr = tbPageContext;
        this.cbM = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void F(bk bkVar) {
        int i = 0;
        if (bkVar != null && this.ajr != null && this.cbM != null) {
            boolean z = (bkVar.getAuthor() == null || bkVar.getAuthor().getUserId() == null || !bkVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bkVar.sB() && bkVar.qq() != null && !z) {
                if (this.buS == null) {
                    this.buS = new com.baidu.tbadk.core.view.o(this.ajr);
                    this.buS.setUniqueId(this.mBdUniqueId);
                    this.buS.setId(w.h.negative_feedback_view);
                    this.buS.wd();
                    this.buS.setLeftPadding((int) this.ajr.getResources().getDimension(w.f.ds60));
                    this.buS.setDefaultReasonArray(new String[]{this.ajr.getString(w.l.bad_quality), "", ""});
                    this.buS.setEventCallback(this.cbN);
                    this.cbM.addView(this.buS);
                }
                if (this.buS.getVisibility() != 0) {
                    this.buS.setVisibility(0);
                }
                com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                amVar.cp(bkVar.getTid());
                amVar.setFid(bkVar.getFid());
                amVar.a(bkVar.qq());
                this.buS.setData(amVar);
            } else {
                if (this.buS != null && this.buS.getVisibility() != 8) {
                    this.buS.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds32);
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
            if (this.buS != null) {
                this.buS.wf();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.buS != null) {
            this.buS.onChangeSkinType();
        }
    }
}
