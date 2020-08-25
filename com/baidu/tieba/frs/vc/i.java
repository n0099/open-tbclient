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
/* loaded from: classes16.dex */
public class i {
    private NEGFeedBackView gjl;
    private ViewGroup gjm;
    private NEGFeedBackView.a gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            TiebaStatic.log(new aq("c11973").dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new aq("c11974").dD("obj_locate", sb.toString()).dD("fid", arVar.getFid()).dD("tid", arVar.getTid()).dD("nid", arVar.getNid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("source", arVar.source).dD("weight", arVar.weight).dD("ab_tag", arVar.abTag).dD("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.dZb));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gjm = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean ctE() {
        return this.gjl != null && this.gjl.getVisibility() == 0;
    }

    public void ax(bw bwVar) {
        int i = 0;
        if (bwVar != null && this.mPageContext != null && this.gjm != null) {
            boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bfT() && bwVar.getFeedBackReasonMap() != null && !z) {
                if (this.gjl == null) {
                    this.gjl = new NEGFeedBackView(this.mPageContext);
                    this.gjl.setUniqueId(this.mBdUniqueId);
                    this.gjl.setId(R.id.negative_feedback_view);
                    this.gjl.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gjl.setEventCallback(this.gjn);
                    this.gjl.a(this.gjm, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gjl.onChangeSkinType();
                }
                if (this.gjl.getVisibility() != 0) {
                    this.gjl.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(bwVar.getFeedBackReasonMap());
                arVar.dYX = bwVar.dYX;
                this.gjl.setData(arVar);
            } else {
                if (this.gjl != null && this.gjl.getVisibility() != 8) {
                    this.gjl.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gjm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjm.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gjm.setLayoutParams(layoutParams);
            }
            if (this.gjm.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gjm.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gjm.setLayoutParams(layoutParams2);
            }
            if (this.gjl != null) {
                this.gjl.bAi();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gjl != null) {
            this.gjl.onChangeSkinType();
        }
    }
}
