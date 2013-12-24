package com.baidu.tieba.im.messageCenter;

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

    public static p a(com.baidu.tieba.im.message.n nVar, LinkedList<p> linkedList) {
        if (nVar == null || linkedList == null) {
            return null;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && next.j() == nVar) {
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
        while (i < size && linkedList.get(i).i() <= pVar.i()) {
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
        if (pVar == null || linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.remove(pVar)) {
            linkedList2.add(pVar);
            return true;
        }
        return false;
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
                    next.e();
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
            if (next != null && next.l() == i) {
                it.remove();
                next.f();
                return next;
            }
        }
        return null;
    }

    public static boolean a(LinkedList<p> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        com.baidu.tieba.im.message.n j;
        if (iDuplicateProcess == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (j = next.j()) != null && j.t() == i && iDuplicateProcess.a(j)) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<p> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        com.baidu.tieba.im.message.n j;
        if (iDuplicateProcess != null) {
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && (j = next.j()) != null && j.t() == i && iDuplicateProcess.a(j)) {
                    it.remove();
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(i, next.l(), "duplicate remove from queue", "MessageQueue: Message throwed", null, 0, null));
                }
            }
        }
    }

    public static boolean a(LinkedList<p> linkedList, c cVar, int i) {
        com.baidu.tieba.im.message.n j;
        if (cVar == null) {
            return false;
        }
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (j = next.j()) != null && j.t() == i && cVar.a(j)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(LinkedList<p> linkedList, int i) {
        com.baidu.tieba.im.message.n j;
        Iterator<p> it = linkedList.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next != null && (j = next.j()) != null && j.t() == i) {
                return true;
            }
        }
        return false;
    }
}
