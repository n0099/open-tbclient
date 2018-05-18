package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dgo;
    private h dgp;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dgo = new f(tbPageContext, bdUniqueId);
        this.dgp = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View asj() {
        if (this.dgo == null || this.dgp == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dgo.getView());
        frameLayout.addView(this.dgp.getView());
        return frameLayout;
    }

    public f ask() {
        return this.dgo;
    }

    public h asl() {
        return this.dgp;
    }

    public void show(int i) {
        if (this.dgo != null && this.dgp != null) {
            switch (i) {
                case 1:
                    this.dgo.setVisibility(0);
                    this.dgp.setVisibility(8);
                    return;
                case 2:
                    this.dgo.setVisibility(8);
                    this.dgp.setVisibility(0);
                    return;
                default:
                    this.dgo.setVisibility(8);
                    this.dgp.setVisibility(8);
                    return;
            }
        }
    }
}
