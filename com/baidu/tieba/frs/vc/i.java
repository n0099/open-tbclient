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
/* loaded from: classes9.dex */
public class i {
    private NEGFeedBackView eOi;
    private ViewGroup eOj;
    private NEGFeedBackView.a eOk = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            TiebaStatic.log(new an("c11973").cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").cx("obj_locate", sb.toString()).cx("fid", alVar.getFid()).cx("tid", alVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("source", alVar.source).cx(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cx(TiebaInitialize.Params.AB_TAG, alVar.cPS).cx("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPT));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eOj = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bLd() {
        return this.eOi != null && this.eOi.getVisibility() == 0;
    }

    public void ay(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.eOj != null) {
            boolean z = (bjVar.aCr() == null || bjVar.aCr().getUserId() == null || !bjVar.aCr().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aDD() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.eOi == null) {
                    this.eOi = new NEGFeedBackView(this.mPageContext);
                    this.eOi.setUniqueId(this.mBdUniqueId);
                    this.eOi.setId(R.id.negative_feedback_view);
                    this.eOi.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eOi.setEventCallback(this.eOk);
                    this.eOi.a(this.eOj, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.eOi.onChangeSkinType();
                }
                if (this.eOi.getVisibility() != 0) {
                    this.eOi.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.eOi.setData(alVar);
            } else {
                if (this.eOi != null && this.eOi.getVisibility() != 8) {
                    this.eOi.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eOj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eOj.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eOj.setLayoutParams(layoutParams);
            }
            if (this.eOj.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eOj.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eOj.setLayoutParams(layoutParams2);
            }
            if (this.eOi != null) {
                this.eOi.aWs();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.eOi != null) {
            this.eOi.onChangeSkinType();
        }
    }
}
