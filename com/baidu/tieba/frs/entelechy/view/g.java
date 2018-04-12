package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dfk;
    private h dfl;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dfk = new f(tbPageContext, bdUniqueId);
        this.dfl = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View ask() {
        if (this.dfk == null || this.dfl == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dfk.getView());
        frameLayout.addView(this.dfl.getView());
        return frameLayout;
    }

    public f asl() {
        return this.dfk;
    }

    public h asm() {
        return this.dfl;
    }

    public void show(int i) {
        if (this.dfk != null && this.dfl != null) {
            switch (i) {
                case 1:
                    this.dfk.setVisibility(0);
                    this.dfl.setVisibility(8);
                    return;
                case 2:
                    this.dfk.setVisibility(8);
                    this.dfl.setVisibility(0);
                    return;
                default:
                    this.dfk.setVisibility(8);
                    this.dfl.setVisibility(8);
                    return;
            }
        }
    }
}
