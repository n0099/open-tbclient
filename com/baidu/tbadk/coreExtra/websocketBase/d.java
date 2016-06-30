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
    private static d anA = new d();
    private int anB;
    private boolean anv;
    private int anw;
    private long anx;
    private final SparseArray<a> any;
    private final HashSet<Integer> anz;

    public static d Ai() {
        return anA;
    }

    private d() {
        super(1001);
        this.anw = 3;
        this.anx = 300000L;
        this.any = new SparseArray<>();
        this.anz = new HashSet<>();
        this.anB = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dV(int i) {
        this.anB = 0;
        if (this.anv) {
            this.anB = 3;
            return false;
        } else if (this.anz.contains(Integer.valueOf(i))) {
            this.anB = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.anB = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aR() > PingManager.Am().Ao() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.anB = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.any.get(i);
            if (aVar != null && aVar.anD) {
                if (Math.abs(System.currentTimeMillis() - aVar.anE) > this.anx) {
                    aVar.reset();
                } else {
                    this.anB = 4;
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
            if (i2 < this.any.size()) {
                this.any.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dW(int i) {
        a aVar = this.any.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.any.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.anw);
        }
        this.anB = 5;
    }

    public void dX(int i) {
        this.any.remove(i);
    }

    public void bl(boolean z) {
        this.anv = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.anz.clear();
            for (int i : iArr) {
                this.anz.add(Integer.valueOf(i));
            }
        }
    }

    public void dY(int i) {
        this.anw = i;
    }

    public void Q(long j) {
        this.anx = j;
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
        public int anC;
        public boolean anD;
        public long anE;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.anC = 0;
            if (this.anD) {
                this.anD = false;
                this.anE = 0L;
            }
        }

        public void onError(int i) {
            this.anC++;
            if (!this.anD && this.anC >= i) {
                this.anD = true;
                this.anE = System.currentTimeMillis();
            }
        }
    }

    public int Aj() {
        return this.anB;
    }
}
