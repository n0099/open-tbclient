package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fUV = BdUniqueId.gen();
    private int fUW;
    private int fUX = 0;
    private List<c> fUY;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fUV;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bxt() {
        return this.fUW;
    }

    public void rN(int i) {
        this.fUW = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bQ(List<b> list) {
        this.forumList = list;
    }

    public List<c> bxu() {
        return this.fUY;
    }

    private void bR(List<c> list) {
        this.fUY = list;
    }

    public List<c> bxv() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fUW == 2) {
            if (bxw() != null) {
                arrayList.add(bxw());
            }
        } else {
            c bxw = bxw();
            c bxw2 = bxw();
            if (bxw != null) {
                arrayList.add(bxw);
            }
            if (bxw2 != null) {
                arrayList.add(bxw2);
            }
        }
        bR(arrayList);
        return arrayList;
    }

    private c bxw() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bxx = bxx();
        b bxx2 = bxx();
        if (bxx == null && bxx2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bxx);
        cVar.a(bxx2);
        return cVar;
    }

    private b bxx() {
        b bVar;
        if (this.fUX < getForumList().size()) {
            bVar = getForumList().get(this.fUX);
        } else if (this.fUW < getForumList().size()) {
            this.fUX = 0;
            bVar = getForumList().get(this.fUX);
        } else {
            return null;
        }
        this.fUX++;
        return bVar;
    }
}
