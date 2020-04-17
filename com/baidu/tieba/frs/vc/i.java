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
    private NEGFeedBackView fsC;
    private ViewGroup fsD;
    private NEGFeedBackView.a fsE = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            TiebaStatic.log(new an("c11973").cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.doY).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.doZ));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fsD = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bVD() {
        return this.fsC != null && this.fsC.getVisibility() == 0;
    }

    public void az(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.fsD != null) {
            boolean z = (bjVar.aKE() == null || bjVar.aKE().getUserId() == null || !bjVar.aKE().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aLQ() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.fsC == null) {
                    this.fsC = new NEGFeedBackView(this.mPageContext);
                    this.fsC.setUniqueId(this.mBdUniqueId);
                    this.fsC.setId(R.id.negative_feedback_view);
                    this.fsC.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fsC.setEventCallback(this.fsE);
                    this.fsC.a(this.fsD, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.fsC.onChangeSkinType();
                }
                if (this.fsC.getVisibility() != 0) {
                    this.fsC.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.fsC.setData(alVar);
            } else {
                if (this.fsC != null && this.fsC.getVisibility() != 8) {
                    this.fsC.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fsD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsD.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fsD.setLayoutParams(layoutParams);
            }
            if (this.fsD.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsD.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fsD.setLayoutParams(layoutParams2);
            }
            if (this.fsC != null) {
                this.fsC.beD();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.fsC != null) {
            this.fsC.onChangeSkinType();
        }
    }
}
