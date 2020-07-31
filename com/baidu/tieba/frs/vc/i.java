package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class i {
    private NEGFeedBackView fXm;
    private ViewGroup fXn;
    private NEGFeedBackView.a fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aq aqVar) {
            TiebaStatic.log(new ap("c11973").dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
            if (arrayList != null && aqVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ap("c11974").dn("obj_locate", sb.toString()).dn("fid", aqVar.getFid()).dn("tid", aqVar.getTid()).dn("nid", aqVar.getNid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("source", aqVar.source).dn("weight", aqVar.weight).dn("ab_tag", aqVar.abTag).dn("extra", aqVar.extra).ah(IntentConfig.CARD_TYPE, aqVar.cardType).ah("obj_floor", aqVar.dPI));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fXn = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cja() {
        return this.fXm != null && this.fXm.getVisibility() == 0;
    }

    public void ax(bv bvVar) {
        int i = 0;
        if (bvVar != null && this.mPageContext != null && this.fXn != null) {
            boolean z = (bvVar.aWl() == null || bvVar.aWl().getUserId() == null || !bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bvVar.aXA() && bvVar.getFeedBackReasonMap() != null && !z) {
                if (this.fXm == null) {
                    this.fXm = new NEGFeedBackView(this.mPageContext);
                    this.fXm.setUniqueId(this.mBdUniqueId);
                    this.fXm.setId(R.id.negative_feedback_view);
                    this.fXm.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fXm.setEventCallback(this.fXo);
                    this.fXm.a(this.fXn, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.fXm.onChangeSkinType();
                }
                if (this.fXm.getVisibility() != 0) {
                    this.fXm.setVisibility(0);
                }
                aq aqVar = new aq();
                aqVar.setTid(bvVar.getTid());
                aqVar.setFid(bvVar.getFid());
                aqVar.setNid(bvVar.getNid());
                aqVar.setFeedBackReasonMap(bvVar.getFeedBackReasonMap());
                aqVar.dPE = bvVar.dPE;
                this.fXm.setData(aqVar);
            } else {
                if (this.fXm != null && this.fXm.getVisibility() != 8) {
                    this.fXm.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fXn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXn.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fXn.setLayoutParams(layoutParams);
            }
            if (this.fXn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fXn.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fXn.setLayoutParams(layoutParams2);
            }
            if (this.fXm != null) {
                this.fXm.brl();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.fXm != null) {
            this.fXm.onChangeSkinType();
        }
    }
}
