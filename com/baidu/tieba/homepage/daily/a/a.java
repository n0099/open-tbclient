package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private m dIZ;
    private e elc;
    private d eld;
    private c ele;
    private b elf;
    private f elg;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, m mVar) {
        this.mPageContext = tbPageContext;
        this.dIZ = mVar;
        initAdapters();
        this.dIZ.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.elc = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.elt);
        this.eld = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.elp);
        this.ele = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.eln);
        this.elf = new b(this.mPageContext, bb.apG);
        this.elg = new f(this.mPageContext, bb.apJ);
        this.mAdapters.add(this.elc);
        this.mAdapters.add(this.eld);
        this.mAdapters.add(this.ele);
        this.mAdapters.add(this.elf);
        this.mAdapters.add(this.elg);
    }

    public void notifyDataSetChanged() {
        if (this.dIZ != null) {
            this.dIZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<h> list) {
        this.dIZ.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
