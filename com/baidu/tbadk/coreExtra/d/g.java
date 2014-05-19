package com.baidu.tbadk.coreExtra.d;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.framework.listener.b {
    private static g e = new g();
    private boolean a;
    private int b;
    private long c;
    private final SparseArray<h> d;

    public static g a() {
        return e;
    }

    private g() {
        super(MessageTypes.CMD_UPDATE_CLIENT_INFO);
        this.b = 3;
        this.c = 300000L;
        this.d = new SparseArray<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean a(int i) {
        h hVar;
        if (!this.a && MessageManager.getInstance().getSocketManager().b() && (hVar = this.d.get(i)) != null) {
            if (hVar.b) {
                if (Math.abs(System.currentTimeMillis() - hVar.c) <= this.c) {
                    return false;
                }
                hVar.a();
            }
            return true;
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
        h hVar = this.d.get(i);
        if (hVar != null) {
            hVar.a(this.b);
        }
    }

    public void c(int i) {
        h hVar = this.d.get(i);
        if (hVar != null) {
            hVar.a();
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a(int[] iArr) {
        this.d.clear();
        if (iArr != null) {
            for (int i : iArr) {
                this.d.put(i, new h(null));
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
