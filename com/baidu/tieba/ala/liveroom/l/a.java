package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ah.b;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bNk;
    private b hsd;
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
        if (com.baidu.live.ae.a.RB().brA.FC() && (viewGroup instanceof PendantParentView)) {
            if (this.hsd == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hsd = (b) runTask.getData();
            }
            if (this.hsd != null) {
                this.hsd.setOtherParams(Oj());
                this.hsd.UD();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView UC;
        if (pendantParentView != null) {
            this.bNk = pendantParentView;
            if (this.hsd != null && (UC = this.hsd.UC()) != null && pendantParentView.indexOfChild(UC) < 0) {
                if (layoutParams == null) {
                    layoutParams = cft();
                }
                pendantParentView.a(UC, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cft() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        if (this.hsd != null) {
            PendantChildView UC = this.hsd.UC();
            if (UC != null && UC.getParent() != null) {
                ((ViewGroup) UC.getParent()).removeView(UC);
            }
            this.hsd.UE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hsd != null) {
            PendantChildView UC = this.hsd.UC();
            if (UC != null && UC.getParent() != null) {
                ((ViewGroup) UC.getParent()).removeView(UC);
            }
            this.hsd.onDestroy();
        }
    }

    public void J(JSONObject jSONObject) {
        if (this.hsd != null) {
            this.hsd.R(jSONObject);
        }
    }

    public void L(w wVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cfu();
        }
        if (this.hsd != null && this.hsd.UC() != null && wVar != null) {
            this.hsd.i(wVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hsd != null) {
            this.hsd.setCanVisible(z);
        }
    }

    public void cfu() {
        if (this.hsd != null && this.hsd.UC() != null) {
            this.hsd.UC().setVisibility(8);
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
