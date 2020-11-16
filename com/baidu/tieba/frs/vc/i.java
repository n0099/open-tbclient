package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class i {
    private NEGFeedBackView gSJ;
    private ViewGroup gSK;
    private NEGFeedBackView.a gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(as asVar) {
            TiebaStatic.log(new ar("c11973").dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
            if (arrayList != null && asVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ar("c11974").dR("obj_locate", sb.toString()).dR("fid", asVar.getFid()).dR("tid", asVar.getTid()).dR("nid", asVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", asVar.source).dR("weight", asVar.weight).dR("ab_tag", asVar.abTag).dR("extra", asVar.extra).ak(IntentConfig.CARD_TYPE, asVar.cardType).ak("obj_floor", asVar.eAb));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gSK = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cFH() {
        return this.gSJ != null && this.gSJ.getVisibility() == 0;
    }

    public void aA(bx bxVar) {
        int i = 0;
        if (bxVar != null && this.mPageContext != null && this.gSK != null) {
            boolean z = (bxVar.blC() == null || bxVar.blC().getUserId() == null || !bxVar.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bxVar.bmT() && bxVar.getFeedBackReasonMap() != null && !z) {
                if (this.gSJ == null) {
                    this.gSJ = new NEGFeedBackView(this.mPageContext);
                    this.gSJ.setUniqueId(this.mBdUniqueId);
                    this.gSJ.setId(R.id.negative_feedback_view);
                    this.gSJ.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gSJ.setEventCallback(this.gSL);
                    this.gSJ.a(this.gSK, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gSJ.onChangeSkinType();
                }
                if (this.gSJ.getVisibility() != 0) {
                    this.gSJ.setVisibility(0);
                }
                as asVar = new as();
                asVar.setTid(bxVar.getTid());
                asVar.setFid(bxVar.getFid());
                asVar.setNid(bxVar.getNid());
                asVar.setFeedBackReasonMap(bxVar.getFeedBackReasonMap());
                asVar.ezX = bxVar.ezX;
                this.gSJ.setData(asVar);
            } else {
                if (this.gSJ != null && this.gSJ.getVisibility() != 8) {
                    this.gSJ.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gSK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSK.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gSK.setLayoutParams(layoutParams);
            }
            if (this.gSK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gSK.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gSK.setLayoutParams(layoutParams2);
            }
            if (this.gSJ != null) {
                this.gSJ.bHP();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gSJ != null) {
            this.gSJ.onChangeSkinType();
        }
    }
}
