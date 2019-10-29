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
    private NEGFeedBackView dTD;
    private ViewGroup dTE;
    private NEGFeedBackView.a dTF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.dTE = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bqL() {
        return this.dTD != null && this.dTD.getVisibility() == 0;
    }

    public void am(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mPageContext != null && this.dTE != null) {
            boolean z = (bhVar.aiG() == null || bhVar.aiG().getUserId() == null || !bhVar.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.ajO() && bhVar.getFeedBackReasonMap() != null && !z) {
                if (this.dTD == null) {
                    this.dTD = new NEGFeedBackView(this.mPageContext);
                    this.dTD.setUniqueId(this.mBdUniqueId);
                    this.dTD.setId(R.id.negative_feedback_view);
                    this.dTD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dTD.setEventCallback(this.dTF);
                    this.dTD.a(this.dTE, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dTD.onChangeSkinType();
                }
                if (this.dTD.getVisibility() != 0) {
                    this.dTD.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setFeedBackReasonMap(bhVar.getFeedBackReasonMap());
                this.dTD.setData(ajVar);
            } else {
                if (this.dTD != null && this.dTD.getVisibility() != 8) {
                    this.dTD.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dTE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTE.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dTE.setLayoutParams(layoutParams);
            }
            if (this.dTE.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dTE.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dTE.setLayoutParams(layoutParams2);
            }
            if (this.dTD != null) {
                this.dTD.aBO();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dTD != null) {
            this.dTD.onChangeSkinType();
        }
    }
}
