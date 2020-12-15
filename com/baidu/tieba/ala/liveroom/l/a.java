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
    private b hsf;
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
            if (this.hsf == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hsf = (b) runTask.getData();
            }
            if (this.hsf != null) {
                this.hsf.setOtherParams(Oj());
                this.hsf.UD();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView UC;
        if (pendantParentView != null) {
            this.bNk = pendantParentView;
            if (this.hsf != null && (UC = this.hsf.UC()) != null && pendantParentView.indexOfChild(UC) < 0) {
                if (layoutParams == null) {
                    layoutParams = cfu();
                }
                pendantParentView.a(UC, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cfu() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
        if (this.hsf != null) {
            PendantChildView UC = this.hsf.UC();
            if (UC != null && UC.getParent() != null) {
                ((ViewGroup) UC.getParent()).removeView(UC);
            }
            this.hsf.UE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hsf != null) {
            PendantChildView UC = this.hsf.UC();
            if (UC != null && UC.getParent() != null) {
                ((ViewGroup) UC.getParent()).removeView(UC);
            }
            this.hsf.onDestroy();
        }
    }

    public void J(JSONObject jSONObject) {
        if (this.hsf != null) {
            this.hsf.R(jSONObject);
        }
    }

    public void L(w wVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cfv();
        }
        if (this.hsf != null && this.hsf.UC() != null && wVar != null) {
            this.hsf.i(wVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hsf != null) {
            this.hsf.setCanVisible(z);
        }
    }

    public void cfv() {
        if (this.hsf != null && this.hsf.UC() != null) {
            this.hsf.UC().setVisibility(8);
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
