package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.codec.NetworkMessage;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {
    public static boolean a(s sVar, LinkedList<s> linkedList) {
        int d;
        if (sVar == null || linkedList == null || (d = d(sVar, linkedList)) < 0 || d > linkedList.size()) {
            return false;
        }
        linkedList.add(d, sVar);
        return true;
    }

    public static boolean b(s sVar, LinkedList<s> linkedList) {
        if (sVar == null || linkedList == null) {
            return false;
        }
        linkedList.add(sVar);
        return true;
    }

    public static boolean c(s sVar, LinkedList<s> linkedList) {
        if (sVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(sVar);
    }

    public static s a(Message message, LinkedList<s> linkedList) {
        if (message == null || linkedList == null) {
            return null;
        }
        Iterator<s> it = linkedList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next != null && next.g() == message) {
                linkedList.remove(next);
                return next;
            }
        }
        return null;
    }

    public static int d(s sVar, LinkedList<s> linkedList) {
        if (sVar == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i = 0;
        while (i < size && linkedList.get(i).h() <= sVar.h()) {
            i++;
        }
        return i;
    }

    public static s a(LinkedList<s> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static s b(LinkedList<s> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static boolean a(LinkedList<s> linkedList, LinkedList<s> linkedList2, s sVar) {
        if (sVar == null || linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.remove(sVar)) {
            linkedList2.add(sVar);
            return true;
        }
        return false;
    }

    public static s a(int i, LinkedList<s> linkedList) {
        AckedMessage.MessageTag msgTag;
        if (linkedList == null) {
            return null;
        }
        Iterator<s> it = linkedList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            NetworkMessage c = next.c();
            if (c != null && (msgTag = c.getMsgTag()) != null && msgTag.getSequence() == i) {
                return next;
            }
        }
        return null;
    }

    public static boolean a(LinkedList<s> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        Message g;
        if (iDuplicateProcess == null) {
            return false;
        }
        Iterator<s> it = linkedList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next != null && (g = next.g()) != null && g.getCmd() == i && iDuplicateProcess.onDuplicateProcess(g)) {
                return true;
            }
        }
        return false;
    }

    public static void b(LinkedList<s> linkedList, IDuplicateProcess iDuplicateProcess, int i) {
        Message g;
        if (iDuplicateProcess != null) {
            Iterator<s> it = linkedList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && (g = next.g()) != null && g.getCmd() == i && iDuplicateProcess.onDuplicateProcess(g)) {
                    it.remove();
                    com.baidu.tieba.util.o.a(i, (next.c() == null || next.c().getMsgTag() == null) ? 0 : next.c().getMsgTag().getSequence(), "duplicate remove from queue", "MessageQueue: Message throwed", null, 0, null);
                }
            }
        }
    }

    public static boolean a(LinkedList<s> linkedList, c cVar, int i) {
        Message g;
        if (cVar == null) {
            return false;
        }
        Iterator<s> it = linkedList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next != null && (g = next.g()) != null && g.getCmd() == i && cVar.onFindMessage(g)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(LinkedList<s> linkedList, int i) {
        Message g;
        Iterator<s> it = linkedList.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next != null && (g = next.g()) != null && g.getCmd() == i) {
                return true;
            }
        }
        return false;
    }
}
