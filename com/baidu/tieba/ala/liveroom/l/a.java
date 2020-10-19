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
    private ViewGroup bBk;
    private b gRm;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.x.a.OS().blo.DV() && (viewGroup instanceof PendantParentView)) {
            if (this.gRm == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.gRm = (b) runTask.getData();
            }
            if (this.gRm != null) {
                this.gRm.setOtherParams(LI());
                this.gRm.Pl();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Pk;
        if (pendantParentView != null) {
            this.bBk = pendantParentView;
            if (this.gRm != null && (Pk = this.gRm.Pk()) != null && pendantParentView.indexOfChild(Pk) < 0) {
                if (layoutParams == null) {
                    layoutParams = bWG();
                }
                pendantParentView.a(Pk, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bWG() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        super.CN();
        if (this.gRm != null) {
            PendantChildView Pk = this.gRm.Pk();
            if (Pk != null && Pk.getParent() != null) {
                ((ViewGroup) Pk.getParent()).removeView(Pk);
            }
            this.gRm.Pm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gRm != null) {
            PendantChildView Pk = this.gRm.Pk();
            if (Pk != null && Pk.getParent() != null) {
                ((ViewGroup) Pk.getParent()).removeView(Pk);
            }
            this.gRm.onDestroy();
        }
    }

    public void J(JSONObject jSONObject) {
        if (this.gRm != null) {
            this.gRm.P(jSONObject);
        }
    }

    public void y(u uVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bWH();
        }
        if (this.gRm != null && this.gRm.Pk() != null && uVar != null) {
            this.gRm.k(uVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.gRm != null) {
            this.gRm.setCanVisible(z);
        }
    }

    public void bWH() {
        if (this.gRm != null && this.gRm.Pk() != null) {
            this.gRm.Pk().setVisibility(8);
        }
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
