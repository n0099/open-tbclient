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
    private static c ayH = new c();
    private boolean ayC;
    private int ayD;
    private long ayE;
    private final SparseArray<a> ayF;
    private final HashSet<Integer> ayG;
    private int ayI;

    public static c BU() {
        return ayH;
    }

    private c() {
        super(1001);
        this.ayD = 3;
        this.ayE = ReportUserInfoModel.TIME_INTERVAL;
        this.ayF = new SparseArray<>();
        this.ayG = new HashSet<>();
        this.ayI = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ep(int i) {
        this.ayI = 0;
        if (this.ayC) {
            this.ayI = 3;
            return false;
        } else if (this.ayG.contains(Integer.valueOf(i))) {
            this.ayI = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ayI = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BY().Ca() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ayI = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.ayF.get(i);
            if (aVar != null && aVar.ayK) {
                if (Math.abs(System.currentTimeMillis() - aVar.ayL) > this.ayE) {
                    aVar.reset();
                } else {
                    this.ayI = 4;
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
            if (i2 < this.ayF.size()) {
                this.ayF.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eq(int i) {
        a aVar = this.ayF.get(i);
        if (aVar == null) {
            aVar = new a();
            this.ayF.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ayD);
        }
        this.ayI = 5;
    }

    public void er(int i) {
        this.ayF.remove(i);
    }

    public void bt(boolean z) {
        this.ayC = z;
    }

    public void e(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.ayG.clear();
            for (int i : iArr) {
                this.ayG.add(Integer.valueOf(i));
            }
        }
    }

    public void es(int i) {
        this.ayD = i;
    }

    public void O(long j) {
        this.ayE = j;
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
        public int ayJ;
        public boolean ayK;
        public long ayL;

        private a() {
        }

        public void reset() {
            this.ayJ = 0;
            if (this.ayK) {
                this.ayK = false;
                this.ayL = 0L;
            }
        }

        public void onError(int i) {
            this.ayJ++;
            if (!this.ayK && this.ayJ >= i) {
                this.ayK = true;
                this.ayL = System.currentTimeMillis();
            }
        }
    }

    public int BV() {
        return this.ayI;
    }
}
