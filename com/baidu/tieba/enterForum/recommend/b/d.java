package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEy = BdUniqueId.gen();
    private int eEA = 0;
    private List<c> eEB;
    private int eEz;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEy;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aXc() {
        return this.eEz;
    }

    public void pf(int i) {
        this.eEz = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bx(List<b> list) {
        this.forumList = list;
    }

    public List<c> aXd() {
        return this.eEB;
    }

    private void by(List<c> list) {
        this.eEB = list;
    }

    public List<c> aXe() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eEz == 2) {
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
        if (this.eEA < getForumList().size()) {
            bVar = getForumList().get(this.eEA);
        } else if (this.eEz < getForumList().size()) {
            this.eEA = 0;
            bVar = getForumList().get(this.eEA);
        } else {
            return null;
        }
        this.eEA++;
        return bVar;
    }
}
