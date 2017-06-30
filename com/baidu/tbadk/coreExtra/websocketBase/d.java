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
    private static d axo = new d();
    private boolean axj;
    private int axk;
    private long axl;
    private final SparseArray<a> axm;
    private final HashSet<Integer> axn;
    private int axp;

    public static d BG() {
        return axo;
    }

    private d() {
        super(1001);
        this.axk = 3;
        this.axl = ReportUserInfoModel.TIME_INTERVAL;
        this.axm = new SparseArray<>();
        this.axn = new HashSet<>();
        this.axp = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean em(int i) {
        this.axp = 0;
        if (this.axj) {
            this.axp = 3;
            return false;
        } else if (this.axn.contains(Integer.valueOf(i))) {
            this.axp = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.axp = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().cT() > PingManager.BK().BM() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.axp = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.axm.get(i);
            if (aVar != null && aVar.axr) {
                if (Math.abs(System.currentTimeMillis() - aVar.axs) > this.axl) {
                    aVar.reset();
                } else {
                    this.axp = 4;
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
            if (i2 < this.axm.size()) {
                this.axm.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void en(int i) {
        a aVar = this.axm.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.axm.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.axk);
        }
        this.axp = 5;
    }

    public void eo(int i) {
        this.axm.remove(i);
    }

    public void bs(boolean z) {
        this.axj = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.axn.clear();
            for (int i : iArr) {
                this.axn.add(Integer.valueOf(i));
            }
        }
    }

    public void ep(int i) {
        this.axk = i;
    }

    public void O(long j) {
        this.axl = j;
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
        public int axq;
        public boolean axr;
        public long axs;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.axq = 0;
            if (this.axr) {
                this.axr = false;
                this.axs = 0L;
            }
        }

        public void onError(int i) {
            this.axq++;
            if (!this.axr && this.axq >= i) {
                this.axr = true;
                this.axs = System.currentTimeMillis();
            }
        }
    }

    public int BH() {
        return this.axp;
    }
}
