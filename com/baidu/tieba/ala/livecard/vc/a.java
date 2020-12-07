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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private NEGFeedBackView hbW;
    private ViewGroup hbX;
    private NEGFeedBackView.a hbY = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(at atVar) {
            if (atVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new ar("c12802").dY("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new ar("c12806").dY("tid", atVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar) {
            if (arrayList != null && atVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new ar("c12803").dY("tid", atVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(atVar.getType())) {
                    TiebaStatic.log(new ar("c12807").dY("tid", atVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hbX = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(by byVar, String str) {
        int i = 0;
        if (byVar != null && byVar.bpj() != null && this.mPageContext != null && this.hbX != null) {
            boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && byVar.bpj().dislikeInfo != null && !z && byVar.bpj().dislikeInfo.size() > 0) {
                if (this.hbW == null) {
                    this.hbW = new NEGFeedBackView(this.mPageContext);
                    this.hbW.setUniqueId(this.mBdUniqueId);
                    this.hbW.setId(R.id.negative_feedback_view);
                    this.hbW.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hbW.setEventCallback(this.hbY);
                    this.hbW.b(this.hbX, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hbW.onChangeSkinType();
                }
                if (this.hbW.getVisibility() != 0) {
                    this.hbW.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(byVar.getTid());
                atVar.setFid(byVar.getFid());
                atVar.setNid(byVar.getNid());
                atVar.setType(str);
                atVar.setFeedBackReasonMap(byVar.bpj().dislikeInfo);
                this.hbW.setData(atVar);
            } else {
                if (this.hbW != null && this.hbW.getVisibility() != 8) {
                    this.hbW.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hbX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbX.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hbX.setLayoutParams(layoutParams);
            }
            if (this.hbX.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hbX.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hbX.setLayoutParams(layoutParams2);
            }
            if (this.hbW != null) {
                this.hbW.bLp();
            }
        }
    }

    public View bYZ() {
        return this.hbW;
    }

    public void onChangeSkinType() {
        if (this.hbW != null) {
            this.hbW.onChangeSkinType();
        }
    }
}
