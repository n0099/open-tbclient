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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    private NEGFeedBackView hpp;
    private ViewGroup hpq;
    private NEGFeedBackView.a hpr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.ala.livecard.vc.a.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackWindowShow(av avVar) {
            if (avVar != null) {
                if ("ala_frs_demo_hell_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12802").dR("tid", avVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12806").dR("tid", avVar.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar) {
            if (arrayList != null && avVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12803").dR("tid", avVar.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(avVar.getType())) {
                    TiebaStatic.log(new ar("c12807").dR("tid", avVar.getTid()));
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.hpq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void l(cb cbVar, String str) {
        int i = 0;
        if (cbVar != null && cbVar.bol() != null && this.mPageContext != null && this.hpq != null) {
            boolean z = (cbVar.bnS() == null || cbVar.bnS().getUserId() == null || !cbVar.bnS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (TbadkCoreApplication.isLogin() && cbVar.bol().dislikeInfo != null && !z && cbVar.bol().dislikeInfo.size() > 0) {
                if (this.hpp == null) {
                    this.hpp = new NEGFeedBackView(this.mPageContext);
                    this.hpp.setUniqueId(this.mBdUniqueId);
                    this.hpp.setId(R.id.negative_feedback_view);
                    this.hpp.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.hpp.setEventCallback(this.hpr);
                    this.hpp.b(this.hpq, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds20));
                    this.hpp.onChangeSkinType();
                }
                if (this.hpp.getVisibility() != 0) {
                    this.hpp.setVisibility(0);
                }
                av avVar = new av();
                avVar.setTid(cbVar.getTid());
                avVar.setFid(cbVar.getFid());
                avVar.setNid(cbVar.bmq());
                avVar.setType(str);
                avVar.setFeedBackReasonMap(cbVar.bol().dislikeInfo);
                this.hpp.setData(avVar);
            } else {
                if (this.hpp != null && this.hpp.getVisibility() != 8) {
                    this.hpp.setVisibility(8);
                }
                i = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.hpq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hpq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.hpq.setLayoutParams(layoutParams);
            }
            if (this.hpq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hpq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.hpq.setLayoutParams(layoutParams2);
            }
            if (this.hpp != null) {
                this.hpp.bKu();
            }
        }
    }

    public View bZb() {
        return this.hpp;
    }

    public void onChangeSkinType() {
        if (this.hpp != null) {
            this.hpp.onChangeSkinType();
        }
    }
}
