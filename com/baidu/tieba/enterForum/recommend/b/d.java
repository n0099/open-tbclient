package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXT = BdUniqueId.gen();
    private int fXU;
    private int fXV = 0;
    private List<c> fXW;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXT;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bze() {
        return this.fXU;
    }

    public void rV(int i) {
        this.fXU = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bN(List<b> list) {
        this.forumList = list;
    }

    public List<c> bzf() {
        return this.fXW;
    }

    private void bO(List<c> list) {
        this.fXW = list;
    }

    public List<c> bzg() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fXU == 2) {
            if (bzh() != null) {
                arrayList.add(bzh());
            }
        } else {
            c bzh = bzh();
            c bzh2 = bzh();
            if (bzh != null) {
                arrayList.add(bzh);
            }
            if (bzh2 != null) {
                arrayList.add(bzh2);
            }
        }
        bO(arrayList);
        return arrayList;
    }

    private c bzh() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bzi = bzi();
        b bzi2 = bzi();
        if (bzi == null && bzi2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bzi);
        cVar.a(bzi2);
        return cVar;
    }

    private b bzi() {
        b bVar;
        if (this.fXV < getForumList().size()) {
            bVar = getForumList().get(this.fXV);
        } else if (this.fXU < getForumList().size()) {
            this.fXV = 0;
            bVar = getForumList().get(this.fXV);
        } else {
            return null;
        }
        this.fXV++;
        return bVar;
    }
}
