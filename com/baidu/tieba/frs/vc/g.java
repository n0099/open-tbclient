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
    private NEGFeedBackView caX;
    private ViewGroup caY;
    private NEGFeedBackView.a caZ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ah ahVar) {
            TiebaStatic.log(new am("c11973").aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new am("c11974").aA("obj_locate", sb.toString()).aA(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aA("tid", ahVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.caY = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aIh() {
        return this.caX != null && this.caX.getVisibility() == 0;
    }

    public void af(bb bbVar) {
        int i = 0;
        if (bbVar != null && this.mPageContext != null && this.caY != null) {
            boolean z = (bbVar.zG() == null || bbVar.zG().getUserId() == null || !bbVar.zG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bbVar.AI() && bbVar.yF() != null && !z) {
                if (this.caX == null) {
                    this.caX = new NEGFeedBackView(this.mPageContext);
                    this.caX.setUniqueId(this.mBdUniqueId);
                    this.caX.setId(e.g.negative_feedback_view);
                    this.caX.setDefaultReasonArray(new String[]{this.mPageContext.getString(e.j.bad_quality), "", ""});
                    this.caX.setEventCallback(this.caZ);
                    this.caX.a(this.caY, l.h(this.mPageContext.getPageActivity(), e.C0210e.tbds120), 0);
                    this.caX.onChangeSkinType();
                }
                if (this.caX.getVisibility() != 0) {
                    this.caX.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.setTid(bbVar.getTid());
                ahVar.setFid(bbVar.getFid());
                ahVar.a(bbVar.yF());
                this.caX.setData(ahVar);
            } else {
                if (this.caX != null && this.caX.getVisibility() != 8) {
                    this.caX.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), e.C0210e.ds32);
            }
            if (this.caY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.caY.getLayoutParams();
                layoutParams.rightMargin = i;
                this.caY.setLayoutParams(layoutParams);
            }
            if (this.caY.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.caY.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.caY.setLayoutParams(layoutParams2);
            }
            if (this.caX != null) {
                this.caX.UB();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.caX != null) {
            this.caX.onChangeSkinType();
        }
    }
}
