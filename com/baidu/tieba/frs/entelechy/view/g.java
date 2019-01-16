package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dVl;
    private h dVm;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dVl = new f(tbPageContext, bdUniqueId);
        this.dVm = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aFw() {
        if (this.dVl == null || this.dVm == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dVl.getView());
        frameLayout.addView(this.dVm.getView());
        return frameLayout;
    }

    public f aFx() {
        return this.dVl;
    }

    public h aFy() {
        return this.dVm;
    }

    public void show(int i) {
        if (this.dVl != null && this.dVm != null) {
            switch (i) {
                case 1:
                    this.dVl.setVisibility(0);
                    this.dVm.setVisibility(8);
                    return;
                case 2:
                    this.dVl.setVisibility(8);
                    this.dVm.setVisibility(0);
                    return;
                default:
                    this.dVl.setVisibility(8);
                    this.dVm.setVisibility(8);
                    return;
            }
        }
    }
}
