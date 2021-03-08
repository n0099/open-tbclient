package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iOc = BdUniqueId.gen();
    private List<b> forumList;
    private int iOd;
    private int iOe = 0;
    private List<c> iOf;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iOc;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cwY() {
        return this.iOd;
    }

    public void xL(int i) {
        this.iOd = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cS(List<b> list) {
        this.forumList = list;
    }

    public List<c> cwZ() {
        return this.iOf;
    }

    private void cT(List<c> list) {
        this.iOf = list;
    }

    public List<c> cxa() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iOd == 2) {
            if (cxb() != null) {
                arrayList.add(cxb());
            }
        } else {
            c cxb = cxb();
            c cxb2 = cxb();
            if (cxb != null) {
                arrayList.add(cxb);
            }
            if (cxb2 != null) {
                arrayList.add(cxb2);
            }
        }
        cT(arrayList);
        return arrayList;
    }

    private c cxb() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cxc = cxc();
        b cxc2 = cxc();
        if (cxc == null && cxc2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cxc);
        cVar.a(cxc2);
        return cVar;
    }

    private b cxc() {
        b bVar;
        if (this.iOe < getForumList().size()) {
            bVar = getForumList().get(this.iOe);
        } else if (this.iOd < getForumList().size()) {
            this.iOe = 0;
            bVar = getForumList().get(this.iOe);
        } else {
            return null;
        }
        this.iOe++;
        return bVar;
    }
}
