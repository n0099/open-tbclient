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
    private static h agf = new h();
    private boolean aga;
    private int agb;
    private long agc;
    private final SparseArray<i> agd;
    private final HashSet<Integer> age;

    public static h xC() {
        return agf;
    }

    private h() {
        super(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
        this.agb = 3;
        this.agc = 300000L;
        this.agd = new SparseArray<>();
        this.age = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean de(int i) {
        if (this.aga || this.age.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().eu() > PingManager.xF().xH() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.agd.get(i);
            if (iVar != null && iVar.agh) {
                if (Math.abs(System.currentTimeMillis() - iVar.agi) <= this.agc) {
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
            if (i2 < this.agd.size()) {
                this.agd.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void df(int i) {
        i iVar = this.agd.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.agd.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.agb);
        }
    }

    public void dg(int i) {
        this.agd.remove(i);
    }

    public void aI(boolean z) {
        this.aga = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.age.clear();
            for (int i : iArr) {
                this.age.add(Integer.valueOf(i));
            }
        }
    }

    public void dh(int i) {
        this.agb = i;
    }

    public void t(long j) {
        this.agc = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
