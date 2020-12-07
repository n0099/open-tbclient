package com.baidu.tieba.ala.liveroom.t;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes4.dex */
public class b {
    private ViewGroup bNk;
    private String fZj;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fZj);
        }
    };
    protected c hBE;
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
        this.fZj = str;
        if (this.hBE == null) {
            this.hBE = new c(getPageContext(), this.foP);
        }
        if (this.bNk != null && this.bNk.indexOfChild(this.hBE.getView()) > 0) {
            this.bNk.removeView(this.hBE.getView());
        }
        this.bNk = viewGroup;
        this.hBE.getView().setId(a.f.privilege_manager_id);
        this.hBE.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hBE.getView(), layoutParams);
        }
    }

    public void ckn() {
        if (this.bNk != null && this.bNk.indexOfChild(this.hBE.getView()) > 0) {
            this.bNk.removeView(this.hBE.getView());
            g.wK(2913128);
        }
    }
}
