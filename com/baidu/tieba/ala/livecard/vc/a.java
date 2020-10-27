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
    private NEGFeedBackView gMD;
    private ViewGroup gME;
    private NEGFeedBackView.a gMF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dR("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dR("tid", arVar.getTid()));
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
                    TiebaStatic.log(new aq("c12803").dR("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dR("tid", arVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gME = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bw bwVar, String str) {
        int i = 0;
        if (bwVar != null && bwVar.bku() != null && this.mPageContext != null && this.gME != null) {
            boolean z = (bwVar.bka() == null || bwVar.bka().getUserId() == null || !bwVar.bka().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bwVar.bku().dislikeInfo != null && !z && bwVar.bku().dislikeInfo.size() > 0) {
                if (this.gMD == null) {
                    this.gMD = new NEGFeedBackView(this.mPageContext);
                    this.gMD.setUniqueId(this.mBdUniqueId);
                    this.gMD.setId(R.id.negative_feedback_view);
                    this.gMD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gMD.setEventCallback(this.gMF);
                    this.gMD.b(this.gME, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.gMD.onChangeSkinType();
                }
                if (this.gMD.getVisibility() != 0) {
                    this.gMD.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setType(str);
                arVar.setFeedBackReasonMap(bwVar.bku().dislikeInfo);
                this.gMD.setData(arVar);
            } else {
                if (this.gMD != null && this.gMD.getVisibility() != 8) {
                    this.gMD.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
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

    public View bTo() {
        return this.gMD;
    }

    public void onChangeSkinType() {
        if (this.gMD != null) {
            this.gMD.onChangeSkinType();
        }
    }
}
