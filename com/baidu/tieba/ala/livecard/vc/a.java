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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private NEGFeedBackView fXm;
    private ViewGroup fXn;
    private NEGFeedBackView.a fXo = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aq aqVar) {
            if (aqVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(aqVar.getType())) {
                    TiebaStatic.log(new ap("c12802").dn("tid", aqVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(aqVar.getType())) {
                    TiebaStatic.log(new ap("c12806").dn("tid", aqVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aq aqVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aq aqVar) {
            if (arrayList != null && aqVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(aqVar.getType())) {
                    TiebaStatic.log(new ap("c12803").dn("tid", aqVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(aqVar.getType())) {
                    TiebaStatic.log(new ap("c12807").dn("tid", aqVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fXn = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bv bvVar, String str) {
        int i = 0;
        if (bvVar != null && bvVar.aWF() != null && this.mPageContext != null && this.fXn != null) {
            boolean z = (bvVar.aWl() == null || bvVar.aWl().getUserId() == null || !bvVar.aWl().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bvVar.aWF().dislikeInfo != null && !z && bvVar.aWF().dislikeInfo.size() > 0) {
                if (this.fXm == null) {
                    this.fXm = new NEGFeedBackView(this.mPageContext);
                    this.fXm.setUniqueId(this.mBdUniqueId);
                    this.fXm.setId(R.id.negative_feedback_view);
                    this.fXm.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fXm.setEventCallback(this.fXo);
                    this.fXm.b(this.fXn, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.fXm.onChangeSkinType();
                }
                if (this.fXm.getVisibility() != 0) {
                    this.fXm.setVisibility(0);
                }
                aq aqVar = new aq();
                aqVar.setTid(bvVar.getTid());
                aqVar.setFid(bvVar.getFid());
                aqVar.setNid(bvVar.getNid());
                aqVar.setType(str);
                aqVar.setFeedBackReasonMap(bvVar.aWF().dislikeInfo);
                this.fXm.setData(aqVar);
            } else {
                if (this.fXm != null && this.fXm.getVisibility() != 8) {
                    this.fXm.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fXn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fXn.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fXn.setLayoutParams(layoutParams);
            }
            if (this.fXn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fXn.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fXn.setLayoutParams(layoutParams2);
            }
            if (this.fXm != null) {
                this.fXm.brl();
            }
        }
    }

    public View bCv() {
        return this.fXm;
    }

    public void onChangeSkinType() {
        if (this.fXm != null) {
            this.fXm.onChangeSkinType();
        }
    }
}
