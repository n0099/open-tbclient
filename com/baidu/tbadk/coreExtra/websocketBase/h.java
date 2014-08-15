package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.d {
    private static h e = new h();
    private boolean a;
    private int b;
    private long c;
    private final SparseArray<i> d;

    public static h a() {
        return e;
    }

    private h() {
        super(1001);
        this.b = 3;
        this.c = 300000L;
        this.d = new SparseArray<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean a(int i) {
        if (!this.a && MessageManager.getInstance().getSocketClient().c()) {
            if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().d() > PingManager.d().g() + 20000) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
                return false;
            } else if (TextUtils.isEmpty("ws://im.tieba.baidu.com:8000")) {
                return false;
            } else {
                if (!"ws://im.tieba.baidu.com:8000".equals(com.baidu.adp.framework.client.socket.l.b())) {
                    com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                    return false;
                }
                i iVar = this.d.get(i);
                if (iVar != null) {
                    if (iVar.b) {
                        if (Math.abs(System.currentTimeMillis() - iVar.c) <= this.c) {
                            return false;
                        }
                        iVar.a();
                    }
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.d.size()) {
                this.d.valueAt(i2).a();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(int i) {
        i iVar = this.d.get(i);
        if (iVar != null) {
            iVar.a(this.b);
        }
    }

    public void c(int i) {
        i iVar = this.d.get(i);
        if (iVar != null) {
            iVar.a();
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a(int[] iArr) {
        this.d.clear();
        if (iArr != null) {
            for (int i : iArr) {
                this.d.put(i, new i(null));
            }
        }
    }

    public void d(int i) {
        this.b = i;
    }

    public void a(long j) {
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            b();
        }
    }
}
