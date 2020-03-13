package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXl = BdUniqueId.gen();
    private int fXm;
    private int fXn = 0;
    private List<c> fXo;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int byY() {
        return this.fXm;
    }

    public void rT(int i) {
        this.fXm = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bN(List<b> list) {
        this.forumList = list;
    }

    public List<c> byZ() {
        return this.fXo;
    }

    private void bO(List<c> list) {
        this.fXo = list;
    }

    public List<c> bza() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fXm == 2) {
            if (bzb() != null) {
                arrayList.add(bzb());
            }
        } else {
            c bzb = bzb();
            c bzb2 = bzb();
            if (bzb != null) {
                arrayList.add(bzb);
            }
            if (bzb2 != null) {
                arrayList.add(bzb2);
            }
        }
        bO(arrayList);
        return arrayList;
    }

    private c bzb() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bzc = bzc();
        b bzc2 = bzc();
        if (bzc == null && bzc2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bzc);
        cVar.a(bzc2);
        return cVar;
    }

    private b bzc() {
        b bVar;
        if (this.fXn < getForumList().size()) {
            bVar = getForumList().get(this.fXn);
        } else if (this.fXm < getForumList().size()) {
            this.fXn = 0;
            bVar = getForumList().get(this.fXn);
        } else {
            return null;
        }
        this.fXn++;
        return bVar;
    }
}
