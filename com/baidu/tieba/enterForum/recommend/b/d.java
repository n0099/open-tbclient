package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gTl = BdUniqueId.gen();
    private List<b> forumList;
    private int gTm;
    private int gTn = 0;
    private List<c> gTo;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gTl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bPy() {
        return this.gTm;
    }

    public void sV(int i) {
        this.gTm = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bW(List<b> list) {
        this.forumList = list;
    }

    public List<c> bPz() {
        return this.gTo;
    }

    private void bX(List<c> list) {
        this.gTo = list;
    }

    public List<c> bPA() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.gTm == 2) {
            if (bPB() != null) {
                arrayList.add(bPB());
            }
        } else {
            c bPB = bPB();
            c bPB2 = bPB();
            if (bPB != null) {
                arrayList.add(bPB);
            }
            if (bPB2 != null) {
                arrayList.add(bPB2);
            }
        }
        bX(arrayList);
        return arrayList;
    }

    private c bPB() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bPC = bPC();
        b bPC2 = bPC();
        if (bPC == null && bPC2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bPC);
        cVar.a(bPC2);
        return cVar;
    }

    private b bPC() {
        b bVar;
        if (this.gTn < getForumList().size()) {
            bVar = getForumList().get(this.gTn);
        } else if (this.gTm < getForumList().size()) {
            this.gTn = 0;
            bVar = getForumList().get(this.gTn);
        } else {
            return null;
        }
        this.gTn++;
        return bVar;
    }
}
