package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fbo = BdUniqueId.gen();
    private int fbp;
    private int fbq = 0;
    private List<c> fbr;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbo;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bhf() {
        return this.fbp;
    }

    public void qH(int i) {
        this.fbp = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bH(List<b> list) {
        this.forumList = list;
    }

    public List<c> bhg() {
        return this.fbr;
    }

    private void bI(List<c> list) {
        this.fbr = list;
    }

    public List<c> bhh() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fbp == 2) {
            if (bhi() != null) {
                arrayList.add(bhi());
            }
        } else {
            c bhi = bhi();
            c bhi2 = bhi();
            if (bhi != null) {
                arrayList.add(bhi);
            }
            if (bhi2 != null) {
                arrayList.add(bhi2);
            }
        }
        bI(arrayList);
        return arrayList;
    }

    private c bhi() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bhj = bhj();
        b bhj2 = bhj();
        if (bhj == null && bhj2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bhj);
        cVar.a(bhj2);
        return cVar;
    }

    private b bhj() {
        b bVar;
        if (this.fbq < getForumList().size()) {
            bVar = getForumList().get(this.fbq);
        } else if (this.fbp < getForumList().size()) {
            this.fbq = 0;
            bVar = getForumList().get(this.fbq);
        } else {
            return null;
        }
        this.fbq++;
        return bVar;
    }
}
