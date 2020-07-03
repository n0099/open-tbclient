package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private LinkedList<com.baidu.adp.widget.ListView.a> ipv = new LinkedList<>();
    private f ipw;
    private c ipx;
    private d ipy;
    private e ipz;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Wa = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.ipw = new f(this.mPageContext, k.gUF);
        this.ipx = new c(this.mPageContext, l.dLH);
        this.ipy = new d(this.mPageContext, k.gUN);
        this.ipz = new e(this.mPageContext, k.gUL);
        this.ipw.a(this.Wa);
        this.ipx.a(this.Wa);
        this.ipy.a(this.Wa);
        this.ipz.a(this.Wa);
        this.ipv.add(this.ipw);
        this.ipv.add(this.ipx);
        this.ipv.add(this.ipy);
        this.ipv.add(this.ipz);
        this.Wa.addAdapters(this.ipv);
    }

    public void notifyDataSetChanged() {
        if (this.Wa != null) {
            this.Wa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ipw != null) {
            this.ipw.setPageUniqueId(bdUniqueId);
        }
        if (this.ipx != null) {
            this.ipx.setPageUniqueId(bdUniqueId);
        }
        if (this.ipy != null) {
            this.ipy.setPageUniqueId(bdUniqueId);
        }
        if (this.ipz != null) {
            this.ipz.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Wa.setData(list);
    }

    public List<q> getDataList() {
        if (this.Wa != null) {
            return this.Wa.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ipz != null) {
            this.ipz.setEventCallback(aVar);
        }
    }

    public void xe(int i) {
        if (this.ipw != null) {
            this.ipw.xe(i);
        }
        if (this.ipx != null) {
            this.ipx.xe(i);
        }
        if (this.ipy != null) {
            this.ipy.xe(i);
        }
        if (this.ipz != null) {
            this.ipz.xe(i);
        }
    }

    public void onPause() {
        if (this.ipx != null) {
            this.ipx.onPause();
        }
    }

    public void onDestroy() {
    }
}
