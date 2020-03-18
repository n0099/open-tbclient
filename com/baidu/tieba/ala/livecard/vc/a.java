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
    private NEGFeedBackView eOi;
    private ViewGroup eOj;
    private NEGFeedBackView.a eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12802").cx("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12806").cx("tid", alVar.getTid()));
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
                    TiebaStatic.log(new an("c12803").cx("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12807").cx("tid", alVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eOj = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void e(bj bjVar, String str) {
        int i = 0;
        if (bjVar != null && bjVar.aCK() != null && this.mPageContext != null && this.eOj != null) {
            boolean z = (bjVar.aCr() == null || bjVar.aCr().getUserId() == null || !bjVar.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bjVar.aCK().dislikeInfo != null && !z && bjVar.aCK().dislikeInfo.size() > 0) {
                if (this.eOi == null) {
                    this.eOi = new NEGFeedBackView(this.mPageContext);
                    this.eOi.setUniqueId(this.mBdUniqueId);
                    this.eOi.setId(R.id.negative_feedback_view);
                    this.eOi.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eOi.setEventCallback(this.eOk);
                    this.eOi.b(this.eOj, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.eOi.onChangeSkinType();
                }
                if (this.eOi.getVisibility() != 0) {
                    this.eOi.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setType(str);
                alVar.setFeedBackReasonMap(bjVar.aCK().dislikeInfo);
                this.eOi.setData(alVar);
            } else {
                if (this.eOi != null && this.eOi.getVisibility() != 8) {
                    this.eOi.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eOj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOj.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eOj.setLayoutParams(layoutParams);
            }
            if (this.eOj.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eOj.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eOj.setLayoutParams(layoutParams2);
            }
            if (this.eOi != null) {
                this.eOi.aWs();
            }
        }
    }

    public View bhd() {
        return this.eOi;
    }

    public void onChangeSkinType() {
        if (this.eOi != null) {
            this.eOi.onChangeSkinType();
        }
    }
}
