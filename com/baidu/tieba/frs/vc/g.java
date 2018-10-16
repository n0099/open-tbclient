package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private NEGFeedBackView bWq;
    private ViewGroup bWr;
    private NEGFeedBackView.a bWs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar) {
            TiebaStatic.log(new am("c11973").ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, ah ahVar) {
            if (arrayList != null && ahVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new am("c11974").ax("obj_locate", sb.toString()).ax(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ax("tid", ahVar.getTid()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bWr = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aGk() {
        return this.bWq != null && this.bWq.getVisibility() == 0;
    }

    public void af(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.bWr != null) {
            boolean z = (bbVar.yv() == null || bbVar.yv().getUserId() == null || !bbVar.yv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.zx() && bbVar.xt() != null && !z) {
                if (this.bWq == null) {
                    this.bWq = new NEGFeedBackView(this.mPageContext);
                    this.bWq.setUniqueId(this.mBdUniqueId);
                    this.bWq.setId(e.g.negative_feedback_view);
                    this.bWq.setDefaultReasonArray(new String[]{this.mPageContext.getString(e.j.bad_quality), "", ""});
                    this.bWq.setEventCallback(this.bWs);
                    this.bWq.a(this.bWr, l.h(this.mPageContext.getPageActivity(), e.C0175e.tbds120), 0);
                    this.bWq.onChangeSkinType();
                }
                if (this.bWq.getVisibility() != 0) {
                    this.bWq.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.xt());
                this.bWq.setData(ahVar);
            } else {
                if (this.bWq != null && this.bWq.getVisibility() != 8) {
                    this.bWq.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), e.C0175e.ds32);
            }
            if (this.bWr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWr.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bWr.setLayoutParams(layoutParams);
            }
            if (this.bWr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bWr.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bWr.setLayoutParams(layoutParams2);
            }
            if (this.bWq != null) {
                this.bWq.Tk();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bWq != null) {
            this.bWq.onChangeSkinType();
        }
    }
}
