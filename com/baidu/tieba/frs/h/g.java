package com.baidu.tieba.frs.h;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.core.view.h bKk;
    private ViewGroup cHA;
    private h.a cHB = new h.a() { // from class: com.baidu.tieba.frs.h.g.1
        @Override // com.baidu.tbadk.core.view.h.a
        public void a(an anVar) {
            TiebaStatic.log(new ak("c11973").ad("fid", anVar.getFid()).ad("tid", anVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tbadk.core.view.h.a
        public void a(an anVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tbadk.core.view.h.a
        public void a(ArrayList<Integer> arrayList, an anVar) {
            if (arrayList != null && anVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ak("c11974").ad("obj_locate", sb.toString()).ad("fid", anVar.getFid()).ad("tid", anVar.getTid()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mF;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mF = tbPageContext;
        this.cHA = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void T(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mF != null && this.cHA != null) {
            boolean z = (bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null || !bjVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.sE() && bjVar.qs() != null && !z) {
                if (this.bKk == null) {
                    this.bKk = new com.baidu.tbadk.core.view.h(this.mF);
                    this.bKk.setUniqueId(this.mBdUniqueId);
                    this.bKk.setId(d.h.negative_feedback_view);
                    this.bKk.wI();
                    this.bKk.setLeftPadding((int) this.mF.getResources().getDimension(d.f.ds60));
                    this.bKk.setDefaultReasonArray(new String[]{this.mF.getString(d.l.bad_quality), "", ""});
                    this.bKk.setEventCallback(this.cHB);
                    this.cHA.addView(this.bKk);
                }
                if (this.bKk.getVisibility() != 0) {
                    this.bKk.setVisibility(0);
                }
                an anVar = new an();
                anVar.cy(bjVar.getTid());
                anVar.setFid(bjVar.getFid());
                anVar.a(bjVar.qs());
                this.bKk.setData(anVar);
            } else {
                if (this.bKk != null && this.bKk.getVisibility() != 8) {
                    this.bKk.setVisibility(8);
                }
                i = k.f(this.mF.getPageActivity(), d.f.ds32);
            }
            if (this.cHA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cHA.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cHA.setLayoutParams(layoutParams);
            }
            if (this.cHA.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cHA.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cHA.setLayoutParams(layoutParams2);
            }
            if (this.bKk != null) {
                this.bKk.wK();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bKk != null) {
            this.bKk.onChangeSkinType();
        }
    }
}
