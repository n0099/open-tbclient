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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private NEGFeedBackView fRT;
    private ViewGroup fRU;
    private NEGFeedBackView.a fRV = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ap apVar) {
            if (apVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(apVar.getType())) {
                    TiebaStatic.log(new ao("c12802").dk("tid", apVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(apVar.getType())) {
                    TiebaStatic.log(new ao("c12806").dk("tid", apVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ap apVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ap apVar) {
            if (arrayList != null && apVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(apVar.getType())) {
                    TiebaStatic.log(new ao("c12803").dk("tid", apVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(apVar.getType())) {
                    TiebaStatic.log(new ao("c12807").dk("tid", apVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fRU = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bu buVar, String str) {
        int i = 0;
        if (buVar != null && buVar.aSJ() != null && this.mPageContext != null && this.fRU != null) {
            boolean z = (buVar.aSp() == null || buVar.aSp().getUserId() == null || !buVar.aSp().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && buVar.aSJ().dislikeInfo != null && !z && buVar.aSJ().dislikeInfo.size() > 0) {
                if (this.fRT == null) {
                    this.fRT = new NEGFeedBackView(this.mPageContext);
                    this.fRT.setUniqueId(this.mBdUniqueId);
                    this.fRT.setId(R.id.negative_feedback_view);
                    this.fRT.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fRT.setEventCallback(this.fRV);
                    this.fRT.b(this.fRU, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.fRT.onChangeSkinType();
                }
                if (this.fRT.getVisibility() != 0) {
                    this.fRT.setVisibility(0);
                }
                ap apVar = new ap();
                apVar.setTid(buVar.getTid());
                apVar.setFid(buVar.getFid());
                apVar.setNid(buVar.getNid());
                apVar.setType(str);
                apVar.setFeedBackReasonMap(buVar.aSJ().dislikeInfo);
                this.fRT.setData(apVar);
            } else {
                if (this.fRT != null && this.fRT.getVisibility() != 8) {
                    this.fRT.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fRU.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fRU.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fRU.setLayoutParams(layoutParams);
            }
            if (this.fRU.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fRU.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fRU.setLayoutParams(layoutParams2);
            }
            if (this.fRT != null) {
                this.fRT.bnp();
            }
        }
    }

    public View bzg() {
        return this.fRT;
    }

    public void onChangeSkinType() {
        if (this.fRT != null) {
            this.fRT.onChangeSkinType();
        }
    }
}
