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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bNl;
    private b hzu;
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
        if (com.baidu.live.af.a.OJ().bru.AX() && (viewGroup instanceof PendantParentView)) {
            if (this.hzu == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hzu = (b) runTask.getData();
            }
            if (this.hzu != null) {
                this.hzu.setOtherParams(JQ());
                this.hzu.RP();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView RO;
        if (pendantParentView != null) {
            this.bNl = pendantParentView;
            if (this.hzu != null && (RO = this.hzu.RO()) != null && pendantParentView.indexOfChild(RO) < 0) {
                if (layoutParams == null) {
                    layoutParams = cet();
                }
                pendantParentView.a(RO, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cet() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void zH() {
        super.zH();
        if (this.hzu != null) {
            PendantChildView RO = this.hzu.RO();
            if (RO != null && RO.getParent() != null) {
                ((ViewGroup) RO.getParent()).removeView(RO);
            }
            this.hzu.RQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hzu != null) {
            PendantChildView RO = this.hzu.RO();
            if (RO != null && RO.getParent() != null) {
                ((ViewGroup) RO.getParent()).removeView(RO);
            }
            this.hzu.onDestroy();
        }
    }

    public void Q(JSONObject jSONObject) {
        if (this.hzu != null) {
            this.hzu.Z(jSONObject);
        }
    }

    public void L(x xVar) {
        if (!TbadkCoreApplication.isLogin()) {
            ceu();
        }
        if (this.hzu != null && this.hzu.RO() != null && xVar != null) {
            this.hzu.j(xVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hzu != null) {
            this.hzu.setCanVisible(z);
        }
    }

    public void ceu() {
        if (this.hzu != null && this.hzu.RO() != null) {
            this.hzu.RO().setVisibility(8);
        }
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
