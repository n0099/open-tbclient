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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private NEGFeedBackView dqG;
    private ViewGroup dqH;
    private NEGFeedBackView.a dqI = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void b(aj ajVar) {
            TiebaStatic.log(new am("c11973").bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(aj ajVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
        public void a(ArrayList<Integer> arrayList, String str, aj ajVar) {
            if (arrayList != null && ajVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new am("c11974").bJ("obj_locate", sb.toString()).bJ(ImageViewerConfig.FORUM_ID, ajVar.getFid()).bJ("tid", ajVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.dqH = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bjm() {
        return this.dqG != null && this.dqG.getVisibility() == 0;
    }

    public void an(bg bgVar) {
        int i = 0;
        if (bgVar != null && this.mPageContext != null && this.dqH != null) {
            boolean z = (bgVar.YR() == null || bgVar.YR().getUserId() == null || !bgVar.YR().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bgVar.aaa() && bgVar.XA() != null && !z) {
                if (this.dqG == null) {
                    this.dqG = new NEGFeedBackView(this.mPageContext);
                    this.dqG.setUniqueId(this.mBdUniqueId);
                    this.dqG.setId(d.g.negative_feedback_view);
                    this.dqG.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.dqG.setEventCallback(this.dqI);
                    this.dqG.a(this.dqH, l.h(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.dqG.onChangeSkinType();
                }
                if (this.dqG.getVisibility() != 0) {
                    this.dqG.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(bgVar.XA());
                this.dqG.setData(ajVar);
            } else {
                if (this.dqG != null && this.dqG.getVisibility() != 8) {
                    this.dqG.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.dqH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqH.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dqH.setLayoutParams(layoutParams);
            }
            if (this.dqH.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqH.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dqH.setLayoutParams(layoutParams2);
            }
            if (this.dqG != null) {
                this.dqG.auU();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dqG != null) {
            this.dqG.onChangeSkinType();
        }
    }
}
