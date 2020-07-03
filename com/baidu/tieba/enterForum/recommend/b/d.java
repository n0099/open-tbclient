package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgf = BdUniqueId.gen();
    private List<b> forumList;
    private int hgg;
    private int hgh = 0;
    private List<c> hgi;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hgf;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bSD() {
        return this.hgg;
    }

    public void ty(int i) {
        this.hgg = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cf(List<b> list) {
        this.forumList = list;
    }

    public List<c> bSE() {
        return this.hgi;
    }

    private void cg(List<c> list) {
        this.hgi = list;
    }

    public List<c> bSF() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hgg == 2) {
            if (bSG() != null) {
                arrayList.add(bSG());
            }
        } else {
            c bSG = bSG();
            c bSG2 = bSG();
            if (bSG != null) {
                arrayList.add(bSG);
            }
            if (bSG2 != null) {
                arrayList.add(bSG2);
            }
        }
        cg(arrayList);
        return arrayList;
    }

    private c bSG() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bSH = bSH();
        b bSH2 = bSH();
        if (bSH == null && bSH2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bSH);
        cVar.a(bSH2);
        return cVar;
    }

    private b bSH() {
        b bVar;
        if (this.hgh < getForumList().size()) {
            bVar = getForumList().get(this.hgh);
        } else if (this.hgg < getForumList().size()) {
            this.hgh = 0;
            bVar = getForumList().get(this.hgh);
        } else {
            return null;
        }
        this.hgh++;
        return bVar;
    }
}
