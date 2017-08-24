package com.baidu.tieba.frs.g;

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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private com.baidu.tbadk.core.view.h bGz;
    private ViewGroup cAo;
    private h.a cAp = new h.a() { // from class: com.baidu.tieba.frs.g.g.1
        @Override // com.baidu.tbadk.core.view.h.a
        public void a(an anVar) {
            TiebaStatic.log(new aj("c11973").aa("fid", anVar.getFid()).aa("tid", anVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new aj("c11974").aa("obj_locate", sb.toString()).aa("fid", anVar.getFid()).aa("tid", anVar.getTid()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext oW;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.oW = tbPageContext;
        this.cAo = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void P(bl blVar) {
        int i = 0;
        if (blVar != null && this.oW != null && this.cAo != null) {
            boolean z = (blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || !blVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (blVar.sJ() && blVar.qx() != null && !z) {
                if (this.bGz == null) {
                    this.bGz = new com.baidu.tbadk.core.view.h(this.oW);
                    this.bGz.setUniqueId(this.mBdUniqueId);
                    this.bGz.setId(d.h.negative_feedback_view);
                    this.bGz.wL();
                    this.bGz.setLeftPadding((int) this.oW.getResources().getDimension(d.f.ds60));
                    this.bGz.setDefaultReasonArray(new String[]{this.oW.getString(d.l.bad_quality), "", ""});
                    this.bGz.setEventCallback(this.cAp);
                    this.cAo.addView(this.bGz);
                }
                if (this.bGz.getVisibility() != 0) {
                    this.bGz.setVisibility(0);
                }
                an anVar = new an();
                anVar.cI(blVar.getTid());
                anVar.setFid(blVar.getFid());
                anVar.a(blVar.qx());
                this.bGz.setData(anVar);
            } else {
                if (this.bGz != null && this.bGz.getVisibility() != 8) {
                    this.bGz.setVisibility(8);
                }
                i = k.g(this.oW.getPageActivity(), d.f.ds32);
            }
            if (this.cAo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cAo.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cAo.setLayoutParams(layoutParams);
            }
            if (this.cAo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cAo.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cAo.setLayoutParams(layoutParams2);
            }
            if (this.bGz != null) {
                this.bGz.wN();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bGz != null) {
            this.bGz.onChangeSkinType();
        }
    }
}
