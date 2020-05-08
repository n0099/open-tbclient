package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gED = BdUniqueId.gen();
    private List<b> forumList;
    private int gEE;
    private int gEF = 0;
    private List<c> gEG;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gED;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bJe() {
        return this.gEE;
    }

    public void sq(int i) {
        this.gEE = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bZ(List<b> list) {
        this.forumList = list;
    }

    public List<c> bJf() {
        return this.gEG;
    }

    private void ca(List<c> list) {
        this.gEG = list;
    }

    public List<c> bJg() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.gEE == 2) {
            if (bJh() != null) {
                arrayList.add(bJh());
            }
        } else {
            c bJh = bJh();
            c bJh2 = bJh();
            if (bJh != null) {
                arrayList.add(bJh);
            }
            if (bJh2 != null) {
                arrayList.add(bJh2);
            }
        }
        ca(arrayList);
        return arrayList;
    }

    private c bJh() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bJi = bJi();
        b bJi2 = bJi();
        if (bJi == null && bJi2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bJi);
        cVar.a(bJi2);
        return cVar;
    }

    private b bJi() {
        b bVar;
        if (this.gEF < getForumList().size()) {
            bVar = getForumList().get(this.gEF);
        } else if (this.gEE < getForumList().size()) {
            this.gEF = 0;
            bVar = getForumList().get(this.gEF);
        } else {
            return null;
        }
        this.gEF++;
        return bVar;
    }
}
