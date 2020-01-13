package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private BdTypeListView efW;
    private d gSR;
    private c gSS;
    private b gST;

    public List<com.baidu.adp.widget.ListView.a> ban() {
        return this.apl;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efW = bdTypeListView;
        this.gSR = new d(tbPageContext);
        this.gSS = new c(tbPageContext);
        this.gST = new b(tbPageContext);
        this.apl.add(this.gSR);
        this.apl.add(this.gSS);
        this.apl.add(this.gST);
    }

    public void notifyDataSetChanged() {
        if (this.efW != null && (this.efW.getAdapter() instanceof e)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }
}
