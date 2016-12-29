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
    private static d arE = new d();
    private int arA;
    private long arB;
    private final SparseArray<a> arC;
    private final HashSet<Integer> arD;
    private int arF;
    private boolean arz;

    public static d Bv() {
        return arE;
    }

    private d() {
        super(1001);
        this.arA = 3;
        this.arB = 300000L;
        this.arC = new SparseArray<>();
        this.arD = new HashSet<>();
        this.arF = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean em(int i) {
        this.arF = 0;
        if (this.arz) {
            this.arF = 3;
            return false;
        } else if (this.arD.contains(Integer.valueOf(i))) {
            this.arF = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.arF = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().bL() > PingManager.Bz().BB() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.arF = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.arC.get(i);
            if (aVar != null && aVar.arH) {
                if (Math.abs(System.currentTimeMillis() - aVar.arI) > this.arB) {
                    aVar.reset();
                } else {
                    this.arF = 4;
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
            if (i2 < this.arC.size()) {
                this.arC.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void en(int i) {
        a aVar = this.arC.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.arC.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.arA);
        }
        this.arF = 5;
    }

    public void eo(int i) {
        this.arC.remove(i);
    }

    public void bt(boolean z) {
        this.arz = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.arD.clear();
            for (int i : iArr) {
                this.arD.add(Integer.valueOf(i));
            }
        }
    }

    public void ep(int i) {
        this.arA = i;
    }

    public void N(long j) {
        this.arB = j;
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
        public int arG;
        public boolean arH;
        public long arI;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.arG = 0;
            if (this.arH) {
                this.arH = false;
                this.arI = 0L;
            }
        }

        public void onError(int i) {
            this.arG++;
            if (!this.arH && this.arG >= i) {
                this.arH = true;
                this.arI = System.currentTimeMillis();
            }
        }
    }

    public int Bw() {
        return this.arF;
    }
}
