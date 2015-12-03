package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d aot = new d();
    private boolean aoo;
    private int aop;
    private long aoq;
    private final SparseArray<a> aor;
    private final HashSet<Integer> aos;
    private int aou;

    public static d Az() {
        return aot;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.aop = 3;
        this.aoq = 300000L;
        this.aor = new SparseArray<>();
        this.aos = new HashSet<>();
        this.aou = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dW(int i) {
        this.aou = 0;
        if (this.aoo) {
            this.aou = 3;
            return false;
        } else if (this.aos.contains(Integer.valueOf(i))) {
            this.aou = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aou = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.AD().AF() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aou = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aor.get(i);
            if (aVar != null && aVar.aow) {
                if (Math.abs(System.currentTimeMillis() - aVar.aox) > this.aoq) {
                    aVar.reset();
                } else {
                    this.aou = 4;
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
            if (i2 < this.aor.size()) {
                this.aor.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dX(int i) {
        a aVar = this.aor.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.aor.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aop);
        }
        this.aou = 5;
    }

    public void dY(int i) {
        this.aor.remove(i);
    }

    public void ba(boolean z) {
        this.aoo = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aos.clear();
            for (int i : iArr) {
                this.aos.add(Integer.valueOf(i));
            }
        }
    }

    public void dZ(int i) {
        this.aop = i;
    }

    public void G(long j) {
        this.aoq = j;
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
        public int aov;
        public boolean aow;
        public long aox;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.aov = 0;
            if (this.aow) {
                this.aow = false;
                this.aox = 0L;
            }
        }

        public void onError(int i) {
            this.aov++;
            if (!this.aow && this.aov >= i) {
                this.aow = true;
                this.aox = System.currentTimeMillis();
            }
        }
    }

    public int AA() {
        return this.aou;
    }
}
