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
    private TbPageContext alI;
    private com.baidu.tbadk.core.view.h bFP;
    private ViewGroup cyq;
    private h.a cyr = new h.a() { // from class: com.baidu.tieba.frs.g.g.1
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

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.alI = tbPageContext;
        this.cyq = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void P(bl blVar) {
        int i = 0;
        if (blVar != null && this.alI != null && this.cyq != null) {
            boolean z = (blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || !blVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (blVar.sI() && blVar.qw() != null && !z) {
                if (this.bFP == null) {
                    this.bFP = new com.baidu.tbadk.core.view.h(this.alI);
                    this.bFP.setUniqueId(this.mBdUniqueId);
                    this.bFP.setId(d.h.negative_feedback_view);
                    this.bFP.wK();
                    this.bFP.setLeftPadding((int) this.alI.getResources().getDimension(d.f.ds60));
                    this.bFP.setDefaultReasonArray(new String[]{this.alI.getString(d.l.bad_quality), "", ""});
                    this.bFP.setEventCallback(this.cyr);
                    this.cyq.addView(this.bFP);
                }
                if (this.bFP.getVisibility() != 0) {
                    this.bFP.setVisibility(0);
                }
                an anVar = new an();
                anVar.cF(blVar.getTid());
                anVar.setFid(blVar.getFid());
                anVar.a(blVar.qw());
                this.bFP.setData(anVar);
            } else {
                if (this.bFP != null && this.bFP.getVisibility() != 8) {
                    this.bFP.setVisibility(8);
                }
                i = k.g(this.alI.getPageActivity(), d.f.ds32);
            }
            if (this.cyq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cyq.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cyq.setLayoutParams(layoutParams);
            }
            if (this.cyq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cyq.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cyq.setLayoutParams(layoutParams2);
            }
            if (this.bFP != null) {
                this.bFP.wM();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bFP != null) {
            this.bFP.onChangeSkinType();
        }
    }
}
