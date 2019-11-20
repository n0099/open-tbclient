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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private NEGFeedBackView dSM;
    private ViewGroup dSN;
    private NEGFeedBackView.a dSO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            if (ajVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(ajVar.getType())) {
                    TiebaStatic.log(new an("c12802").bS("tid", ajVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(ajVar.getType())) {
                    TiebaStatic.log(new an("c12806").bS("tid", ajVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
            if (arrayList != null && ajVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(ajVar.getType())) {
                    TiebaStatic.log(new an("c12803").bS("tid", ajVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(ajVar.getType())) {
                    TiebaStatic.log(new an("c12807").bS("tid", ajVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dSN = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void c(bh bhVar, String str) {
        int i = 0;
        if (bhVar != null && bhVar.aiX() != null && this.mPageContext != null && this.dSN != null) {
            boolean z = (bhVar.aiE() == null || bhVar.aiE().getUserId() == null || !bhVar.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bhVar.aiX().dislikeInfo != null && !z && bhVar.aiX().dislikeInfo.size() > 0) {
                if (this.dSM == null) {
                    this.dSM = new NEGFeedBackView(this.mPageContext);
                    this.dSM.setUniqueId(this.mBdUniqueId);
                    this.dSM.setId(R.id.negative_feedback_view);
                    this.dSM.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dSM.setEventCallback(this.dSO);
                    this.dSM.b(this.dSN, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.dSM.onChangeSkinType();
                }
                if (this.dSM.getVisibility() != 0) {
                    this.dSM.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setType(str);
                ajVar.setFeedBackReasonMap(bhVar.aiX().dislikeInfo);
                this.dSM.setData(ajVar);
            } else {
                if (this.dSM != null && this.dSM.getVisibility() != 8) {
                    this.dSM.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dSN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSN.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dSN.setLayoutParams(layoutParams);
            }
            if (this.dSN.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dSN.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dSN.setLayoutParams(layoutParams2);
            }
            if (this.dSM != null) {
                this.dSM.aBM();
            }
        }
    }

    public View aML() {
        return this.dSM;
    }

    public void onChangeSkinType() {
        if (this.dSM != null) {
            this.dSM.onChangeSkinType();
        }
    }
}
