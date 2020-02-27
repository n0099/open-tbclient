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
    private String dYo;
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserHelper.startInternalWebActivity(b.this.mTbPageContext.getPageActivity(), b.this.dYo);
        }
    };
    private ViewGroup ewd;
    protected c fjJ;
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
        this.dYo = str;
        if (this.fjJ == null) {
            this.fjJ = new c(getPageContext(), this.drh);
        }
        if (this.ewd != null && this.ewd.indexOfChild(this.fjJ.getView()) > 0) {
            this.ewd.removeView(this.fjJ.getView());
        }
        this.ewd = viewGroup;
        this.fjJ.getView().setId(a.g.privilege_manager_id);
        this.fjJ.getView().setVisibility(0);
        return true;
    }

    public void b(ViewGroup viewGroup, String str) {
        if (a(viewGroup, str)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.setMargins(getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18), 0, getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds180), 0);
            layoutParams.bottomMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_tbds130) + getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18);
            viewGroup.addView(this.fjJ.getView(), layoutParams);
        }
    }

    public void bqj() {
        if (this.ewd != null && this.ewd.indexOfChild(this.fjJ.getView()) > 0) {
            this.ewd.removeView(this.fjJ.getView());
            g.pZ(2913128);
        }
    }
}
