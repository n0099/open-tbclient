package com.baidu.tieba.ala.liveroom.t;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes7.dex */
public class b {
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fnL);
        }
    };
    private ViewGroup fZu;
    private String fnL;
    protected c gId;
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
        this.fnL = str;
        if (this.gId == null) {
            this.gId = new c(getPageContext(), this.eFC);
        }
        if (this.fZu != null && this.fZu.indexOfChild(this.gId.getView()) > 0) {
            this.fZu.removeView(this.gId.getView());
        }
        this.fZu = viewGroup;
        this.gId.getView().setId(a.g.privilege_manager_id);
        this.gId.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gId.getView(), layoutParams);
        }
    }

    public void bWi() {
        if (this.fZu != null && this.fZu.indexOfChild(this.gId.getView()) > 0) {
            this.fZu.removeView(this.gId.getView());
            g.uc(2913128);
        }
    }
}
