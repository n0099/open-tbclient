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
    private static d apX = new d();
    private boolean apS;
    private int apT;
    private long apU;
    private final SparseArray<a> apV;
    private final HashSet<Integer> apW;
    private int apY;

    public static d Ap() {
        return apX;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.apT = 3;
        this.apU = 300000L;
        this.apV = new SparseArray<>();
        this.apW = new HashSet<>();
        this.apY = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dQ(int i) {
        this.apY = 0;
        if (this.apS) {
            this.apY = 3;
            return false;
        } else if (this.apW.contains(Integer.valueOf(i))) {
            this.apY = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.apY = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.At().Av() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.apY = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.apV.get(i);
            if (aVar != null && aVar.aqa) {
                if (Math.abs(System.currentTimeMillis() - aVar.aqb) > this.apU) {
                    aVar.reset();
                } else {
                    this.apY = 4;
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
            if (i2 < this.apV.size()) {
                this.apV.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dR(int i) {
        a aVar = this.apV.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.apV.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.apT);
        }
        this.apY = 5;
    }

    public void dS(int i) {
        this.apV.remove(i);
    }

    public void aZ(boolean z) {
        this.apS = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.apW.clear();
            for (int i : iArr) {
                this.apW.add(Integer.valueOf(i));
            }
        }
    }

    public void dT(int i) {
        this.apT = i;
    }

    public void H(long j) {
        this.apU = j;
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
        public int apZ;
        public boolean aqa;
        public long aqb;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.apZ = 0;
            if (this.aqa) {
                this.aqa = false;
                this.aqb = 0L;
            }
        }

        public void onError(int i) {
            this.apZ++;
            if (!this.aqa && this.apZ >= i) {
                this.aqa = true;
                this.aqb = System.currentTimeMillis();
            }
        }
    }

    public int Aq() {
        return this.apY;
    }
}
