package com.baidu.tieba.ala.liveroom.s;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes4.dex */
public class b {
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fcs);
        }
    };
    private ViewGroup fNw;
    private String fcs;
    protected c gvf;
    protected TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean a(ViewGroup viewGroup, String str) {
        if (viewGroup == null) {
            return false;
        }
        this.fcs = str;
        if (this.gvf == null) {
            this.gvf = new c(getPageContext(), this.eve);
        }
        if (this.fNw != null && this.fNw.indexOfChild(this.gvf.getView()) > 0) {
            this.fNw.removeView(this.gvf.getView());
        }
        this.fNw = viewGroup;
        this.gvf.getView().setId(a.g.privilege_manager_id);
        this.gvf.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gvf.getView(), layoutParams);
        }
    }

    public void bMg() {
        if (this.fNw != null && this.fNw.indexOfChild(this.gvf.getView()) > 0) {
            this.fNw.removeView(this.gvf.getView());
            g.rM(2913128);
        }
    }
}
