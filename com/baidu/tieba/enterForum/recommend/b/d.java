package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hyG = BdUniqueId.gen();
    private List<b> forumList;
    private int hyH;
    private int hyI = 0;
    private List<c> hyJ;
    private String title;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hyG;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cgi() {
        return this.hyH;
    }

    public void wf(int i) {
        this.hyH = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cm(List<b> list) {
        this.forumList = list;
    }

    public List<c> cgj() {
        return this.hyJ;
    }

    private void cn(List<c> list) {
        this.hyJ = list;
    }

    public List<c> cgk() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.hyH == 2) {
            if (cgl() != null) {
                arrayList.add(cgl());
            }
        } else {
            c cgl = cgl();
            c cgl2 = cgl();
            if (cgl != null) {
                arrayList.add(cgl);
            }
            if (cgl2 != null) {
                arrayList.add(cgl2);
            }
        }
        cn(arrayList);
        return arrayList;
    }

    private c cgl() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cgm = cgm();
        b cgm2 = cgm();
        if (cgm == null && cgm2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cgm);
        cVar.a(cgm2);
        return cVar;
    }

    private b cgm() {
        b bVar;
        if (this.hyI < getForumList().size()) {
            bVar = getForumList().get(this.hyI);
        } else if (this.hyH < getForumList().size()) {
            this.hyI = 0;
            bVar = getForumList().get(this.hyI);
        } else {
            return null;
        }
        this.hyI++;
        return bVar;
    }
}
