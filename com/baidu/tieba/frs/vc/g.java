package com.baidu.tieba.frs.vc;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private NEGFeedBackView bxn;
    private ViewGroup bxo;
    private NEGFeedBackView.a bxp = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ai aiVar) {
            TiebaStatic.log(new al("c11973").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, ai aiVar) {
            if (arrayList != null && aiVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new al("c11974").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.bxo = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean avq() {
        return this.bxn != null && this.bxn.getVisibility() == 0;
    }

    public void X(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.bxo != null) {
            boolean z = (bdVar.rP() == null || bdVar.rP().getUserId() == null || !bdVar.rP().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.sO() && bdVar.qT() != null && !z) {
                if (this.bxn == null) {
                    this.bxn = new NEGFeedBackView(this.mPageContext);
                    this.bxn.setUniqueId(this.mBdUniqueId);
                    this.bxn.setId(d.g.negative_feedback_view);
                    this.bxn.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.k.bad_quality), "", ""});
                    this.bxn.setEventCallback(this.bxp);
                    this.bxn.a(this.bxo, l.e(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.bxn.onChangeSkinType();
                }
                if (this.bxn.getVisibility() != 0) {
                    this.bxn.setVisibility(0);
                }
                ai aiVar = new ai();
                aiVar.cJ(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(bdVar.qT());
                this.bxn.setData(aiVar);
            } else {
                if (this.bxn != null && this.bxn.getVisibility() != 8) {
                    this.bxn.setVisibility(8);
                }
                i = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.bxo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bxo.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bxo.setLayoutParams(layoutParams);
            }
            if (this.bxo.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bxo.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bxo.setLayoutParams(layoutParams2);
            }
            if (this.bxn != null) {
                this.bxn.Lv();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bxn != null) {
            this.bxn.onChangeSkinType();
        }
    }
}
