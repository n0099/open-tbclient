package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h {
    public static boolean a(p pVar, LinkedList<p> linkedList) {
        int i;
        if (pVar == null || linkedList == null) {
            return false;
        }
        if (pVar == null || linkedList == null) {
            i = -1;
        } else {
            int size = linkedList.size();
            int i2 = 0;
            while (i2 < size && linkedList.get(i2).h() <= pVar.h()) {
                i2++;
            }
            i = i2;
        }
        if (i < 0 || i > linkedList.size()) {
            return false;
        }
        linkedList.add(i, pVar);
        return true;
    }

    public static boolean a(LinkedList<p> linkedList, LinkedList<p> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            p poll = linkedList2.poll();
            if (poll != null) {
                a(poll, linkedList);
            } else {
                return true;
            }
        }
    }

    public static boolean b(p pVar, LinkedList<p> linkedList) {
        if (pVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(pVar);
    }

    public static boolean a(LinkedList<p> linkedList, LinkedList<p> linkedList2, p pVar) {
        if (pVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(pVar)) {
            return false;
        }
        linkedList2.add(pVar);
        return true;
    }

    public static boolean a(LinkedList<p> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null) {
                next.o();
                if (next.n() >= 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static p a(int i, LinkedList<p> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.l() == i) {
                it.remove();
                next.d();
                return next;
            }
        }
        return null;
    }

    public static boolean a(LinkedList<p> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        s i2;
        if (iDuplicateProcess == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (i2 = next.i()) != null && i2.w() == i) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<p> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        s i2;
        if (iDuplicateProcess != null) {
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && (i2 = next.i()) != null && i2.w() == i) {
                    it.remove();
                    cb.a(i, next.l(), "duplicate remove from queue", "MessageQueue: Message throwed", null, 0, null);
                }
            }
        }
    }

    public static boolean a(LinkedList<p> linkedList, b bVar, int i) {
        s i2;
        if (bVar == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (i2 = next.i()) != null && i2.w() == i && bVar.a(i2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(LinkedList<p> linkedList, int i) {
        s i2;
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (i2 = next.i()) != null && i2.w() == i) {
                return true;
            }
        }
        return false;
    }
}
