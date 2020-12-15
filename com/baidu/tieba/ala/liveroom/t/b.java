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
    private String fZl;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fZl);
        }
    };
    protected c hBG;
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
        this.fZl = str;
        if (this.hBG == null) {
            this.hBG = new c(getPageContext(), this.foP);
        }
        if (this.bNk != null && this.bNk.indexOfChild(this.hBG.getView()) > 0) {
            this.bNk.removeView(this.hBG.getView());
        }
        this.bNk = viewGroup;
        this.hBG.getView().setId(a.f.privilege_manager_id);
        this.hBG.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hBG.getView(), layoutParams);
        }
    }

    public void cko() {
        if (this.bNk != null && this.bNk.indexOfChild(this.hBG.getView()) > 0) {
            this.bNk.removeView(this.hBG.getView());
            g.wK(2913128);
        }
    }
}
