package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iGw = BdUniqueId.gen();
    private List<b> forumList;
    private int iGx;
    private int iGy = 0;
    private List<c> iGz;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iGw;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cvz() {
        return this.iGx;
    }

    public void xA(int i) {
        this.iGx = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cX(List<b> list) {
        this.forumList = list;
    }

    public List<c> cvA() {
        return this.iGz;
    }

    private void cY(List<c> list) {
        this.iGz = list;
    }

    public List<c> cvB() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.iGx == 2) {
            if (cvC() != null) {
                arrayList.add(cvC());
            }
        } else {
            c cvC = cvC();
            c cvC2 = cvC();
            if (cvC != null) {
                arrayList.add(cvC);
            }
            if (cvC2 != null) {
                arrayList.add(cvC2);
            }
        }
        cY(arrayList);
        return arrayList;
    }

    private c cvC() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b cvD = cvD();
        b cvD2 = cvD();
        if (cvD == null && cvD2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(cvD);
        cVar.a(cvD2);
        return cVar;
    }

    private b cvD() {
        b bVar;
        if (this.iGy < getForumList().size()) {
            bVar = getForumList().get(this.iGy);
        } else if (this.iGx < getForumList().size()) {
            this.iGy = 0;
            bVar = getForumList().get(this.iGy);
        } else {
            return null;
        }
        this.iGy++;
        return bVar;
    }
}
