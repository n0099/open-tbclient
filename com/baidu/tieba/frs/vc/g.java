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
    private NEGFeedBackView dBq;
    private ViewGroup dBr;
    private NEGFeedBackView.a dBs = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.dBr = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bqF() {
        return this.dBq != null && this.dBq.getVisibility() == 0;
    }

    public void am(bg bgVar) {
        int i = 0;
        if (bgVar != null && this.mPageContext != null && this.dBr != null) {
            boolean z = (bgVar.adv() == null || bgVar.adv().getUserId() == null || !bgVar.adv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bgVar.aeE() && bgVar.ace() != null && !z) {
                if (this.dBq == null) {
                    this.dBq = new NEGFeedBackView(this.mPageContext);
                    this.dBq.setUniqueId(this.mBdUniqueId);
                    this.dBq.setId(R.id.negative_feedback_view);
                    this.dBq.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dBq.setEventCallback(this.dBs);
                    this.dBq.a(this.dBr, l.g(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dBq.onChangeSkinType();
                }
                if (this.dBq.getVisibility() != 0) {
                    this.dBq.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(bgVar.ace());
                this.dBq.setData(ajVar);
            } else {
                if (this.dBq != null && this.dBq.getVisibility() != 8) {
                    this.dBq.setVisibility(8);
                }
                i = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dBr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dBr.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dBr.setLayoutParams(layoutParams);
            }
            if (this.dBr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dBr.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dBr.setLayoutParams(layoutParams2);
            }
            if (this.dBq != null) {
                this.dBq.azZ();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dBq != null) {
            this.dBq.onChangeSkinType();
        }
    }
}
