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
    private ViewGroup fZy;
    private b gzI;
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
        if (com.baidu.live.w.a.Nk().beJ.CI() && (viewGroup instanceof PendantParentView)) {
            if (this.gzI == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.gzI = (b) runTask.getData();
            }
            if (this.gzI != null) {
                this.gzI.setOtherParams(JY());
                this.gzI.ND();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView NC;
        if (pendantParentView != null) {
            this.fZy = pendantParentView;
            if (this.gzI != null && (NC = this.gzI.NC()) != null && pendantParentView.indexOfChild(NC) < 0) {
                if (layoutParams == null) {
                    layoutParams = bRR();
                }
                pendantParentView.a(NC, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bRR() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
        if (this.gzI != null) {
            PendantChildView NC = this.gzI.NC();
            if (NC != null && NC.getParent() != null) {
                ((ViewGroup) NC.getParent()).removeView(NC);
            }
            this.gzI.NE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gzI != null) {
            PendantChildView NC = this.gzI.NC();
            if (NC != null && NC.getParent() != null) {
                ((ViewGroup) NC.getParent()).removeView(NC);
            }
            this.gzI.onDestroy();
        }
    }

    public void I(JSONObject jSONObject) {
        if (this.gzI != null) {
            this.gzI.N(jSONObject);
        }
    }

    public void v(r rVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bRS();
        }
        if (this.gzI != null && this.gzI.NC() != null && rVar != null) {
            this.gzI.j(rVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.gzI != null) {
            this.gzI.setCanVisible(z);
        }
    }

    public void bRS() {
        if (this.gzI != null && this.gzI.NC() != null) {
            this.gzI.NC().setVisibility(8);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
