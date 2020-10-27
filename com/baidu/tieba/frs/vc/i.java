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
    private NEGFeedBackView gMD;
    private ViewGroup gME;
    private NEGFeedBackView.a gMF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            TiebaStatic.log(new aq("c11973").dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new aq("c11974").dR("obj_locate", sb.toString()).dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", arVar.source).dR("weight", arVar.weight).dR("ab_tag", arVar.abTag).dR("extra", arVar.extra).aj(IntentConfig.CARD_TYPE, arVar.cardType).aj("obj_floor", arVar.evR));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gME = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cDB() {
        return this.gMD != null && this.gMD.getVisibility() == 0;
    }

    public void ay(bw bwVar) {
        int i = 0;
        if (bwVar != null && this.mPageContext != null && this.gME != null) {
            boolean z = (bwVar.bka() == null || bwVar.bka().getUserId() == null || !bwVar.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.blp() && bwVar.getFeedBackReasonMap() != null && !z) {
                if (this.gMD == null) {
                    this.gMD = new NEGFeedBackView(this.mPageContext);
                    this.gMD.setUniqueId(this.mBdUniqueId);
                    this.gMD.setId(R.id.negative_feedback_view);
                    this.gMD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gMD.setEventCallback(this.gMF);
                    this.gMD.a(this.gME, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gMD.onChangeSkinType();
                }
                if (this.gMD.getVisibility() != 0) {
                    this.gMD.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(bwVar.getFeedBackReasonMap());
                arVar.evN = bwVar.evN;
                this.gMD.setData(arVar);
            } else {
                if (this.gMD != null && this.gMD.getVisibility() != 8) {
                    this.gMD.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gME.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gME.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gME.setLayoutParams(layoutParams);
            }
            if (this.gME.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gME.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gME.setLayoutParams(layoutParams2);
            }
            if (this.gMD != null) {
                this.gMD.bFX();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gMD != null) {
            this.gMD.onChangeSkinType();
        }
    }
}
