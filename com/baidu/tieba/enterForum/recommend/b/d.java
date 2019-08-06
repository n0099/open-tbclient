package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eZI = BdUniqueId.gen();
    private int eZJ;
    private int eZK = 0;
    private List<c> eZL;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eZI;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int bgz() {
        return this.eZJ;
    }

    public void qE(int i) {
        this.eZJ = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bH(List<b> list) {
        this.forumList = list;
    }

    public List<c> bgA() {
        return this.eZL;
    }

    private void bI(List<c> list) {
        this.eZL = list;
    }

    public List<c> bgB() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.eZJ == 2) {
            if (bgC() != null) {
                arrayList.add(bgC());
            }
        } else {
            c bgC = bgC();
            c bgC2 = bgC();
            if (bgC != null) {
                arrayList.add(bgC);
            }
            if (bgC2 != null) {
                arrayList.add(bgC2);
            }
        }
        bI(arrayList);
        return arrayList;
    }

    private c bgC() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bgD = bgD();
        b bgD2 = bgD();
        if (bgD == null && bgD2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bgD);
        cVar.a(bgD2);
        return cVar;
    }

    private b bgD() {
        b bVar;
        if (this.eZK < getForumList().size()) {
            bVar = getForumList().get(this.eZK);
        } else if (this.eZJ < getForumList().size()) {
            this.eZK = 0;
            bVar = getForumList().get(this.eZK);
        } else {
            return null;
        }
        this.eZK++;
        return bVar;
    }
}
