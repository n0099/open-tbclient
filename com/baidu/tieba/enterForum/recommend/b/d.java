package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iyQ = BdUniqueId.gen();
    private List<b> forumList;
    private int iyR;
    private int iyS = 0;
    private List<c> iyT;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyQ;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cwx() {
        return this.iyR;
    }

    public void yT(int i) {
        this.iyR = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cQ(List<b> list) {
        this.forumList = list;
    }

    public List<c> cwy() {
        return this.iyT;
    }

    private void cR(List<c> list) {
        this.iyT = list;
    }

    public List<c> cwz() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iyR == 2) {
            if (cwA() != null) {
                arrayList.add(cwA());
            }
        } else {
            c cwA = cwA();
            c cwA2 = cwA();
            if (cwA != null) {
                arrayList.add(cwA);
            }
            if (cwA2 != null) {
                arrayList.add(cwA2);
            }
        }
        cR(arrayList);
        return arrayList;
    }

    private c cwA() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cwB = cwB();
        b cwB2 = cwB();
        if (cwB == null && cwB2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cwB);
        cVar.a(cwB2);
        return cVar;
    }

    private b cwB() {
        b bVar;
        if (this.iyS < getForumList().size()) {
            bVar = getForumList().get(this.iyS);
        } else if (this.iyR < getForumList().size()) {
            this.iyS = 0;
            bVar = getForumList().get(this.iyS);
        } else {
            return null;
        }
        this.iyS++;
        return bVar;
    }
}
