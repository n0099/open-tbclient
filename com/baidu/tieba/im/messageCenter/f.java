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
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f1644a = null;
    private SparseArray<Class<? extends d>> b;
    private SparseArray<Class<? extends a>> c;
    private SparseArray<Class<? extends ResponsedMessage>> d;
    private SparseArray<LinkedList<WeakReference<h>>> e;
    private com.baidu.tieba.im.a<ResponsedMessage> f;
    private k g;

    private f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.g = new k(this);
        this.d = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
        this.e = new SparseArray<>();
        this.f = new g(this);
    }

    public static f a() {
        if (f1644a == null) {
            synchronized (f.class) {
                if (f1644a == null) {
                    f1644a = new f();
                }
            }
        }
        return f1644a;
    }

    public void a(Message message, boolean z, int i, int i2, int i3) {
        this.g.a(message, z, i, i2, i3);
    }

    public void a(Message message) {
        if (message != null) {
            Class<? extends d> cls = this.b.get(message.getCmd());
            if (cls == null) {
                this.g.a(message, true, 0, 1, 0);
                return;
            }
            try {
                d newInstance = cls.newInstance();
                newInstance.a(message);
                com.baidu.tieba.im.m.a(newInstance, this.f);
            } catch (Exception e) {
                a(message, com.baidu.tieba.im.k.t, TiebaApplication.g().getString(R.string.error_unkown));
            }
        }
    }

    public void a(boolean z) {
        this.g.a(z);
    }

    public void b(boolean z) {
        this.g.b(z);
    }

    public void a(com.baidu.tieba.im.net.link.a aVar) {
        this.g.a(aVar);
    }

    public void b(Message message) {
        this.g.c(message);
    }

    public void b() {
        this.g.a();
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
                com.baidu.adp.lib.h.d.a(e.getMessage());
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

    public void a(int i, h hVar) {
        if (hVar != null) {
            LinkedList<WeakReference<h>> linkedList = this.e.get(i);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.e.put(i, linkedList);
            }
            linkedList.add(new WeakReference<>(hVar));
        }
    }

    public void a(h hVar) {
        if (hVar != null) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                LinkedList<WeakReference<h>> valueAt = this.e.valueAt(i);
                Iterator<WeakReference<h>> it = valueAt.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WeakReference<h> next = it.next();
                    h hVar2 = next.get();
                    if (hVar2 != null && hVar2.equals(hVar)) {
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
        LinkedList<WeakReference<h>> linkedList;
        if (list != null) {
            for (Message message : list) {
                if (message != null && (linkedList = this.e.get(message.getCmd())) != null && !linkedList.isEmpty()) {
                    Iterator<WeakReference<h>> it = linkedList.iterator();
                    while (it.hasNext()) {
                        h hVar = it.next().get();
                        if (hVar != null) {
                            hVar.a(message);
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
                    if (i > 0 && TiebaApplication.g().s()) {
                        StatService.onEvent(TiebaApplication.g().getApplicationContext(), "send_msg_fail_time", "send_fail", 1);
                    }
                } catch (Exception e) {
                    b = b(message, com.baidu.tieba.im.k.t, TiebaApplication.g().getString(R.string.error_unkown));
                }
            }
            e(b);
        }
    }
}
