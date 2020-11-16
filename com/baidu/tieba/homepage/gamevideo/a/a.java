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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private LinkedList<com.baidu.adp.widget.ListView.a> jAQ = new LinkedList<>();
    private f jAR;
    private c jAS;
    private d jAT;
    private e jAU;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Xi = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.jAR = new f(this.mPageContext, k.icq);
        this.jAS = new c(this.mPageContext, l.eCo);
        this.jAT = new d(this.mPageContext, k.icx);
        this.jAU = new e(this.mPageContext, k.icv);
        this.jAR.a(this.Xi);
        this.jAS.a(this.Xi);
        this.jAT.a(this.Xi);
        this.jAU.a(this.Xi);
        this.jAQ.add(this.jAR);
        this.jAQ.add(this.jAS);
        this.jAQ.add(this.jAT);
        this.jAQ.add(this.jAU);
        this.Xi.addAdapters(this.jAQ);
    }

    public void notifyDataSetChanged() {
        if (this.Xi != null) {
            this.Xi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.jAR != null) {
            this.jAR.setPageUniqueId(bdUniqueId);
        }
        if (this.jAS != null) {
            this.jAS.setPageUniqueId(bdUniqueId);
        }
        if (this.jAT != null) {
            this.jAT.setPageUniqueId(bdUniqueId);
        }
        if (this.jAU != null) {
            this.jAU.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<q> list) {
        this.Xi.setData(list);
    }

    public List<q> getDataList() {
        if (this.Xi != null) {
            return this.Xi.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.jAU != null) {
            this.jAU.setEventCallback(aVar);
        }
    }

    public void Cb(int i) {
        if (this.jAR != null) {
            this.jAR.Cb(i);
        }
        if (this.jAS != null) {
            this.jAS.Cb(i);
        }
        if (this.jAT != null) {
            this.jAT.Cb(i);
        }
        if (this.jAU != null) {
            this.jAU.Cb(i);
        }
    }

    public void onPause() {
        if (this.jAS != null) {
            this.jAS.onPause();
        }
    }

    public void onDestroy() {
    }
}
