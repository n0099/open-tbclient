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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private NEGFeedBackView eJD;
    private ViewGroup eJE;
    private NEGFeedBackView.a eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12802").cp("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12806").cp("tid", alVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12803").cp("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12807").cp("tid", alVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eJE = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void e(bj bjVar, String str) {
        int i = 0;
        if (bjVar != null && bjVar.aAq() != null && this.mPageContext != null && this.eJE != null) {
            boolean z = (bjVar.azX() == null || bjVar.azX().getUserId() == null || !bjVar.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bjVar.aAq().dislikeInfo != null && !z && bjVar.aAq().dislikeInfo.size() > 0) {
                if (this.eJD == null) {
                    this.eJD = new NEGFeedBackView(this.mPageContext);
                    this.eJD.setUniqueId(this.mBdUniqueId);
                    this.eJD.setId(R.id.negative_feedback_view);
                    this.eJD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eJD.setEventCallback(this.eJF);
                    this.eJD.b(this.eJE, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.eJD.onChangeSkinType();
                }
                if (this.eJD.getVisibility() != 0) {
                    this.eJD.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setType(str);
                alVar.setFeedBackReasonMap(bjVar.aAq().dislikeInfo);
                this.eJD.setData(alVar);
            } else {
                if (this.eJD != null && this.eJD.getVisibility() != 8) {
                    this.eJD.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eJE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJE.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eJE.setLayoutParams(layoutParams);
            }
            if (this.eJE.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eJE.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eJE.setLayoutParams(layoutParams2);
            }
            if (this.eJD != null) {
                this.eJD.aTV();
            }
        }
    }

    public View beL() {
        return this.eJD;
    }

    public void onChangeSkinType() {
        if (this.eJD != null) {
            this.eJD.onChangeSkinType();
        }
    }
}
