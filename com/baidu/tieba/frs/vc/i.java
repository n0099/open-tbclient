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
    private NEGFeedBackView hnF;
    private ViewGroup hnG;
    private NEGFeedBackView.a hnH = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
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
        this.hnG = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cLC() {
        return this.hnF != null && this.hnF.getVisibility() == 0;
    }

    public void aB(cb cbVar) {
        int i = 0;
        if (cbVar != null && this.mPageContext != null && this.hnG != null) {
            boolean z = (cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null || !cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (cbVar.bph() && cbVar.getFeedBackReasonMap() != null && !z) {
                if (this.hnF == null) {
                    this.hnF = new NEGFeedBackView(this.mPageContext);
                    this.hnF.setUniqueId(this.mBdUniqueId);
                    this.hnF.setId(R.id.negative_feedback_view);
                    this.hnF.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hnF.setEventCallback(this.hnH);
                    this.hnF.a(this.hnG, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hnF.onChangeSkinType();
                }
                if (this.hnF.getVisibility() != 0) {
                    this.hnF.setVisibility(0);
                }
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmo());
                avVar.setFeedBackReasonMap(cbVar.getFeedBackReasonMap());
                avVar.eOo = cbVar.eOo;
                this.hnF.setData(avVar);
            } else {
                if (this.hnF != null && this.hnF.getVisibility() != 8) {
                    this.hnF.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hnG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnG.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hnG.setLayoutParams(layoutParams);
            }
            if (this.hnG.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hnG.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hnG.setLayoutParams(layoutParams2);
            }
            if (this.hnF != null) {
                this.hnF.bKq();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hnF != null) {
            this.hnF.onChangeSkinType();
        }
    }
}
