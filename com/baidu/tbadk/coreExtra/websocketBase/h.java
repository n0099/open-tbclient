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
    private static h PE = new h();
    private long PA;
    private final SparseArray<i> PC;
    private final HashSet<Integer> PD;
    private boolean Py;
    private int Pz;

    public static h qB() {
        return PE;
    }

    private h() {
        super(1001);
        this.Pz = 3;
        this.PA = 300000L;
        this.PC = new SparseArray<>();
        this.PD = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean cw(int i) {
        if (this.Py || this.PD.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ax() > PingManager.qE().qG() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.PC.get(i);
            if (iVar != null && iVar.PG) {
                if (Math.abs(System.currentTimeMillis() - iVar.PH) <= this.PA) {
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
            if (i2 < this.PC.size()) {
                this.PC.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cx(int i) {
        i iVar = this.PC.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.PC.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.Pz);
        }
    }

    public void cy(int i) {
        this.PC.remove(i);
    }

    public void am(boolean z) {
        this.Py = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.PD.clear();
            for (int i : iArr) {
                this.PD.add(Integer.valueOf(i));
            }
        }
    }

    public void cz(int i) {
        this.Pz = i;
    }

    public void o(long j) {
        this.PA = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
