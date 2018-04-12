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
    private NEGFeedBackView bww;
    private ViewGroup bwx;
    private NEGFeedBackView.a bwy = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.bwx = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean avr() {
        return this.bww != null && this.bww.getVisibility() == 0;
    }

    public void X(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.bwx != null) {
            boolean z = (bdVar.rQ() == null || bdVar.rQ().getUserId() == null || !bdVar.rQ().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.sP() && bdVar.qU() != null && !z) {
                if (this.bww == null) {
                    this.bww = new NEGFeedBackView(this.mPageContext);
                    this.bww.setUniqueId(this.mBdUniqueId);
                    this.bww.setId(d.g.negative_feedback_view);
                    this.bww.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.k.bad_quality), "", ""});
                    this.bww.setEventCallback(this.bwy);
                    this.bww.a(this.bwx, l.e(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.bww.onChangeSkinType();
                }
                if (this.bww.getVisibility() != 0) {
                    this.bww.setVisibility(0);
                }
                ai aiVar = new ai();
                aiVar.cJ(bdVar.getTid());
                aiVar.setFid(bdVar.getFid());
                aiVar.a(bdVar.qU());
                this.bww.setData(aiVar);
            } else {
                if (this.bww != null && this.bww.getVisibility() != 8) {
                    this.bww.setVisibility(8);
                }
                i = l.e(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.bwx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwx.getLayoutParams();
                layoutParams.rightMargin = i;
                this.bwx.setLayoutParams(layoutParams);
            }
            if (this.bwx.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bwx.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.bwx.setLayoutParams(layoutParams2);
            }
            if (this.bww != null) {
                this.bww.Lx();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.bww != null) {
            this.bww.onChangeSkinType();
        }
    }
}
