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
    private static h Pz = new h();
    private boolean Pu;
    private int Pv;
    private long Pw;
    private final SparseArray<i> Px;
    private final HashSet<Integer> Py;

    public static h qz() {
        return Pz;
    }

    private h() {
        super(1001);
        this.Pv = 3;
        this.Pw = 300000L;
        this.Px = new SparseArray<>();
        this.Py = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean cw(int i) {
        if (this.Pu || this.Py.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().ax() > PingManager.qC().qE() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.Px.get(i);
            if (iVar != null && iVar.PC) {
                if (Math.abs(System.currentTimeMillis() - iVar.PD) <= this.Pw) {
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
            if (i2 < this.Px.size()) {
                this.Px.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cx(int i) {
        i iVar = this.Px.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.Px.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.Pv);
        }
    }

    public void cy(int i) {
        this.Px.remove(i);
    }

    public void am(boolean z) {
        this.Pu = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.Py.clear();
            for (int i : iArr) {
                this.Py.add(Integer.valueOf(i));
            }
        }
    }

    public void cz(int i) {
        this.Pv = i;
    }

    public void o(long j) {
        this.Pw = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
