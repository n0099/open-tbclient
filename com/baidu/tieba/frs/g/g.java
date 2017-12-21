package com.baidu.tieba.frs.g;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tieba.NEGFeedBack.c bZk;
    private ViewGroup dbg;
    private c.a dbh = new c.a() { // from class: com.baidu.tieba.frs.g.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ah ahVar) {
            TiebaStatic.log(new ak("c11973").ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ArrayList<Integer> arrayList, ah ahVar) {
            if (arrayList != null && ahVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ak("c11974").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ac("tid", ahVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dbg = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void U(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.dbg != null) {
            boolean z = (bdVar.rv() == null || bdVar.rv().getUserId() == null || !bdVar.rv().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.sz() && bdVar.ql() != null && !z) {
                if (this.bZk == null) {
                    this.bZk = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.bZk.setUniqueId(this.mBdUniqueId);
                    this.bZk.setId(d.g.negative_feedback_view);
                    this.bZk.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.bZk.setEventCallback(this.dbh);
                    this.bZk.a(this.dbg, l.f(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.bZk.onChangeSkinType();
                }
                if (this.bZk.getVisibility() != 0) {
                    this.bZk.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.cD(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(bdVar.ql());
                this.bZk.setData(ahVar);
            } else {
                if (this.bZk != null && this.bZk.getVisibility() != 8) {
                    this.bZk.setVisibility(8);
                }
                i = l.f(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.dbg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbg.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dbg.setLayoutParams(layoutParams);
            }
            if (this.dbg.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dbg.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dbg.setLayoutParams(layoutParams2);
            }
            if (this.bZk != null) {
                this.bZk.Le();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bZk != null) {
            this.bZk.onChangeSkinType();
        }
    }
}
