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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private NEGFeedBackView dGE;
    private ViewGroup dGF;
    private NEGFeedBackView.a dGG = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            TiebaStatic.log(new an("c11973").bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").bT("obj_locate", sb.toString()).bT("fid", ajVar.getFid()).bT("tid", ajVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dGF = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean btI() {
        return this.dGE != null && this.dGE.getVisibility() == 0;
    }

    public void ao(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mPageContext != null && this.dGF != null) {
            boolean z = (bhVar.aeC() == null || bhVar.aeC().getUserId() == null || !bhVar.aeC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.afL() && bhVar.adl() != null && !z) {
                if (this.dGE == null) {
                    this.dGE = new NEGFeedBackView(this.mPageContext);
                    this.dGE.setUniqueId(this.mBdUniqueId);
                    this.dGE.setId(R.id.negative_feedback_view);
                    this.dGE.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dGE.setEventCallback(this.dGG);
                    this.dGE.a(this.dGF, l.g(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dGE.onChangeSkinType();
                }
                if (this.dGE.getVisibility() != 0) {
                    this.dGE.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bhVar.getTid());
                ajVar.setFid(bhVar.getFid());
                ajVar.b(bhVar.adl());
                this.dGE.setData(ajVar);
            } else {
                if (this.dGE != null && this.dGE.getVisibility() != 8) {
                    this.dGE.setVisibility(8);
                }
                i = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dGF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dGF.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dGF.setLayoutParams(layoutParams);
            }
            if (this.dGF.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dGF.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dGF.setLayoutParams(layoutParams2);
            }
            if (this.dGE != null) {
                this.dGE.aBD();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dGE != null) {
            this.dGE.onChangeSkinType();
        }
    }
}
