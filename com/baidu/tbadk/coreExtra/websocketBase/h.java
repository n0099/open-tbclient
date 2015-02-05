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
    private static h VR = new h();
    private boolean VM;
    private int VN;
    private long VO;
    private final SparseArray<i> VP;
    private final HashSet<Integer> VQ;

    public static h uf() {
        return VR;
    }

    private h() {
        super(1001);
        this.VN = 3;
        this.VO = 300000L;
        this.VP = new SparseArray<>();
        this.VQ = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean dc(int i) {
        if (this.VM || this.VQ.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aX() > PingManager.ui().uk() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.VP.get(i);
            if (iVar != null && iVar.VT) {
                if (Math.abs(System.currentTimeMillis() - iVar.VU) <= this.VO) {
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
            if (i2 < this.VP.size()) {
                this.VP.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dd(int i) {
        i iVar = this.VP.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.VP.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.VN);
        }
    }

    public void de(int i) {
        this.VP.remove(i);
    }

    public void aC(boolean z) {
        this.VM = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.VQ.clear();
            for (int i : iArr) {
                this.VQ.add(Integer.valueOf(i));
            }
        }
    }

    public void df(int i) {
        this.VN = i;
    }

    public void t(long j) {
        this.VO = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
