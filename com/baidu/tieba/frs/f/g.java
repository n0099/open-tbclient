package com.baidu.tieba.frs.f;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private com.baidu.tieba.NEGFeedBack.c ciP;
    private ViewGroup ciQ;
    private c.a ciR = new c.a() { // from class: com.baidu.tieba.frs.f.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ai aiVar) {
            TiebaStatic.log(new ak("c11973").ab(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ab("tid", aiVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ArrayList<Integer> arrayList, ai aiVar) {
            if (arrayList != null && aiVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ak("c11974").ab("obj_locate", sb.toString()).ab(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ab("tid", aiVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.ciQ = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void T(be beVar) {
        int i = 0;
        if (beVar != null && this.mPageContext != null && this.ciQ != null) {
            boolean z = (beVar.yX() == null || beVar.yX().getUserId() == null || !beVar.yX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (beVar.Ab() && beVar.xO() != null && !z) {
                if (this.ciP == null) {
                    this.ciP = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.ciP.setUniqueId(this.mBdUniqueId);
                    this.ciP.setId(d.g.negative_feedback_view);
                    this.ciP.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.ciP.setEventCallback(this.ciR);
                    this.ciP.a(this.ciQ, l.s(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.ciP.onChangeSkinType();
                }
                if (this.ciP.getVisibility() != 0) {
                    this.ciP.setVisibility(0);
                }
                ai aiVar = new ai();
                aiVar.cK(beVar.getTid());
                aiVar.setFid(beVar.getFid());
                aiVar.a(beVar.xO());
                this.ciP.setData(aiVar);
            } else {
                if (this.ciP != null && this.ciP.getVisibility() != 8) {
                    this.ciP.setVisibility(8);
                }
                i = l.s(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.ciQ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciQ.getLayoutParams();
                layoutParams.rightMargin = i;
                this.ciQ.setLayoutParams(layoutParams);
            }
            if (this.ciQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ciQ.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.ciQ.setLayoutParams(layoutParams2);
            }
            if (this.ciP != null) {
                this.ciP.SD();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ciP != null) {
            this.ciP.onChangeSkinType();
        }
    }
}
