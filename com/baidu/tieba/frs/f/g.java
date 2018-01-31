package com.baidu.tieba.frs.f;

import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class g {
    private com.baidu.tieba.NEGFeedBack.c cje;
    private ViewGroup cjf;
    private c.a cjg = new c.a() { // from class: com.baidu.tieba.frs.f.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ah ahVar) {
            TiebaStatic.log(new ak("c11973").aa(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aa("tid", ahVar.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ah ahVar, CompoundButton compoundButton, boolean z) {
        }

        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ArrayList<Integer> arrayList, ah ahVar) {
            if (arrayList != null && ahVar != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new ak("c11974").aa("obj_locate", sb.toString()).aa(ImageViewerConfig.FORUM_ID, ahVar.getFid()).aa("tid", ahVar.getTid()).aa("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.cjf = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void T(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.cjf != null) {
            boolean z = (bdVar.yT() == null || bdVar.yT().getUserId() == null || !bdVar.yT().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.zU() && bdVar.xM() != null && !z) {
                if (this.cje == null) {
                    this.cje = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.cje.setUniqueId(this.mBdUniqueId);
                    this.cje.setId(d.g.negative_feedback_view);
                    this.cje.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.cje.setEventCallback(this.cjg);
                    this.cje.a(this.cjf, l.s(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.cje.onChangeSkinType();
                }
                if (this.cje.getVisibility() != 0) {
                    this.cje.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.cK(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(bdVar.xM());
                this.cje.setData(ahVar);
            } else {
                if (this.cje != null && this.cje.getVisibility() != 8) {
                    this.cje.setVisibility(8);
                }
                i = l.s(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.cjf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cjf.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cjf.setLayoutParams(layoutParams);
            }
            if (this.cjf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cjf.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cjf.setLayoutParams(layoutParams2);
            }
            if (this.cje != null) {
                this.cje.St();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cje != null) {
            this.cje.onChangeSkinType();
        }
    }
}
