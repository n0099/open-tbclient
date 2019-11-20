package com.baidu.tieba.homepage.daily.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bh;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy;
    private r fcN;
    private e geP;
    private d geQ;
    private c geR;
    private b geS;
    private f geT;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fcN = rVar;
        sY();
        this.fcN.addAdapters(this.agy);
    }

    private void sY() {
        this.agy = new ArrayList();
        this.geP = new e(this.mPageContext, com.baidu.tieba.homepage.daily.b.e.gfh);
        this.geQ = new d(this.mPageContext, com.baidu.tieba.homepage.daily.b.d.gfd);
        this.geR = new c(this.mPageContext, com.baidu.tieba.homepage.daily.b.c.gfb);
        this.geS = new b(this.mPageContext, bh.caD);
        this.geT = new f(this.mPageContext, bh.caR);
        this.agy.add(this.geP);
        this.agy.add(this.geQ);
        this.agy.add(this.geR);
        this.agy.add(this.geS);
        this.agy.add(this.geT);
    }

    public void notifyDataSetChanged() {
        if (this.fcN != null) {
            this.fcN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.fcN.setData(list);
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
