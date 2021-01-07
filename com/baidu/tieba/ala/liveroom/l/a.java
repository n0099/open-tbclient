package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ai.b;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bRX;
    private b hEa;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.af.a.SE().bwi.ES() && (viewGroup instanceof PendantParentView)) {
            if (this.hEa == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hEa = (b) runTask.getData();
            }
            if (this.hEa != null) {
                this.hEa.setOtherParams(NL());
                this.hEa.VI();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView VH;
        if (pendantParentView != null) {
            this.bRX = pendantParentView;
            if (this.hEa != null && (VH = this.hEa.VH()) != null && pendantParentView.indexOfChild(VH) < 0) {
                if (layoutParams == null) {
                    layoutParams = cil();
                }
                pendantParentView.a(VH, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cil() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void DC() {
        super.DC();
        if (this.hEa != null) {
            PendantChildView VH = this.hEa.VH();
            if (VH != null && VH.getParent() != null) {
                ((ViewGroup) VH.getParent()).removeView(VH);
            }
            this.hEa.VJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hEa != null) {
            PendantChildView VH = this.hEa.VH();
            if (VH != null && VH.getParent() != null) {
                ((ViewGroup) VH.getParent()).removeView(VH);
            }
            this.hEa.onDestroy();
        }
    }

    public void Q(JSONObject jSONObject) {
        if (this.hEa != null) {
            this.hEa.Z(jSONObject);
        }
    }

    public void L(x xVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cim();
        }
        if (this.hEa != null && this.hEa.VH() != null && xVar != null) {
            this.hEa.j(xVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hEa != null) {
            this.hEa.setCanVisible(z);
        }
    }

    public void cim() {
        if (this.hEa != null && this.hEa.VH() != null) {
            this.hEa.VH().setVisibility(8);
        }
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
