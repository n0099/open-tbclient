package com.baidu.tieba.frs.vc;

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
/* loaded from: classes4.dex */
public class g {
    private NEGFeedBackView dSM;
    private ViewGroup dSN;
    private NEGFeedBackView.a dSO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            TiebaStatic.log(new an("c11973").bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").bS("obj_locate", sb.toString()).bS("fid", ajVar.getFid()).bS("tid", ajVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dSN = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bqJ() {
        return this.dSM != null && this.dSM.getVisibility() == 0;
    }

    public void am(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mPageContext != null && this.dSN != null) {
            boolean z = (bhVar.aiE() == null || bhVar.aiE().getUserId() == null || !bhVar.aiE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.ajM() && bhVar.getFeedBackReasonMap() != null && !z) {
                if (this.dSM == null) {
                    this.dSM = new NEGFeedBackView(this.mPageContext);
                    this.dSM.setUniqueId(this.mBdUniqueId);
                    this.dSM.setId(R.id.negative_feedback_view);
                    this.dSM.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dSM.setEventCallback(this.dSO);
                    this.dSM.a(this.dSN, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dSM.onChangeSkinType();
                }
                if (this.dSM.getVisibility() != 0) {
                    this.dSM.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setFeedBackReasonMap(bhVar.getFeedBackReasonMap());
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

    public void onChangeSkinType() {
        if (this.dSM != null) {
            this.dSM.onChangeSkinType();
        }
    }
}
