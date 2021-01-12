package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class i {
    private NEGFeedBackView hje;
    private ViewGroup hjf;
    private NEGFeedBackView.a hjg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            TiebaStatic.log(new aq("c11973").dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
            if (arrayList != null && atVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new aq("c11974").dW("obj_locate", sb.toString()).dW("fid", atVar.getFid()).dW("tid", atVar.getTid()).dW(IntentConfig.NID, atVar.blV()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("source", atVar.source).dW("weight", atVar.weight).dW("ab_tag", atVar.abTag).dW("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eMg));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hjf = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cKh() {
        return this.hje != null && this.hje.getVisibility() == 0;
    }

    public void aA(bz bzVar) {
        int i = 0;
        if (bzVar != null && this.mPageContext != null && this.hjf != null) {
            boolean z = (bzVar.bnx() == null || bzVar.bnx().getUserId() == null || !bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bzVar.boP() && bzVar.getFeedBackReasonMap() != null && !z) {
                if (this.hje == null) {
                    this.hje = new NEGFeedBackView(this.mPageContext);
                    this.hje.setUniqueId(this.mBdUniqueId);
                    this.hje.setId(R.id.negative_feedback_view);
                    this.hje.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hje.setEventCallback(this.hjg);
                    this.hje.a(this.hjf, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hje.onChangeSkinType();
                }
                if (this.hje.getVisibility() != 0) {
                    this.hje.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.blV());
                atVar.setFeedBackReasonMap(bzVar.getFeedBackReasonMap());
                atVar.eMc = bzVar.eMc;
                this.hje.setData(atVar);
            } else {
                if (this.hje != null && this.hje.getVisibility() != 8) {
                    this.hje.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hjf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjf.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hjf.setLayoutParams(layoutParams);
            }
            if (this.hjf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hjf.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hjf.setLayoutParams(layoutParams2);
            }
            if (this.hje != null) {
                this.hje.bJR();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hje != null) {
            this.hje.onChangeSkinType();
        }
    }
}
