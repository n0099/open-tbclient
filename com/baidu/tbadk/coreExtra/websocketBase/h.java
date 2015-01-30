package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import java.util.HashSet;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.e {
    private static h VU = new h();
    private boolean VP;
    private int VQ;
    private long VR;
    private final SparseArray<i> VS;
    private final HashSet<Integer> VT;

    public static h ul() {
        return VU;
    }

    private h() {
        super(1001);
        this.VQ = 3;
        this.VR = 300000L;
        this.VS = new SparseArray<>();
        this.VT = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dc(int i) {
        if (this.VP || this.VT.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aX() > PingManager.uo().uq() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.VS.get(i);
            if (iVar != null && iVar.VW) {
                if (Math.abs(System.currentTimeMillis() - iVar.VX) <= this.VR) {
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
            if (i2 < this.VS.size()) {
                this.VS.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dd(int i) {
        i iVar = this.VS.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.VS.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.VQ);
        }
    }

    public void de(int i) {
        this.VS.remove(i);
    }

    public void aC(boolean z) {
        this.VP = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.VT.clear();
            for (int i : iArr) {
                this.VT.add(Integer.valueOf(i));
            }
        }
    }

    public void df(int i) {
        this.VQ = i;
    }

    public void t(long j) {
        this.VR = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
