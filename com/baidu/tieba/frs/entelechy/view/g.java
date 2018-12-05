package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dRO;
    private h dRP;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dRO = new f(tbPageContext, bdUniqueId);
        this.dRP = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View aEk() {
        if (this.dRO == null || this.dRP == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dRO.getView());
        frameLayout.addView(this.dRP.getView());
        return frameLayout;
    }

    public f aEl() {
        return this.dRO;
    }

    public h aEm() {
        return this.dRP;
    }

    public void show(int i) {
        if (this.dRO != null && this.dRP != null) {
            switch (i) {
                case 1:
                    this.dRO.setVisibility(0);
                    this.dRP.setVisibility(8);
                    return;
                case 2:
                    this.dRO.setVisibility(8);
                    this.dRP.setVisibility(0);
                    return;
                default:
                    this.dRO.setVisibility(8);
                    this.dRP.setVisibility(8);
                    return;
            }
        }
    }
}
