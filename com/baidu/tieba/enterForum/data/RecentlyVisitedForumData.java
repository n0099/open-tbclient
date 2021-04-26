package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.data.VisitedForumData;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<VisitedForumData> f15169e = new LinkedList<>();

    public void s(VisitedForumData visitedForumData) {
        if (visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.f15169e.iterator();
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
            this.f15169e.remove(visitedForumData2);
        }
        this.f15169e.addFirst(visitedForumData);
    }

    public int t(VisitedForumData visitedForumData) {
        int i2 = -1;
        if (visitedForumData == null) {
            return -1;
        }
        int size = this.f15169e.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData2 = this.f15169e.get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f15169e.remove(i2);
        }
        return i2;
    }

    public LinkedList<VisitedForumData> u() {
        return this.f15169e;
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
            if (!v(this.f15169e, next)) {
                this.f15169e.addLast(next);
            }
        }
        y(20);
    }

    public void x(LinkedList<VisitedForumData> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.f15169e.clear();
        this.f15169e.addAll(linkedList);
    }

    public void y(int i2) {
        if (this.f15169e == null) {
            return;
        }
        while (this.f15169e.size() > i2) {
            this.f15169e.removeLast();
        }
    }
}
