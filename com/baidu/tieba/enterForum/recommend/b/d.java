package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEM = BdUniqueId.gen();
    private int eEN;
    private int eEO = 0;
    private List<c> eEP;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEM;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aXe() {
        return this.eEN;
    }

    public void pj(int i) {
        this.eEN = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bz(List<b> list) {
        this.forumList = list;
    }

    public List<c> aXf() {
        return this.eEP;
    }

    private void bA(List<c> list) {
        this.eEP = list;
    }

    public List<c> aXg() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eEN == 2) {
            if (aXh() != null) {
                arrayList.add(aXh());
            }
        } else {
            c aXh = aXh();
            c aXh2 = aXh();
            if (aXh != null) {
                arrayList.add(aXh);
            }
            if (aXh2 != null) {
                arrayList.add(aXh2);
            }
        }
        bA(arrayList);
        return arrayList;
    }

    private c aXh() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b aXi = aXi();
        b aXi2 = aXi();
        if (aXi == null && aXi2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(aXi);
        cVar.a(aXi2);
        return cVar;
    }

    private b aXi() {
        b bVar;
        if (this.eEO < getForumList().size()) {
            bVar = getForumList().get(this.eEO);
        } else if (this.eEN < getForumList().size()) {
            this.eEO = 0;
            bVar = getForumList().get(this.eEO);
        } else {
            return null;
        }
        this.eEO++;
        return bVar;
    }
}
