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
    private NEGFeedBackView eNw;
    private ViewGroup eNx;
    private NEGFeedBackView.a eNy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
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
                TiebaStatic.log(new an("c11974").cy("obj_locate", sb.toString()).cy("fid", alVar.getFid()).cy("tid", alVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("source", alVar.source).cy(TableDefine.SessionColumns.COLUMN_WEIGHT, alVar.weight).cy(TiebaInitialize.Params.AB_TAG, alVar.cPD).cy("extra", alVar.extra).X("card_type", alVar.cardType).X("obj_floor", alVar.cPE));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.eNx = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bKN() {
        return this.eNw != null && this.eNw.getVisibility() == 0;
    }

    public void ax(bj bjVar) {
        int i = 0;
        if (bjVar != null && this.mPageContext != null && this.eNx != null) {
            boolean z = (bjVar.aCm() == null || bjVar.aCm().getUserId() == null || !bjVar.aCm().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bjVar.aDx() && bjVar.getFeedBackReasonMap() != null && !z) {
                if (this.eNw == null) {
                    this.eNw = new NEGFeedBackView(this.mPageContext);
                    this.eNw.setUniqueId(this.mBdUniqueId);
                    this.eNw.setId(R.id.negative_feedback_view);
                    this.eNw.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.eNw.setEventCallback(this.eNy);
                    this.eNw.a(this.eNx, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.eNw.onChangeSkinType();
                }
                if (this.eNw.getVisibility() != 0) {
                    this.eNw.setVisibility(0);
                }
                al alVar = new al();
                alVar.setTid(bjVar.getTid());
                alVar.setFid(bjVar.getFid());
                alVar.setFeedBackReasonMap(bjVar.getFeedBackReasonMap());
                this.eNw.setData(alVar);
            } else {
                if (this.eNw != null && this.eNw.getVisibility() != 8) {
                    this.eNw.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.eNx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eNx.getLayoutParams();
                layoutParams.rightMargin = i;
                this.eNx.setLayoutParams(layoutParams);
            }
            if (this.eNx.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNx.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.eNx.setLayoutParams(layoutParams2);
            }
            if (this.eNw != null) {
                this.eNw.aWl();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.eNw != null) {
            this.eNw.onChangeSkinType();
        }
    }
}
