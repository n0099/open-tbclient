package com.baidu.tieba.ala.livecard.vc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private NEGFeedBackView hnK;
    private ViewGroup hnL;
    private NEGFeedBackView.a hnM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dX("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dX("tid", atVar.getTid()));
                }
            }
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
                if ("ala_frs_demo_hell_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12803").dX("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dX("tid", atVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hnL = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bz bzVar, String str) {
        int i = 0;
        if (bzVar != null && bzVar.brK() != null && this.mPageContext != null && this.hnL != null) {
            boolean z = (bzVar.brr() == null || bzVar.brr().getUserId() == null || !bzVar.brr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bzVar.brK().dislikeInfo != null && !z && bzVar.brK().dislikeInfo.size() > 0) {
                if (this.hnK == null) {
                    this.hnK = new NEGFeedBackView(this.mPageContext);
                    this.hnK.setUniqueId(this.mBdUniqueId);
                    this.hnK.setId(R.id.negative_feedback_view);
                    this.hnK.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hnK.setEventCallback(this.hnM);
                    this.hnK.b(this.hnL, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hnK.onChangeSkinType();
                }
                if (this.hnK.getVisibility() != 0) {
                    this.hnK.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.bpP());
                atVar.setType(str);
                atVar.setFeedBackReasonMap(bzVar.brK().dislikeInfo);
                this.hnK.setData(atVar);
            } else {
                if (this.hnK != null && this.hnK.getVisibility() != 8) {
                    this.hnK.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hnL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hnL.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hnL.setLayoutParams(layoutParams);
            }
            if (this.hnL.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hnL.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hnL.setLayoutParams(layoutParams2);
            }
            if (this.hnK != null) {
                this.hnK.bNJ();
            }
        }
    }

    public View cbI() {
        return this.hnK;
    }

    public void onChangeSkinType() {
        if (this.hnK != null) {
            this.hnK.onChangeSkinType();
        }
    }
}
