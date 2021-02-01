package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class i {
    private NEGFeedBackView hnr;
    private ViewGroup hns;
    private NEGFeedBackView.a hnt = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            TiebaStatic.log(new ar("c11973").dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmo()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).ap(IntentConfig.CARD_TYPE, avVar.cardType).ap("obj_floor", avVar.eOs));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hns = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cLv() {
        return this.hnr != null && this.hnr.getVisibility() == 0;
    }

    public void aB(cb cbVar) {
        int i = 0;
        if (cbVar != null && this.mPageContext != null && this.hns != null) {
            boolean z = (cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null || !cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (cbVar.bph() && cbVar.getFeedBackReasonMap() != null && !z) {
                if (this.hnr == null) {
                    this.hnr = new NEGFeedBackView(this.mPageContext);
                    this.hnr.setUniqueId(this.mBdUniqueId);
                    this.hnr.setId(R.id.negative_feedback_view);
                    this.hnr.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hnr.setEventCallback(this.hnt);
                    this.hnr.a(this.hns, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hnr.onChangeSkinType();
                }
                if (this.hnr.getVisibility() != 0) {
                    this.hnr.setVisibility(0);
                }
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmo());
                avVar.setFeedBackReasonMap(cbVar.getFeedBackReasonMap());
                avVar.eOo = cbVar.eOo;
                this.hnr.setData(avVar);
            } else {
                if (this.hnr != null && this.hnr.getVisibility() != 8) {
                    this.hnr.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hns.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hns.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hns.setLayoutParams(layoutParams);
            }
            if (this.hns.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hns.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hns.setLayoutParams(layoutParams2);
            }
            if (this.hnr != null) {
                this.hnr.bKl();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hnr != null) {
            this.hnr.onChangeSkinType();
        }
    }
}
