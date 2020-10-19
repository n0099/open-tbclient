package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class i {
    private NEGFeedBackView gAP;
    private ViewGroup gAQ;
    private NEGFeedBackView.a gAR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            TiebaStatic.log(new aq("c11973").dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar) {
            if (arrayList != null && arVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new aq("c11974").dK("obj_locate", sb.toString()).dK("fid", arVar.getFid()).dK("tid", arVar.getTid()).dK("nid", arVar.getNid()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("source", arVar.source).dK("weight", arVar.weight).dK("ab_tag", arVar.abTag).dK("extra", arVar.extra).aj(IntentConfig.CARD_TYPE, arVar.cardType).aj("obj_floor", arVar.ens));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gAQ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cAu() {
        return this.gAP != null && this.gAP.getVisibility() == 0;
    }

    public void ay(bw bwVar) {
        int i = 0;
        if (bwVar != null && this.mPageContext != null && this.gAQ != null) {
            boolean z = (bwVar.bih() == null || bwVar.bih().getUserId() == null || !bwVar.bih().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bjw() && bwVar.getFeedBackReasonMap() != null && !z) {
                if (this.gAP == null) {
                    this.gAP = new NEGFeedBackView(this.mPageContext);
                    this.gAP.setUniqueId(this.mBdUniqueId);
                    this.gAP.setId(R.id.negative_feedback_view);
                    this.gAP.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gAP.setEventCallback(this.gAR);
                    this.gAP.a(this.gAQ, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gAP.onChangeSkinType();
                }
                if (this.gAP.getVisibility() != 0) {
                    this.gAP.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(bwVar.getFeedBackReasonMap());
                arVar.eno = bwVar.eno;
                this.gAP.setData(arVar);
            } else {
                if (this.gAP != null && this.gAP.getVisibility() != 8) {
                    this.gAP.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gAQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAQ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gAQ.setLayoutParams(layoutParams);
            }
            if (this.gAQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gAQ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gAQ.setLayoutParams(layoutParams2);
            }
            if (this.gAP != null) {
                this.gAP.bEe();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gAP != null) {
            this.gAP.onChangeSkinType();
        }
    }
}
