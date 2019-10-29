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
    private NEGFeedBackView dTD;
    private ViewGroup dTE;
    private NEGFeedBackView.a dTF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
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
        this.dTE = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void c(bh bhVar, String str) {
        int i = 0;
        if (bhVar != null && bhVar.aiZ() != null && this.mPageContext != null && this.dTE != null) {
            boolean z = (bhVar.aiG() == null || bhVar.aiG().getUserId() == null || !bhVar.aiG().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bhVar.aiZ().dislikeInfo != null && !z && bhVar.aiZ().dislikeInfo.size() > 0) {
                if (this.dTD == null) {
                    this.dTD = new NEGFeedBackView(this.mPageContext);
                    this.dTD.setUniqueId(this.mBdUniqueId);
                    this.dTD.setId(R.id.negative_feedback_view);
                    this.dTD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dTD.setEventCallback(this.dTF);
                    this.dTD.b(this.dTE, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.dTD.onChangeSkinType();
                }
                if (this.dTD.getVisibility() != 0) {
                    this.dTD.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.setType(str);
                ajVar.setFeedBackReasonMap(bhVar.aiZ().dislikeInfo);
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

    public View aMN() {
        return this.dTD;
    }

    public void onChangeSkinType() {
        if (this.dTD != null) {
            this.dTD.onChangeSkinType();
        }
    }
}
