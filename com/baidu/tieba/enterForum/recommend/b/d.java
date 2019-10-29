package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdZ = BdUniqueId.gen();
    private int fea;
    private int feb = 0;
    private List<c> fec;
    private List<b> forumList;
    private String title;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdZ;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int beZ() {
        return this.fea;
    }

    public void pD(int i) {
        this.fea = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void bU(List<b> list) {
        this.forumList = list;
    }

    public List<c> bfa() {
        return this.fec;
    }

    private void bV(List<c> list) {
        this.fec = list;
    }

    public List<c> bfb() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.fea == 2) {
            if (bfc() != null) {
                arrayList.add(bfc());
            }
        } else {
            c bfc = bfc();
            c bfc2 = bfc();
            if (bfc != null) {
                arrayList.add(bfc);
            }
            if (bfc2 != null) {
                arrayList.add(bfc2);
            }
        }
        bV(arrayList);
        return arrayList;
    }

    private c bfc() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b bfd = bfd();
        b bfd2 = bfd();
        if (bfd == null && bfd2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(bfd);
        cVar.a(bfd2);
        return cVar;
    }

    private b bfd() {
        b bVar;
        if (this.feb < getForumList().size()) {
            bVar = getForumList().get(this.feb);
        } else if (this.fea < getForumList().size()) {
            this.feb = 0;
            bVar = getForumList().get(this.feb);
        } else {
            return null;
        }
        this.feb++;
        return bVar;
    }
}
