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
    private static h afX = new h();
    private boolean afS;
    private int afT;
    private long afU;
    private final SparseArray<i> afV;
    private final HashSet<Integer> afW;

    public static h xw() {
        return afX;
    }

    private h() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.afT = 3;
        this.afU = 300000L;
        this.afV = new SparseArray<>();
        this.afW = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean de(int i) {
        if (this.afS || this.afW.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().eu() > PingManager.xz().xB() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.afV.get(i);
            if (iVar != null && iVar.afZ) {
                if (Math.abs(System.currentTimeMillis() - iVar.aga) <= this.afU) {
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
            if (i2 < this.afV.size()) {
                this.afV.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void df(int i) {
        i iVar = this.afV.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.afV.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.afT);
        }
    }

    public void dg(int i) {
        this.afV.remove(i);
    }

    public void aI(boolean z) {
        this.afS = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.afW.clear();
            for (int i : iArr) {
                this.afW.add(Integer.valueOf(i));
            }
        }
    }

    public void dh(int i) {
        this.afT = i;
    }

    public void t(long j) {
        this.afU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
