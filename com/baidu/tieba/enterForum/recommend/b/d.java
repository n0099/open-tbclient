package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gEx = BdUniqueId.gen();
    private List<b> forumList;
    private List<c> gEA;
    private int gEy;
    private int gEz = 0;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gEx;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bJg() {
        return this.gEy;
    }

    public void sq(int i) {
        this.gEy = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bZ(List<b> list) {
        this.forumList = list;
    }

    public List<c> bJh() {
        return this.gEA;
    }

    private void ca(List<c> list) {
        this.gEA = list;
    }

    public List<c> bJi() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.gEy == 2) {
            if (bJj() != null) {
                arrayList.add(bJj());
            }
        } else {
            c bJj = bJj();
            c bJj2 = bJj();
            if (bJj != null) {
                arrayList.add(bJj);
            }
            if (bJj2 != null) {
                arrayList.add(bJj2);
            }
        }
        ca(arrayList);
        return arrayList;
    }

    private c bJj() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bJk = bJk();
        b bJk2 = bJk();
        if (bJk == null && bJk2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bJk);
        cVar.a(bJk2);
        return cVar;
    }

    private b bJk() {
        b bVar;
        if (this.gEz < getForumList().size()) {
            bVar = getForumList().get(this.gEz);
        } else if (this.gEy < getForumList().size()) {
            this.gEz = 0;
            bVar = getForumList().get(this.gEz);
        } else {
            return null;
        }
        this.gEz++;
        return bVar;
    }
}
