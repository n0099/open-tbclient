package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdi = BdUniqueId.gen();
    private int fdj;
    private int fdk = 0;
    private List<c> fdl;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdi;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int beX() {
        return this.fdj;
    }

    public void pC(int i) {
        this.fdj = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bU(List<b> list) {
        this.forumList = list;
    }

    public List<c> beY() {
        return this.fdl;
    }

    private void bV(List<c> list) {
        this.fdl = list;
    }

    public List<c> beZ() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fdj == 2) {
            if (bfa() != null) {
                arrayList.add(bfa());
            }
        } else {
            c bfa = bfa();
            c bfa2 = bfa();
            if (bfa != null) {
                arrayList.add(bfa);
            }
            if (bfa2 != null) {
                arrayList.add(bfa2);
            }
        }
        bV(arrayList);
        return arrayList;
    }

    private c bfa() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bfb = bfb();
        b bfb2 = bfb();
        if (bfb == null && bfb2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bfb);
        cVar.a(bfb2);
        return cVar;
    }

    private b bfb() {
        b bVar;
        if (this.fdk < getForumList().size()) {
            bVar = getForumList().get(this.fdk);
        } else if (this.fdj < getForumList().size()) {
            this.fdk = 0;
            bVar = getForumList().get(this.fdk);
        } else {
            return null;
        }
        this.fdk++;
        return bVar;
    }
}
