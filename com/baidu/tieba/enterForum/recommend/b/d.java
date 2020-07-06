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

    public int bSE() {
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

    public List<c> bSF() {
        return this.hgi;
    }

    private void cg(List<c> list) {
        this.hgi = list;
    }

    public List<c> bSG() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hgg == 2) {
            if (bSH() != null) {
                arrayList.add(bSH());
            }
        } else {
            c bSH = bSH();
            c bSH2 = bSH();
            if (bSH != null) {
                arrayList.add(bSH);
            }
            if (bSH2 != null) {
                arrayList.add(bSH2);
            }
        }
        cg(arrayList);
        return arrayList;
    }

    private c bSH() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bSI = bSI();
        b bSI2 = bSI();
        if (bSI == null && bSI2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bSI);
        cVar.a(bSI2);
        return cVar;
    }

    private b bSI() {
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
