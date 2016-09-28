package com.baidu.tbadk.coreExtra.websocketBase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import java.util.HashSet;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    private static d arh = new d();
    private boolean arc;
    private int ard;
    private long are;
    private final SparseArray<a> arf;
    private final HashSet<Integer> arg;
    private int ari;

    public static d BB() {
        return arh;
    }

    private d() {
        super(1001);
        this.ard = 3;
        this.are = 300000L;
        this.arf = new SparseArray<>();
        this.arg = new HashSet<>();
        this.ari = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ej(int i) {
        this.ari = 0;
        if (this.arc) {
            this.ari = 3;
            return false;
        } else if (this.arg.contains(Integer.valueOf(i))) {
            this.ari = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.ari = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().bL() > PingManager.BF().BH() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.ari = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.arf.get(i);
            if (aVar != null && aVar.ark) {
                if (Math.abs(System.currentTimeMillis() - aVar.arl) > this.are) {
                    aVar.reset();
                } else {
                    this.ari = 4;
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
            if (i2 < this.arf.size()) {
                this.arf.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ek(int i) {
        a aVar = this.arf.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.arf.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ard);
        }
        this.ari = 5;
    }

    public void el(int i) {
        this.arf.remove(i);
    }

    public void bp(boolean z) {
        this.arc = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.arg.clear();
            for (int i : iArr) {
                this.arg.add(Integer.valueOf(i));
            }
        }
    }

    public void em(int i) {
        this.ard = i;
    }

    public void P(long j) {
        this.are = j;
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
        public int arj;
        public boolean ark;
        public long arl;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.arj = 0;
            if (this.ark) {
                this.ark = false;
                this.arl = 0L;
            }
        }

        public void onError(int i) {
            this.arj++;
            if (!this.ark && this.arj >= i) {
                this.ark = true;
                this.arl = System.currentTimeMillis();
            }
        }
    }

    public int BC() {
        return this.ari;
    }
}
