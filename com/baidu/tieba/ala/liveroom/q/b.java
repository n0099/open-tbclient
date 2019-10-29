package com.baidu.tieba.ala.liveroom.q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
/* loaded from: classes6.dex */
public class b {
    private i aaB;
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eoa != null && view == b.this.eoa.getView()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                alaStaticItem.addParams("other_params", b.this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                if (a.aVQ().aVR() != null) {
                    a.aVQ().aVR().ua("fetchUserInfo");
                }
            }
        }
    };
    private ViewGroup dYV;
    protected c eoa;
    protected TbPageContext mTbPageContext;
    private String otherParams;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean e(ViewGroup viewGroup, i iVar) {
        if (viewGroup == null) {
            return false;
        }
        this.aaB = iVar;
        if (this.eoa == null) {
            this.eoa = new c(getPageContext(), iVar.PN, this.czV);
        }
        if (this.dYV != null && this.dYV.indexOfChild(this.eoa.getView()) > 0) {
            this.dYV.removeView(this.eoa.getView());
        }
        this.dYV = viewGroup;
        this.eoa.getView().setId(a.g.guide_rename_view);
        this.eoa.getView().setVisibility(0);
        aVT();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void aVT() {
        a.aVQ().a(new e() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        });
    }

    public void f(ViewGroup viewGroup, i iVar) {
        if (e(viewGroup, iVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.eoa.getView(), layoutParams);
        }
    }

    public void aVU() {
        if (this.dYV != null && this.dYV.indexOfChild(this.eoa.getView()) > 0) {
            this.dYV.removeView(this.eoa.getView());
        }
    }
}
