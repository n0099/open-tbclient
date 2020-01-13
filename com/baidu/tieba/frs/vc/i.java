package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class i {
    private NEGFeedBackView eJD;
    private ViewGroup eJE;
    private NEGFeedBackView.a eJF = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            TiebaStatic.log(new an("c11973").cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(al alVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, al alVar) {
            if (arrayList != null && alVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new an("c11974").cp("obj_locate", sb.toString()).cp("fid", alVar.getFid()).cp("tid", alVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("source", alVar.source).cp(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cp(TiebaInitialize.Params.AB_TAG, alVar.cLA).cp("extra", alVar.extra).Z("card_type", alVar.cardType).Z("obj_floor", alVar.cLB));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eJE = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bJm() {
        return this.eJD != null && this.eJD.getVisibility() == 0;
    }

    public void at(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.eJE != null) {
            boolean z = (bjVar.azX() == null || bjVar.azX().getUserId() == null || !bjVar.azX().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aBk() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.eJD == null) {
                    this.eJD = new NEGFeedBackView(this.mPageContext);
                    this.eJD.setUniqueId(this.mBdUniqueId);
                    this.eJD.setId(R.id.negative_feedback_view);
                    this.eJD.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eJD.setEventCallback(this.eJF);
                    this.eJD.a(this.eJE, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.eJD.onChangeSkinType();
                }
                if (this.eJD.getVisibility() != 0) {
                    this.eJD.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.eJD.setData(alVar);
            } else {
                if (this.eJD != null && this.eJD.getVisibility() != 8) {
                    this.eJD.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eJE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJE.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eJE.setLayoutParams(layoutParams);
            }
            if (this.eJE.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eJE.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eJE.setLayoutParams(layoutParams2);
            }
            if (this.eJD != null) {
                this.eJD.aTV();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.eJD != null) {
            this.eJD.onChangeSkinType();
        }
    }
}
