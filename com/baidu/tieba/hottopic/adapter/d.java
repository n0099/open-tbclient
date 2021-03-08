package com.baidu.tieba.hottopic.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.m;
import com.baidu.tieba.hottopic.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private i kuI;
    private g kuJ;
    private RelateCardForumAdapter kuK;
    private e kuL;
    private f kuM;
    private HomePageVideoThreadAdapter kuN;
    private h kuO;

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    private void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.kuL = new e(hotTopicActivity, com.baidu.tieba.hottopic.data.g.TYPE);
        this.kuI = new i(hotTopicActivity, m.kxr);
        this.kuJ = new g(hotTopicActivity, com.baidu.tieba.hottopic.data.i.kwZ);
        this.kuK = new RelateCardForumAdapter(hotTopicActivity, n.kxu);
        TbPageContext pageContext = hotTopicActivity.getPageContext();
        this.kuM = new f(pageContext, com.baidu.tieba.card.data.k.TYPE);
        this.kuN = new HomePageVideoThreadAdapter(pageContext, l.eSl);
        this.kuO = new h(pageContext, com.baidu.tieba.card.data.k.eSq);
        this.boS.add(this.kuI);
        this.boS.add(this.kuJ);
        this.boS.add(this.kuK);
        this.boS.add(this.kuL);
        this.boS.add(this.kuM);
        this.boS.add(this.kuN);
        this.boS.add(this.kuO);
        this.gAY = bdTypeListView;
        this.gAY.addAdapters(this.boS);
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList;
        if (eVar.cTC() != null) {
            arrayList = eVar.cTC();
        } else {
            arrayList = new ArrayList<>();
        }
        if (this.gAY != null) {
            this.gAY.setData(arrayList);
        }
    }

    public void setFromCDN(boolean z) {
        if (this.kuM != null) {
            this.kuM.setFromCDN(z);
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
