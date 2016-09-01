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
    private static d arw = new d();
    private boolean arr;
    private int ars;
    private long art;
    private final SparseArray<a> aru;
    private final HashSet<Integer> arv;
    private int arx;

    public static d Bx() {
        return arw;
    }

    private d() {
        super(1001);
        this.ars = 3;
        this.art = 300000L;
        this.aru = new SparseArray<>();
        this.arv = new HashSet<>();
        this.arx = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean ej(int i) {
        this.arx = 0;
        if (this.arr) {
            this.arx = 3;
            return false;
        } else if (this.arv.contains(Integer.valueOf(i))) {
            this.arx = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.arx = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().bL() > PingManager.BB().BD() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.arx = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.aru.get(i);
            if (aVar != null && aVar.arz) {
                if (Math.abs(System.currentTimeMillis() - aVar.arA) > this.art) {
                    aVar.reset();
                } else {
                    this.arx = 4;
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
            if (i2 < this.aru.size()) {
                this.aru.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void ek(int i) {
        a aVar = this.aru.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.aru.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.ars);
        }
        this.arx = 5;
    }

    public void el(int i) {
        this.aru.remove(i);
    }

    public void bq(boolean z) {
        this.arr = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.arv.clear();
            for (int i : iArr) {
                this.arv.add(Integer.valueOf(i));
            }
        }
    }

    public void em(int i) {
        this.ars = i;
    }

    public void O(long j) {
        this.art = j;
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
        public long arA;
        public int ary;
        public boolean arz;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.ary = 0;
            if (this.arz) {
                this.arz = false;
                this.arA = 0L;
            }
        }

        public void onError(int i) {
            this.ary++;
            if (!this.arz && this.ary >= i) {
                this.arz = true;
                this.arA = System.currentTimeMillis();
            }
        }
    }

    public int By() {
        return this.arx;
    }
}
