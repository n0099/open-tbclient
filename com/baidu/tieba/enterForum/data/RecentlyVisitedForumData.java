package com.baidu.tieba.enterForum.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.data.VisitedForumData;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class RecentlyVisitedForumData extends OrmObject {

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<VisitedForumData> f14444e = new LinkedList<>();

    public void A(RecentlyVisitedForumData recentlyVisitedForumData) {
        if (recentlyVisitedForumData == null || recentlyVisitedForumData.y() == null || recentlyVisitedForumData.y().size() == 0) {
            return;
        }
        Iterator<VisitedForumData> it = recentlyVisitedForumData.y().iterator();
        while (it.hasNext()) {
            VisitedForumData next = it.next();
            if (!z(this.f14444e, next)) {
                this.f14444e.addLast(next);
            }
        }
        C(20);
    }

    public void B(LinkedList<VisitedForumData> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return;
        }
        this.f14444e.clear();
        this.f14444e.addAll(linkedList);
    }

    public void C(int i2) {
        if (this.f14444e == null) {
            return;
        }
        while (this.f14444e.size() > i2) {
            this.f14444e.removeLast();
        }
    }

    public void w(VisitedForumData visitedForumData) {
        if (visitedForumData == null) {
            return;
        }
        VisitedForumData visitedForumData2 = null;
        Iterator<VisitedForumData> it = this.f14444e.iterator();
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
            this.f14444e.remove(visitedForumData2);
        }
        this.f14444e.addFirst(visitedForumData);
    }

    public int x(VisitedForumData visitedForumData) {
        int i2 = -1;
        if (visitedForumData == null) {
            return -1;
        }
        int size = this.f14444e.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            VisitedForumData visitedForumData2 = this.f14444e.get(i3);
            if (!k.isEmpty(visitedForumData.getForumId()) && visitedForumData.getForumId().equals(visitedForumData2.getForumId())) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            this.f14444e.remove(i2);
        }
        return i2;
    }

    public LinkedList<VisitedForumData> y() {
        return this.f14444e;
    }

    public final boolean z(LinkedList<VisitedForumData> linkedList, VisitedForumData visitedForumData) {
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
}
