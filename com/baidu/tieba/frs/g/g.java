package com.baidu.tieba.frs.g;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tieba.NEGFeedBack.c bRe;
    private ViewGroup cRK;
    private c.a cRL = new c.a() { // from class: com.baidu.tieba.frs.g.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(al alVar) {
            TiebaStatic.log(new ak("c11973").ac(ImageViewerConfig.FORUM_ID, alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ArrayList<Integer> arrayList, al alVar) {
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ak("c11974").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.cRK = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Q(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mPageContext != null && this.cRK != null) {
            boolean z = (bhVar.rt() == null || bhVar.rt().getUserId() == null || !bhVar.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.sy() && bhVar.qk() != null && !z) {
                if (this.bRe == null) {
                    this.bRe = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.bRe.setUniqueId(this.mBdUniqueId);
                    this.bRe.setId(d.g.negative_feedback_view);
                    this.bRe.KF();
                    this.bRe.setLeftPadding((int) this.mPageContext.getResources().getDimension(d.e.ds60));
                    this.bRe.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.bRe.setEventCallback(this.cRL);
                    this.cRK.addView(this.bRe);
                }
                if (this.bRe.getVisibility() != 0) {
                    this.bRe.setVisibility(0);
                }
                al alVar = new al();
                alVar.cD(bhVar.getTid());
                alVar.setFid(bhVar.getFid());
                alVar.a(bhVar.qk());
                this.bRe.setData(alVar);
            } else {
                if (this.bRe != null && this.bRe.getVisibility() != 8) {
                    this.bRe.setVisibility(8);
                }
                i = l.f(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.cRK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cRK.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cRK.setLayoutParams(layoutParams);
            }
            if (this.cRK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cRK.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cRK.setLayoutParams(layoutParams2);
            }
            if (this.bRe != null) {
                this.bRe.KH();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bRe != null) {
            this.bRe.onChangeSkinType();
        }
    }
}
