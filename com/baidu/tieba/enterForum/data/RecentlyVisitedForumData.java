package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VisitedForumData;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class RecentlyVisitedForumData extends OrmObject {
    private LinkedList<VisitedForumData> mForumData = new LinkedList<>();

    public void a(VisitedForumData visitedForumData) {
        VisitedForumData visitedForumData2;
        if (visitedForumData != null) {
            Iterator<VisitedForumData> it = this.mForumData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    visitedForumData2 = null;
                    break;
                }
                visitedForumData2 = it.next();
                if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                    break;
                }
            }
            if (visitedForumData2 != null) {
                this.mForumData.remove(visitedForumData2);
            }
            this.mForumData.addFirst(visitedForumData);
        }
    }

    public void xt(int i) {
        if (this.mForumData != null) {
            while (this.mForumData.size() > i) {
                this.mForumData.removeLast();
            }
        }
    }

    public int b(VisitedForumData visitedForumData) {
        int i;
        if (visitedForumData == null) {
            return -1;
        }
        int size = this.mForumData.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            VisitedForumData visitedForumData2 = this.mForumData.get(i2);
            if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.mForumData.remove(i);
            return i;
        }
        return i;
    }

    public void setForumData(LinkedList<VisitedForumData> linkedList) {
        if (linkedList != null && linkedList.size() != 0) {
            this.mForumData.clear();
            this.mForumData.addAll(linkedList);
        }
    }

    public void a(RecentlyVisitedForumData recentlyVisitedForumData) {
        if (recentlyVisitedForumData != null && recentlyVisitedForumData.getForumData() != null && recentlyVisitedForumData.getForumData().size() != 0) {
            Iterator<VisitedForumData> it = recentlyVisitedForumData.getForumData().iterator();
            while (it.hasNext()) {
                VisitedForumData next = it.next();
                if (!a(this.mForumData, next)) {
                    this.mForumData.addLast(next);
                }
            }
            xt(20);
        }
    }

    private boolean a(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
        if (linkedList == null || visitedForumData == null) {
            return false;
        }
        Iterator<VisitedForumData> it = linkedList.iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!at.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<VisitedForumData> getForumData() {
        return this.mForumData;
    }
}
