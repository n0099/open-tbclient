package com.baidu.tieba.frs.g;

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
    private com.baidu.tieba.NEGFeedBack.c cmv;
    private ViewGroup cmw;
    private c.a cmx = new c.a() { // from class: com.baidu.tieba.frs.g.g.1
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
        this.cmw = viewGroup;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public boolean aAu() {
        return this.cmv != null && this.cmv.getVisibility() == 0;
    }

    public void W(bd bdVar) {
        int i = 0;
        if (bdVar != null && this.mPageContext != null && this.cmw != null) {
            boolean z = (bdVar.zn() == null || bdVar.zn().getUserId() == null || !bdVar.zn().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bdVar.An() && bdVar.yo() != null && !z) {
                if (this.cmv == null) {
                    this.cmv = new com.baidu.tieba.NEGFeedBack.c(this.mPageContext);
                    this.cmv.setUniqueId(this.mBdUniqueId);
                    this.cmv.setId(d.g.negative_feedback_view);
                    this.cmv.setDefaultReasonArray(new String[]{this.mPageContext.getString(d.j.bad_quality), "", ""});
                    this.cmv.setEventCallback(this.cmx);
                    this.cmv.a(this.cmw, l.t(this.mPageContext.getPageActivity(), d.e.tbds120), 0);
                    this.cmv.onChangeSkinType();
                }
                if (this.cmv.getVisibility() != 0) {
                    this.cmv.setVisibility(0);
                }
                ah ahVar = new ah();
                ahVar.cV(bdVar.getTid());
                ahVar.setFid(bdVar.getFid());
                ahVar.a(bdVar.yo());
                this.cmv.setData(ahVar);
            } else {
                if (this.cmv != null && this.cmv.getVisibility() != 8) {
                    this.cmv.setVisibility(8);
                }
                i = l.t(this.mPageContext.getPageActivity(), d.e.ds32);
            }
            if (this.cmw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmw.getLayoutParams();
                layoutParams.rightMargin = i;
                this.cmw.setLayoutParams(layoutParams);
            }
            if (this.cmw.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.cmw.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.cmw.setLayoutParams(layoutParams2);
            }
            if (this.cmv != null) {
                this.cmv.Ta();
            }
        }
    }

    public void onChangeSkinType() {
        if (this.cmv != null) {
            this.cmv.onChangeSkinType();
        }
    }
}
