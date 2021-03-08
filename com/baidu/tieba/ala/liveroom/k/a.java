package com.baidu.tieba.ala.liveroom.k;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ag.b;
import com.baidu.live.data.ab;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bSB;
    private b hFC;
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
        if (com.baidu.live.ae.a.Qm().bwx.Cn() && (viewGroup instanceof PendantParentView)) {
            if (this.hFC == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hFC = (b) runTask.getData();
            }
            if (this.hFC != null) {
                this.hFC.setOtherParams(Lr());
                this.hFC.Tz();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Ty;
        if (pendantParentView != null) {
            this.bSB = pendantParentView;
            if (this.hFC != null && (Ty = this.hFC.Ty()) != null && pendantParentView.indexOfChild(Ty) < 0) {
                if (layoutParams == null) {
                    layoutParams = cfB();
                }
                pendantParentView.a(Ty, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cfB() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Au() {
        super.Au();
        if (this.hFC != null) {
            PendantChildView Ty = this.hFC.Ty();
            if (Ty != null && Ty.getParent() != null) {
                ((ViewGroup) Ty.getParent()).removeView(Ty);
            }
            this.hFC.TA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hFC != null) {
            PendantChildView Ty = this.hFC.Ty();
            if (Ty != null && Ty.getParent() != null) {
                ((ViewGroup) Ty.getParent()).removeView(Ty);
            }
            this.hFC.onDestroy();
        }
    }

    public void S(JSONObject jSONObject) {
        if (this.hFC != null) {
            this.hFC.ad(jSONObject);
        }
    }

    public void M(ab abVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cfC();
        }
        if (this.hFC != null && this.hFC.Ty() != null && abVar != null) {
            this.hFC.j(abVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hFC != null) {
            this.hFC.setCanVisible(z);
        }
    }

    public void cfC() {
        if (this.hFC != null && this.hFC.Ty() != null) {
            this.hFC.Ty().setVisibility(8);
        }
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
