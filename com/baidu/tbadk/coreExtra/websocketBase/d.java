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
    private static d amB = new d();
    private final HashSet<Integer> amA;
    private boolean amw;
    private int amx;
    private long amy;
    private final SparseArray<a> amz;

    public static d zB() {
        return amB;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.amx = 3;
        this.amy = 300000L;
        this.amz = new SparseArray<>();
        this.amA = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dH(int i) {
        if (this.amw || this.amA.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.zE().zG() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.j.getUrl())) {
                com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            a aVar = this.amz.get(i);
            if (aVar != null && aVar.amD) {
                if (Math.abs(System.currentTimeMillis() - aVar.amE) <= this.amy) {
                    return false;
                }
                aVar.reset();
            }
            return true;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.amz.size()) {
                this.amz.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dI(int i) {
        a aVar = this.amz.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.amz.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.amx);
        }
    }

    public void dJ(int i) {
        this.amz.remove(i);
    }

    public void aV(boolean z) {
        this.amw = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.amA.clear();
            for (int i : iArr) {
                this.amA.add(Integer.valueOf(i));
            }
        }
    }

    public void dK(int i) {
        this.amx = i;
    }

    public void B(long j) {
        this.amy = j;
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
        public int amC;
        public boolean amD;
        public long amE;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.amC = 0;
            if (this.amD) {
                this.amD = false;
                this.amE = 0L;
            }
        }

        public void onError(int i) {
            this.amC++;
            if (!this.amD && this.amC >= i) {
                this.amD = true;
                this.amE = System.currentTimeMillis();
            }
        }
    }
}
