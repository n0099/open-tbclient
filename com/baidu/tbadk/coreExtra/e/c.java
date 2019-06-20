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
    private static c cok = new c();
    private boolean cof;
    private int cog;
    private long coh;
    private final SparseArray<a> coi;
    private final HashSet<Integer> coj;
    private int col;

    public static c apU() {
        return cok;
    }

    private c() {
        super(1001);
        this.cog = 3;
        this.coh = ReportUserInfoModel.TIME_INTERVAL;
        this.coi = new SparseArray<>();
        this.coj = new HashSet<>();
        this.col = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean jV(int i) {
        this.col = 0;
        if (this.cof) {
            this.col = 3;
            return false;
        } else if (this.coj.contains(Integer.valueOf(i))) {
            this.col = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.col = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().fG() > e.apX().apZ() + 20000) {
            com.baidu.adp.framework.client.socket.i.a("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.col = 2;
            return false;
        } else if (TextUtils.isEmpty(TiebaIMConfig.defaultUrl)) {
            return false;
        } else {
            a aVar = this.coi.get(i);
            if (aVar != null && aVar.con) {
                if (Math.abs(System.currentTimeMillis() - aVar.coo) > this.coh) {
                    aVar.reset();
                } else {
                    this.col = 4;
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
            if (i2 < this.coi.size()) {
                this.coi.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void jW(int i) {
        a aVar = this.coi.get(i);
        if (aVar == null) {
            aVar = new a();
            this.coi.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.cog);
        }
        this.col = 5;
    }

    public void jX(int i) {
        this.coi.remove(i);
    }

    public void eS(boolean z) {
        this.cof = z;
    }

    public void i(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.coj.clear();
            for (int i : iArr) {
                this.coj.add(Integer.valueOf(i));
            }
        }
    }

    public void jY(int i) {
        this.cog = i;
    }

    public void bf(long j) {
        this.coh = j;
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

        /* renamed from: com  reason: collision with root package name */
        public int f4com;
        public boolean con;
        public long coo;

        private a() {
        }

        public void reset() {
            this.f4com = 0;
            if (this.con) {
                this.con = false;
                this.coo = 0L;
            }
        }

        public void onError(int i) {
            this.f4com++;
            if (!this.con && this.f4com >= i) {
                this.con = true;
                this.coo = System.currentTimeMillis();
            }
        }
    }

    public int apV() {
        return this.col;
    }
}
