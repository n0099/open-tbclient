package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eUt = BdUniqueId.gen();
    private int eUu;
    private int eUv = 0;
    private List<c> eUw;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUt;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bet() {
        return this.eUu;
    }

    public void qk(int i) {
        this.eUu = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bF(List<b> list) {
        this.forumList = list;
    }

    public List<c> beu() {
        return this.eUw;
    }

    private void bG(List<c> list) {
        this.eUw = list;
    }

    public List<c> bev() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eUu == 2) {
            if (bew() != null) {
                arrayList.add(bew());
            }
        } else {
            c bew = bew();
            c bew2 = bew();
            if (bew != null) {
                arrayList.add(bew);
            }
            if (bew2 != null) {
                arrayList.add(bew2);
            }
        }
        bG(arrayList);
        return arrayList;
    }

    private c bew() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bex = bex();
        b bex2 = bex();
        if (bex == null && bex2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bex);
        cVar.a(bex2);
        return cVar;
    }

    private b bex() {
        b bVar;
        if (this.eUv < getForumList().size()) {
            bVar = getForumList().get(this.eUv);
        } else if (this.eUu < getForumList().size()) {
            this.eUv = 0;
            bVar = getForumList().get(this.eUv);
        } else {
            return null;
        }
        this.eUv++;
        return bVar;
    }
}
