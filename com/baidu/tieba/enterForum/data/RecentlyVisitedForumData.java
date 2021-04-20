package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.data.VisitedForumData;
import d.b.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<VisitedForumData> f15040e = new LinkedList<>();

    public void s(VisitedForumData visitedForumData) {
        if (visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.f15040e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VisitedForumData next = it.next();
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                visitedForumData2 = next;
                break;
            }
        }
        if (visitedForumData2 != null) {
            this.f15040e.remove(visitedForumData2);
        }
        this.f15040e.addFirst(visitedForumData);
    }

    public int t(VisitedForumData visitedForumData) {
        int i = -1;
        if (visitedForumData == null) {
            return -1;
        }
        int size = this.f15040e.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            VisitedForumData visitedForumData2 = this.f15040e.get(i2);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            this.f15040e.remove(i);
        }
        return i;
    }

    public LinkedList<VisitedForumData> u() {
        return this.f15040e;
    }

    public final boolean v(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
        if (linkedList != null && visitedForumData != null) {
            Iterator<VisitedForumData> it = linkedList.iterator();
            while (it.hasNext()) {
                VisitedForumData next = it.next();
                if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(next.getForumId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void w(RecentlyVisitedForumData recentlyVisitedForumData) {
        if (recentlyVisitedForumData == null || recentlyVisitedForumData.u() == null || recentlyVisitedForumData.u().size() == 0) {
            return;
        }
        Iterator<VisitedForumData> it = recentlyVisitedForumData.u().iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!v(this.f15040e, next)) {
                this.f15040e.addLast(next);
            }
        }
        y(20);
    }

    public void x(LinkedList<VisitedForumData> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.f15040e.clear();
        this.f15040e.addAll(linkedList);
    }

    public void y(int i) {
        if (this.f15040e == null) {
            return;
        }
        while (this.f15040e.size() > i) {
            this.f15040e.removeLast();
        }
    }
}
