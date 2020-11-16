package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId inW = BdUniqueId.gen();
    private List<b> forumList;
    private int inX;
    private int inY = 0;
    private List<c> inZ;
    private String title;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return inW;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int csh() {
        return this.inX;
    }

    public void yo(int i) {
        this.inX = i;
    }

    public List<b> getForumList() {
        return this.forumList;
    }

    public void cM(List<b> list) {
        this.forumList = list;
    }

    public List<c> csi() {
        return this.inZ;
    }

    private void cN(List<c> list) {
        this.inZ = list;
    }

    public List<c> csj() {
        if (getForumList().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.inX == 2) {
            if (csk() != null) {
                arrayList.add(csk());
            }
        } else {
            c csk = csk();
            c csk2 = csk();
            if (csk != null) {
                arrayList.add(csk);
            }
            if (csk2 != null) {
                arrayList.add(csk2);
            }
        }
        cN(arrayList);
        return arrayList;
    }

    private c csk() {
        if (getForumList().size() <= 0) {
            return null;
        }
        b csl = csl();
        b csl2 = csl();
        if (csl == null && csl2 == null) {
            return null;
        }
        c cVar = new c();
        cVar.b(csl);
        cVar.a(csl2);
        return cVar;
    }

    private b csl() {
        b bVar;
        if (this.inY < getForumList().size()) {
            bVar = getForumList().get(this.inY);
        } else if (this.inX < getForumList().size()) {
            this.inY = 0;
            bVar = getForumList().get(this.inY);
        } else {
            return null;
        }
        this.inY++;
        return bVar;
    }
}
