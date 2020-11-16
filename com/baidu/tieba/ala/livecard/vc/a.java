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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private NEGFeedBackView gSJ;
    private ViewGroup gSK;
    private NEGFeedBackView.a gSL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(as asVar) {
            if (asVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(asVar.getType())) {
                    TiebaStatic.log(new ar("c12802").dR("tid", asVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(asVar.getType())) {
                    TiebaStatic.log(new ar("c12806").dR("tid", asVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(as asVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, as asVar) {
            if (arrayList != null && asVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(asVar.getType())) {
                    TiebaStatic.log(new ar("c12803").dR("tid", asVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(asVar.getType())) {
                    TiebaStatic.log(new ar("c12807").dR("tid", asVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.gSK = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(bx bxVar, String str) {
        int i = 0;
        if (bxVar != null && bxVar.blW() != null && this.mPageContext != null && this.gSK != null) {
            boolean z = (bxVar.blC() == null || bxVar.blC().getUserId() == null || !bxVar.blC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && bxVar.blW().dislikeInfo != null && !z && bxVar.blW().dislikeInfo.size() > 0) {
                if (this.gSJ == null) {
                    this.gSJ = new NEGFeedBackView(this.mPageContext);
                    this.gSJ.setUniqueId(this.mBdUniqueId);
                    this.gSJ.setId(R.id.negative_feedback_view);
                    this.gSJ.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.gSJ.setEventCallback(this.gSL);
                    this.gSJ.b(this.gSK, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.gSJ.onChangeSkinType();
                }
                if (this.gSJ.getVisibility() != 0) {
                    this.gSJ.setVisibility(0);
                }
                as asVar = new as();
                asVar.setTid(bxVar.getTid());
                asVar.setFid(bxVar.getFid());
                asVar.setNid(bxVar.getNid());
                asVar.setType(str);
                asVar.setFeedBackReasonMap(bxVar.blW().dislikeInfo);
                this.gSJ.setData(asVar);
            } else {
                if (this.gSJ != null && this.gSJ.getVisibility() != 8) {
                    this.gSJ.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.gSK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gSK.getLayoutParams();
                layoutParams.rightMargin = i;
                this.gSK.setLayoutParams(layoutParams);
            }
            if (this.gSK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gSK.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.gSK.setLayoutParams(layoutParams2);
            }
            if (this.gSJ != null) {
                this.gSJ.bHP();
            }
        }
    }

    public View bVp() {
        return this.gSJ;
    }

    public void onChangeSkinType() {
        if (this.gSJ != null) {
            this.gSJ.onChangeSkinType();
        }
    }
}
