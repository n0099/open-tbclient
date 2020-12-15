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
    private NEGFeedBackView hbY;
    private ViewGroup hbZ;
    private NEGFeedBackView.a hca = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
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
        this.hbZ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(by byVar, String str) {
        int i = 0;
        if (byVar != null && byVar.bpj() != null && this.mPageContext != null && this.hbZ != null) {
            boolean z = (byVar.boP() == null || byVar.boP().getUserId() == null || !byVar.boP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && byVar.bpj().dislikeInfo != null && !z && byVar.bpj().dislikeInfo.size() > 0) {
                if (this.hbY == null) {
                    this.hbY = new NEGFeedBackView(this.mPageContext);
                    this.hbY.setUniqueId(this.mBdUniqueId);
                    this.hbY.setId(R.id.negative_feedback_view);
                    this.hbY.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hbY.setEventCallback(this.hca);
                    this.hbY.b(this.hbZ, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hbY.onChangeSkinType();
                }
                if (this.hbY.getVisibility() != 0) {
                    this.hbY.setVisibility(0);
                }
                at atVar = new at();
                atVar.setTid(byVar.getTid());
                atVar.setFid(byVar.getFid());
                atVar.setNid(byVar.getNid());
                atVar.setType(str);
                atVar.setFeedBackReasonMap(byVar.bpj().dislikeInfo);
                this.hbY.setData(atVar);
            } else {
                if (this.hbY != null && this.hbY.getVisibility() != 8) {
                    this.hbY.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hbZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hbZ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hbZ.setLayoutParams(layoutParams);
            }
            if (this.hbZ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hbZ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hbZ.setLayoutParams(layoutParams2);
            }
            if (this.hbY != null) {
                this.hbY.bLq();
            }
        }
    }

    public View bZa() {
        return this.hbY;
    }

    public void onChangeSkinType() {
        if (this.hbY != null) {
            this.hbY.onChangeSkinType();
        }
    }
}
