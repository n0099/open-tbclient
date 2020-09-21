package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hFO = BdUniqueId.gen();
    private List<b> forumList;
    private int hFP;
    private int hFQ = 0;
    private List<c> hFR;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hFO;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cjA() {
        return this.hFP;
    }

    public void wE(int i) {
        this.hFP = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cs(List<b> list) {
        this.forumList = list;
    }

    public List<c> cjB() {
        return this.hFR;
    }

    private void ct(List<c> list) {
        this.hFR = list;
    }

    public List<c> cjC() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hFP == 2) {
            if (cjD() != null) {
                arrayList.add(cjD());
            }
        } else {
            c cjD = cjD();
            c cjD2 = cjD();
            if (cjD != null) {
                arrayList.add(cjD);
            }
            if (cjD2 != null) {
                arrayList.add(cjD2);
            }
        }
        ct(arrayList);
        return arrayList;
    }

    private c cjD() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cjE = cjE();
        b cjE2 = cjE();
        if (cjE == null && cjE2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cjE);
        cVar.a(cjE2);
        return cVar;
    }

    private b cjE() {
        b bVar;
        if (this.hFQ < getForumList().size()) {
            bVar = getForumList().get(this.hFQ);
        } else if (this.hFP < getForumList().size()) {
            this.hFQ = 0;
            bVar = getForumList().get(this.hFQ);
        } else {
            return null;
        }
        this.hFQ++;
        return bVar;
    }
}
