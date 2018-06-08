package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dpD;
    private h dpE;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dpD = new f(tbPageContext, bdUniqueId);
        this.dpE = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View awo() {
        if (this.dpD == null || this.dpE == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dpD.getView());
        frameLayout.addView(this.dpE.getView());
        return frameLayout;
    }

    public f awp() {
        return this.dpD;
    }

    public h awq() {
        return this.dpE;
    }

    public void show(int i) {
        if (this.dpD != null && this.dpE != null) {
            switch (i) {
                case 1:
                    this.dpD.setVisibility(0);
                    this.dpE.setVisibility(8);
                    return;
                case 2:
                    this.dpD.setVisibility(8);
                    this.dpE.setVisibility(0);
                    return;
                default:
                    this.dpD.setVisibility(8);
                    this.dpE.setVisibility(8);
                    return;
            }
        }
    }
}
