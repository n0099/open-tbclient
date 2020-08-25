package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.r;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.y.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup fZu;
    private b gzE;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.w.a.Nk().beH.CI() && (viewGroup instanceof PendantParentView)) {
            if (this.gzE == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.gzE = (b) runTask.getData();
            }
            if (this.gzE != null) {
                this.gzE.setOtherParams(JY());
                this.gzE.ND();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView NC;
        if (pendantParentView != null) {
            this.fZu = pendantParentView;
            if (this.gzE != null && (NC = this.gzE.NC()) != null && pendantParentView.indexOfChild(NC) < 0) {
                if (layoutParams == null) {
                    layoutParams = bRQ();
                }
                pendantParentView.a(NC, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bRQ() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        if (this.gzE != null) {
            PendantChildView NC = this.gzE.NC();
            if (NC != null && NC.getParent() != null) {
                ((ViewGroup) NC.getParent()).removeView(NC);
            }
            this.gzE.NE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gzE != null) {
            PendantChildView NC = this.gzE.NC();
            if (NC != null && NC.getParent() != null) {
                ((ViewGroup) NC.getParent()).removeView(NC);
            }
            this.gzE.onDestroy();
        }
    }

    public void I(JSONObject jSONObject) {
        if (this.gzE != null) {
            this.gzE.N(jSONObject);
        }
    }

    public void v(r rVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bRR();
        }
        if (this.gzE != null && this.gzE.NC() != null && rVar != null) {
            this.gzE.j(rVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.gzE != null) {
            this.gzE.setCanVisible(z);
        }
    }

    public void bRR() {
        if (this.gzE != null && this.gzE.NC() != null) {
            this.gzE.NC().setVisibility(8);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
