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

    public int aXe() {
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

    public List<c> aXf() {
        return this.eET;
    }

    private void bA(List<c> list) {
        this.eET = list;
    }

    public List<c> aXg() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eER == 2) {
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
