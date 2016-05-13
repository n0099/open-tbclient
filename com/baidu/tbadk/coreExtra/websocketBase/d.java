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
    private static d amU = new d();
    private boolean amP;
    private int amQ;
    private long amR;
    private final SparseArray<a> amS;
    private final HashSet<Integer> amT;
    private int amV;

    public static d Ad() {
        return amU;
    }

    private d() {
        super(1001);
        this.amQ = 3;
        this.amR = 300000L;
        this.amS = new SparseArray<>();
        this.amT = new HashSet<>();
        this.amV = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dT(int i) {
        this.amV = 0;
        if (this.amP) {
            this.amV = 3;
            return false;
        } else if (this.amT.contains(Integer.valueOf(i))) {
            this.amV = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.amV = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aR() > PingManager.Ah().Aj() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.amV = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.amS.get(i);
            if (aVar != null && aVar.amX) {
                if (Math.abs(System.currentTimeMillis() - aVar.amY) > this.amR) {
                    aVar.reset();
                } else {
                    this.amV = 4;
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
            if (i2 < this.amS.size()) {
                this.amS.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dU(int i) {
        a aVar = this.amS.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.amS.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.amQ);
        }
        this.amV = 5;
    }

    public void dV(int i) {
        this.amS.remove(i);
    }

    public void bo(boolean z) {
        this.amP = z;
    }

    public void c(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.amT.clear();
            for (int i : iArr) {
                this.amT.add(Integer.valueOf(i));
            }
        }
    }

    public void dW(int i) {
        this.amQ = i;
    }

    public void N(long j) {
        this.amR = j;
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
        public int amW;
        public boolean amX;
        public long amY;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.amW = 0;
            if (this.amX) {
                this.amX = false;
                this.amY = 0L;
            }
        }

        public void onError(int i) {
            this.amW++;
            if (!this.amX && this.amW >= i) {
                this.amX = true;
                this.amY = System.currentTimeMillis();
            }
        }
    }

    public int Ae() {
        return this.amV;
    }
}
