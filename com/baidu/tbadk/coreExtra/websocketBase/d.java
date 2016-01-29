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
    private static d aqP = new d();
    private boolean aqK;
    private int aqL;
    private long aqM;
    private final SparseArray<a> aqN;
    private final HashSet<Integer> aqO;
    private int aqQ;

    public static d BF() {
        return aqP;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.aqL = 3;
        this.aqM = 300000L;
        this.aqN = new SparseArray<>();
        this.aqO = new HashSet<>();
        this.aqQ = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean el(int i) {
        this.aqQ = 0;
        if (this.aqK) {
            this.aqQ = 3;
            return false;
        } else if (this.aqO.contains(Integer.valueOf(i))) {
            this.aqQ = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aqQ = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().eB() > PingManager.BJ().BL() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aqQ = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aqN.get(i);
            if (aVar != null && aVar.aqS) {
                if (Math.abs(System.currentTimeMillis() - aVar.aqT) > this.aqM) {
                    aVar.reset();
                } else {
                    this.aqQ = 4;
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
            if (i2 < this.aqN.size()) {
                this.aqN.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void em(int i) {
        a aVar = this.aqN.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.aqN.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aqL);
        }
        this.aqQ = 5;
    }

    public void en(int i) {
        this.aqN.remove(i);
    }

    public void bb(boolean z) {
        this.aqK = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aqO.clear();
            for (int i : iArr) {
                this.aqO.add(Integer.valueOf(i));
            }
        }
    }

    public void eo(int i) {
        this.aqL = i;
    }

    public void K(long j) {
        this.aqM = j;
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
        public int aqR;
        public boolean aqS;
        public long aqT;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.aqR = 0;
            if (this.aqS) {
                this.aqS = false;
                this.aqT = 0L;
            }
        }

        public void onError(int i) {
            this.aqR++;
            if (!this.aqS && this.aqR >= i) {
                this.aqS = true;
                this.aqT = System.currentTimeMillis();
            }
        }
    }

    public int BG() {
        return this.aqQ;
    }
}
