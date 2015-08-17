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
    private static d amm = new d();
    private boolean amh;
    private int ami;
    private long amj;
    private final SparseArray<a> amk;
    private final HashSet<Integer> aml;

    public static d zz() {
        return amm;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.ami = 3;
        this.amj = 300000L;
        this.amk = new SparseArray<>();
        this.aml = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dy(int i) {
        if (this.amh || this.aml.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ey() > PingManager.zC().zE() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.j.getUrl())) {
                com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            a aVar = this.amk.get(i);
            if (aVar != null && aVar.amo) {
                if (Math.abs(System.currentTimeMillis() - aVar.amp) <= this.amj) {
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
            if (i2 < this.amk.size()) {
                this.amk.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dz(int i) {
        a aVar = this.amk.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.amk.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ami);
        }
    }

    public void dA(int i) {
        this.amk.remove(i);
    }

    public void aT(boolean z) {
        this.amh = z;
    }

    public void c(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aml.clear();
            for (int i : iArr) {
                this.aml.add(Integer.valueOf(i));
            }
        }
    }

    public void dB(int i) {
        this.ami = i;
    }

    public void t(long j) {
        this.amj = j;
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
        public int amn;
        public boolean amo;
        public long amp;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.amn = 0;
            if (this.amo) {
                this.amo = false;
                this.amp = 0L;
            }
        }

        public void onError(int i) {
            this.amn++;
            if (!this.amo && this.amn >= i) {
                this.amo = true;
                this.amp = System.currentTimeMillis();
            }
        }
    }
}
