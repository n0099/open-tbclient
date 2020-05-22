package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class i {
    private ViewGroup fGA;
    private NEGFeedBackView.a fGB = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.i.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(ak akVar) {
            TiebaStatic.log(new an("c11973").dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ak akVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, ak akVar) {
            if (arrayList != null && akVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new an("c11974").dh("obj_locate", sb.toString()).dh("fid", akVar.getFid()).dh("tid", akVar.getTid()).dh("nid", akVar.getNid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("source", akVar.source).dh("weight", akVar.weight).dh("ab_tag", akVar.abTag).dh("extra", akVar.extra).ag(IntentConfig.CARD_TYPE, akVar.cardType).ag("obj_floor", akVar.dDb));
            }
        }
    };
    private NEGFeedBackView fGz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public i(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.fGA = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean cca() {
        return this.fGz != null && this.fGz.getVisibility() == 0;
    }

    public void aA(bk bkVar) {
        int i = 0;
        if (bkVar != null && this.mPageContext != null && this.fGA != null) {
            boolean z = (bkVar.aQx() == null || bkVar.aQx().getUserId() == null || !bkVar.aQx().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bkVar.aRN() && bkVar.getFeedBackReasonMap() != null && !z) {
                if (this.fGz == null) {
                    this.fGz = new NEGFeedBackView(this.mPageContext);
                    this.fGz.setUniqueId(this.mBdUniqueId);
                    this.fGz.setId(R.id.negative_feedback_view);
                    this.fGz.setDefaultReasonArray(new String[]{this.mPageContext.getString(R.string.bad_quality), "", ""});
                    this.fGz.setEventCallback(this.fGB);
                    this.fGz.a(this.fGA, com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds120), 0);
                    this.fGz.onChangeSkinType();
                }
                if (this.fGz.getVisibility() != 0) {
                    this.fGz.setVisibility(0);
                }
                ak akVar = new ak();
                akVar.setTid(bkVar.getTid());
                akVar.setFid(bkVar.getFid());
                akVar.setNid(bkVar.getNid());
                akVar.setFeedBackReasonMap(bkVar.getFeedBackReasonMap());
                this.fGz.setData(akVar);
            } else {
                if (this.fGz != null && this.fGz.getVisibility() != 8) {
                    this.fGz.setVisibility(8);
                }
                i = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.ds32);
            }
            if (this.fGA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGA.getLayoutParams();
                layoutParams.rightMargin = i;
                this.fGA.setLayoutParams(layoutParams);
            }
            if (this.fGA.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fGA.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.fGA.setLayoutParams(layoutParams2);
            }
            if (this.fGz != null) {
                this.fGz.bkO();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.fGz != null) {
            this.fGz.onChangeSkinType();
        }
    }
}
