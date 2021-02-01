package com.baidu.tieba.ala.liveroom.s;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.i.g;
/* loaded from: classes11.dex */
public class b {
    private ViewGroup bRb;
    private String ggy;
    protected c hNz;
    protected TbPageContext mTbPageContext;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.ggy);
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
        this.ggy = str;
        if (this.hNz == null) {
            this.hNz = new c(getPageContext(), this.onClickListener);
        }
        if (this.bRb != null && this.bRb.indexOfChild(this.hNz.getView()) > 0) {
            this.bRb.removeView(this.hNz.getView());
        }
        this.bRb = viewGroup;
        this.hNz.getView().setId(a.f.privilege_manager_id);
        this.hNz.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hNz.getView(), layoutParams);
        }
    }

    public void ckk() {
        if (this.bRb != null && this.bRb.indexOfChild(this.hNz.getView()) > 0) {
            this.bRb.removeView(this.hNz.getView());
            g.vA(2913128);
        }
    }
}
