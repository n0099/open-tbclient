package com.baidu.tieba.frs.f;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ae {
    private TbPageContext ajh;
    private com.baidu.tbadk.core.view.o bzF;
    private ViewGroup chZ;
    private o.a cia = new af(this);
    private BdUniqueId mBdUniqueId;

    public ae(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.ajh = tbPageContext;
        this.chZ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void K(bl blVar) {
        int i = 0;
        if (blVar != null && this.ajh != null && this.chZ != null) {
            boolean z = (blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || !blVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (blVar.sw() && blVar.qm() != null && !z) {
                if (this.bzF == null) {
                    this.bzF = new com.baidu.tbadk.core.view.o(this.ajh);
                    this.bzF.setUniqueId(this.mBdUniqueId);
                    this.bzF.setId(w.h.negative_feedback_view);
                    this.bzF.wa();
                    this.bzF.setLeftPadding((int) this.ajh.getResources().getDimension(w.f.ds60));
                    this.bzF.setDefaultReasonArray(new String[]{this.ajh.getString(w.l.bad_quality), "", ""});
                    this.bzF.setEventCallback(this.cia);
                    this.chZ.addView(this.bzF);
                }
                if (this.bzF.getVisibility() != 0) {
                    this.bzF.setVisibility(0);
                }
                an anVar = new an();
                anVar.co(blVar.getTid());
                anVar.setFid(blVar.getFid());
                anVar.a(blVar.qm());
                this.bzF.setData(anVar);
            } else {
                if (this.bzF != null && this.bzF.getVisibility() != 8) {
                    this.bzF.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds32);
            }
            if (this.chZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.chZ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.chZ.setLayoutParams(layoutParams);
            }
            if (this.chZ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.chZ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.chZ.setLayoutParams(layoutParams2);
            }
            if (this.bzF != null) {
                this.bzF.wc();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bzF != null) {
            this.bzF.onChangeSkinType();
        }
    }
}
