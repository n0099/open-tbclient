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
    private i aaj;
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eni != null && view == b.this.eni.getView()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.RENAME_CLICK);
                alaStaticItem.addParams("other_params", b.this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                if (a.aVO().aVP() != null) {
                    a.aVO().aVP().ua("fetchUserInfo");
                }
            }
        }
    };
    private ViewGroup dYe;
    protected c eni;
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
        this.aaj = iVar;
        if (this.eni == null) {
            this.eni = new c(getPageContext(), iVar.Pj, this.cze);
        }
        if (this.dYe != null && this.dYe.indexOfChild(this.eni.getView()) > 0) {
            this.dYe.removeView(this.eni.getView());
        }
        this.dYe = viewGroup;
        this.eni.getView().setId(a.g.guide_rename_view);
        this.eni.getView().setVisibility(0);
        aVR();
        return true;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void aVR() {
        a.aVO().a(new e() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        });
    }

    public void f(ViewGroup viewGroup, i iVar) {
        if (e(viewGroup, iVar)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.eni.getView(), layoutParams);
        }
    }

    public void aVS() {
        if (this.dYe != null && this.dYe.indexOfChild(this.eni.getView()) > 0) {
            this.dYe.removeView(this.eni.getView());
        }
    }
}
