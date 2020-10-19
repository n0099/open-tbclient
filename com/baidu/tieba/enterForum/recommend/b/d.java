package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hUJ = BdUniqueId.gen();
    private List<b> forumList;
    private int hUK;
    private int hUL = 0;
    private List<c> hUM;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hUJ;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cmW() {
        return this.hUK;
    }

    public void xk(int i) {
        this.hUK = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cv(List<b> list) {
        this.forumList = list;
    }

    public List<c> cmX() {
        return this.hUM;
    }

    private void cw(List<c> list) {
        this.hUM = list;
    }

    public List<c> cmY() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hUK == 2) {
            if (cmZ() != null) {
                arrayList.add(cmZ());
            }
        } else {
            c cmZ = cmZ();
            c cmZ2 = cmZ();
            if (cmZ != null) {
                arrayList.add(cmZ);
            }
            if (cmZ2 != null) {
                arrayList.add(cmZ2);
            }
        }
        cw(arrayList);
        return arrayList;
    }

    private c cmZ() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cna = cna();
        b cna2 = cna();
        if (cna == null && cna2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cna);
        cVar.a(cna2);
        return cVar;
    }

    private b cna() {
        b bVar;
        if (this.hUL < getForumList().size()) {
            bVar = getForumList().get(this.hUL);
        } else if (this.hUK < getForumList().size()) {
            this.hUL = 0;
            bVar = getForumList().get(this.hUL);
        } else {
            return null;
        }
        this.hUL++;
        return bVar;
    }
}
