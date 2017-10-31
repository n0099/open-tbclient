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
    private com.baidu.tieba.NEGFeedBack.c bQR;
    private ViewGroup cRq;
    private c.a cRr = new c.a() { // from class: com.baidu.tieba.frs.g.g.1
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
        this.cRq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Q(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mPageContext != null && this.cRq != null) {
            boolean z = (bhVar.rt() == null || bhVar.rt().getUserId() == null || !bhVar.rt().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.sy() && bhVar.qk() != null && !z) {
                if (this.bQR == null) {
                    this.bQR = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.bQR.setUniqueId(this.mBdUniqueId);
                    this.bQR.setId(d.g.negative_feedback_view);
                    this.bQR.Ku();
                    this.bQR.setLeftPadding((int) this.mPageContext.getResources().getDimension(d.e.ds60));
                    this.bQR.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.bQR.setEventCallback(this.cRr);
                    this.cRq.addView(this.bQR);
                }
                if (this.bQR.getVisibility() != 0) {
                    this.bQR.setVisibility(0);
                }
                al alVar = new al();
                alVar.cD(bhVar.getTid());
                alVar.setFid(bhVar.getFid());
                alVar.a(bhVar.qk());
                this.bQR.setData(alVar);
            } else {
                if (this.bQR != null && this.bQR.getVisibility() != 8) {
                    this.bQR.setVisibility(8);
                }
                i = l.f(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.cRq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cRq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cRq.setLayoutParams(layoutParams);
            }
            if (this.cRq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cRq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cRq.setLayoutParams(layoutParams2);
            }
            if (this.bQR != null) {
                this.bQR.Kw();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bQR != null) {
            this.bQR.onChangeSkinType();
        }
    }
}
