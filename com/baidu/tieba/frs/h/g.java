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
    private com.baidu.tieba.NEGFeedBack.c bJx;
    private ViewGroup cIq;
    private c.a cIr = new c.a() { // from class: com.baidu.tieba.frs.h.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(al alVar) {
            TiebaStatic.log(new ak("c11973").ad("fid", alVar.getFid()).ad("tid", alVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new ak("c11974").ad("obj_locate", sb.toString()).ad("fid", alVar.getFid()).ad("tid", alVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mG;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mG = tbPageContext;
        this.cIq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void O(bh bhVar) {
        int i = 0;
        if (bhVar != null && this.mG != null && this.cIq != null) {
            boolean z = (bhVar.getAuthor() == null || bhVar.getAuthor().getUserId() == null || !bhVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bhVar.sy() && bhVar.qm() != null && !z) {
                if (this.bJx == null) {
                    this.bJx = new com.baidu.tieba.NEGFeedBack.c(this.mG);
                    this.bJx.setUniqueId(this.mBdUniqueId);
                    this.bJx.setId(d.h.negative_feedback_view);
                    this.bJx.Kr();
                    this.bJx.setLeftPadding((int) this.mG.getResources().getDimension(d.f.ds60));
                    this.bJx.setDefaultReasonArray(new String[]{this.mG.getString(d.l.bad_quality), "", ""});
                    this.bJx.setEventCallback(this.cIr);
                    this.cIq.addView(this.bJx);
                }
                if (this.bJx.getVisibility() != 0) {
                    this.bJx.setVisibility(0);
                }
                al alVar = new al();
                alVar.cy(bhVar.getTid());
                alVar.setFid(bhVar.getFid());
                alVar.a(bhVar.qm());
                this.bJx.setData(alVar);
            } else {
                if (this.bJx != null && this.bJx.getVisibility() != 8) {
                    this.bJx.setVisibility(8);
                }
                i = l.f(this.mG.getPageActivity(), d.f.ds32);
            }
            if (this.cIq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cIq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cIq.setLayoutParams(layoutParams);
            }
            if (this.cIq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cIq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cIq.setLayoutParams(layoutParams2);
            }
            if (this.bJx != null) {
                this.bJx.Kt();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bJx != null) {
            this.bJx.onChangeSkinType();
        }
    }
}
