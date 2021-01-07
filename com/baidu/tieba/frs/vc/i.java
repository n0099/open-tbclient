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
    private NEGFeedBackView hnK;
    private ViewGroup hnL;
    private NEGFeedBackView.a hnM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            TiebaStatic.log(new aq("c11973").dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new aq("c11974").dX("obj_locate", sb.toString()).dX("fid", atVar.getFid()).dX("tid", atVar.getTid()).dX(IntentConfig.NID, atVar.bpP()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("source", atVar.source).dX("weight", atVar.weight).dX("ab_tag", atVar.abTag).dX("extra", atVar.extra).an(IntentConfig.CARD_TYPE, atVar.cardType).an("obj_floor", atVar.eQR));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hnL = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cNZ() {
        return this.hnK != null && this.hnK.getVisibility() == 0;
    }

    public void aA(bz bzVar) {
        int i = 0;
        if (bzVar != null && this.mPageContext != null && this.hnL != null) {
            boolean z = (bzVar.brr() == null || bzVar.brr().getUserId() == null || !bzVar.brr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bzVar.bsJ() && bzVar.getFeedBackReasonMap() != null && !z) {
                if (this.hnK == null) {
                    this.hnK = new NEGFeedBackView(this.mPageContext);
                    this.hnK.setUniqueId(this.mBdUniqueId);
                    this.hnK.setId(R.id.negative_feedback_view);
                    this.hnK.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hnK.setEventCallback(this.hnM);
                    this.hnK.a(this.hnL, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hnK.onChangeSkinType();
                }
                if (this.hnK.getVisibility() != 0) {
                    this.hnK.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.bpP());
                atVar.setFeedBackReasonMap(bzVar.getFeedBackReasonMap());
                atVar.eQN = bzVar.eQN;
                this.hnK.setData(atVar);
            } else {
                if (this.hnK != null && this.hnK.getVisibility() != 8) {
                    this.hnK.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hnL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnL.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hnL.setLayoutParams(layoutParams);
            }
            if (this.hnL.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hnL.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hnL.setLayoutParams(layoutParams2);
            }
            if (this.hnK != null) {
                this.hnK.bNJ();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hnK != null) {
            this.hnK.onChangeSkinType();
        }
    }
}
