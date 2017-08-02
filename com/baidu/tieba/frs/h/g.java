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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g {
    private TbPageContext ako;
    private com.baidu.tbadk.core.view.h bEF;
    private ViewGroup cwW;
    private h.a cwX = new h.a() { // from class: com.baidu.tieba.frs.h.g.1
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
        this.ako = tbPageContext;
        this.cwW = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void P(bl blVar) {
        int i = 0;
        if (blVar != null && this.ako != null && this.cwW != null) {
            boolean z = (blVar.getAuthor() == null || blVar.getAuthor().getUserId() == null || !blVar.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (blVar.sy() && blVar.qm() != null && !z) {
                if (this.bEF == null) {
                    this.bEF = new com.baidu.tbadk.core.view.h(this.ako);
                    this.bEF.setUniqueId(this.mBdUniqueId);
                    this.bEF.setId(d.h.negative_feedback_view);
                    this.bEF.wA();
                    this.bEF.setLeftPadding((int) this.ako.getResources().getDimension(d.f.ds60));
                    this.bEF.setDefaultReasonArray(new String[]{this.ako.getString(d.l.bad_quality), "", ""});
                    this.bEF.setEventCallback(this.cwX);
                    this.cwW.addView(this.bEF);
                }
                if (this.bEF.getVisibility() != 0) {
                    this.bEF.setVisibility(0);
                }
                an anVar = new an();
                anVar.cz(blVar.getTid());
                anVar.setFid(blVar.getFid());
                anVar.a(blVar.qm());
                this.bEF.setData(anVar);
            } else {
                if (this.bEF != null && this.bEF.getVisibility() != 8) {
                    this.bEF.setVisibility(8);
                }
                i = k.g(this.ako.getPageActivity(), d.f.ds32);
            }
            if (this.cwW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwW.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cwW.setLayoutParams(layoutParams);
            }
            if (this.cwW.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cwW.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cwW.setLayoutParams(layoutParams2);
            }
            if (this.bEF != null) {
                this.bEF.wC();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bEF != null) {
            this.bEF.onChangeSkinType();
        }
    }
}
