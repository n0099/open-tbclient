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
    private com.baidu.tbadk.core.view.h bGy;
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
    private TbPageContext oV;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.oV = tbPageContext;
        this.cAo = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void P(bl blVar) {
        int i = 0;
        if (blVar != null && this.oV != null && this.cAo != null) {
            boolean z = (blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || !blVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (blVar.sI() && blVar.qw() != null && !z) {
                if (this.bGy == null) {
                    this.bGy = new com.baidu.tbadk.core.view.h(this.oV);
                    this.bGy.setUniqueId(this.mBdUniqueId);
                    this.bGy.setId(d.h.negative_feedback_view);
                    this.bGy.wK();
                    this.bGy.setLeftPadding((int) this.oV.getResources().getDimension(d.f.ds60));
                    this.bGy.setDefaultReasonArray(new String[]{this.oV.getString(d.l.bad_quality), "", ""});
                    this.bGy.setEventCallback(this.cAp);
                    this.cAo.addView(this.bGy);
                }
                if (this.bGy.getVisibility() != 0) {
                    this.bGy.setVisibility(0);
                }
                an anVar = new an();
                anVar.cF(blVar.getTid());
                anVar.setFid(blVar.getFid());
                anVar.a(blVar.qw());
                this.bGy.setData(anVar);
            } else {
                if (this.bGy != null && this.bGy.getVisibility() != 8) {
                    this.bGy.setVisibility(8);
                }
                i = k.g(this.oV.getPageActivity(), d.f.ds32);
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
            if (this.bGy != null) {
                this.bGy.wM();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bGy != null) {
            this.bGy.onChangeSkinType();
        }
    }
}
