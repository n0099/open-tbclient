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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private NEGFeedBackView bFq;
    private ViewGroup bFr;
    private NEGFeedBackView.a bFs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ai aiVar) {
            TiebaStatic.log(new am("c11973").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, ai aiVar) {
            if (arrayList != null && aiVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new am("c11974").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bFr = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean azz() {
        return this.bFq != null && this.bFq.getVisibility() == 0;
    }

    public void X(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.bFr != null) {
            boolean z = (bdVar.vm() == null || bdVar.vm().getUserId() == null || !bdVar.vm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.wl() && bdVar.up() != null && !z) {
                if (this.bFq == null) {
                    this.bFq = new NEGFeedBackView(this.mPageContext);
                    this.bFq.setUniqueId(this.mBdUniqueId);
                    this.bFq.setId(d.g.negative_feedback_view);
                    this.bFq.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.k.bad_quality), "", ""});
                    this.bFq.setEventCallback(this.bFs);
                    this.bFq.a(this.bFr, l.e(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.bFq.onChangeSkinType();
                }
                if (this.bFq.getVisibility() != 0) {
                    this.bFq.setVisibility(0);
                }
                ai aiVar = new ai();
                aiVar.dh(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(bdVar.up());
                this.bFq.setData(aiVar);
            } else {
                if (this.bFq != null && this.bFq.getVisibility() != 8) {
                    this.bFq.setVisibility(8);
                }
                i = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.bFr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bFr.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bFr.setLayoutParams(layoutParams);
            }
            if (this.bFr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bFr.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bFr.setLayoutParams(layoutParams2);
            }
            if (this.bFq != null) {
                this.bFq.OU();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bFq != null) {
            this.bFq.onChangeSkinType();
        }
    }
}
