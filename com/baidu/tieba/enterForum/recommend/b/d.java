package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ihj = BdUniqueId.gen();
    private List<b> forumList;
    private int ihk;
    private int ihl = 0;
    private List<c> ihm;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ihj;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cqd() {
        return this.ihk;
    }

    public void xD(int i) {
        this.ihk = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cE(List<b> list) {
        this.forumList = list;
    }

    public List<c> cqe() {
        return this.ihm;
    }

    private void cF(List<c> list) {
        this.ihm = list;
    }

    public List<c> cqf() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.ihk == 2) {
            if (cqg() != null) {
                arrayList.add(cqg());
            }
        } else {
            c cqg = cqg();
            c cqg2 = cqg();
            if (cqg != null) {
                arrayList.add(cqg);
            }
            if (cqg2 != null) {
                arrayList.add(cqg2);
            }
        }
        cF(arrayList);
        return arrayList;
    }

    private c cqg() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cqh = cqh();
        b cqh2 = cqh();
        if (cqh == null && cqh2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cqh);
        cVar.a(cqh2);
        return cVar;
    }

    private b cqh() {
        b bVar;
        if (this.ihl < getForumList().size()) {
            bVar = getForumList().get(this.ihl);
        } else if (this.ihk < getForumList().size()) {
            this.ihl = 0;
            bVar = getForumList().get(this.ihl);
        } else {
            return null;
        }
        this.ihl++;
        return bVar;
    }
}
