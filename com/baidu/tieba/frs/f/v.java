package com.baidu.tieba.frs.f;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class v {
    private TbPageContext ajP;
    private com.baidu.tbadk.core.view.o bAy;
    private ViewGroup cqa;
    private o.a cqb = new w(this);
    private BdUniqueId mBdUniqueId;

    public v(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajP = tbPageContext;
        this.cqa = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void L(bm bmVar) {
        int i = 0;
        if (bmVar != null && this.ajP != null && this.cqa != null) {
            boolean z = (bmVar.getAuthor() == null || bmVar.getAuthor().getUserId() == null || !bmVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bmVar.su() && bmVar.qj() != null && !z) {
                if (this.bAy == null) {
                    this.bAy = new com.baidu.tbadk.core.view.o(this.ajP);
                    this.bAy.setUniqueId(this.mBdUniqueId);
                    this.bAy.setId(w.h.negative_feedback_view);
                    this.bAy.wr();
                    this.bAy.setLeftPadding((int) this.ajP.getResources().getDimension(w.f.ds60));
                    this.bAy.setDefaultReasonArray(new String[]{this.ajP.getString(w.l.bad_quality), "", ""});
                    this.bAy.setEventCallback(this.cqb);
                    this.cqa.addView(this.bAy);
                }
                if (this.bAy.getVisibility() != 0) {
                    this.bAy.setVisibility(0);
                }
                ao aoVar = new ao();
                aoVar.cu(bmVar.getTid());
                aoVar.setFid(bmVar.getFid());
                aoVar.a(bmVar.qj());
                this.bAy.setData(aoVar);
            } else {
                if (this.bAy != null && this.bAy.getVisibility() != 8) {
                    this.bAy.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds32);
            }
            if (this.cqa.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqa.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cqa.setLayoutParams(layoutParams);
            }
            if (this.cqa.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cqa.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cqa.setLayoutParams(layoutParams2);
            }
            if (this.bAy != null) {
                this.bAy.wt();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bAy != null) {
            this.bAy.onChangeSkinType();
        }
    }
}
