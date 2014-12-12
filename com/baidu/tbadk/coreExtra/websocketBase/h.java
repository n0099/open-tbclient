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
    private static h Vp = new h();
    private boolean Vk;
    private int Vl;
    private long Vm;
    private final SparseArray<i> Vn;
    private final HashSet<Integer> Vo;

    public static h tU() {
        return Vp;
    }

    private h() {
        super(1001);
        this.Vl = 3;
        this.Vm = 300000L;
        this.Vn = new SparseArray<>();
        this.Vo = new HashSet<>();
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean cV(int i) {
        if (this.Vk || this.Vo.contains(Integer.valueOf(i)) || !MessageManager.getInstance().getSocketClient().isValid()) {
            return false;
        }
        if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().aX() > PingManager.tX().tZ() + 20000) {
            com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            if (!TiebaIMConfig.defaultUrl.equals(com.baidu.adp.framework.client.socket.l.getUrl())) {
                com.baidu.adp.framework.client.socket.m.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "retryiplist");
                return false;
            }
            i iVar = this.Vn.get(i);
            if (iVar != null && iVar.Vr) {
                if (Math.abs(System.currentTimeMillis() - iVar.Vs) <= this.Vm) {
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
            if (i2 < this.Vn.size()) {
                this.Vn.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void cW(int i) {
        i iVar = this.Vn.get(i);
        if (iVar == null) {
            iVar = new i(null);
            this.Vn.append(i, iVar);
        }
        if (iVar != null) {
            iVar.onError(this.Vl);
        }
    }

    public void cX(int i) {
        this.Vn.remove(i);
    }

    public void aA(boolean z) {
        this.Vk = z;
    }

    public void b(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.Vo.clear();
            for (int i : iArr) {
                this.Vo.add(Integer.valueOf(i));
            }
        }
    }

    public void cY(int i) {
        this.Vl = i;
    }

    public void t(long j) {
        this.Vm = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseOnlineMessage) && ((ResponseOnlineMessage) socketResponsedMessage).getError() == 0) {
            reset();
        }
    }
}
