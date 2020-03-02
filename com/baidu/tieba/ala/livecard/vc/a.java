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
    private NEGFeedBackView eNx;
    private ViewGroup eNy;
    private NEGFeedBackView.a eNz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            if (alVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12802").cy("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12806").cy("tid", alVar.getTid()));
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
                    TiebaStatic.log(new an("c12803").cy("tid", alVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(alVar.getType())) {
                    TiebaStatic.log(new an("c12807").cy("tid", alVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eNy = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void e(bj bjVar, String str) {
        int i = 0;
        if (bjVar != null && bjVar.aCH() != null && this.mPageContext != null && this.eNy != null) {
            boolean z = (bjVar.aCo() == null || bjVar.aCo().getUserId() == null || !bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bjVar.aCH().dislikeInfo != null && !z && bjVar.aCH().dislikeInfo.size() > 0) {
                if (this.eNx == null) {
                    this.eNx = new NEGFeedBackView(this.mPageContext);
                    this.eNx.setUniqueId(this.mBdUniqueId);
                    this.eNx.setId(R.id.negative_feedback_view);
                    this.eNx.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eNx.setEventCallback(this.eNz);
                    this.eNx.b(this.eNy, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.eNx.onChangeSkinType();
                }
                if (this.eNx.getVisibility() != 0) {
                    this.eNx.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setType(str);
                alVar.setFeedBackReasonMap(bjVar.aCH().dislikeInfo);
                this.eNx.setData(alVar);
            } else {
                if (this.eNx != null && this.eNx.getVisibility() != 8) {
                    this.eNx.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eNy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNy.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eNy.setLayoutParams(layoutParams);
            }
            if (this.eNy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNy.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eNy.setLayoutParams(layoutParams2);
            }
            if (this.eNx != null) {
                this.eNx.aWn();
            }
        }
    }

    public View bgX() {
        return this.eNx;
    }

    public void onChangeSkinType() {
        if (this.eNx != null) {
            this.eNx.onChangeSkinType();
        }
    }
}
