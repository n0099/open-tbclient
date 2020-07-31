package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private v hlu;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hlu = vVar;
        DS();
        this.hlu.addAdapters(this.aWf);
    }

    private void DS() {
        this.aWf.add(new f(this.mPageContext));
        this.aWf.add(new d(this.mPageContext));
        this.aWf.add(new c(this.mPageContext));
        this.aWf.add(new e(this.mPageContext));
        this.aWf.add(new b(this.mPageContext));
    }

    public void notifyDataSetChanged() {
        if (this.hlu != null) {
            this.hlu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hlu.setData(list);
    }

    public List<q> getData() {
        return this.hlu.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
