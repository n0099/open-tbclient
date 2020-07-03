package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private v hfK;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hfK = vVar;
        Dz();
        this.hfK.addAdapters(this.aUP);
    }

    private void Dz() {
        this.aUP.add(new f(this.mPageContext));
        this.aUP.add(new d(this.mPageContext));
        this.aUP.add(new c(this.mPageContext));
        this.aUP.add(new e(this.mPageContext));
        this.aUP.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hfK != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hfK.setData(list);
    }

    public List<q> getData() {
        return this.hfK.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
