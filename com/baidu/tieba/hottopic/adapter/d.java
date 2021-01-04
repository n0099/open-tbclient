package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private i koQ;
    private g koR;
    private RelateCardForumAdapter koS;
    private e koT;
    private f koU;
    private HomePageVideoThreadAdapter koV;
    private h koW;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.koT = new e(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.koQ = new i(hotTopicActivity, m.krz);
        this.koR = new g(hotTopicActivity, com.baidu.tieba.hottopic.data.i.krh);
        this.koS = new RelateCardForumAdapter(hotTopicActivity, n.krC);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.koU = new f(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.koV = new HomePageVideoThreadAdapter(pageContext, l.eTj);
        this.koW = new h(pageContext, com.baidu.tieba.card.data.k.eTo);
        this.boM.add(this.koQ);
        this.boM.add(this.koR);
        this.boM.add(this.koS);
        this.boM.add(this.koT);
        this.boM.add(this.koU);
        this.boM.add(this.koV);
        this.boM.add(this.koW);
        this.gAY = bdTypeListView;
        this.gAY.addAdapters(this.boM);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList;
        if (eVar.cVg() != null) {
            arrayList = eVar.cVg();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gAY != null) {
            this.gAY.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.koU != null) {
            this.koU.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
