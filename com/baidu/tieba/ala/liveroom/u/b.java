package com.baidu.tieba.ala.liveroom.u;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes4.dex */
public class b {
    private ViewGroup bIc;
    private String fRa;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.u.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fRa);
        }
    };
    protected c hsa;
    protected TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean b(ViewGroup viewGroup, String str) {
        if (viewGroup == null) {
            return false;
        }
        this.fRa = str;
        if (this.hsa == null) {
            this.hsa = new c(getPageContext(), this.fhp);
        }
        if (this.bIc != null && this.bIc.indexOfChild(this.hsa.getView()) > 0) {
            this.bIc.removeView(this.hsa.getView());
        }
        this.bIc = viewGroup;
        this.hsa.getView().setId(a.f.privilege_manager_id);
        this.hsa.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hsa.getView(), layoutParams);
        }
    }

    public void cgt() {
        if (this.bIc != null && this.bIc.indexOfChild(this.hsa.getView()) > 0) {
            this.bIc.removeView(this.hsa.getView());
            g.wf(2913128);
        }
    }
}
