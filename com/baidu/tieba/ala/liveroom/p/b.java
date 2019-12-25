package com.baidu.tieba.ala.liveroom.p;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
/* loaded from: classes2.dex */
public class b {
    private String dUb;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.dUb);
        }
    };
    private ViewGroup eqG;
    protected c fdo;
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
        this.dUb = str;
        if (this.fdo == null) {
            this.fdo = new c(getPageContext(), this.dmK);
        }
        if (this.eqG != null && this.eqG.indexOfChild(this.fdo.getView()) > 0) {
            this.eqG.removeView(this.fdo.getView());
        }
        this.eqG = viewGroup;
        this.fdo.getView().setId(a.g.privilege_manager_id);
        this.fdo.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fdo.getView(), layoutParams);
        }
    }

    public void bnw() {
        if (this.eqG != null && this.eqG.indexOfChild(this.fdo.getView()) > 0) {
            this.eqG.removeView(this.fdo.getView());
        }
    }
}
