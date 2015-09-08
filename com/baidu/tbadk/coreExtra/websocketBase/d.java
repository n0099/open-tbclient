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
    private static d anY = new d();
    private boolean anT;
    private int anU;
    private long anV;
    private final SparseArray<a> anW;
    private final HashSet<Integer> anX;

    public static d zM() {
        return anY;
    }

    private d() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.anU = 3;
        this.anV = 300000L;
        this.anW = new SparseArray<>();
        this.anX = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dG(int i) {
        if (this.anT || this.anX.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.zP().zR() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.j.getUrl())) {
                com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            a aVar = this.anW.get(i);
            if (aVar != null && aVar.aoa) {
                if (Math.abs(System.currentTimeMillis() - aVar.aob) <= this.anV) {
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
            if (i2 < this.anW.size()) {
                this.anW.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dH(int i) {
        a aVar = this.anW.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.anW.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.anU);
        }
    }

    public void dI(int i) {
        this.anW.remove(i);
    }

    public void ba(boolean z) {
        this.anT = z;
    }

    public void c(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.anX.clear();
            for (int i : iArr) {
                this.anX.add(Integer.valueOf(i));
            }
        }
    }

    public void dJ(int i) {
        this.anU = i;
    }

    public void u(long j) {
        this.anV = j;
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
        public int anZ;
        public boolean aoa;
        public long aob;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.anZ = 0;
            if (this.aoa) {
                this.aoa = false;
                this.aob = 0L;
            }
        }

        public void onError(int i) {
            this.anZ++;
            if (!this.aoa && this.anZ >= i) {
                this.aoa = true;
                this.aob = System.currentTimeMillis();
            }
        }
    }
}
