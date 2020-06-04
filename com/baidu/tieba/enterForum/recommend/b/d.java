package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gTw = BdUniqueId.gen();
    private List<b> forumList;
    private int gTx;
    private int gTy = 0;
    private List<c> gTz;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gTw;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bPA() {
        return this.gTx;
    }

    public void sX(int i) {
        this.gTx = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bW(List<b> list) {
        this.forumList = list;
    }

    public List<c> bPB() {
        return this.gTz;
    }

    private void bX(List<c> list) {
        this.gTz = list;
    }

    public List<c> bPC() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.gTx == 2) {
            if (bPD() != null) {
                arrayList.add(bPD());
            }
        } else {
            c bPD = bPD();
            c bPD2 = bPD();
            if (bPD != null) {
                arrayList.add(bPD);
            }
            if (bPD2 != null) {
                arrayList.add(bPD2);
            }
        }
        bX(arrayList);
        return arrayList;
    }

    private c bPD() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bPE = bPE();
        b bPE2 = bPE();
        if (bPE == null && bPE2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bPE);
        cVar.a(bPE2);
        return cVar;
    }

    private b bPE() {
        b bVar;
        if (this.gTy < getForumList().size()) {
            bVar = getForumList().get(this.gTy);
        } else if (this.gTx < getForumList().size()) {
            this.gTy = 0;
            bVar = getForumList().get(this.gTy);
        } else {
            return null;
        }
        this.gTy++;
        return bVar;
    }
}
