package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private NEGFeedBackView dBp;
    private ViewGroup dBq;
    private NEGFeedBackView.a dBr = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            TiebaStatic.log(new am("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
            if (arrayList != null && ajVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new am("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dBq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bqC() {
        return this.dBp != null && this.dBp.getVisibility() == 0;
    }

    public void am(bg bgVar) {
        int i = 0;
        if (bgVar != null && this.mPageContext != null && this.dBq != null) {
            boolean z = (bgVar.adv() == null || bgVar.adv().getUserId() == null || !bgVar.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bgVar.aeE() && bgVar.ace() != null && !z) {
                if (this.dBp == null) {
                    this.dBp = new NEGFeedBackView(this.mPageContext);
                    this.dBp.setUniqueId(this.mBdUniqueId);
                    this.dBp.setId(R.id.negative_feedback_view);
                    this.dBp.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dBp.setEventCallback(this.dBr);
                    this.dBp.a(this.dBq, l.g(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dBp.onChangeSkinType();
                }
                if (this.dBp.getVisibility() != 0) {
                    this.dBp.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(bgVar.ace());
                this.dBp.setData(ajVar);
            } else {
                if (this.dBp != null && this.dBp.getVisibility() != 8) {
                    this.dBp.setVisibility(8);
                }
                i = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dBq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dBq.setLayoutParams(layoutParams);
            }
            if (this.dBq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dBq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dBq.setLayoutParams(layoutParams2);
            }
            if (this.dBp != null) {
                this.dBp.azW();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dBp != null) {
            this.dBp.onChangeSkinType();
        }
    }
}
