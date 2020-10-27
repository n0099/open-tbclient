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
    private ViewGroup bEg;
    private String fLC;
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.u.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fLC);
        }
    };
    protected c hmv;
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
        this.fLC = str;
        if (this.hmv == null) {
            this.hmv = new c(getPageContext(), this.fcr);
        }
        if (this.bEg != null && this.bEg.indexOfChild(this.hmv.getView()) > 0) {
            this.bEg.removeView(this.hmv.getView());
        }
        this.bEg = viewGroup;
        this.hmv.getView().setId(a.g.privilege_manager_id);
        this.hmv.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.hmv.getView(), layoutParams);
        }
    }

    public void cex() {
        if (this.bEg != null && this.bEg.indexOfChild(this.hmv.getView()) > 0) {
            this.bEg.removeView(this.hmv.getView());
            g.vu(2913128);
        }
    }
}
