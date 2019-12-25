package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRL = BdUniqueId.gen();
    private int fRM;
    private int fRN = 0;
    private List<c> fRO;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bwr() {
        return this.fRM;
    }

    public void rI(int i) {
        this.fRM = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bQ(List<b> list) {
        this.forumList = list;
    }

    public List<c> bws() {
        return this.fRO;
    }

    private void bR(List<c> list) {
        this.fRO = list;
    }

    public List<c> bwt() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fRM == 2) {
            if (bwu() != null) {
                arrayList.add(bwu());
            }
        } else {
            c bwu = bwu();
            c bwu2 = bwu();
            if (bwu != null) {
                arrayList.add(bwu);
            }
            if (bwu2 != null) {
                arrayList.add(bwu2);
            }
        }
        bR(arrayList);
        return arrayList;
    }

    private c bwu() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bwv = bwv();
        b bwv2 = bwv();
        if (bwv == null && bwv2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bwv);
        cVar.a(bwv2);
        return cVar;
    }

    private b bwv() {
        b bVar;
        if (this.fRN < getForumList().size()) {
            bVar = getForumList().get(this.fRN);
        } else if (this.fRM < getForumList().size()) {
            this.fRN = 0;
            bVar = getForumList().get(this.fRN);
        } else {
            return null;
        }
        this.fRN++;
        return bVar;
    }
}
