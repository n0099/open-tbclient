package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private BdTypeListView dvB;
    private com.baidu.tieba.card.divider.a gck;
    private c gcl;
    private b gcm;

    public List<com.baidu.adp.widget.ListView.a> aJs() {
        return this.agQ;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dvB = bdTypeListView;
        this.gck = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.gcl = new c(tbPageContext);
        this.gcm = new b(tbPageContext);
        this.agQ.add(this.gck);
        this.agQ.add(this.gcl);
        this.agQ.add(this.gcm);
    }

    public void notifyDataSetChanged() {
        if (this.dvB != null && (this.dvB.getAdapter() instanceof e)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }
}
