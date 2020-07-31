package com.baidu.tieba.ala.liveroom.l;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.x.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup fNw;
    private b gmP;
    private String otherParams;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        super.ar(viewGroup);
        a(viewGroup, (LinearLayout.LayoutParams) null);
    }

    public void a(ViewGroup viewGroup, LinearLayout.LayoutParams layoutParams) {
        CustomResponsedMessage runTask;
        if (com.baidu.live.v.a.Hs().aZn.xf() && (viewGroup instanceof PendantParentView)) {
            if (this.gmP == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.gmP = (b) runTask.getData();
            }
            if (this.gmP != null) {
                this.gmP.setOtherParams(Et());
                this.gmP.HK();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView HJ;
        if (pendantParentView != null) {
            this.fNw = pendantParentView;
            if (this.gmP != null && (HJ = this.gmP.HJ()) != null && pendantParentView.indexOfChild(HJ) < 0) {
                if (layoutParams == null) {
                    layoutParams = bHR();
                }
                pendantParentView.a(HJ, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams bHR() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
        if (this.gmP != null) {
            PendantChildView HJ = this.gmP.HJ();
            if (HJ != null && HJ.getParent() != null) {
                ((ViewGroup) HJ.getParent()).removeView(HJ);
            }
            this.gmP.HL();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gmP != null) {
            PendantChildView HJ = this.gmP.HJ();
            if (HJ != null && HJ.getParent() != null) {
                ((ViewGroup) HJ.getParent()).removeView(HJ);
            }
            this.gmP.onDestroy();
        }
    }

    public void G(JSONObject jSONObject) {
        if (this.gmP != null) {
            this.gmP.L(jSONObject);
        }
    }

    public void u(q qVar) {
        if (!TbadkCoreApplication.isLogin()) {
            bHS();
        }
        if (this.gmP != null && this.gmP.HJ() != null && qVar != null) {
            this.gmP.j(qVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.gmP != null) {
            this.gmP.setCanVisible(z);
        }
    }

    public void bHS() {
        if (this.gmP != null && this.gmP.HJ() != null) {
            this.gmP.HJ().setVisibility(8);
        }
    }

    public String Et() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
