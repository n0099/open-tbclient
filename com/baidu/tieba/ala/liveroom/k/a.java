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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bRb;
    private b hDF;
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
        if (com.baidu.live.ae.a.Qj().buX.Ck() && (viewGroup instanceof PendantParentView)) {
            if (this.hDF == null && (runTask = MessageManager.getInstance().runTask(2913034, b.class, getPageContext().getPageActivity())) != null && runTask.getData() != null) {
                this.hDF = (b) runTask.getData();
            }
            if (this.hDF != null) {
                this.hDF.setOtherParams(Lo());
                this.hDF.Tw();
            }
            a((PendantParentView) viewGroup, layoutParams);
        }
    }

    private void a(PendantParentView pendantParentView, LinearLayout.LayoutParams layoutParams) {
        PendantChildView Tv;
        if (pendantParentView != null) {
            this.bRb = pendantParentView;
            if (this.hDF != null && (Tv = this.hDF.Tv()) != null && pendantParentView.indexOfChild(Tv) < 0) {
                if (layoutParams == null) {
                    layoutParams = cfo();
                }
                pendantParentView.a(Tv, layoutParams);
            }
        }
    }

    private LinearLayout.LayoutParams cfo() {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.hDF != null) {
            PendantChildView Tv = this.hDF.Tv();
            if (Tv != null && Tv.getParent() != null) {
                ((ViewGroup) Tv.getParent()).removeView(Tv);
            }
            this.hDF.Tx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hDF != null) {
            PendantChildView Tv = this.hDF.Tv();
            if (Tv != null && Tv.getParent() != null) {
                ((ViewGroup) Tv.getParent()).removeView(Tv);
            }
            this.hDF.onDestroy();
        }
    }

    public void Q(JSONObject jSONObject) {
        if (this.hDF != null) {
            this.hDF.ab(jSONObject);
        }
    }

    public void M(ab abVar) {
        if (!TbadkCoreApplication.isLogin()) {
            cfp();
        }
        if (this.hDF != null && this.hDF.Tv() != null && abVar != null) {
            this.hDF.j(abVar);
        }
    }

    public void setCanVisible(boolean z) {
        if (this.hDF != null) {
            this.hDF.setCanVisible(z);
        }
    }

    public void cfp() {
        if (this.hDF != null && this.hDF.Tv() != null) {
            this.hDF.Tv().setVisibility(8);
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
