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
    private ViewGroup bJN;
    private b hiV;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.aa.a.PQ().bod.EA() && (viewGroup instanceof PendantParentView)) {
            if (this.hiV == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hiV = (b) runTask.getData();
            }
            if (this.hiV != null) {
                this.hiV.setOtherParams(MD());
                this.hiV.SO();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView SN;
        if (pendantParentView != null) {
            this.bJN = pendantParentView;
            if (this.hiV != null && (SN = this.hiV.SN()) != null && pendantParentView.indexOfChild(SN) < 0) {
                if (layoutParams == null) {
                    layoutParams = cch();
                }
                pendantParentView.a(SN, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cch() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.hiV != null) {
            PendantChildView SN = this.hiV.SN();
            if (SN != null && SN.getParent() != null) {
                ((ViewGroup) SN.getParent()).removeView(SN);
            }
            this.hiV.SP();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hiV != null) {
            PendantChildView SN = this.hiV.SN();
            if (SN != null && SN.getParent() != null) {
                ((ViewGroup) SN.getParent()).removeView(SN);
            }
            this.hiV.onDestroy();
        }
    }

    public void O(JSONObject jSONObject) {
        if (this.hiV != null) {
            this.hiV.V(jSONObject);
        }
    }

    public void G(w wVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cci();
        }
        if (this.hiV != null && this.hiV.SN() != null && wVar != null) {
            this.hiV.i(wVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hiV != null) {
            this.hiV.setCanVisible(z);
        }
    }

    public void cci() {
        if (this.hiV != null && this.hiV.SN() != null) {
            this.hiV.SN().setVisibility(8);
        }
    }

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
