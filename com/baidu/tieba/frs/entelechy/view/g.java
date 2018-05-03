package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dfh;
    private h dfi;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dfh = new f(tbPageContext, bdUniqueId);
        this.dfi = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View ask() {
        if (this.dfh == null || this.dfi == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dfh.getView());
        frameLayout.addView(this.dfi.getView());
        return frameLayout;
    }

    public f asl() {
        return this.dfh;
    }

    public h asm() {
        return this.dfi;
    }

    public void show(int i) {
        if (this.dfh != null && this.dfi != null) {
            switch (i) {
                case 1:
                    this.dfh.setVisibility(0);
                    this.dfi.setVisibility(8);
                    return;
                case 2:
                    this.dfh.setVisibility(8);
                    this.dfi.setVisibility(0);
                    return;
                default:
                    this.dfh.setVisibility(8);
                    this.dfi.setVisibility(8);
                    return;
            }
        }
    }
}
