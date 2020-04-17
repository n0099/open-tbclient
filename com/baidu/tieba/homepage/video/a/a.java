package com.baidu.tieba.homepage.video.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vf;
    private LinkedList<com.baidu.adp.widget.ListView.a> hLE = new LinkedList<>();
    private c hUA;
    private f hUw;
    private b hUx;
    private d hUy;
    private e hUz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vf = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.hUw = new f(this.mPageContext, k.gsA);
        this.hUx = new b(this.mPageContext, l.dqV);
        this.hUy = new d(this.mPageContext, k.gsI);
        this.hUz = new e(this.mPageContext, k.gsJ);
        this.hUA = new c(this.mPageContext, k.gsH);
        this.hUw.a(this.Vf);
        this.hUx.a(this.Vf);
        this.hUy.a(this.Vf);
        this.hUz.a(this.Vf);
        this.hUA.a(this.Vf);
        this.hLE.add(this.hUw);
        this.hLE.add(this.hUx);
        this.hLE.add(this.hUy);
        this.hLE.add(this.hUz);
        this.hLE.add(this.hUA);
        this.Vf.addAdapters(this.hLE);
    }

    public void notifyDataSetChanged() {
        if (this.Vf != null) {
            this.Vf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hUw != null) {
            this.hUw.setPageUniqueId(bdUniqueId);
        }
        if (this.hUx != null) {
            this.hUx.setPageUniqueId(bdUniqueId);
        }
        if (this.hUy != null) {
            this.hUy.setPageUniqueId(bdUniqueId);
        }
        if (this.hUz != null) {
            this.hUz.setPageUniqueId(bdUniqueId);
        }
        if (this.hUA != null) {
            this.hUA.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Vf.setData(list);
    }

    public List<m> getDataList() {
        if (this.Vf != null) {
            return this.Vf.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hUz != null) {
            this.hUz.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hUx != null) {
            this.hUx.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hUx != null) {
            this.hUx.b(eVar);
        }
    }
}
