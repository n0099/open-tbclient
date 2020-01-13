package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private LinkedList<com.baidu.adp.widget.ListView.a> gYs = new LinkedList<>();
    private f gYt;
    private c gYu;
    private d gYv;
    private e gYw;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Bs = bdTypeRecyclerView;
        vi();
    }

    private void vi() {
        this.gYt = new f(this.mPageContext, k.fKA);
        this.gYu = new c(this.mPageContext, l.cNv);
        this.gYv = new d(this.mPageContext, k.fKI);
        this.gYw = new e(this.mPageContext, k.fKJ);
        this.gYt.b((r) this.Bs);
        this.gYu.b((r) this.Bs);
        this.gYv.b((r) this.Bs);
        this.gYw.b((r) this.Bs);
        this.gYs.add(this.gYt);
        this.gYs.add(this.gYu);
        this.gYs.add(this.gYv);
        this.gYs.add(this.gYw);
        this.Bs.addAdapters(this.gYs);
    }

    public void notifyDataSetChanged() {
        if (this.Bs != null) {
            this.Bs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gYt != null) {
            this.gYt.setPageUniqueId(bdUniqueId);
        }
        if (this.gYu != null) {
            this.gYu.setPageUniqueId(bdUniqueId);
        }
        if (this.gYv != null) {
            this.gYv.setPageUniqueId(bdUniqueId);
        }
        if (this.gYw != null) {
            this.gYw.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Bs.setData(list);
    }

    public List<m> getDataList() {
        if (this.Bs != null) {
            return this.Bs.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.gYw != null) {
            this.gYw.setEventCallback(aVar);
        }
    }

    public void vf(int i) {
        if (this.gYt != null) {
            this.gYt.vf(i);
        }
        if (this.gYu != null) {
            this.gYu.vf(i);
        }
        if (this.gYv != null) {
            this.gYv.vf(i);
        }
        if (this.gYw != null) {
            this.gYw.vf(i);
        }
    }

    public void onPause() {
        if (this.gYu != null) {
            this.gYu.onPause();
        }
    }

    public void onDestroy() {
    }
}
