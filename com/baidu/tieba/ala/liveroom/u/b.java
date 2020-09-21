package com.baidu.tieba.ala.liveroom.u;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.j.g;
/* loaded from: classes4.dex */
public class b {
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.u.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.fqU);
        }
    };
    private String fqU;
    protected c gLI;
    private ViewGroup gcM;
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
        this.fqU = str;
        if (this.gLI == null) {
            this.gLI = new c(getPageContext(), this.eHN);
        }
        if (this.gcM != null && this.gcM.indexOfChild(this.gLI.getView()) > 0) {
            this.gcM.removeView(this.gLI.getView());
        }
        this.gcM = viewGroup;
        this.gLI.getView().setId(a.g.privilege_manager_id);
        this.gLI.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gLI.getView(), layoutParams);
        }
    }

    public void bXT() {
        if (this.gcM != null && this.gcM.indexOfChild(this.gLI.getView()) > 0) {
            this.gcM.removeView(this.gLI.getView());
            g.uv(2913128);
        }
    }
}
