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
    private NEGFeedBackView gmw;
    private ViewGroup gmx;
    private NEGFeedBackView.a gmy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dF("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dF("tid", arVar.getTid()));
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
                    TiebaStatic.log(new aq("c12803").dF("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dF("tid", arVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gmx = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bw bwVar, String str) {
        int i = 0;
        if (bwVar != null && bwVar.bfS() != null && this.mPageContext != null && this.gmx != null) {
            boolean z = (bwVar.bfy() == null || bwVar.bfy().getUserId() == null || !bwVar.bfy().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bwVar.bfS().dislikeInfo != null && !z && bwVar.bfS().dislikeInfo.size() > 0) {
                if (this.gmw == null) {
                    this.gmw = new NEGFeedBackView(this.mPageContext);
                    this.gmw.setUniqueId(this.mBdUniqueId);
                    this.gmw.setId(R.id.negative_feedback_view);
                    this.gmw.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gmw.setEventCallback(this.gmy);
                    this.gmw.b(this.gmx, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.gmw.onChangeSkinType();
                }
                if (this.gmw.getVisibility() != 0) {
                    this.gmw.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setType(str);
                arVar.setFeedBackReasonMap(bwVar.bfS().dislikeInfo);
                this.gmw.setData(arVar);
            } else {
                if (this.gmw != null && this.gmw.getVisibility() != 8) {
                    this.gmw.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gmx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmx.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gmx.setLayoutParams(layoutParams);
            }
            if (this.gmx.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gmx.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gmx.setLayoutParams(layoutParams2);
            }
            if (this.gmw != null) {
                this.gmw.bBs();
            }
        }
    }

    public View bNa() {
        return this.gmw;
    }

    public void onChangeSkinType() {
        if (this.gmw != null) {
            this.gmw.onChangeSkinType();
        }
    }
}
