package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d aqK = new d();
    private boolean aqF;
    private int aqG;
    private long aqH;
    private final SparseArray<a> aqI;
    private final HashSet<Integer> aqJ;
    private int aqL;

    public static d Bq() {
        return aqK;
    }

    private d() {
        super(1001);
        this.aqG = 3;
        this.aqH = ReportUserInfoModel.TIME_INTERVAL;
        this.aqI = new SparseArray<>();
        this.aqJ = new HashSet<>();
        this.aqL = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean en(int i) {
        this.aqL = 0;
        if (this.aqF) {
            this.aqL = 3;
            return false;
        } else if (this.aqJ.contains(Integer.valueOf(i))) {
            this.aqL = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aqL = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().bL() > PingManager.Bu().Bw() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aqL = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aqI.get(i);
            if (aVar != null && aVar.aqM) {
                if (Math.abs(System.currentTimeMillis() - aVar.aqN) > this.aqH) {
                    aVar.reset();
                } else {
                    this.aqL = 4;
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
            if (i2 < this.aqI.size()) {
                this.aqI.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void eo(int i) {
        a aVar = this.aqI.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.aqI.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aqG);
        }
        this.aqL = 5;
    }

    public void ep(int i) {
        this.aqI.remove(i);
    }

    public void bt(boolean z) {
        this.aqF = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aqJ.clear();
            for (int i : iArr) {
                this.aqJ.add(Integer.valueOf(i));
            }
        }
    }

    public void eq(int i) {
        this.aqG = i;
    }

    public void M(long j) {
        this.aqH = j;
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
        public boolean aqM;
        public long aqN;
        public int errorCount;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.errorCount = 0;
            if (this.aqM) {
                this.aqM = false;
                this.aqN = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.aqM && this.errorCount >= i) {
                this.aqM = true;
                this.aqN = System.currentTimeMillis();
            }
        }
    }

    public int Br() {
        return this.aqL;
    }
}
