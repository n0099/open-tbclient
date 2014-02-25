package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    public static boolean a(p pVar, LinkedList<p> linkedList) {
        int c;
        if (pVar == null || linkedList == null || (c = c(pVar, linkedList)) < 0 || c > linkedList.size()) {
            return false;
        }
        linkedList.add(c, pVar);
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

    public static int a(LinkedList<p> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }

    public static p b(LinkedList<p> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && !next.m()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean b(p pVar, LinkedList<p> linkedList) {
        if (pVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(pVar);
    }

    public static p a(s sVar, LinkedList<p> linkedList) {
        if (sVar == null || linkedList == null) {
            return null;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.i() == sVar) {
                linkedList.remove(next);
                return next;
            }
        }
        return null;
    }

    public static int c(p pVar, LinkedList<p> linkedList) {
        if (pVar == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size && linkedList.get(i).g() <= pVar.g()) {
            i++;
        }
        return i;
    }

    public static p c(LinkedList<p> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static p d(LinkedList<p> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean a(LinkedList<p> linkedList, LinkedList<p> linkedList2, p pVar) {
        if (pVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(pVar)) {
            return false;
        }
        linkedList2.add(pVar);
        return true;
    }

    public static boolean e(LinkedList<p> linkedList) {
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

    public static void f(LinkedList<p> linkedList) {
        if (linkedList != null) {
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public static p a(int i, LinkedList<p> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.k() == i) {
                it.remove();
                next.b();
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
            if (next != null && (i2 = next.i()) != null && i2.w() == i && iDuplicateProcess.a(i2)) {
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
                if (next != null && (i2 = next.i()) != null && i2.w() == i && iDuplicateProcess.a(i2)) {
                    it.remove();
                    cb.a(i, next.k(), "duplicate remove from queue", "MessageQueue: Message throwed", null, 0, null);
                }
            }
        }
    }

    public static boolean a(LinkedList<p> linkedList, c cVar, int i) {
        s i2;
        if (cVar == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (i2 = next.i()) != null && i2.w() == i && cVar.a(i2)) {
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
