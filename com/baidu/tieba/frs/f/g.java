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
    private com.baidu.tieba.NEGFeedBack.c ciW;
    private ViewGroup ciX;
    private c.a ciY = new c.a() { // from class: com.baidu.tieba.frs.f.g.1
        @Override // com.baidu.tieba.NEGFeedBack.c.a
        public void a(ah ahVar) {
            TiebaStatic.log(new ak("c11973").ab(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ab("tid", ahVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
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
                TiebaStatic.log(new ak("c11974").ab("obj_locate", sb.toString()).ab(ImageViewerConfig.FORUM_ID, ahVar.getFid()).ab("tid", ahVar.getTid()).ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private TbPageContext mPageContext;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.mPageContext = tbPageContext;
        this.ciX = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void T(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.ciX != null) {
            boolean z = (bdVar.yS() == null || bdVar.yS().getUserId() == null || !bdVar.yS().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.zT() && bdVar.xL() != null && !z) {
                if (this.ciW == null) {
                    this.ciW = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.ciW.setUniqueId(this.mBdUniqueId);
                    this.ciW.setId(d.g.negative_feedback_view);
                    this.ciW.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.ciW.setEventCallback(this.ciY);
                    this.ciW.a(this.ciX, l.s(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.ciW.onChangeSkinType();
                }
                if (this.ciW.getVisibility() != 0) {
                    this.ciW.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.cK(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(bdVar.xL());
                this.ciW.setData(ahVar);
            } else {
                if (this.ciW != null && this.ciW.getVisibility() != 8) {
                    this.ciW.setVisibility(8);
                }
                i = l.s(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.ciX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ciX.getLayoutParams();
                layoutParams.rightMargin = i;
                this.ciX.setLayoutParams(layoutParams);
            }
            if (this.ciX.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ciX.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.ciX.setLayoutParams(layoutParams2);
            }
            if (this.ciW != null) {
                this.ciW.Sr();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.ciW != null) {
            this.ciW.onChangeSkinType();
        }
    }
}
