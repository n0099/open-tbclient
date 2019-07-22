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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private NEGFeedBackView dEM;
    private ViewGroup dEN;
    private NEGFeedBackView.a dEO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.dEN = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bsI() {
        return this.dEM != null && this.dEM.getVisibility() == 0;
    }

    public void am(bg bgVar) {
        int i = 0;
        if (bgVar != null && this.mPageContext != null && this.dEN != null) {
            boolean z = (bgVar.aex() == null || bgVar.aex().getUserId() == null || !bgVar.aex().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bgVar.afG() && bgVar.adg() != null && !z) {
                if (this.dEM == null) {
                    this.dEM = new NEGFeedBackView(this.mPageContext);
                    this.dEM.setUniqueId(this.mBdUniqueId);
                    this.dEM.setId(R.id.negative_feedback_view);
                    this.dEM.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.dEM.setEventCallback(this.dEO);
                    this.dEM.a(this.dEN, l.g(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.dEM.onChangeSkinType();
                }
                if (this.dEM.getVisibility() != 0) {
                    this.dEM.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(bgVar.adg());
                this.dEM.setData(ajVar);
            } else {
                if (this.dEM != null && this.dEM.getVisibility() != 8) {
                    this.dEM.setVisibility(8);
                }
                i = l.g(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.dEN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dEN.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dEN.setLayoutParams(layoutParams);
            }
            if (this.dEN.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dEN.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dEN.setLayoutParams(layoutParams2);
            }
            if (this.dEM != null) {
                this.dEM.aBn();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dEM != null) {
            this.dEM.onChangeSkinType();
        }
    }
}
