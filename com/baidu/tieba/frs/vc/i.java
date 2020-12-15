package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class i {
    private NEGFeedBackView hbY;
    private ViewGroup hbZ;
    private NEGFeedBackView.a hca = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            TiebaStatic.log(new ar("c11973").dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new ar("c11974").dY("obj_locate", sb.toString()).dY("fid", atVar.getFid()).dY("tid", atVar.getTid()).dY("nid", atVar.getNid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("source", atVar.source).dY("weight", atVar.weight).dY("ab_tag", atVar.abTag).dY("extra", atVar.extra).al(IntentConfig.CARD_TYPE, atVar.cardType).al("obj_floor", atVar.eHa));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hbZ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cKX() {
        return this.hbY != null && this.hbY.getVisibility() == 0;
    }

    public void aA(by byVar) {
        int i = 0;
        if (byVar != null && this.mPageContext != null && this.hbZ != null) {
            boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (byVar.bqg() && byVar.getFeedBackReasonMap() != null && !z) {
                if (this.hbY == null) {
                    this.hbY = new NEGFeedBackView(this.mPageContext);
                    this.hbY.setUniqueId(this.mBdUniqueId);
                    this.hbY.setId(R.id.negative_feedback_view);
                    this.hbY.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hbY.setEventCallback(this.hca);
                    this.hbY.a(this.hbZ, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.hbY.onChangeSkinType();
                }
                if (this.hbY.getVisibility() != 0) {
                    this.hbY.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(byVar.getTid());
                atVar.setFid(byVar.getFid());
                atVar.setNid(byVar.getNid());
                atVar.setFeedBackReasonMap(byVar.getFeedBackReasonMap());
                atVar.eGW = byVar.eGW;
                this.hbY.setData(atVar);
            } else {
                if (this.hbY != null && this.hbY.getVisibility() != 8) {
                    this.hbY.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hbZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbZ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hbZ.setLayoutParams(layoutParams);
            }
            if (this.hbZ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hbZ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hbZ.setLayoutParams(layoutParams2);
            }
            if (this.hbY != null) {
                this.hbY.bLq();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.hbY != null) {
            this.hbY.onChangeSkinType();
        }
    }
}
