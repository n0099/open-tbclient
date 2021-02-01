package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iMf = BdUniqueId.gen();
    private List<b> forumList;
    private int iMg;
    private int iMh = 0;
    private List<c> iMi;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iMf;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cwL() {
        return this.iMg;
    }

    public void xK(int i) {
        this.iMg = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cS(List<b> list) {
        this.forumList = list;
    }

    public List<c> cwM() {
        return this.iMi;
    }

    private void cT(List<c> list) {
        this.iMi = list;
    }

    public List<c> cwN() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iMg == 2) {
            if (cwO() != null) {
                arrayList.add(cwO());
            }
        } else {
            c cwO = cwO();
            c cwO2 = cwO();
            if (cwO != null) {
                arrayList.add(cwO);
            }
            if (cwO2 != null) {
                arrayList.add(cwO2);
            }
        }
        cT(arrayList);
        return arrayList;
    }

    private c cwO() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cwP = cwP();
        b cwP2 = cwP();
        if (cwP == null && cwP2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cwP);
        cVar.a(cwP2);
        return cVar;
    }

    private b cwP() {
        b bVar;
        if (this.iMh < getForumList().size()) {
            bVar = getForumList().get(this.iMh);
        } else if (this.iMg < getForumList().size()) {
            this.iMh = 0;
            bVar = getForumList().get(this.iMh);
        } else {
            return null;
        }
        this.iMh++;
        return bVar;
    }
}
