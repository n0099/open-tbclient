package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.ad.b;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bIc;
    private b hiC;
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
        if (com.baidu.live.aa.a.Ph().bms.DR() && (viewGroup instanceof PendantParentView)) {
            if (this.hiC == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hiC = (b) runTask.getData();
            }
            if (this.hiC != null) {
                this.hiC.setOtherParams(LU());
                this.hiC.Sf();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Se;
        if (pendantParentView != null) {
            this.bIc = pendantParentView;
            if (this.hiC != null && (Se = this.hiC.Se()) != null && pendantParentView.indexOfChild(Se) < 0) {
                if (layoutParams == null) {
                    layoutParams = cbA();
                }
                pendantParentView.a(Se, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cbA() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CD() {
        super.CD();
        if (this.hiC != null) {
            PendantChildView Se = this.hiC.Se();
            if (Se != null && Se.getParent() != null) {
                ((ViewGroup) Se.getParent()).removeView(Se);
            }
            this.hiC.Sg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hiC != null) {
            PendantChildView Se = this.hiC.Se();
            if (Se != null && Se.getParent() != null) {
                ((ViewGroup) Se.getParent()).removeView(Se);
            }
            this.hiC.onDestroy();
        }
    }

    public void I(JSONObject jSONObject) {
        if (this.hiC != null) {
            this.hiC.P(jSONObject);
        }
    }

    public void G(w wVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cbB();
        }
        if (this.hiC != null && this.hiC.Se() != null && wVar != null) {
            this.hiC.i(wVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hiC != null) {
            this.hiC.setCanVisible(z);
        }
    }

    public void cbB() {
        if (this.hiC != null && this.hiC.Se() != null) {
            this.hiC.Se().setVisibility(8);
        }
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
