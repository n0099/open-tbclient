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
    private BdTypeRecyclerView Vi;
    private LinkedList<com.baidu.adp.widget.ListView.a> hLK = new LinkedList<>();
    private f hUC;
    private b hUD;
    private d hUE;
    private e hUF;
    private c hUG;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        this.mPageContext = tbPageContext;
        this.Vi = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.hUC = new f(this.mPageContext, k.gsG);
        this.hUD = new b(this.mPageContext, l.dqZ);
        this.hUE = new d(this.mPageContext, k.gsO);
        this.hUF = new e(this.mPageContext, k.gsP);
        this.hUG = new c(this.mPageContext, k.gsN);
        this.hUC.a(this.Vi);
        this.hUD.a(this.Vi);
        this.hUE.a(this.Vi);
        this.hUF.a(this.Vi);
        this.hUG.a(this.Vi);
        this.hLK.add(this.hUC);
        this.hLK.add(this.hUD);
        this.hLK.add(this.hUE);
        this.hLK.add(this.hUF);
        this.hLK.add(this.hUG);
        this.Vi.addAdapters(this.hLK);
    }

    public void notifyDataSetChanged() {
        if (this.Vi != null) {
            this.Vi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hUC != null) {
            this.hUC.setPageUniqueId(bdUniqueId);
        }
        if (this.hUD != null) {
            this.hUD.setPageUniqueId(bdUniqueId);
        }
        if (this.hUE != null) {
            this.hUE.setPageUniqueId(bdUniqueId);
        }
        if (this.hUF != null) {
            this.hUF.setPageUniqueId(bdUniqueId);
        }
        if (this.hUG != null) {
            this.hUG.setPageUniqueId(bdUniqueId);
        }
    }

    public void setData(List<m> list) {
        this.Vi.setData(list);
    }

    public List<m> getDataList() {
        if (this.Vi != null) {
            return this.Vi.getData();
        }
        return null;
    }

    public void b(NEGFeedBackView.a aVar) {
        if (this.hUF != null) {
            this.hUF.setEventCallback(aVar);
        }
    }

    public void onPause() {
        if (this.hUD != null) {
            this.hUD.onPause();
        }
    }

    public void onDestroy() {
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        if (this.hUD != null) {
            this.hUD.b(eVar);
        }
    }
}
