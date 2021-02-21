package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iMt = BdUniqueId.gen();
    private List<b> forumList;
    private int iMu;
    private int iMv = 0;
    private List<c> iMw;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iMt;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cwS() {
        return this.iMu;
    }

    public void xK(int i) {
        this.iMu = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cS(List<b> list) {
        this.forumList = list;
    }

    public List<c> cwT() {
        return this.iMw;
    }

    private void cT(List<c> list) {
        this.iMw = list;
    }

    public List<c> cwU() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iMu == 2) {
            if (cwV() != null) {
                arrayList.add(cwV());
            }
        } else {
            c cwV = cwV();
            c cwV2 = cwV();
            if (cwV != null) {
                arrayList.add(cwV);
            }
            if (cwV2 != null) {
                arrayList.add(cwV2);
            }
        }
        cT(arrayList);
        return arrayList;
    }

    private c cwV() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cwW = cwW();
        b cwW2 = cwW();
        if (cwW == null && cwW2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cwW);
        cVar.a(cwW2);
        return cVar;
    }

    private b cwW() {
        b bVar;
        if (this.iMv < getForumList().size()) {
            bVar = getForumList().get(this.iMv);
        } else if (this.iMu < getForumList().size()) {
            this.iMv = 0;
            bVar = getForumList().get(this.iMv);
        } else {
            return null;
        }
        this.iMv++;
        return bVar;
    }
}
