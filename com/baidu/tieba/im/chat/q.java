package com.baidu.tieba.im.chat;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class q {
    private final LinkedList<WeakReference<bc>> c = new LinkedList<>();
    private ai d = null;
    private static q b = null;
    public static volatile int a = 0;

    private q() {
    }

    public final void a() {
        this.d = new ai(this, (byte) 0);
        com.baidu.tieba.im.messageCenter.d.a().a(202001, this.d);
        com.baidu.tieba.im.messageCenter.d.a().a(SapiErrorCode.INVALID_ARG, this.d);
        com.baidu.tieba.im.messageCenter.d.a().a(SapiErrorCode.GET_CERT_FAIL, this.d);
        com.baidu.tieba.im.messageCenter.d.a().a(205001, this.d);
    }

    public static q b() {
        if (b == null) {
            b = new q();
        }
        return b;
    }

    public static void a(int i) {
        if (i != 0 && a != i) {
            if (a != 0) {
                com.baidu.adp.lib.util.e.b("私聊GID有变化!!!!!!!!!!!");
            }
            a = i;
            com.baidu.tieba.im.i.a(new r(i), null);
        }
    }

    public final void a(bc bcVar) {
        Iterator<WeakReference<bc>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().get() == bcVar) {
                z = true;
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(bcVar));
        }
    }

    public final void b(bc bcVar) {
        WeakReference<bc> weakReference;
        Iterator<WeakReference<bc>> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == bcVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.c.remove(weakReference);
        }
    }

    public final void a(String str, bd bdVar) {
        com.baidu.tieba.im.i.a(new aa(this, str), new ab(this, bdVar));
    }

    public final void b(String str, bd bdVar) {
        com.baidu.tieba.im.i.a(new ac(this, str), new ad(this, bdVar));
    }

    public final void a(com.baidu.tieba.im.message.b bVar) {
        com.baidu.adp.lib.util.e.e("SHNAG chatManager sendMessage, content = " + bVar.k());
        if (bVar instanceof com.baidu.tieba.im.message.g) {
            com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) bVar;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(gVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.i.a(new ae(this, gVar, linkedList), new af(this, gVar));
        } else if (bVar instanceof com.baidu.tieba.im.message.w) {
            com.baidu.tieba.im.message.w wVar = (com.baidu.tieba.im.message.w) bVar;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(bVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.i.a(new ag(this, wVar, linkedList2), new ah(this, wVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(q qVar, com.baidu.tieba.im.message.s sVar) {
        if (sVar instanceof com.baidu.tieba.im.message.bp) {
            com.baidu.tieba.im.message.bp bpVar = (com.baidu.tieba.im.message.bp) sVar;
            com.baidu.adp.lib.util.e.e("SHANG ChatResponsedMessage onAcked");
            if (bpVar.l()) {
                qVar.a((com.baidu.tieba.im.message.da) bpVar);
            } else {
                com.baidu.tieba.im.i.a(new w(qVar, bpVar), new x(qVar, bpVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(q qVar, com.baidu.tieba.im.message.s sVar) {
        if (sVar instanceof com.baidu.tieba.im.message.bs) {
            com.baidu.tieba.im.message.bs bsVar = (com.baidu.tieba.im.message.bs) sVar;
            com.baidu.adp.lib.util.e.e("SHANG ChatResponsedMessage onAcked");
            if (bsVar.l()) {
                qVar.a((com.baidu.tieba.im.message.da) bsVar);
            } else {
                int a2 = com.baidu.adp.lib.f.b.a(bsVar.c(), 0);
                a(a2);
                com.baidu.adp.lib.util.e.e("GET Personal Gid MSGACK=" + a2);
            }
            com.baidu.tieba.im.i.a(new y(qVar, com.baidu.adp.lib.f.b.a(TiebaApplication.v(), 0L), com.baidu.adp.lib.f.b.a(bsVar.d(), 0L), bsVar), new z(qVar, bsVar));
        }
    }

    private void a(com.baidu.tieba.im.message.da daVar) {
        if (daVar != null && daVar.o() != null) {
            com.baidu.tieba.im.message.b bVar = (com.baidu.tieba.im.message.b) daVar.o();
            if (bVar == null) {
                com.baidu.adp.lib.util.e.b("chatMessage == null");
            } else if (bVar instanceof com.baidu.tieba.im.message.g) {
                com.baidu.tieba.im.i.a(new s(this, (com.baidu.tieba.im.message.g) bVar, bVar), new t(this, daVar));
            } else if (bVar instanceof com.baidu.tieba.im.message.w) {
                com.baidu.tieba.im.i.a(new u(this, (com.baidu.tieba.im.message.w) bVar, bVar), new v(this, daVar));
            }
        }
    }

    public final void a(com.baidu.tieba.im.message.s sVar) {
        Iterator<WeakReference<bc>> it = this.c.iterator();
        while (it.hasNext()) {
            bc bcVar = it.next().get();
            if (bcVar != null) {
                bcVar.a(sVar);
            }
        }
    }
}
