package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eZu = BdUniqueId.gen();
    private int eZv;
    private int eZw = 0;
    private List<c> eZx;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eZu;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bgw() {
        return this.eZv;
    }

    public void qC(int i) {
        this.eZv = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bH(List<b> list) {
        this.forumList = list;
    }

    public List<c> bgx() {
        return this.eZx;
    }

    private void bI(List<c> list) {
        this.eZx = list;
    }

    public List<c> bgy() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eZv == 2) {
            if (bgz() != null) {
                arrayList.add(bgz());
            }
        } else {
            c bgz = bgz();
            c bgz2 = bgz();
            if (bgz != null) {
                arrayList.add(bgz);
            }
            if (bgz2 != null) {
                arrayList.add(bgz2);
            }
        }
        bI(arrayList);
        return arrayList;
    }

    private c bgz() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bgA = bgA();
        b bgA2 = bgA();
        if (bgA == null && bgA2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bgA);
        cVar.a(bgA2);
        return cVar;
    }

    private b bgA() {
        b bVar;
        if (this.eZw < getForumList().size()) {
            bVar = getForumList().get(this.eZw);
        } else if (this.eZv < getForumList().size()) {
            this.eZw = 0;
            bVar = getForumList().get(this.eZw);
        } else {
            return null;
        }
        this.eZw++;
        return bVar;
    }
}
