package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eUs = BdUniqueId.gen();
    private int eUt;
    private int eUu = 0;
    private List<c> eUv;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUs;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int beq() {
        return this.eUt;
    }

    public void qk(int i) {
        this.eUt = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bF(List<b> list) {
        this.forumList = list;
    }

    public List<c> ber() {
        return this.eUv;
    }

    private void bG(List<c> list) {
        this.eUv = list;
    }

    public List<c> bes() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eUt == 2) {
            if (bet() != null) {
                arrayList.add(bet());
            }
        } else {
            c bet = bet();
            c bet2 = bet();
            if (bet != null) {
                arrayList.add(bet);
            }
            if (bet2 != null) {
                arrayList.add(bet2);
            }
        }
        bG(arrayList);
        return arrayList;
    }

    private c bet() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b beu = beu();
        b beu2 = beu();
        if (beu == null && beu2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(beu);
        cVar.a(beu2);
        return cVar;
    }

    private b beu() {
        b bVar;
        if (this.eUu < getForumList().size()) {
            bVar = getForumList().get(this.eUu);
        } else if (this.eUt < getForumList().size()) {
            this.eUu = 0;
            bVar = getForumList().get(this.eUu);
        } else {
            return null;
        }
        this.eUu++;
        return bVar;
    }
}
