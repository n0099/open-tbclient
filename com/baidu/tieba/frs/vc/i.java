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
    private NEGFeedBackView hpp;
    private ViewGroup hpq;
    private NEGFeedBackView.a hpr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
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
                TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", avVar.getFid()).dR("tid", avVar.getTid()).dR(IntentConfig.NID, avVar.bmq()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", avVar.source).dR("weight", avVar.weight).dR("ab_tag", avVar.abTag).dR("extra", avVar.extra).aq(IntentConfig.CARD_TYPE, avVar.cardType).aq("obj_floor", avVar.ePT));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hpq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cLI() {
        return this.hpp != null && this.hpp.getVisibility() == 0;
    }

    public void aB(cb cbVar) {
        int i = 0;
        if (cbVar != null && this.mPageContext != null && this.hpq != null) {
            boolean z = (cbVar.bnS() == null || cbVar.bnS().getUserId() == null || !cbVar.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (cbVar.bpj() && cbVar.getFeedBackReasonMap() != null && !z) {
                if (this.hpp == null) {
                    this.hpp = new NEGFeedBackView(this.mPageContext);
                    this.hpp.setUniqueId(this.mBdUniqueId);
                    this.hpp.setId(R.id.negative_feedback_view);
                    this.hpp.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hpp.setEventCallback(this.hpr);
                    this.hpp.a(this.hpq, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hpp.onChangeSkinType();
                }
                if (this.hpp.getVisibility() != 0) {
                    this.hpp.setVisibility(0);
                }
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmq());
                avVar.setFeedBackReasonMap(cbVar.getFeedBackReasonMap());
                avVar.ePP = cbVar.ePP;
                this.hpp.setData(avVar);
            } else {
                if (this.hpp != null && this.hpp.getVisibility() != 8) {
                    this.hpp.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hpq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hpq.setLayoutParams(layoutParams);
            }
            if (this.hpq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hpq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hpq.setLayoutParams(layoutParams2);
            }
            if (this.hpp != null) {
                this.hpp.bKu();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hpp != null) {
            this.hpp.onChangeSkinType();
        }
    }
}
