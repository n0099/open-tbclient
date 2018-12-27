package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dUF;
    private h dUG;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dUF = new f(tbPageContext, bdUniqueId);
        this.dUG = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aEZ() {
        if (this.dUF == null || this.dUG == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dUF.getView());
        frameLayout.addView(this.dUG.getView());
        return frameLayout;
    }

    public f aFa() {
        return this.dUF;
    }

    public h aFb() {
        return this.dUG;
    }

    public void show(int i) {
        if (this.dUF != null && this.dUG != null) {
            switch (i) {
                case 1:
                    this.dUF.setVisibility(0);
                    this.dUG.setVisibility(8);
                    return;
                case 2:
                    this.dUF.setVisibility(8);
                    this.dUG.setVisibility(0);
                    return;
                default:
                    this.dUF.setVisibility(8);
                    this.dUG.setVisibility(8);
                    return;
            }
        }
    }
}
