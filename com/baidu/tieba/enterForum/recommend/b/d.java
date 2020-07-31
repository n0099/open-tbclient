package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hlP = BdUniqueId.gen();
    private List<b> forumList;
    private int hlQ;
    private int hlR = 0;
    private List<c> hlS;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hlP;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bVV() {
        return this.hlQ;
    }

    public void tQ(int i) {
        this.hlQ = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void ck(List<b> list) {
        this.forumList = list;
    }

    public List<c> bVW() {
        return this.hlS;
    }

    private void cl(List<c> list) {
        this.hlS = list;
    }

    public List<c> bVX() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hlQ == 2) {
            if (bVY() != null) {
                arrayList.add(bVY());
            }
        } else {
            c bVY = bVY();
            c bVY2 = bVY();
            if (bVY != null) {
                arrayList.add(bVY);
            }
            if (bVY2 != null) {
                arrayList.add(bVY2);
            }
        }
        cl(arrayList);
        return arrayList;
    }

    private c bVY() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bVZ = bVZ();
        b bVZ2 = bVZ();
        if (bVZ == null && bVZ2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bVZ);
        cVar.a(bVZ2);
        return cVar;
    }

    private b bVZ() {
        b bVar;
        if (this.hlR < getForumList().size()) {
            bVar = getForumList().get(this.hlR);
        } else if (this.hlQ < getForumList().size()) {
            this.hlR = 0;
            bVar = getForumList().get(this.hlR);
        } else {
            return null;
        }
        this.hlR++;
        return bVar;
    }
}
