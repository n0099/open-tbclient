package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iLd = BdUniqueId.gen();
    private List<b> forumList;
    private int iLe;
    private int iLf = 0;
    private List<c> iLg;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iLd;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int czr() {
        return this.iLe;
    }

    public void zg(int i) {
        this.iLe = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cX(List<b> list) {
        this.forumList = list;
    }

    public List<c> czs() {
        return this.iLg;
    }

    private void cY(List<c> list) {
        this.iLg = list;
    }

    public List<c> czt() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iLe == 2) {
            if (czu() != null) {
                arrayList.add(czu());
            }
        } else {
            c czu = czu();
            c czu2 = czu();
            if (czu != null) {
                arrayList.add(czu);
            }
            if (czu2 != null) {
                arrayList.add(czu2);
            }
        }
        cY(arrayList);
        return arrayList;
    }

    private c czu() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b czv = czv();
        b czv2 = czv();
        if (czv == null && czv2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(czv);
        cVar.a(czv2);
        return cVar;
    }

    private b czv() {
        b bVar;
        if (this.iLf < getForumList().size()) {
            bVar = getForumList().get(this.iLf);
        } else if (this.iLe < getForumList().size()) {
            this.iLf = 0;
            bVar = getForumList().get(this.iLf);
        } else {
            return null;
        }
        this.iLf++;
        return bVar;
    }
}
