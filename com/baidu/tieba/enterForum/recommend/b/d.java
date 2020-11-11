package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId inh = BdUniqueId.gen();
    private List<b> forumList;
    private int ini;
    private int inj = 0;
    private List<c> ink;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inh;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int csE() {
        return this.ini;
    }

    public void xQ(int i) {
        this.ini = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cM(List<b> list) {
        this.forumList = list;
    }

    public List<c> csF() {
        return this.ink;
    }

    private void cN(List<c> list) {
        this.ink = list;
    }

    public List<c> csG() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.ini == 2) {
            if (csH() != null) {
                arrayList.add(csH());
            }
        } else {
            c csH = csH();
            c csH2 = csH();
            if (csH != null) {
                arrayList.add(csH);
            }
            if (csH2 != null) {
                arrayList.add(csH2);
            }
        }
        cN(arrayList);
        return arrayList;
    }

    private c csH() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b csI = csI();
        b csI2 = csI();
        if (csI == null && csI2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(csI);
        cVar.a(csI2);
        return cVar;
    }

    private b csI() {
        b bVar;
        if (this.inj < getForumList().size()) {
            bVar = getForumList().get(this.inj);
        } else if (this.ini < getForumList().size()) {
            this.inj = 0;
            bVar = getForumList().get(this.inj);
        } else {
            return null;
        }
        this.inj++;
        return bVar;
    }
}
