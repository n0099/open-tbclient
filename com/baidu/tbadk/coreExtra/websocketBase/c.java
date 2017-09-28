package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c ayc = new c();
    private boolean axX;
    private int axY;
    private long axZ;
    private final SparseArray<a> aya;
    private final HashSet<Integer> ayb;
    private int ayd;

    public static c Bx() {
        return ayc;
    }

    private c() {
        super(1001);
        this.axY = 3;
        this.axZ = ReportUserInfoModel.TIME_INTERVAL;
        this.aya = new SparseArray<>();
        this.ayb = new HashSet<>();
        this.ayd = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.ayd = 0;
        if (this.axX) {
            this.ayd = 3;
            return false;
        } else if (this.ayb.contains(Integer.valueOf(i))) {
            this.ayd = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayd = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BB().BD() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayd = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aya.get(i);
            if (aVar != null && aVar.ayf) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayg) > this.axZ) {
                    aVar.reset();
                } else {
                    this.ayd = 4;
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
            if (i2 < this.aya.size()) {
                this.aya.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.aya.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aya.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.axY);
        }
        this.ayd = 5;
    }

    public void eC(int i) {
        this.aya.remove(i);
    }

    public void bs(boolean z) {
        this.axX = z;
    }

    public void e(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayb.clear();
            for (int i : iArr) {
                this.ayb.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.axY = i;
    }

    public void O(long j) {
        this.axZ = j;
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
        public int aye;
        public boolean ayf;
        public long ayg;

        private a() {
        }

        public void reset() {
            this.aye = 0;
            if (this.ayf) {
                this.ayf = false;
                this.ayg = 0L;
            }
        }

        public void onError(int i) {
            this.aye++;
            if (!this.ayf && this.aye >= i) {
                this.ayf = true;
                this.ayg = System.currentTimeMillis();
            }
        }
    }

    public int By() {
        return this.ayd;
    }
}
