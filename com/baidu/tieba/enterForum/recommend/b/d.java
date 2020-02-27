package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWW = BdUniqueId.gen();
    private int fWX;
    private int fWY = 0;
    private List<c> fWZ;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fWW;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int byV() {
        return this.fWX;
    }

    public void rT(int i) {
        this.fWX = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bN(List<b> list) {
        this.forumList = list;
    }

    public List<c> byW() {
        return this.fWZ;
    }

    private void bO(List<c> list) {
        this.fWZ = list;
    }

    public List<c> byX() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fWX == 2) {
            if (byY() != null) {
                arrayList.add(byY());
            }
        } else {
            c byY = byY();
            c byY2 = byY();
            if (byY != null) {
                arrayList.add(byY);
            }
            if (byY2 != null) {
                arrayList.add(byY2);
            }
        }
        bO(arrayList);
        return arrayList;
    }

    private c byY() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b byZ = byZ();
        b byZ2 = byZ();
        if (byZ == null && byZ2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(byZ);
        cVar.a(byZ2);
        return cVar;
    }

    private b byZ() {
        b bVar;
        if (this.fWY < getForumList().size()) {
            bVar = getForumList().get(this.fWY);
        } else if (this.fWX < getForumList().size()) {
            this.fWY = 0;
            bVar = getForumList().get(this.fWY);
        } else {
            return null;
        }
        this.fWY++;
        return bVar;
    }
}
