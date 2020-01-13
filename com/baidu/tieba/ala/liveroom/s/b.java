package com.baidu.tieba.ala.liveroom.s;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.tieba.ala.liveroom.i.g;
/* loaded from: classes2.dex */
public class b {
    private String dUk;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.dUk);
        }
    };
    private ViewGroup erT;
    protected c fgu;
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
        this.dUk = str;
        if (this.fgu == null) {
            this.fgu = new c(getPageContext(), this.dmY);
        }
        if (this.erT != null && this.erT.indexOfChild(this.fgu.getView()) > 0) {
            this.erT.removeView(this.fgu.getView());
        }
        this.erT = viewGroup;
        this.fgu.getView().setId(a.g.privilege_manager_id);
        this.fgu.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fgu.getView(), layoutParams);
        }
    }

    public void bow() {
        if (this.erT != null && this.erT.indexOfChild(this.fgu.getView()) > 0) {
            this.erT.removeView(this.fgu.getView());
            g.pR(2913128);
        }
    }
}
