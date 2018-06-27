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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private NEGFeedBackView bHl;
    private ViewGroup bHm;
    private NEGFeedBackView.a bHn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ai aiVar) {
            TiebaStatic.log(new an("c11973").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bHm = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aAf() {
        return this.bHl != null && this.bHl.getVisibility() == 0;
    }

    public void ac(bc bcVar) {
        int i = 0;
        if (bcVar != null && this.mPageContext != null && this.bHm != null) {
            boolean z = (bcVar.vw() == null || bcVar.vw().getUserId() == null || !bcVar.vw().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bcVar.wv() && bcVar.uv() != null && !z) {
                if (this.bHl == null) {
                    this.bHl = new NEGFeedBackView(this.mPageContext);
                    this.bHl.setUniqueId(this.mBdUniqueId);
                    this.bHl.setId(d.g.negative_feedback_view);
                    this.bHl.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.k.bad_quality), "", ""});
                    this.bHl.setEventCallback(this.bHn);
                    this.bHl.a(this.bHm, l.e(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.bHl.onChangeSkinType();
                }
                if (this.bHl.getVisibility() != 0) {
                    this.bHl.setVisibility(0);
                }
                ai aiVar = new ai();
                aiVar.dk(bcVar.getTid());
                aiVar.setFid(bcVar.getFid());
                aiVar.a(bcVar.uv());
                this.bHl.setData(aiVar);
            } else {
                if (this.bHl != null && this.bHl.getVisibility() != 8) {
                    this.bHl.setVisibility(8);
                }
                i = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.bHm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bHm.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bHm.setLayoutParams(layoutParams);
            }
            if (this.bHm.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bHm.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bHm.setLayoutParams(layoutParams2);
            }
            if (this.bHl != null) {
                this.bHl.Pp();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bHl != null) {
            this.bHl.onChangeSkinType();
        }
    }
}
