package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEx = BdUniqueId.gen();
    private List<c> eEA;
    private int eEy;
    private int eEz = 0;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEx;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aXc() {
        return this.eEy;
    }

    public void pf(int i) {
        this.eEy = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bx(List<b> list) {
        this.forumList = list;
    }

    public List<c> aXd() {
        return this.eEA;
    }

    private void by(List<c> list) {
        this.eEA = list;
    }

    public List<c> aXe() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eEy == 2) {
            if (aXf() != null) {
                arrayList.add(aXf());
            }
        } else {
            c aXf = aXf();
            c aXf2 = aXf();
            if (aXf != null) {
                arrayList.add(aXf);
            }
            if (aXf2 != null) {
                arrayList.add(aXf2);
            }
        }
        by(arrayList);
        return arrayList;
    }

    private c aXf() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b aXg = aXg();
        b aXg2 = aXg();
        if (aXg == null && aXg2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(aXg);
        cVar.a(aXg2);
        return cVar;
    }

    private b aXg() {
        b bVar;
        if (this.eEz < getForumList().size()) {
            bVar = getForumList().get(this.eEz);
        } else if (this.eEy < getForumList().size()) {
            this.eEz = 0;
            bVar = getForumList().get(this.eEz);
        } else {
            return null;
        }
        this.eEz++;
        return bVar;
    }
}
