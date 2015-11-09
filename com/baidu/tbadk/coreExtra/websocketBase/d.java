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
    private static d amG = new d();
    private boolean amB;
    private int amC;
    private long amD;
    private final SparseArray<a> amE;
    private final HashSet<Integer> amF;

    public static d zD() {
        return amG;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.amC = 3;
        this.amD = 300000L;
        this.amE = new SparseArray<>();
        this.amF = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dH(int i) {
        if (this.amB || this.amF.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.zG().zI() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.j.getUrl())) {
                com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            a aVar = this.amE.get(i);
            if (aVar != null && aVar.amI) {
                if (Math.abs(System.currentTimeMillis() - aVar.amJ) <= this.amD) {
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
            if (i2 < this.amE.size()) {
                this.amE.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dI(int i) {
        a aVar = this.amE.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.amE.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.amC);
        }
    }

    public void dJ(int i) {
        this.amE.remove(i);
    }

    public void aV(boolean z) {
        this.amB = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.amF.clear();
            for (int i : iArr) {
                this.amF.add(Integer.valueOf(i));
            }
        }
    }

    public void dK(int i) {
        this.amC = i;
    }

    public void z(long j) {
        this.amD = j;
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
        public int amH;
        public boolean amI;
        public long amJ;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.amH = 0;
            if (this.amI) {
                this.amI = false;
                this.amJ = 0L;
            }
        }

        public void onError(int i) {
            this.amH++;
            if (!this.amI && this.amH >= i) {
                this.amI = true;
                this.amJ = System.currentTimeMillis();
            }
        }
    }
}
