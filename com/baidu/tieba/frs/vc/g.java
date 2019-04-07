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
    private NEGFeedBackView dqJ;
    private ViewGroup dqK;
    private NEGFeedBackView.a dqL = new NEGFeedBackView.a() { // from class: com.baidu.tieba.frs.vc.g.1
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
        this.dqK = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean bjk() {
        return this.dqJ != null && this.dqJ.getVisibility() == 0;
    }

    public void am(bg bgVar) {
        int i = 0;
        if (bgVar != null && this.mPageContext != null && this.dqK != null) {
            boolean z = (bgVar.YO() == null || bgVar.YO().getUserId() == null || !bgVar.YO().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bgVar.ZX() && bgVar.Xx() != null && !z) {
                if (this.dqJ == null) {
                    this.dqJ = new NEGFeedBackView(this.mPageContext);
                    this.dqJ.setUniqueId(this.mBdUniqueId);
                    this.dqJ.setId(d.g.negative_feedback_view);
                    this.dqJ.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.dqJ.setEventCallback(this.dqL);
                    this.dqJ.a(this.dqK, l.h(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.dqJ.onChangeSkinType();
                }
                if (this.dqJ.getVisibility() != 0) {
                    this.dqJ.setVisibility(0);
                }
                aj ajVar = new aj();
                ajVar.setTid(bgVar.getTid());
                ajVar.setFid(bgVar.getFid());
                ajVar.b(bgVar.Xx());
                this.dqJ.setData(ajVar);
            } else {
                if (this.dqJ != null && this.dqJ.getVisibility() != 8) {
                    this.dqJ.setVisibility(8);
                }
                i = l.h(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.dqK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dqK.getLayoutParams();
                layoutParams.rightMargin = i;
                this.dqK.setLayoutParams(layoutParams);
            }
            if (this.dqK.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dqK.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.dqK.setLayoutParams(layoutParams2);
            }
            if (this.dqJ != null) {
                this.dqJ.auR();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.dqJ != null) {
            this.dqJ.onChangeSkinType();
        }
    }
}
