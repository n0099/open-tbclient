package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dvA;
    private h dvB;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dvA = new f(tbPageContext, bdUniqueId);
        this.dvB = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View axx() {
        if (this.dvA == null || this.dvB == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dvA.getView());
        frameLayout.addView(this.dvB.getView());
        return frameLayout;
    }

    public f axy() {
        return this.dvA;
    }

    public h axz() {
        return this.dvB;
    }

    public void show(int i) {
        if (this.dvA != null && this.dvB != null) {
            switch (i) {
                case 1:
                    this.dvA.setVisibility(0);
                    this.dvB.setVisibility(8);
                    return;
                case 2:
                    this.dvA.setVisibility(8);
                    this.dvB.setVisibility(0);
                    return;
                default:
                    this.dvA.setVisibility(8);
                    this.dvB.setVisibility(8);
                    return;
            }
        }
    }
}
