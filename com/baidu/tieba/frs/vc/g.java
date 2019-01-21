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
    private NEGFeedBackView cbJ;
    private ViewGroup cbK;
    private NEGFeedBackView.a cbL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar) {
            TiebaStatic.log(new am("c11973").aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new am("c11974").aB("obj_locate", sb.toString()).aB(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aB("tid", ahVar.getTid()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.cbK = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aIE() {
        return this.cbJ != null && this.cbJ.getVisibility() == 0;
    }

    public void af(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.cbK != null) {
            boolean z = (bbVar.zT() == null || bbVar.zT().getUserId() == null || !bbVar.zT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.AV() && bbVar.yS() != null && !z) {
                if (this.cbJ == null) {
                    this.cbJ = new NEGFeedBackView(this.mPageContext);
                    this.cbJ.setUniqueId(this.mBdUniqueId);
                    this.cbJ.setId(e.g.negative_feedback_view);
                    this.cbJ.setDefaultReasonArray(new String[]{this.mPageContext.getString(e.j.bad_quality), "", ""});
                    this.cbJ.setEventCallback(this.cbL);
                    this.cbJ.a(this.cbK, l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds120), 0);
                    this.cbJ.onChangeSkinType();
                }
                if (this.cbJ.getVisibility() != 0) {
                    this.cbJ.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.yS());
                this.cbJ.setData(ahVar);
            } else {
                if (this.cbJ != null && this.cbJ.getVisibility() != 8) {
                    this.cbJ.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
            }
            if (this.cbK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cbK.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cbK.setLayoutParams(layoutParams);
            }
            if (this.cbK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cbK.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cbK.setLayoutParams(layoutParams2);
            }
            if (this.cbJ != null) {
                this.cbJ.UX();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cbJ != null) {
            this.cbJ.onChangeSkinType();
        }
    }
}
