package com.baidu.tieba.ala.liveroom.q;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.h.g;
/* loaded from: classes3.dex */
public class b {
    private String eNF;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.eNF);
        }
    };
    private ViewGroup foI;
    protected c gdk;
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
        this.eNF = str;
        if (this.gdk == null) {
            this.gdk = new c(getPageContext(), this.ege);
        }
        if (this.foI != null && this.foI.indexOfChild(this.gdk.getView()) > 0) {
            this.foI.removeView(this.gdk.getView());
        }
        this.foI = viewGroup;
        this.gdk.getView().setId(a.g.privilege_manager_id);
        this.gdk.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gdk.getView(), layoutParams);
        }
    }

    public void bFV() {
        if (this.foI != null && this.foI.indexOfChild(this.gdk.getView()) > 0) {
            this.foI.removeView(this.gdk.getView());
            g.qX(2913128);
        }
    }
}
