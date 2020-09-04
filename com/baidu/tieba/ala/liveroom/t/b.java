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
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fnP);
        }
    };
    private ViewGroup fZy;
    private String fnP;
    protected c gIh;
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
        this.fnP = str;
        if (this.gIh == null) {
            this.gIh = new c(getPageContext(), this.eFG);
        }
        if (this.fZy != null && this.fZy.indexOfChild(this.gIh.getView()) > 0) {
            this.fZy.removeView(this.gIh.getView());
        }
        this.fZy = viewGroup;
        this.gIh.getView().setId(a.g.privilege_manager_id);
        this.gIh.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gIh.getView(), layoutParams);
        }
    }

    public void bWj() {
        if (this.fZy != null && this.fZy.indexOfChild(this.gIh.getView()) > 0) {
            this.fZy.removeView(this.gIh.getView());
            g.uc(2913128);
        }
    }
}
