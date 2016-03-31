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
    private static d arg = new d();
    private boolean arb;
    private int arc;
    private long ard;
    private final SparseArray<a> are;
    private final HashSet<Integer> arf;
    private int arh;

    public static d Ci() {
        return arg;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.arc = 3;
        this.ard = 300000L;
        this.are = new SparseArray<>();
        this.arf = new HashSet<>();
        this.arh = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eo(int i) {
        this.arh = 0;
        if (this.arb) {
            this.arh = 3;
            return false;
        } else if (this.arf.contains(Integer.valueOf(i))) {
            this.arh = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.arh = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().eB() > PingManager.Cm().Co() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.arh = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.are.get(i);
            if (aVar != null && aVar.arj) {
                if (Math.abs(System.currentTimeMillis() - aVar.ark) > this.ard) {
                    aVar.reset();
                } else {
                    this.arh = 4;
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
            if (i2 < this.are.size()) {
                this.are.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ep(int i) {
        a aVar = this.are.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.are.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.arc);
        }
        this.arh = 5;
    }

    public void eq(int i) {
        this.are.remove(i);
    }

    public void bh(boolean z) {
        this.arb = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.arf.clear();
            for (int i : iArr) {
                this.arf.add(Integer.valueOf(i));
            }
        }
    }

    public void er(int i) {
        this.arc = i;
    }

    public void M(long j) {
        this.ard = j;
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
        public int ari;
        public boolean arj;
        public long ark;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.ari = 0;
            if (this.arj) {
                this.arj = false;
                this.ark = 0L;
            }
        }

        public void onError(int i) {
            this.ari++;
            if (!this.arj && this.ari >= i) {
                this.arj = true;
                this.ark = System.currentTimeMillis();
            }
        }
    }

    public int Cj() {
        return this.arh;
    }
}
