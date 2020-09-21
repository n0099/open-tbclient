package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.u;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.z.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private b gCT;
    private ViewGroup gcM;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.x.a.NN().bhy.CY() && (viewGroup instanceof PendantParentView)) {
            if (this.gCT == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.gCT = (b) runTask.getData();
            }
            if (this.gCT != null) {
                this.gCT.setOtherParams(KD());
                this.gCT.Og();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Of;
        if (pendantParentView != null) {
            this.gcM = pendantParentView;
            if (this.gCT != null && (Of = this.gCT.Of()) != null && pendantParentView.indexOfChild(Of) < 0) {
                if (layoutParams == null) {
                    layoutParams = bTn();
                }
                pendantParentView.a(Of, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bTn() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BQ() {
        super.BQ();
        if (this.gCT != null) {
            PendantChildView Of = this.gCT.Of();
            if (Of != null && Of.getParent() != null) {
                ((ViewGroup) Of.getParent()).removeView(Of);
            }
            this.gCT.Oh();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gCT != null) {
            PendantChildView Of = this.gCT.Of();
            if (Of != null && Of.getParent() != null) {
                ((ViewGroup) Of.getParent()).removeView(Of);
            }
            this.gCT.onDestroy();
        }
    }

    public void J(JSONObject jSONObject) {
        if (this.gCT != null) {
            this.gCT.Q(jSONObject);
        }
    }

    public void x(u uVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bTo();
        }
        if (this.gCT != null && this.gCT.Of() != null && uVar != null) {
            this.gCT.k(uVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.gCT != null) {
            this.gCT.setCanVisible(z);
        }
    }

    public void bTo() {
        if (this.gCT != null && this.gCT.Of() != null) {
            this.gCT.Of().setVisibility(8);
        }
    }

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
