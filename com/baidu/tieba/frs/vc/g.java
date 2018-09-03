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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private NEGFeedBackView bIa;
    private ViewGroup bIb;
    private NEGFeedBackView.a bIc = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar) {
            TiebaStatic.log(new an("c11973").ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").ae("obj_locate", sb.toString()).ae(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ae("tid", ahVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bIb = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aAJ() {
        return this.bIa != null && this.bIa.getVisibility() == 0;
    }

    public void ae(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.bIb != null) {
            boolean z = (bbVar.vj() == null || bbVar.vj().getUserId() == null || !bbVar.vj().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.wj() && bbVar.uh() != null && !z) {
                if (this.bIa == null) {
                    this.bIa = new NEGFeedBackView(this.mPageContext);
                    this.bIa.setUniqueId(this.mBdUniqueId);
                    this.bIa.setId(f.g.negative_feedback_view);
                    this.bIa.setDefaultReasonArray(new String[]{this.mPageContext.getString(f.j.bad_quality), "", ""});
                    this.bIa.setEventCallback(this.bIc);
                    this.bIa.a(this.bIb, l.f(this.mPageContext.getPageActivity(), f.e.tbds120), 0);
                    this.bIa.onChangeSkinType();
                }
                if (this.bIa.getVisibility() != 0) {
                    this.bIa.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.uh());
                this.bIa.setData(ahVar);
            } else {
                if (this.bIa != null && this.bIa.getVisibility() != 8) {
                    this.bIa.setVisibility(8);
                }
                i = l.f(this.mPageContext.getPageActivity(), f.e.ds32);
            }
            if (this.bIb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bIb.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bIb.setLayoutParams(layoutParams);
            }
            if (this.bIb.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bIb.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bIb.setLayoutParams(layoutParams2);
            }
            if (this.bIa != null) {
                this.bIa.PB();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bIa != null) {
            this.bIa.onChangeSkinType();
        }
    }
}
