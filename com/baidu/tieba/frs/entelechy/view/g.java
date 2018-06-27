package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class g {
    private f dsM;
    private h dsN;
    private TbPageContext<?> pageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        this.dsM = new f(tbPageContext, bdUniqueId);
        this.dsN = new h(tbPageContext, bdUniqueId);
        this.pageContext = tbPageContext;
        show(-1);
    }

    public View awS() {
        if (this.dsM == null || this.dsN == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(this.pageContext.getPageActivity());
        frameLayout.addView(this.dsM.getView());
        frameLayout.addView(this.dsN.getView());
        return frameLayout;
    }

    public f awT() {
        return this.dsM;
    }

    public h awU() {
        return this.dsN;
    }

    public void show(int i) {
        if (this.dsM != null && this.dsN != null) {
            switch (i) {
                case 1:
                    this.dsM.setVisibility(0);
                    this.dsN.setVisibility(8);
                    return;
                case 2:
                    this.dsM.setVisibility(8);
                    this.dsN.setVisibility(0);
                    return;
                default:
                    this.dsM.setVisibility(8);
                    this.dsN.setVisibility(8);
                    return;
            }
        }
    }
}
