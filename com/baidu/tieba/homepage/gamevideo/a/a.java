package com.baidu.tieba.homepage.gamevideo.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Vw;
    private LinkedList<com.baidu.adp.widget.ListView.a> iaY = new LinkedList<>();
    private f iaZ;
    private c iba;
    private d ibb;
    private e ibc;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vw = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.iaZ = new f(this.mPageContext, k.gHF);
        this.iba = new c(this.mPageContext, l.dEV);
        this.ibb = new d(this.mPageContext, k.gHN);
        this.ibc = new e(this.mPageContext, k.gHL);
        this.iaZ.a(this.Vw);
        this.iba.a(this.Vw);
        this.ibb.a(this.Vw);
        this.ibc.a(this.Vw);
        this.iaY.add(this.iaZ);
        this.iaY.add(this.iba);
        this.iaY.add(this.ibb);
        this.iaY.add(this.ibc);
        this.Vw.addAdapters(this.iaY);
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iaZ != null) {
            this.iaZ.setPageUniqueId(bdUniqueId);
        }
        if (this.iba != null) {
            this.iba.setPageUniqueId(bdUniqueId);
        }
        if (this.ibb != null) {
            this.ibb.setPageUniqueId(bdUniqueId);
        }
        if (this.ibc != null) {
            this.ibc.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<o> list) {
        this.Vw.setData(list);
    }

    public List<o> getDataList() {
        if (this.Vw != null) {
            return this.Vw.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.ibc != null) {
            this.ibc.setEventCallback(aVar);
        }
    }

    public void wy(int i) {
        if (this.iaZ != null) {
            this.iaZ.wy(i);
        }
        if (this.iba != null) {
            this.iba.wy(i);
        }
        if (this.ibb != null) {
            this.ibb.wy(i);
        }
        if (this.ibc != null) {
            this.ibc.wy(i);
        }
    }

    public void onPause() {
        if (this.iba != null) {
            this.iba.onPause();
        }
    }

    public void onDestroy() {
    }
}
