package com.baidu.tieba.frs.h;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    private com.baidu.tieba.NEGFeedBack.c bJl;
    private ViewGroup cIe;
    private c.a cIf = new c.a() { // from class: com.baidu.tieba.frs.h.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(al alVar) {
            TiebaStatic.log(new ak("c11973").ac("fid", alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new ak("c11974").ac("obj_locate", sb.toString()).ac("fid", alVar.getFid()).ac("tid", alVar.getTid()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mH;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mH = tbPageContext;
        this.cIe = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void O(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mH != null && this.cIe != null) {
            boolean z = (bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null || !bhVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.sr() && bhVar.qf() != null && !z) {
                if (this.bJl == null) {
                    this.bJl = new com.baidu.tieba.NEGFeedBack.c(this.mH);
                    this.bJl.setUniqueId(this.mBdUniqueId);
                    this.bJl.setId(d.h.negative_feedback_view);
                    this.bJl.Kl();
                    this.bJl.setLeftPadding((int) this.mH.getResources().getDimension(d.f.ds60));
                    this.bJl.setDefaultReasonArray(new String[]{this.mH.getString(d.l.bad_quality), "", ""});
                    this.bJl.setEventCallback(this.cIf);
                    this.cIe.addView(this.bJl);
                }
                if (this.bJl.getVisibility() != 0) {
                    this.bJl.setVisibility(0);
                }
                al alVar = new al();
                alVar.cx(bhVar.getTid());
                alVar.setFid(bhVar.getFid());
                alVar.a(bhVar.qf());
                this.bJl.setData(alVar);
            } else {
                if (this.bJl != null && this.bJl.getVisibility() != 8) {
                    this.bJl.setVisibility(8);
                }
                i = l.f(this.mH.getPageActivity(), d.f.ds32);
            }
            if (this.cIe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cIe.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cIe.setLayoutParams(layoutParams);
            }
            if (this.cIe.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cIe.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cIe.setLayoutParams(layoutParams2);
            }
            if (this.bJl != null) {
                this.bJl.Kn();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bJl != null) {
            this.bJl.onChangeSkinType();
        }
    }
}
