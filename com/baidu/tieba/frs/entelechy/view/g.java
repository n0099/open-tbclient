package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dCh;
    private h dCi;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dCh = new f(tbPageContext, bdUniqueId);
        this.dCi = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View azK() {
        if (this.dCh == null || this.dCi == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dCh.getView());
        frameLayout.addView(this.dCi.getView());
        return frameLayout;
    }

    public f azL() {
        return this.dCh;
    }

    public h azM() {
        return this.dCi;
    }

    public void show(int i) {
        if (this.dCh != null && this.dCi != null) {
            switch (i) {
                case 1:
                    this.dCh.setVisibility(0);
                    this.dCi.setVisibility(8);
                    return;
                case 2:
                    this.dCh.setVisibility(8);
                    this.dCi.setVisibility(0);
                    return;
                default:
                    this.dCh.setVisibility(8);
                    this.dCi.setVisibility(8);
                    return;
            }
        }
    }
}
