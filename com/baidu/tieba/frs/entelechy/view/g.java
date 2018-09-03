package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dvx;
    private h dvy;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dvx = new f(tbPageContext, bdUniqueId);
        this.dvy = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View axw() {
        if (this.dvx == null || this.dvy == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dvx.getView());
        frameLayout.addView(this.dvy.getView());
        return frameLayout;
    }

    public f axx() {
        return this.dvx;
    }

    public h axy() {
        return this.dvy;
    }

    public void show(int i) {
        if (this.dvx != null && this.dvy != null) {
            switch (i) {
                case 1:
                    this.dvx.setVisibility(0);
                    this.dvy.setVisibility(8);
                    return;
                case 2:
                    this.dvx.setVisibility(8);
                    this.dvy.setVisibility(0);
                    return;
                default:
                    this.dvx.setVisibility(8);
                    this.dvy.setVisibility(8);
                    return;
            }
        }
    }
}
