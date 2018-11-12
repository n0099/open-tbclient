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
    private NEGFeedBackView bXc;
    private ViewGroup bXd;
    private NEGFeedBackView.a bXe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.bXd = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aFG() {
        return this.bXc != null && this.bXc.getVisibility() == 0;
    }

    public void af(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.bXd != null) {
            boolean z = (bbVar.yC() == null || bbVar.yC().getUserId() == null || !bbVar.yC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.zE() && bbVar.xB() != null && !z) {
                if (this.bXc == null) {
                    this.bXc = new NEGFeedBackView(this.mPageContext);
                    this.bXc.setUniqueId(this.mBdUniqueId);
                    this.bXc.setId(e.g.negative_feedback_view);
                    this.bXc.setDefaultReasonArray(new String[]{this.mPageContext.getString(e.j.bad_quality), "", ""});
                    this.bXc.setEventCallback(this.bXe);
                    this.bXc.a(this.bXd, l.h(this.mPageContext.getPageActivity(), e.C0200e.tbds120), 0);
                    this.bXc.onChangeSkinType();
                }
                if (this.bXc.getVisibility() != 0) {
                    this.bXc.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.xB());
                this.bXc.setData(ahVar);
            } else {
                if (this.bXc != null && this.bXc.getVisibility() != 8) {
                    this.bXc.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), e.C0200e.ds32);
            }
            if (this.bXd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bXd.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bXd.setLayoutParams(layoutParams);
            }
            if (this.bXd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bXd.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bXd.setLayoutParams(layoutParams2);
            }
            if (this.bXc != null) {
                this.bXc.Tt();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bXc != null) {
            this.bXc.onChangeSkinType();
        }
    }
}
