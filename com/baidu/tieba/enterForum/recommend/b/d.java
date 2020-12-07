package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iyO = BdUniqueId.gen();
    private List<b> forumList;
    private int iyP;
    private int iyQ = 0;
    private List<c> iyR;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyO;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cww() {
        return this.iyP;
    }

    public void yT(int i) {
        this.iyP = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cQ(List<b> list) {
        this.forumList = list;
    }

    public List<c> cwx() {
        return this.iyR;
    }

    private void cR(List<c> list) {
        this.iyR = list;
    }

    public List<c> cwy() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iyP == 2) {
            if (cwz() != null) {
                arrayList.add(cwz());
            }
        } else {
            c cwz = cwz();
            c cwz2 = cwz();
            if (cwz != null) {
                arrayList.add(cwz);
            }
            if (cwz2 != null) {
                arrayList.add(cwz2);
            }
        }
        cR(arrayList);
        return arrayList;
    }

    private c cwz() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cwA = cwA();
        b cwA2 = cwA();
        if (cwA == null && cwA2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cwA);
        cVar.a(cwA2);
        return cVar;
    }

    private b cwA() {
        b bVar;
        if (this.iyQ < getForumList().size()) {
            bVar = getForumList().get(this.iyQ);
        } else if (this.iyP < getForumList().size()) {
            this.iyQ = 0;
            bVar = getForumList().get(this.iyQ);
        } else {
            return null;
        }
        this.iyQ++;
        return bVar;
    }
}
