package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEQ = BdUniqueId.gen();
    private int eER;
    private int eES = 0;
    private List<c> eET;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEQ;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aXf() {
        return this.eER;
    }

    public void pj(int i) {
        this.eER = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bz(List<b> list) {
        this.forumList = list;
    }

    public List<c> aXg() {
        return this.eET;
    }

    private void bA(List<c> list) {
        this.eET = list;
    }

    public List<c> aXh() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eER == 2) {
            if (aXi() != null) {
                arrayList.add(aXi());
            }
        } else {
            c aXi = aXi();
            c aXi2 = aXi();
            if (aXi != null) {
                arrayList.add(aXi);
            }
            if (aXi2 != null) {
                arrayList.add(aXi2);
            }
        }
        bA(arrayList);
        return arrayList;
    }

    private c aXi() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b aXj = aXj();
        b aXj2 = aXj();
        if (aXj == null && aXj2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(aXj);
        cVar.a(aXj2);
        return cVar;
    }

    private b aXj() {
        b bVar;
        if (this.eES < getForumList().size()) {
            bVar = getForumList().get(this.eES);
        } else if (this.eER < getForumList().size()) {
            this.eES = 0;
            bVar = getForumList().get(this.eES);
        } else {
            return null;
        }
        this.eES++;
        return bVar;
    }
}
