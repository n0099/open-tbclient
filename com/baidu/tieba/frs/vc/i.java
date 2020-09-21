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
/* loaded from: classes21.dex */
public class i {
    private NEGFeedBackView gmw;
    private ViewGroup gmx;
    private NEGFeedBackView.a gmy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            TiebaStatic.log(new aq("c11973").dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new aq("c11974").dF("obj_locate", sb.toString()).dF("fid", arVar.getFid()).dF("tid", arVar.getTid()).dF("nid", arVar.getNid()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("source", arVar.source).dF("weight", arVar.weight).dF("ab_tag", arVar.abTag).dF("extra", arVar.extra).ai(IntentConfig.CARD_TYPE, arVar.cardType).ai("obj_floor", arVar.ebp));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gmx = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cwX() {
        return this.gmw != null && this.gmw.getVisibility() == 0;
    }

    public void ay(bw bwVar) {
        int i = 0;
        if (bwVar != null && this.mPageContext != null && this.gmx != null) {
            boolean z = (bwVar.bfy() == null || bwVar.bfy().getUserId() == null || !bwVar.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bwVar.bgN() && bwVar.getFeedBackReasonMap() != null && !z) {
                if (this.gmw == null) {
                    this.gmw = new NEGFeedBackView(this.mPageContext);
                    this.gmw.setUniqueId(this.mBdUniqueId);
                    this.gmw.setId(R.id.negative_feedback_view);
                    this.gmw.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gmw.setEventCallback(this.gmy);
                    this.gmw.a(this.gmx, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.gmw.onChangeSkinType();
                }
                if (this.gmw.getVisibility() != 0) {
                    this.gmw.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setFeedBackReasonMap(bwVar.getFeedBackReasonMap());
                arVar.ebl = bwVar.ebl;
                this.gmw.setData(arVar);
            } else {
                if (this.gmw != null && this.gmw.getVisibility() != 8) {
                    this.gmw.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gmx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmx.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gmx.setLayoutParams(layoutParams);
            }
            if (this.gmx.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmx.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gmx.setLayoutParams(layoutParams2);
            }
            if (this.gmw != null) {
                this.gmw.bBs();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.gmw != null) {
            this.gmw.onChangeSkinType();
        }
    }
}
