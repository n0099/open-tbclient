package com.baidu.tbadk.coreExtra.e;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c cpx = new c();
    private boolean cpr;
    private int cps;
    private long cpt;
    private final SparseArray<a> cpv;
    private final HashSet<Integer> cpw;
    private int cpy;

    public static c aqZ() {
        return cpx;
    }

    private c() {
        super(1001);
        this.cps = 3;
        this.cpt = ReportUserInfoModel.TIME_INTERVAL;
        this.cpv = new SparseArray<>();
        this.cpw = new HashSet<>();
        this.cpy = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean kb(int i) {
        this.cpy = 0;
        if (this.cpr) {
            this.cpy = 3;
            return false;
        } else if (this.cpw.contains(Integer.valueOf(i))) {
            this.cpy = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.cpy = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fO() > e.arc().are() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.cpy = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.cpv.get(i);
            if (aVar != null && aVar.cpA) {
                if (Math.abs(System.currentTimeMillis() - aVar.cpB) > this.cpt) {
                    aVar.reset();
                } else {
                    this.cpy = 4;
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
            if (i2 < this.cpv.size()) {
                this.cpv.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void kc(int i) {
        a aVar = this.cpv.get(i);
        if (aVar == null) {
            aVar = new a();
            this.cpv.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cps);
        }
        this.cpy = 5;
    }

    public void kd(int i) {
        this.cpv.remove(i);
    }

    public void eW(boolean z) {
        this.cpr = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.cpw.clear();
            for (int i : iArr) {
                this.cpw.add(Integer.valueOf(i));
            }
        }
    }

    public void ke(int i) {
        this.cps = i;
    }

    public void bg(long j) {
        this.cpt = j;
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
        public boolean cpA;
        public long cpB;
        public int cpz;

        private a() {
        }

        public void reset() {
            this.cpz = 0;
            if (this.cpA) {
                this.cpA = false;
                this.cpB = 0L;
            }
        }

        public void onError(int i) {
            this.cpz++;
            if (!this.cpA && this.cpz >= i) {
                this.cpA = true;
                this.cpB = System.currentTimeMillis();
            }
        }
    }

    public int ara() {
        return this.cpy;
    }
}
