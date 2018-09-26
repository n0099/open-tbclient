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
/* loaded from: classes2.dex */
public class g {
    private NEGFeedBackView bNP;
    private ViewGroup bNQ;
    private NEGFeedBackView.a bNR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar) {
            TiebaStatic.log(new am("c11973").al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new am("c11974").al("obj_locate", sb.toString()).al(ImageViewerConfig.FORUM_ID, ahVar.getFid()).al("tid", ahVar.getTid()).al("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bNQ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aCS() {
        return this.bNP != null && this.bNP.getVisibility() == 0;
    }

    public void af(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.bNQ != null) {
            boolean z = (bbVar.wm() == null || bbVar.wm().getUserId() == null || !bbVar.wm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.xo() && bbVar.vk() != null && !z) {
                if (this.bNP == null) {
                    this.bNP = new NEGFeedBackView(this.mPageContext);
                    this.bNP.setUniqueId(this.mBdUniqueId);
                    this.bNP.setId(e.g.negative_feedback_view);
                    this.bNP.setDefaultReasonArray(new String[]{this.mPageContext.getString(e.j.bad_quality), "", ""});
                    this.bNP.setEventCallback(this.bNR);
                    this.bNP.a(this.bNQ, l.h(this.mPageContext.getPageActivity(), e.C0141e.tbds120), 0);
                    this.bNP.onChangeSkinType();
                }
                if (this.bNP.getVisibility() != 0) {
                    this.bNP.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.vk());
                this.bNP.setData(ahVar);
            } else {
                if (this.bNP != null && this.bNP.getVisibility() != 8) {
                    this.bNP.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), e.C0141e.ds32);
            }
            if (this.bNQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bNQ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bNQ.setLayoutParams(layoutParams);
            }
            if (this.bNQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bNQ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bNQ.setLayoutParams(layoutParams2);
            }
            if (this.bNP != null) {
                this.bNP.Ro();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bNP != null) {
            this.bNP.onChangeSkinType();
        }
    }
}
