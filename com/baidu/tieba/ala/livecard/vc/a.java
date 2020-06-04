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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private NEGFeedBackView fGK;
    private ViewGroup fGL;
    private NEGFeedBackView.a fGM = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ak akVar) {
            if (akVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(akVar.getType())) {
                    TiebaStatic.log(new an("c12802").dh("tid", akVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(akVar.getType())) {
                    TiebaStatic.log(new an("c12806").dh("tid", akVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ak akVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
            if (arrayList != null && akVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(akVar.getType())) {
                    TiebaStatic.log(new an("c12803").dh("tid", akVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(akVar.getType())) {
                    TiebaStatic.log(new an("c12807").dh("tid", akVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fGL = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void e(bk bkVar, String str) {
        int i = 0;
        if (bkVar != null && bkVar.aQS() != null && this.mPageContext != null && this.fGL != null) {
            boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bkVar.aQS().dislikeInfo != null && !z && bkVar.aQS().dislikeInfo.size() > 0) {
                if (this.fGK == null) {
                    this.fGK = new NEGFeedBackView(this.mPageContext);
                    this.fGK.setUniqueId(this.mBdUniqueId);
                    this.fGK.setId(R.id.negative_feedback_view);
                    this.fGK.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fGK.setEventCallback(this.fGM);
                    this.fGK.b(this.fGL, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.fGK.onChangeSkinType();
                }
                if (this.fGK.getVisibility() != 0) {
                    this.fGK.setVisibility(0);
                }
                ak akVar = new ak();
                akVar.setTid(bkVar.getTid());
                akVar.setFid(bkVar.getFid());
                akVar.setNid(bkVar.getNid());
                akVar.setType(str);
                akVar.setFeedBackReasonMap(bkVar.aQS().dislikeInfo);
                this.fGK.setData(akVar);
            } else {
                if (this.fGK != null && this.fGK.getVisibility() != 8) {
                    this.fGK.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fGL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGL.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fGL.setLayoutParams(layoutParams);
            }
            if (this.fGL.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fGL.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fGL.setLayoutParams(layoutParams2);
            }
            if (this.fGK != null) {
                this.fGK.bkQ();
            }
        }
    }

    public View bwl() {
        return this.fGK;
    }

    public void onChangeSkinType() {
        if (this.fGK != null) {
            this.fGK.onChangeSkinType();
        }
    }
}
