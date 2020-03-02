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
    private NEGFeedBackView eNx;
    private ViewGroup eNy;
    private NEGFeedBackView.a eNz = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(al alVar) {
            TiebaStatic.log(new an("c11973").cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPE).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPF));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eNy = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bKP() {
        return this.eNx != null && this.eNx.getVisibility() == 0;
    }

    public void ax(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.eNy != null) {
            boolean z = (bjVar.aCo() == null || bjVar.aCo().getUserId() == null || !bjVar.aCo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aDz() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.eNx == null) {
                    this.eNx = new NEGFeedBackView(this.mPageContext);
                    this.eNx.setUniqueId(this.mBdUniqueId);
                    this.eNx.setId(R.id.negative_feedback_view);
                    this.eNx.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eNx.setEventCallback(this.eNz);
                    this.eNx.a(this.eNy, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.eNx.onChangeSkinType();
                }
                if (this.eNx.getVisibility() != 0) {
                    this.eNx.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.eNx.setData(alVar);
            } else {
                if (this.eNx != null && this.eNx.getVisibility() != 8) {
                    this.eNx.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eNy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNy.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eNy.setLayoutParams(layoutParams);
            }
            if (this.eNy.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNy.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eNy.setLayoutParams(layoutParams2);
            }
            if (this.eNx != null) {
                this.eNx.aWn();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.eNx != null) {
            this.eNx.onChangeSkinType();
        }
    }
}
