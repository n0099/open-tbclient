package com.baidu.tieba.ala.liveroom.r;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.i.g;
/* loaded from: classes3.dex */
public class b {
    private String eXQ;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.eXQ);
        }
    };
    private ViewGroup fIb;
    protected c gqe;
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
        this.eXQ = str;
        if (this.gqe == null) {
            this.gqe = new c(getPageContext(), this.eoP);
        }
        if (this.fIb != null && this.fIb.indexOfChild(this.gqe.getView()) > 0) {
            this.fIb.removeView(this.gqe.getView());
        }
        this.fIb = viewGroup;
        this.gqe.getView().setId(a.g.privilege_manager_id);
        this.gqe.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gqe.getView(), layoutParams);
        }
    }

    public void bJa() {
        if (this.fIb != null && this.fIb.indexOfChild(this.gqe.getView()) > 0) {
            this.fIb.removeView(this.gqe.getView());
            g.rw(2913128);
        }
    }
}
