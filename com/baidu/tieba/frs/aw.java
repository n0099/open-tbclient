package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.a;
/* loaded from: classes.dex */
public class aw {
    private TbPageContext Fp;
    private com.baidu.tieba.frs.mc.t bHf;

    public aw(TbPageContext tbPageContext, com.baidu.tieba.frs.mc.t tVar) {
        this.Fp = tbPageContext;
        this.bHf = tVar;
    }

    public void b(a aVar) {
        if (this.bHf != null && this.bHf.Xy() != null && this.bHf.Xy().abf() != null && this.bHf.XF() != null && aVar != null && this.bHf.XF().Iv() != null && this.bHf.XC() != null) {
            BdTypeListView Iv = this.bHf.XF().Iv();
            switch (aVar.what) {
                case 2:
                    if (aVar.getView() != null) {
                        if (!this.bHf.XM()) {
                            Iv.removeHeaderView(aVar.getView());
                            Iv.addHeaderView(aVar.getView(), Iv.getHeaderViewsCount() - 1);
                        }
                        this.bHf.XC().iL(8);
                        return;
                    }
                    return;
                case 3:
                    if (aVar.getView() != null) {
                        Iv.removeHeaderView(aVar.getView());
                        this.bHf.XC().iL(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
