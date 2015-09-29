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
    private static d amA = new d();
    private boolean amv;
    private int amw;
    private long amx;
    private final SparseArray<a> amy;
    private final HashSet<Integer> amz;

    public static d zB() {
        return amA;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.amw = 3;
        this.amx = 300000L;
        this.amy = new SparseArray<>();
        this.amz = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dH(int i) {
        if (this.amv || this.amz.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
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
            a aVar = this.amy.get(i);
            if (aVar != null && aVar.amC) {
                if (Math.abs(System.currentTimeMillis() - aVar.amD) <= this.amx) {
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
            if (i2 < this.amy.size()) {
                this.amy.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dI(int i) {
        a aVar = this.amy.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.amy.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.amw);
        }
    }

    public void dJ(int i) {
        this.amy.remove(i);
    }

    public void aV(boolean z) {
        this.amv = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.amz.clear();
            for (int i : iArr) {
                this.amz.add(Integer.valueOf(i));
            }
        }
    }

    public void dK(int i) {
        this.amw = i;
    }

    public void B(long j) {
        this.amx = j;
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
        public int amB;
        public boolean amC;
        public long amD;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.amB = 0;
            if (this.amC) {
                this.amC = false;
                this.amD = 0L;
            }
        }

        public void onError(int i) {
            this.amB++;
            if (!this.amC && this.amB >= i) {
                this.amC = true;
                this.amD = System.currentTimeMillis();
            }
        }
    }
}
