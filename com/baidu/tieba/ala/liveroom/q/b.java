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
    private String eNu;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.eNu);
        }
    };
    private ViewGroup fox;
    protected c gcZ;
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
        this.eNu = str;
        if (this.gcZ == null) {
            this.gcZ = new c(getPageContext(), this.ege);
        }
        if (this.fox != null && this.fox.indexOfChild(this.gcZ.getView()) > 0) {
            this.fox.removeView(this.gcZ.getView());
        }
        this.fox = viewGroup;
        this.gcZ.getView().setId(a.g.privilege_manager_id);
        this.gcZ.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.gcZ.getView(), layoutParams);
        }
    }

    public void bFT() {
        if (this.fox != null && this.fox.indexOfChild(this.gcZ.getView()) > 0) {
            this.fox.removeView(this.gcZ.getView());
            g.qV(2913128);
        }
    }
}
