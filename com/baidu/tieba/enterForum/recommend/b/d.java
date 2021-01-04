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

    public int czq() {
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

    public List<c> czr() {
        return this.iLg;
    }

    private void cY(List<c> list) {
        this.iLg = list;
    }

    public List<c> czs() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iLe == 2) {
            if (czt() != null) {
                arrayList.add(czt());
            }
        } else {
            c czt = czt();
            c czt2 = czt();
            if (czt != null) {
                arrayList.add(czt);
            }
            if (czt2 != null) {
                arrayList.add(czt2);
            }
        }
        cY(arrayList);
        return arrayList;
    }

    private c czt() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b czu = czu();
        b czu2 = czu();
        if (czu == null && czu2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(czu);
        cVar.a(czu2);
        return cVar;
    }

    private b czu() {
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
