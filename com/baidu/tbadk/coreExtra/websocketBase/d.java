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
    private static d asb = new d();
    private boolean arW;
    private int arX;
    private long arY;
    private final SparseArray<a> arZ;
    private final HashSet<Integer> asa;
    private int asc;

    public static d BI() {
        return asb;
    }

    private d() {
        super(1001);
        this.arX = 3;
        this.arY = 300000L;
        this.arZ = new SparseArray<>();
        this.asa = new HashSet<>();
        this.asc = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean el(int i) {
        this.asc = 0;
        if (this.arW) {
            this.asc = 3;
            return false;
        } else if (this.asa.contains(Integer.valueOf(i))) {
            this.asc = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.asc = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().bL() > PingManager.BM().BO() + 20000) {
            com.baidu.adp.framework.client.socket.k.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.asc = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.arZ.get(i);
            if (aVar != null && aVar.ase) {
                if (Math.abs(System.currentTimeMillis() - aVar.asf) > this.arY) {
                    aVar.reset();
                } else {
                    this.asc = 4;
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
            if (i2 < this.arZ.size()) {
                this.arZ.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void em(int i) {
        a aVar = this.arZ.get(i);
        if (aVar == null) {
            aVar = new a(null);
            this.arZ.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.arX);
        }
        this.asc = 5;
    }

    public void en(int i) {
        this.arZ.remove(i);
    }

    public void bt(boolean z) {
        this.arW = z;
    }

    public void d(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.asa.clear();
            for (int i : iArr) {
                this.asa.add(Integer.valueOf(i));
            }
        }
    }

    public void eo(int i) {
        this.arX = i;
    }

    public void O(long j) {
        this.arY = j;
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
        public int asd;
        public boolean ase;
        public long asf;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public void reset() {
            this.asd = 0;
            if (this.ase) {
                this.ase = false;
                this.asf = 0L;
            }
        }

        public void onError(int i) {
            this.asd++;
            if (!this.ase && this.asd >= i) {
                this.ase = true;
                this.asf = System.currentTimeMillis();
            }
        }
    }

    public int BJ() {
        return this.asc;
    }
}
