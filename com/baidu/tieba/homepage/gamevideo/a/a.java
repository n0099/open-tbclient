package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Yc;
    private LinkedList<com.baidu.adp.widget.ListView.a> kbI = new LinkedList<>();
    private f kbJ;
    private c kbK;
    private d kbL;
    private e kbM;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Yc = bdTypeRecyclerView;
        MT();
    }

    private void MT() {
        this.kbJ = new f(this.mPageContext, k.izK);
        this.kbK = new c(this.mPageContext, l.eTj);
        this.kbL = new d(this.mPageContext, k.izR);
        this.kbM = new e(this.mPageContext, k.izP);
        this.kbJ.a(this.Yc);
        this.kbK.a(this.Yc);
        this.kbL.a(this.Yc);
        this.kbM.a(this.Yc);
        this.kbI.add(this.kbJ);
        this.kbI.add(this.kbK);
        this.kbI.add(this.kbL);
        this.kbI.add(this.kbM);
        this.Yc.addAdapters(this.kbI);
    }

    public void notifyDataSetChanged() {
        if (this.Yc != null) {
            this.Yc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.kbJ != null) {
            this.kbJ.setPageUniqueId(bdUniqueId);
        }
        if (this.kbK != null) {
            this.kbK.setPageUniqueId(bdUniqueId);
        }
        if (this.kbL != null) {
            this.kbL.setPageUniqueId(bdUniqueId);
        }
        if (this.kbM != null) {
            this.kbM.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<n> list) {
        this.Yc.setData(list);
    }

    public List<n> getDataList() {
        if (this.Yc != null) {
            return this.Yc.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.kbM != null) {
            this.kbM.setEventCallback(aVar);
        }
    }

    public void De(int i) {
        if (this.kbJ != null) {
            this.kbJ.De(i);
        }
        if (this.kbK != null) {
            this.kbK.De(i);
        }
        if (this.kbL != null) {
            this.kbL.De(i);
        }
        if (this.kbM != null) {
            this.kbM.De(i);
        }
    }

    public void onPause() {
        if (this.kbK != null) {
            this.kbK.onPause();
        }
    }

    public void onDestroy() {
    }
}
