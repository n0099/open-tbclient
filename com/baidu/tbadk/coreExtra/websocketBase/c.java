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
    private static c ayB = new c();
    private final HashSet<Integer> ayA;
    private int ayC;
    private boolean ayw;
    private int ayx;
    private long ayy;
    private final SparseArray<a> ayz;

    public static c BF() {
        return ayB;
    }

    private c() {
        super(1001);
        this.ayx = 3;
        this.ayy = ReportUserInfoModel.TIME_INTERVAL;
        this.ayz = new SparseArray<>();
        this.ayA = new HashSet<>();
        this.ayC = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean eA(int i) {
        this.ayC = 0;
        if (this.ayw) {
            this.ayC = 3;
            return false;
        } else if (this.ayA.contains(Integer.valueOf(i))) {
            this.ayC = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayC = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BJ().BL() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayC = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.ayz.get(i);
            if (aVar != null && aVar.ayE) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayF) > this.ayy) {
                    aVar.reset();
                } else {
                    this.ayC = 4;
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
            if (i2 < this.ayz.size()) {
                this.ayz.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eB(int i) {
        a aVar = this.ayz.get(i);
        if (aVar == null) {
            aVar = new a();
            this.ayz.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ayx);
        }
        this.ayC = 5;
    }

    public void eC(int i) {
        this.ayz.remove(i);
    }

    public void bm(boolean z) {
        this.ayw = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayA.clear();
            for (int i : iArr) {
                this.ayA.add(Integer.valueOf(i));
            }
        }
    }

    public void eD(int i) {
        this.ayx = i;
    }

    public void P(long j) {
        this.ayy = j;
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
        public int ayD;
        public boolean ayE;
        public long ayF;

        private a() {
        }

        public void reset() {
            this.ayD = 0;
            if (this.ayE) {
                this.ayE = false;
                this.ayF = 0L;
            }
        }

        public void onError(int i) {
            this.ayD++;
            if (!this.ayE && this.ayD >= i) {
                this.ayE = true;
                this.ayF = System.currentTimeMillis();
            }
        }
    }

    public int BG() {
        return this.ayC;
    }
}
