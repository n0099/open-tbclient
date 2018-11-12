package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dLl;
    private h dLm;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dLl = new f(tbPageContext, bdUniqueId);
        this.dLm = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aCy() {
        if (this.dLl == null || this.dLm == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dLl.getView());
        frameLayout.addView(this.dLm.getView());
        return frameLayout;
    }

    public f aCz() {
        return this.dLl;
    }

    public h aCA() {
        return this.dLm;
    }

    public void show(int i) {
        if (this.dLl != null && this.dLm != null) {
            switch (i) {
                case 1:
                    this.dLl.setVisibility(0);
                    this.dLm.setVisibility(8);
                    return;
                case 2:
                    this.dLl.setVisibility(8);
                    this.dLm.setVisibility(0);
                    return;
                default:
                    this.dLl.setVisibility(8);
                    this.dLm.setVisibility(8);
                    return;
            }
        }
    }
}
