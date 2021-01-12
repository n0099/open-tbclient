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
/* loaded from: classes9.dex */
public class a {
    private NEGFeedBackView hje;
    private ViewGroup hjf;
    private NEGFeedBackView.a hjg = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dW("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dW("tid", atVar.getTid()));
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
                    TiebaStatic.log(new aq("c12803").dW("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dW("tid", atVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hjf = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bz bzVar, String str) {
        int i = 0;
        if (bzVar != null && bzVar.bnQ() != null && this.mPageContext != null && this.hjf != null) {
            boolean z = (bzVar.bnx() == null || bzVar.bnx().getUserId() == null || !bzVar.bnx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bzVar.bnQ().dislikeInfo != null && !z && bzVar.bnQ().dislikeInfo.size() > 0) {
                if (this.hje == null) {
                    this.hje = new NEGFeedBackView(this.mPageContext);
                    this.hje.setUniqueId(this.mBdUniqueId);
                    this.hje.setId(R.id.negative_feedback_view);
                    this.hje.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hje.setEventCallback(this.hjg);
                    this.hje.b(this.hjf, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hje.onChangeSkinType();
                }
                if (this.hje.getVisibility() != 0) {
                    this.hje.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(bzVar.getTid());
                atVar.setFid(bzVar.getFid());
                atVar.setNid(bzVar.blV());
                atVar.setType(str);
                atVar.setFeedBackReasonMap(bzVar.bnQ().dislikeInfo);
                this.hje.setData(atVar);
            } else {
                if (this.hje != null && this.hje.getVisibility() != 8) {
                    this.hje.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hjf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hjf.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hjf.setLayoutParams(layoutParams);
            }
            if (this.hjf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hjf.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hjf.setLayoutParams(layoutParams2);
            }
            if (this.hje != null) {
                this.hje.bJR();
            }
        }
    }

    public View bXQ() {
        return this.hje;
    }

    public void onChangeSkinType() {
        if (this.hje != null) {
            this.hje.onChangeSkinType();
        }
    }
}
