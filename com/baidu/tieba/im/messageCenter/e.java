package com.baidu.tieba.im.messageCenter;

import android.util.SparseArray;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.slidingmenu.lib.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f1796a = null;
    private SparseArray<Class<? extends d>> b;
    private SparseArray<Class<? extends a>> c;
    private SparseArray<Class<? extends ResponsedMessage>> d;
    private SparseArray<LinkedList<WeakReference<g>>> e;
    private com.baidu.tieba.im.a<ResponsedMessage> f;
    private i g;

    private e() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.d = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.e = new SparseArray<>();
        this.f = new f(this);
        this.g = new i(this);
    }

    public static e a() {
        if (f1796a == null) {
            synchronized (e.class) {
                if (f1796a == null) {
                    f1796a = new e();
                }
            }
        }
        return f1796a;
    }

    public void a(Message message, int i, int i2, boolean z) {
        this.g.a(message, true, i, 1, i2, z);
    }

    public void a(Message message) {
        if (message != null) {
            Class<? extends d> cls = this.b.get(message.getCmd());
            if (cls == null) {
                this.g.a(message, true, 0, 1, 0, true);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.b(message);
                com.baidu.tieba.im.m.a(newInstance, this.f);
            } catch (Exception e) {
                a(message, com.baidu.tieba.im.k.u, TiebaApplication.h().getString(R.string.error_unkown));
            }
        }
    }

    public void a(boolean z) {
        this.g.a(z);
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.g.a(aVar);
    }

    public void b(Message message) {
        this.g.b(message);
    }

    public void a(int i, Class<? extends d> cls) {
        this.b.put(i, cls);
    }

    public a a(int i) {
        Class<? extends a> cls = this.c.get(i);
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
            }
        }
        return null;
    }

    public void b(int i, Class<? extends a> cls) {
        this.c.put(i, cls);
    }

    public void c(int i, Class<? extends ResponsedMessage> cls) {
        this.d.put(i, cls);
    }

    public void a(int i, g gVar) {
        if (gVar != null) {
            LinkedList<WeakReference<g>> linkedList = this.e.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(i, linkedList);
            }
            linkedList.add(new WeakReference<>(gVar));
        }
    }

    public void a(g gVar) {
        if (gVar != null) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                LinkedList<WeakReference<g>> valueAt = this.e.valueAt(i);
                Iterator<WeakReference<g>> it = valueAt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<g> next = it.next();
                    g gVar2 = next.get();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        valueAt.remove(next);
                        break;
                    }
                }
            }
        }
    }

    private ResponsedMessage b(Message message, int i, String str) {
        if (message == null) {
            return null;
        }
        ResponsedMessage responsedMessage = new ResponsedMessage(message.getCmd());
        responsedMessage.setOrginalMessage(message);
        responsedMessage.setErrNo(i);
        responsedMessage.setErrMsg(str);
        return responsedMessage;
    }

    public boolean c(Message message) {
        return this.g.a(message);
    }

    public boolean b(int i) {
        return this.g.a(i);
    }

    public void d(Message message) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(message);
        a(linkedList);
    }

    public void e(Message message) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(message);
        a(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<Message> list) {
        LinkedList<WeakReference<g>> linkedList;
        if (list != null) {
            for (Message message : list) {
                if (message != null && (linkedList = this.e.get(message.getCmd())) != null && !linkedList.isEmpty()) {
                    Iterator<WeakReference<g>> it = linkedList.iterator();
                    while (it.hasNext()) {
                        g gVar = it.next().get();
                        if (gVar != null) {
                            gVar.a(message);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Message message, int i, String str) {
        ResponsedMessage b;
        if (message != null) {
            Class<? extends ResponsedMessage> cls = this.d.get(message.getCmd());
            if (cls == null) {
                b = b(message, i, str);
            } else {
                try {
                    b = cls.newInstance();
                    b.setCmd(message.getCmd());
                    b.setErrNo(i);
                    b.setErrMsg(str);
                    b.setOrginalMessage(message);
                    if (i > 0 && TiebaApplication.h().t()) {
                        StatService.onEvent(TiebaApplication.h().getApplicationContext(), "send_msg_fail_time", "send_fail", 1);
                    }
                } catch (Exception e) {
                    b = b(message, com.baidu.tieba.im.k.u, TiebaApplication.h().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
