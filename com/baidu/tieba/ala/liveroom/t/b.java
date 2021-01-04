package com.baidu.tieba.ala.liveroom.t;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes11.dex */
public class b {
    private ViewGroup bRX;
    private String giS;
    protected c hNH;
    protected TbPageContext mTbPageContext;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.giS);
        }
    };

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
        this.giS = str;
        if (this.hNH == null) {
            this.hNH = new c(getPageContext(), this.onClickListener);
        }
        if (this.bRX != null && this.bRX.indexOfChild(this.hNH.getView()) > 0) {
            this.bRX.removeView(this.hNH.getView());
        }
        this.bRX = viewGroup;
        this.hNH.getView().setId(a.f.privilege_manager_id);
        this.hNH.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hNH.getView(), layoutParams);
        }
    }

    public void cnc() {
        if (this.bRX != null && this.bRX.indexOfChild(this.hNH.getView()) > 0) {
            this.bRX.removeView(this.hNH.getView());
            g.wV(2913128);
        }
    }
}
