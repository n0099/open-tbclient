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
/* loaded from: classes3.dex */
public class a {
    private NEGFeedBackView fsC;
    private ViewGroup fsD;
    private NEGFeedBackView.a fsE = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12802").cI("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12806").cI("tid", alVar.getTid()));
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
                    TiebaStatic.log(new an("c12803").cI("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12807").cI("tid", alVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fsD = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void e(bj bjVar, String str) {
        int i = 0;
        if (bjVar != null && bjVar.aKX() != null && this.mPageContext != null && this.fsD != null) {
            boolean z = (bjVar.aKE() == null || bjVar.aKE().getUserId() == null || !bjVar.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bjVar.aKX().dislikeInfo != null && !z && bjVar.aKX().dislikeInfo.size() > 0) {
                if (this.fsC == null) {
                    this.fsC = new NEGFeedBackView(this.mPageContext);
                    this.fsC.setUniqueId(this.mBdUniqueId);
                    this.fsC.setId(R.id.negative_feedback_view);
                    this.fsC.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fsC.setEventCallback(this.fsE);
                    this.fsC.b(this.fsD, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.fsC.onChangeSkinType();
                }
                if (this.fsC.getVisibility() != 0) {
                    this.fsC.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setType(str);
                alVar.setFeedBackReasonMap(bjVar.aKX().dislikeInfo);
                this.fsC.setData(alVar);
            } else {
                if (this.fsC != null && this.fsC.getVisibility() != 8) {
                    this.fsC.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fsD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsD.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fsD.setLayoutParams(layoutParams);
            }
            if (this.fsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsD.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fsD.setLayoutParams(layoutParams2);
            }
            if (this.fsC != null) {
                this.fsC.beD();
            }
        }
    }

    public View bqu() {
        return this.fsC;
    }

    public void onChangeSkinType() {
        if (this.fsC != null) {
            this.fsC.onChangeSkinType();
        }
    }
}
