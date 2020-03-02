package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWY = BdUniqueId.gen();
    private int fWZ;
    private int fXa = 0;
    private List<c> fXb;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fWY;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int byX() {
        return this.fWZ;
    }

    public void rT(int i) {
        this.fWZ = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bN(List<b> list) {
        this.forumList = list;
    }

    public List<c> byY() {
        return this.fXb;
    }

    private void bO(List<c> list) {
        this.fXb = list;
    }

    public List<c> byZ() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fWZ == 2) {
            if (bza() != null) {
                arrayList.add(bza());
            }
        } else {
            c bza = bza();
            c bza2 = bza();
            if (bza != null) {
                arrayList.add(bza);
            }
            if (bza2 != null) {
                arrayList.add(bza2);
            }
        }
        bO(arrayList);
        return arrayList;
    }

    private c bza() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bzb = bzb();
        b bzb2 = bzb();
        if (bzb == null && bzb2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bzb);
        cVar.a(bzb2);
        return cVar;
    }

    private b bzb() {
        b bVar;
        if (this.fXa < getForumList().size()) {
            bVar = getForumList().get(this.fXa);
        } else if (this.fWZ < getForumList().size()) {
            this.fXa = 0;
            bVar = getForumList().get(this.fXa);
        } else {
            return null;
        }
        this.fXa++;
        return bVar;
    }
}
