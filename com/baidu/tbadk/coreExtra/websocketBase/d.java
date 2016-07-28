package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d aop = new d();
    private boolean aok;
    private int aol;
    private long aom;
    private final SparseArray<a> aon;
    private final HashSet<Integer> aoo;
    private int aoq;

    public static d Ai() {
        return aop;
    }

    private d() {
        super(1001);
        this.aol = 3;
        this.aom = 300000L;
        this.aon = new SparseArray<>();
        this.aoo = new HashSet<>();
        this.aoq = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dV(int i) {
        this.aoq = 0;
        if (this.aok) {
            this.aoq = 3;
            return false;
        } else if (this.aoo.contains(Integer.valueOf(i))) {
            this.aoq = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aoq = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aQ() > PingManager.Am().Ao() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aoq = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aon.get(i);
            if (aVar != null && aVar.aos) {
                if (Math.abs(System.currentTimeMillis() - aVar.aot) > this.aom) {
                    aVar.reset();
                } else {
                    this.aoq = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aon.size()) {
                this.aon.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dW(int i) {
        a aVar = this.aon.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.aon.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aol);
        }
        this.aoq = 5;
    }

    public void dX(int i) {
        this.aon.remove(i);
    }

    public void bo(boolean z) {
        this.aok = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aoo.clear();
            for (int i : iArr) {
                this.aoo.add(Integer.valueOf(i));
            }
        }
    }

    public void dY(int i) {
        this.aol = i;
    }

    public void L(long j) {
        this.aom = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int aor;
        public boolean aos;
        public long aot;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.aor = 0;
            if (this.aos) {
                this.aos = false;
                this.aot = 0L;
            }
        }

        public void onError(int i) {
            this.aor++;
            if (!this.aos && this.aor >= i) {
                this.aos = true;
                this.aot = System.currentTimeMillis();
            }
        }
    }

    public int Aj() {
        return this.aoq;
    }
}
