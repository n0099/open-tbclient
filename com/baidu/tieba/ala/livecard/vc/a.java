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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private NEGFeedBackView gAP;
    private ViewGroup gAQ;
    private NEGFeedBackView.a gAR = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dK("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dK("tid", arVar.getTid()));
                }
            }
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
                if ("ala_frs_demo_hell_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12803").dK("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dK("tid", arVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gAQ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bw bwVar, String str) {
        int i = 0;
        if (bwVar != null && bwVar.biB() != null && this.mPageContext != null && this.gAQ != null) {
            boolean z = (bwVar.bih() == null || bwVar.bih().getUserId() == null || !bwVar.bih().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bwVar.biB().dislikeInfo != null && !z && bwVar.biB().dislikeInfo.size() > 0) {
                if (this.gAP == null) {
                    this.gAP = new NEGFeedBackView(this.mPageContext);
                    this.gAP.setUniqueId(this.mBdUniqueId);
                    this.gAP.setId(R.id.negative_feedback_view);
                    this.gAP.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gAP.setEventCallback(this.gAR);
                    this.gAP.b(this.gAQ, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.gAP.onChangeSkinType();
                }
                if (this.gAP.getVisibility() != 0) {
                    this.gAP.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setType(str);
                arVar.setFeedBackReasonMap(bwVar.biB().dislikeInfo);
                this.gAP.setData(arVar);
            } else {
                if (this.gAP != null && this.gAP.getVisibility() != 8) {
                    this.gAP.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gAQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAQ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gAQ.setLayoutParams(layoutParams);
            }
            if (this.gAQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gAQ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gAQ.setLayoutParams(layoutParams2);
            }
            if (this.gAP != null) {
                this.gAP.bEe();
            }
        }
    }

    public View bQr() {
        return this.gAP;
    }

    public void onChangeSkinType() {
        if (this.gAP != null) {
            this.gAP.onChangeSkinType();
        }
    }
}
