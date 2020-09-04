package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hyM = BdUniqueId.gen();
    private List<b> forumList;
    private int hyN;
    private int hyO = 0;
    private List<c> hyP;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hyM;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cgj() {
        return this.hyN;
    }

    public void wf(int i) {
        this.hyN = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cm(List<b> list) {
        this.forumList = list;
    }

    public List<c> cgk() {
        return this.hyP;
    }

    private void cn(List<c> list) {
        this.hyP = list;
    }

    public List<c> cgl() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hyN == 2) {
            if (cgm() != null) {
                arrayList.add(cgm());
            }
        } else {
            c cgm = cgm();
            c cgm2 = cgm();
            if (cgm != null) {
                arrayList.add(cgm);
            }
            if (cgm2 != null) {
                arrayList.add(cgm2);
            }
        }
        cn(arrayList);
        return arrayList;
    }

    private c cgm() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cgn = cgn();
        b cgn2 = cgn();
        if (cgn == null && cgn2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cgn);
        cVar.a(cgn2);
        return cVar;
    }

    private b cgn() {
        b bVar;
        if (this.hyO < getForumList().size()) {
            bVar = getForumList().get(this.hyO);
        } else if (this.hyN < getForumList().size()) {
            this.hyO = 0;
            bVar = getForumList().get(this.hyO);
        } else {
            return null;
        }
        this.hyO++;
        return bVar;
    }
}
