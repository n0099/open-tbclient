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
    private NEGFeedBackView gjl;
    private ViewGroup gjm;
    private NEGFeedBackView.a gjn = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(ar arVar) {
            if (arVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12802").dD("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12806").dD("tid", arVar.getTid()));
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
                    TiebaStatic.log(new aq("c12803").dD("tid", arVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(arVar.getType())) {
                    TiebaStatic.log(new aq("c12807").dD("tid", arVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gjm = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bw bwVar, String str) {
        int i = 0;
        if (bwVar != null && bwVar.beY() != null && this.mPageContext != null && this.gjm != null) {
            boolean z = (bwVar.beE() == null || bwVar.beE().getUserId() == null || !bwVar.beE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bwVar.beY().dislikeInfo != null && !z && bwVar.beY().dislikeInfo.size() > 0) {
                if (this.gjl == null) {
                    this.gjl = new NEGFeedBackView(this.mPageContext);
                    this.gjl.setUniqueId(this.mBdUniqueId);
                    this.gjl.setId(R.id.negative_feedback_view);
                    this.gjl.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gjl.setEventCallback(this.gjn);
                    this.gjl.b(this.gjm, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.gjl.onChangeSkinType();
                }
                if (this.gjl.getVisibility() != 0) {
                    this.gjl.setVisibility(0);
                }
                ar arVar = new ar();
                arVar.setTid(bwVar.getTid());
                arVar.setFid(bwVar.getFid());
                arVar.setNid(bwVar.getNid());
                arVar.setType(str);
                arVar.setFeedBackReasonMap(bwVar.beY().dislikeInfo);
                this.gjl.setData(arVar);
            } else {
                if (this.gjl != null && this.gjl.getVisibility() != 8) {
                    this.gjl.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gjm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gjm.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gjm.setLayoutParams(layoutParams);
            }
            if (this.gjm.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gjm.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gjm.setLayoutParams(layoutParams2);
            }
            if (this.gjl != null) {
                this.gjl.bAi();
            }
        }
    }

    public View bLP() {
        return this.gjl;
    }

    public void onChangeSkinType() {
        if (this.gjl != null) {
            this.gjl.onChangeSkinType();
        }
    }
}
