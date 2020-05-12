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
    private NEGFeedBackView fsH;
    private ViewGroup fsI;
    private NEGFeedBackView.a fsJ = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
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
                TiebaStatic.log(new an("c11974").cI("obj_locate", sb.toString()).cI("fid", alVar.getFid()).cI("tid", alVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("source", alVar.source).cI(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cI(TiebaInitialize.Params.AB_TAG, alVar.dpc).cI("extra", alVar.extra).af("card_type", alVar.cardType).af("obj_floor", alVar.dpd));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fsI = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bVC() {
        return this.fsH != null && this.fsH.getVisibility() == 0;
    }

    public void az(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.fsI != null) {
            boolean z = (bjVar.aKC() == null || bjVar.aKC().getUserId() == null || !bjVar.aKC().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aLO() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.fsH == null) {
                    this.fsH = new NEGFeedBackView(this.mPageContext);
                    this.fsH.setUniqueId(this.mBdUniqueId);
                    this.fsH.setId(R.id.negative_feedback_view);
                    this.fsH.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fsH.setEventCallback(this.fsJ);
                    this.fsH.a(this.fsI, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.fsH.onChangeSkinType();
                }
                if (this.fsH.getVisibility() != 0) {
                    this.fsH.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.fsH.setData(alVar);
            } else {
                if (this.fsH != null && this.fsH.getVisibility() != 8) {
                    this.fsH.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fsI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fsI.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fsI.setLayoutParams(layoutParams);
            }
            if (this.fsI.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsI.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fsI.setLayoutParams(layoutParams2);
            }
            if (this.fsH != null) {
                this.fsH.beB();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.fsH != null) {
            this.fsH.onChangeSkinType();
        }
    }
}
