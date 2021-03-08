package com.baidu.tieba.ala.liveroom.s;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.i.g;
/* loaded from: classes10.dex */
public class b {
    private ViewGroup bSB;
    private String gih;
    protected c hPw;
    protected TbPageContext mTbPageContext;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.gih);
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
        this.gih = str;
        if (this.hPw == null) {
            this.hPw = new c(getPageContext(), this.onClickListener);
        }
        if (this.bSB != null && this.bSB.indexOfChild(this.hPw.getView()) > 0) {
            this.bSB.removeView(this.hPw.getView());
        }
        this.bSB = viewGroup;
        this.hPw.getView().setId(a.f.privilege_manager_id);
        this.hPw.getView().setVisibility(0);
        return true;
    }

    public void c(ViewGroup viewGroup, String str) {
        if (b(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds18);
            viewGroup.addView(this.hPw.getView(), layoutParams);
        }
    }

    public void ckx() {
        if (this.bSB != null && this.bSB.indexOfChild(this.hPw.getView()) > 0) {
            this.bSB.removeView(this.hPw.getView());
            g.vC(2913128);
        }
    }
}
