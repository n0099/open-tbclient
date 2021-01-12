package com.baidu.tieba.ala.liveroom.t;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes10.dex */
public class b {
    private ViewGroup bNl;
    private String gej;
    protected c hJb;
    protected TbPageContext mTbPageContext;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.gej);
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
        this.gej = str;
        if (this.hJb == null) {
            this.hJb = new c(getPageContext(), this.onClickListener);
        }
        if (this.bNl != null && this.bNl.indexOfChild(this.hJb.getView()) > 0) {
            this.bNl.removeView(this.hJb.getView());
        }
        this.bNl = viewGroup;
        this.hJb.getView().setId(a.f.privilege_manager_id);
        this.hJb.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hJb.getView(), layoutParams);
        }
    }

    public void cjl() {
        if (this.bNl != null && this.bNl.indexOfChild(this.hJb.getView()) > 0) {
            this.bNl.removeView(this.hJb.getView());
            g.vp(2913128);
        }
    }
}
