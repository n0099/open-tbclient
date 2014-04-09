package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class x {
    private final LinkedList<WeakReference<bu>> c = new LinkedList<>();
    private com.baidu.adp.framework.c.g d = new y(this, 0);
    private com.baidu.adp.framework.c.a e = new aj(this, 0);
    private static x b = null;
    public static volatile int a = 0;

    private x() {
    }

    public final void a() {
        com.baidu.adp.framework.c.a().a(202001, this.d);
        com.baidu.adp.framework.c.a().a(205001, this.d);
        com.baidu.adp.framework.c.a().a(2001103, this.e);
        com.baidu.adp.framework.c.a().a(2001105, this.e);
    }

    public static x b() {
        if (b == null) {
            b = new x();
        }
        return b;
    }

    public static void a(int i) {
        if (i != 0 && a != i) {
            if (a != 0) {
                com.baidu.adp.lib.util.f.b("私聊GID有变化!!!!!!!!!!!");
            }
            a = i;
            com.baidu.tieba.im.r.a(new as(i), null);
        }
    }

    public final void a(bu buVar) {
        Iterator<WeakReference<bu>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().get() == buVar) {
                z = true;
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(buVar));
        }
    }

    public final void b(bu buVar) {
        WeakReference<bu> weakReference;
        Iterator<WeakReference<bu>> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = it.next();
            if (weakReference.get() == buVar) {
                break;
            }
        }
        if (weakReference != null) {
            this.c.remove(weakReference);
        }
    }

    public final void a(String str, bv bvVar) {
        com.baidu.tieba.im.r.a(new at(this, str), new au(this, bvVar));
    }

    public final void b(String str, bv bvVar) {
        com.baidu.tieba.im.r.a(new av(this, str), new aw(this, bvVar));
    }

    public final void c(String str, bv bvVar) {
        com.baidu.tieba.im.r.a(new ax(this, str), new ay(this, bvVar));
    }

    public final void a(com.baidu.tieba.im.message.a.a aVar) {
        com.baidu.adp.lib.util.f.e("SHNAG chatManager sendMessage, content = " + aVar.v());
        if (aVar instanceof com.baidu.tieba.im.message.a.b) {
            com.baidu.tieba.im.message.a.b bVar = (com.baidu.tieba.im.message.a.b) aVar;
            LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(bVar);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            com.baidu.tieba.im.r.a(new z(this, bVar, linkedList), new aa(this, bVar));
        } else if (aVar instanceof com.baidu.tieba.im.message.a.f) {
            com.baidu.tieba.im.message.a.f fVar = (com.baidu.tieba.im.message.a.f) aVar;
            LinkedList linkedList2 = new LinkedList();
            CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(aVar);
            commonMsgPojo2.setRead_flag(0);
            linkedList2.add(commonMsgPojo2);
            com.baidu.tieba.im.r.a(new ab(this, fVar, linkedList2), new ac(this, fVar));
        } else if (aVar instanceof com.baidu.tieba.im.message.a.e) {
            com.baidu.tieba.im.message.a.e eVar = (com.baidu.tieba.im.message.a.e) aVar;
            LinkedList linkedList3 = new LinkedList();
            CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(aVar);
            commonMsgPojo3.setRead_flag(0);
            linkedList3.add(commonMsgPojo3);
            com.baidu.tieba.im.r.a(new ad(this, eVar, linkedList3), new ae(this, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(x xVar, SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof com.baidu.adp.framework.message.f) {
            com.baidu.adp.framework.message.d<?> h = socketResponsedMessage.h();
            if (h instanceof com.baidu.tieba.im.message.a.a) {
                TiebaStatic.a(socketResponsedMessage, String.valueOf(((com.baidu.tieba.im.message.a.a) h).t()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(x xVar, SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseCommitGroupMessage) {
            ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
            com.baidu.adp.lib.util.f.e("SHANG ChatResponsedMessage onAcked");
            if (responseCommitGroupMessage.e() != 0) {
                xVar.b(responseCommitGroupMessage);
            } else {
                com.baidu.tieba.im.r.a(new am(xVar, responseCommitGroupMessage), new an(xVar, responseCommitGroupMessage));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(x xVar, SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseCommitPersonalMessage) {
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
            com.baidu.adp.lib.util.f.e("SHANG ChatResponsedMessage onAcked");
            if (responseCommitPersonalMessage.e() != 0) {
                xVar.b(responseCommitPersonalMessage);
                return;
            }
            int a2 = com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.j(), 0);
            a(a2);
            com.baidu.adp.lib.util.f.e("GET Personal Gid MSGACK=" + a2);
            if (responseCommitPersonalMessage.l() == 0) {
                com.baidu.tieba.im.r.a(new ao(xVar, com.baidu.adp.lib.f.b.a(TbadkApplication.E(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.k(), 0L), responseCommitPersonalMessage), new ap(xVar, responseCommitPersonalMessage));
            } else {
                com.baidu.tieba.im.r.a(new aq(xVar, com.baidu.adp.lib.f.b.a(TbadkApplication.E(), 0L), com.baidu.adp.lib.f.b.a(responseCommitPersonalMessage.k(), 0L), responseCommitPersonalMessage), new ar(xVar, responseCommitPersonalMessage));
            }
        }
    }

    private void b(com.baidu.adp.framework.message.f<?> fVar) {
        if (fVar != null && fVar.h() != null) {
            com.baidu.tieba.im.message.a.a aVar = (com.baidu.tieba.im.message.a.a) fVar.h();
            if (aVar == null) {
                com.baidu.adp.lib.util.f.b("chatMessage == null");
            } else if (aVar instanceof com.baidu.tieba.im.message.a.b) {
                com.baidu.tieba.im.r.a(new af(this, (com.baidu.tieba.im.message.a.b) aVar, aVar), new ag(this, fVar));
            } else if (aVar instanceof com.baidu.tieba.im.message.a.f) {
                com.baidu.tieba.im.r.a(new ah(this, (com.baidu.tieba.im.message.a.f) aVar, aVar), new ai(this, fVar));
            } else if (aVar instanceof com.baidu.tieba.im.message.a.e) {
                com.baidu.tieba.im.r.a(new ak(this, (com.baidu.tieba.im.message.a.e) aVar, aVar), new al(this, fVar));
            }
        }
    }

    public final void a(com.baidu.adp.framework.message.f<?> fVar) {
        Iterator<WeakReference<bu>> it = this.c.iterator();
        while (it.hasNext()) {
            bu buVar = it.next().get();
            if (buVar != null) {
                buVar.a(fVar);
            }
        }
    }
}
