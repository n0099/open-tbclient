package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dKh;
    private h dKi;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dKh = new f(tbPageContext, bdUniqueId);
        this.dKi = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aDd() {
        if (this.dKh == null || this.dKi == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dKh.getView());
        frameLayout.addView(this.dKi.getView());
        return frameLayout;
    }

    public f aDe() {
        return this.dKh;
    }

    public h aDf() {
        return this.dKi;
    }

    public void show(int i) {
        if (this.dKh != null && this.dKi != null) {
            switch (i) {
                case 1:
                    this.dKh.setVisibility(0);
                    this.dKi.setVisibility(8);
                    return;
                case 2:
                    this.dKh.setVisibility(8);
                    this.dKi.setVisibility(0);
                    return;
                default:
                    this.dKh.setVisibility(8);
                    this.dKi.setVisibility(8);
                    return;
            }
        }
    }
}
