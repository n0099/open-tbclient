package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.ac.b;
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
    private ViewGroup bEg;
    private b hcZ;
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
        if (com.baidu.live.z.a.Pq().bmJ.Ee() && (viewGroup instanceof PendantParentView)) {
            if (this.hcZ == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hcZ = (b) runTask.getData();
            }
            if (this.hcZ != null) {
                this.hcZ.setOtherParams(Md());
                this.hcZ.Qe();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Qd;
        if (pendantParentView != null) {
            this.bEg = pendantParentView;
            if (this.hcZ != null && (Qd = this.hcZ.Qd()) != null && pendantParentView.indexOfChild(Qd) < 0) {
                if (layoutParams == null) {
                    layoutParams = bZF();
                }
                pendantParentView.a(Qd, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bZF() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CT() {
        super.CT();
        if (this.hcZ != null) {
            PendantChildView Qd = this.hcZ.Qd();
            if (Qd != null && Qd.getParent() != null) {
                ((ViewGroup) Qd.getParent()).removeView(Qd);
            }
            this.hcZ.Qf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hcZ != null) {
            PendantChildView Qd = this.hcZ.Qd();
            if (Qd != null && Qd.getParent() != null) {
                ((ViewGroup) Qd.getParent()).removeView(Qd);
            }
            this.hcZ.onDestroy();
        }
    }

    public void L(JSONObject jSONObject) {
        if (this.hcZ != null) {
            this.hcZ.R(jSONObject);
        }
    }

    public void B(w wVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bZG();
        }
        if (this.hcZ != null && this.hcZ.Qd() != null && wVar != null) {
            this.hcZ.j(wVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hcZ != null) {
            this.hcZ.setCanVisible(z);
        }
    }

    public void bZG() {
        if (this.hcZ != null && this.hcZ.Qd() != null) {
            this.hcZ.Qd().setVisibility(8);
        }
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
