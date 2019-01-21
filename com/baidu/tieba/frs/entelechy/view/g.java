package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dVm;
    private h dVn;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dVm = new f(tbPageContext, bdUniqueId);
        this.dVn = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aFw() {
        if (this.dVm == null || this.dVn == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dVm.getView());
        frameLayout.addView(this.dVn.getView());
        return frameLayout;
    }

    public f aFx() {
        return this.dVm;
    }

    public h aFy() {
        return this.dVn;
    }

    public void show(int i) {
        if (this.dVm != null && this.dVn != null) {
            switch (i) {
                case 1:
                    this.dVm.setVisibility(0);
                    this.dVn.setVisibility(8);
                    return;
                case 2:
                    this.dVm.setVisibility(8);
                    this.dVn.setVisibility(0);
                    return;
                default:
                    this.dVm.setVisibility(8);
                    this.dVn.setVisibility(8);
                    return;
            }
        }
    }
}
