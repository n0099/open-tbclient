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
    private static c aAs = new c();
    private boolean aAn;
    private int aAo;
    private long aAp;
    private final SparseArray<a> aAq;
    private final HashSet<Integer> aAr;
    private int aAt;

    public static c CI() {
        return aAs;
    }

    private c() {
        super(1001);
        this.aAo = 3;
        this.aAp = ReportUserInfoModel.TIME_INTERVAL;
        this.aAq = new SparseArray<>();
        this.aAr = new HashSet<>();
        this.aAt = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean er(int i) {
        this.aAt = 0;
        if (this.aAn) {
            this.aAt = 3;
            return false;
        } else if (this.aAr.contains(Integer.valueOf(i))) {
            this.aAt = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.aAt = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cC() > PingManager.CM().CO() + 20000) {
            i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.aAt = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aAq.get(i);
            if (aVar != null && aVar.aAv) {
                if (Math.abs(System.currentTimeMillis() - aVar.aAw) > this.aAp) {
                    aVar.reset();
                } else {
                    this.aAt = 4;
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
            if (i2 < this.aAq.size()) {
                this.aAq.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void es(int i) {
        a aVar = this.aAq.get(i);
        if (aVar == null) {
            aVar = new a();
            this.aAq.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.aAo);
        }
        this.aAt = 5;
    }

    public void et(int i) {
        this.aAq.remove(i);
    }

    public void bo(boolean z) {
        this.aAn = z;
    }

    public void g(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.aAr.clear();
            for (int i : iArr) {
                this.aAr.add(Integer.valueOf(i));
            }
        }
    }

    public void eu(int i) {
        this.aAo = i;
    }

    public void S(long j) {
        this.aAp = j;
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
        public int aAu;
        public boolean aAv;
        public long aAw;

        private a() {
        }

        public void reset() {
            this.aAu = 0;
            if (this.aAv) {
                this.aAv = false;
                this.aAw = 0L;
            }
        }

        public void onError(int i) {
            this.aAu++;
            if (!this.aAv && this.aAu >= i) {
                this.aAv = true;
                this.aAw = System.currentTimeMillis();
            }
        }
    }

    public int CJ() {
        return this.aAt;
    }
}
