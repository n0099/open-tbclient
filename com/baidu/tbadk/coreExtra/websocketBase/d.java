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
    private static d awf = new d();
    private boolean awa;
    private int awb;
    private long awc;
    private final SparseArray<a> awd;
    private final HashSet<Integer> awe;
    private int awg;

    public static d BJ() {
        return awf;
    }

    private d() {
        super(1001);
        this.awb = 3;
        this.awc = ReportUserInfoModel.TIME_INTERVAL;
        this.awd = new SparseArray<>();
        this.awe = new HashSet<>();
        this.awg = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ei(int i) {
        this.awg = 0;
        if (this.awa) {
            this.awg = 3;
            return false;
        } else if (this.awe.contains(Integer.valueOf(i))) {
            this.awg = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.awg = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cU() > PingManager.BN().BP() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.awg = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.awd.get(i);
            if (aVar != null && aVar.awh) {
                if (Math.abs(System.currentTimeMillis() - aVar.awi) > this.awc) {
                    aVar.reset();
                } else {
                    this.awg = 4;
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
            if (i2 < this.awd.size()) {
                this.awd.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ej(int i) {
        a aVar = this.awd.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.awd.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.awb);
        }
        this.awg = 5;
    }

    public void ek(int i) {
        this.awd.remove(i);
    }

    public void bs(boolean z) {
        this.awa = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.awe.clear();
            for (int i : iArr) {
                this.awe.add(Integer.valueOf(i));
            }
        }
    }

    public void el(int i) {
        this.awb = i;
    }

    public void M(long j) {
        this.awc = j;
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
        public boolean awh;
        public long awi;
        public int errorCount;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.errorCount = 0;
            if (this.awh) {
                this.awh = false;
                this.awi = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.awh && this.errorCount >= i) {
                this.awh = true;
                this.awi = System.currentTimeMillis();
            }
        }
    }

    public int BK() {
        return this.awg;
    }
}
