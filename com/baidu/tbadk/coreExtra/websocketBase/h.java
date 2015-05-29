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
public class h extends com.baidu.adp.framework.listener.e {
    private static h ahg = new h();
    private boolean ahb;
    private int ahc;
    private long ahd;
    private final SparseArray<i> ahe;
    private final HashSet<Integer> ahf;

    public static h yp() {
        return ahg;
    }

    private h() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.ahc = 3;
        this.ahd = 300000L;
        this.ahe = new SparseArray<>();
        this.ahf = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dn(int i) {
        if (this.ahb || this.ahf.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ex() > PingManager.ys().yu() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.ahe.get(i);
            if (iVar != null && iVar.ahi) {
                if (Math.abs(System.currentTimeMillis() - iVar.ahj) <= this.ahd) {
                    return false;
                }
                iVar.reset();
            }
            return true;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ahe.size()) {
                this.ahe.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dp(int i) {
        i iVar = this.ahe.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.ahe.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.ahc);
        }
    }

    public void dq(int i) {
        this.ahe.remove(i);
    }

    public void aP(boolean z) {
        this.ahb = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ahf.clear();
            for (int i : iArr) {
                this.ahf.add(Integer.valueOf(i));
            }
        }
    }

    public void dr(int i) {
        this.ahc = i;
    }

    public void v(long j) {
        this.ahd = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
