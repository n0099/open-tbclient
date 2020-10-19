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
    private ViewGroup bBk;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.u.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fDh);
        }
    };
    private String fDh;
    protected c haF;
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
        this.fDh = str;
        if (this.haF == null) {
            this.haF = new c(getPageContext(), this.eTU);
        }
        if (this.bBk != null && this.bBk.indexOfChild(this.haF.getView()) > 0) {
            this.bBk.removeView(this.haF.getView());
        }
        this.bBk = viewGroup;
        this.haF.getView().setId(a.g.privilege_manager_id);
        this.haF.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.haF.getView(), layoutParams);
        }
    }

    public void cbt() {
        if (this.bBk != null && this.bBk.indexOfChild(this.haF.getView()) > 0) {
            this.bBk.removeView(this.haF.getView());
            g.va(2913128);
        }
    }
}
