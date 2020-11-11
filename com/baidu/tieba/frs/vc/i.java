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
    private NEGFeedBackView gTc;
    private ViewGroup gTd;
    private NEGFeedBackView.a gTe = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
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
                TiebaStatic.log(new aq("c11974").dR("obj_locate", sb.toString()).dR("fid", arVar.getFid()).dR("tid", arVar.getTid()).dR("nid", arVar.getNid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("source", arVar.source).dR("weight", arVar.weight).dR("ab_tag", arVar.abTag).dR("extra", arVar.extra).al(IntentConfig.CARD_TYPE, arVar.cardType).al("obj_floor", arVar.eBK));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gTd = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cGc() {
        return this.gTc != null && this.gTc.getVisibility() == 0;
    }

    public void ay(bw bwVar) {
        int i = 0;
        if (bwVar != null && this.mPageContext != null && this.gTd != null) {
            boolean z = (bwVar.bmA() == null || bwVar.bmA().getUserId() == null || !bwVar.bmA().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bnP() && bwVar.getFeedBackReasonMap() != null && !z) {
                if (this.gTc == null) {
                    this.gTc = new NEGFeedBackView(this.mPageContext);
                    this.gTc.setUniqueId(this.mBdUniqueId);
                    this.gTc.setId(R.id.negative_feedback_view);
                    this.gTc.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gTc.setEventCallback(this.gTe);
                    this.gTc.a(this.gTd, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gTc.onChangeSkinType();
                }
                if (this.gTc.getVisibility() != 0) {
                    this.gTc.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(bwVar.getFeedBackReasonMap());
                arVar.eBG = bwVar.eBG;
                this.gTc.setData(arVar);
            } else {
                if (this.gTc != null && this.gTc.getVisibility() != 8) {
                    this.gTc.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gTd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gTd.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gTd.setLayoutParams(layoutParams);
            }
            if (this.gTd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gTd.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gTd.setLayoutParams(layoutParams2);
            }
            if (this.gTc != null) {
                this.gTc.bIw();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gTc != null) {
            this.gTc.onChangeSkinType();
        }
    }
}
