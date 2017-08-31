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
    private com.baidu.tbadk.core.view.h bJt;
    private ViewGroup cGG;
    private h.a cGH = new h.a() { // from class: com.baidu.tieba.frs.h.g.1
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
        this.cGG = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void T(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mF != null && this.cGG != null) {
            boolean z = (bjVar.getAuthor() == null || bjVar.getAuthor().getUserId() == null || !bjVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.sE() && bjVar.qs() != null && !z) {
                if (this.bJt == null) {
                    this.bJt = new com.baidu.tbadk.core.view.h(this.mF);
                    this.bJt.setUniqueId(this.mBdUniqueId);
                    this.bJt.setId(d.h.negative_feedback_view);
                    this.bJt.wI();
                    this.bJt.setLeftPadding((int) this.mF.getResources().getDimension(d.f.ds60));
                    this.bJt.setDefaultReasonArray(new String[]{this.mF.getString(d.l.bad_quality), "", ""});
                    this.bJt.setEventCallback(this.cGH);
                    this.cGG.addView(this.bJt);
                }
                if (this.bJt.getVisibility() != 0) {
                    this.bJt.setVisibility(0);
                }
                an anVar = new an();
                anVar.cy(bjVar.getTid());
                anVar.setFid(bjVar.getFid());
                anVar.a(bjVar.qs());
                this.bJt.setData(anVar);
            } else {
                if (this.bJt != null && this.bJt.getVisibility() != 8) {
                    this.bJt.setVisibility(8);
                }
                i = k.g(this.mF.getPageActivity(), d.f.ds32);
            }
            if (this.cGG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGG.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cGG.setLayoutParams(layoutParams);
            }
            if (this.cGG.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cGG.setLayoutParams(layoutParams2);
            }
            if (this.bJt != null) {
                this.bJt.wK();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bJt != null) {
            this.bJt.onChangeSkinType();
        }
    }
}
