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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private NEGFeedBackView hnr;
    private ViewGroup hns;
    private NEGFeedBackView.a hnt = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12802").dR("tid", avVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12806").dR("tid", avVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12803").dR("tid", avVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12807").dR("tid", avVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hns = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(cb cbVar, String str) {
        int i = 0;
        if (cbVar != null && cbVar.boj() != null && this.mPageContext != null && this.hns != null) {
            boolean z = (cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null || !cbVar.bnQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && cbVar.boj().dislikeInfo != null && !z && cbVar.boj().dislikeInfo.size() > 0) {
                if (this.hnr == null) {
                    this.hnr = new NEGFeedBackView(this.mPageContext);
                    this.hnr.setUniqueId(this.mBdUniqueId);
                    this.hnr.setId(R.id.negative_feedback_view);
                    this.hnr.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hnr.setEventCallback(this.hnt);
                    this.hnr.b(this.hns, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hnr.onChangeSkinType();
                }
                if (this.hnr.getVisibility() != 0) {
                    this.hnr.setVisibility(0);
                }
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmo());
                avVar.setType(str);
                avVar.setFeedBackReasonMap(cbVar.boj().dislikeInfo);
                this.hnr.setData(avVar);
            } else {
                if (this.hnr != null && this.hnr.getVisibility() != 8) {
                    this.hnr.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hns.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hns.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hns.setLayoutParams(layoutParams);
            }
            if (this.hns.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hns.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hns.setLayoutParams(layoutParams2);
            }
            if (this.hnr != null) {
                this.hnr.bKl();
            }
        }
    }

    public View bYO() {
        return this.hnr;
    }

    public void onChangeSkinType() {
        if (this.hnr != null) {
            this.hnr.onChangeSkinType();
        }
    }
}
