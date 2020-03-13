package com.baidu.tbadk.coreExtra.d;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import java.util.HashSet;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.c {
    private static c duH = new c();
    private final SparseArray<a> availableAPIs;
    private boolean closeLongConnectionAPI;
    private int longConnectionFailedErrno;
    private int maxErrorCount;
    private long retryTimeInMills;
    private final HashSet<Integer> unavailableAPIS;

    public static c aNt() {
        return duH;
    }

    private c() {
        super(1001);
        this.maxErrorCount = 3;
        this.retryTimeInMills = 300000L;
        this.availableAPIs = new SparseArray<>();
        this.unavailableAPIS = new HashSet<>();
        this.longConnectionFailedErrno = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean isAPIAvailableNow(int i) {
        this.longConnectionFailedErrno = 0;
        if (this.closeLongConnectionAPI) {
            this.longConnectionFailedErrno = 3;
            return false;
        } else if (this.unavailableAPIS.contains(Integer.valueOf(i))) {
            this.longConnectionFailedErrno = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.longConnectionFailedErrno = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > e.aNv().getForegroundInterval() + 20000) {
            com.baidu.adp.framework.client.socket.i.debug("lcapimgr", i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.longConnectionFailedErrno = 2;
            return false;
        } else if (TextUtils.isEmpty("ws://im.tieba.baidu.com:8000")) {
            return false;
        } else {
            a aVar = this.availableAPIs.get(i);
            if (aVar != null && aVar.startBlockOnErrorCount) {
                if (Math.abs(System.currentTimeMillis() - aVar.startBlockTime) > this.retryTimeInMills) {
                    aVar.reset();
                } else {
                    this.longConnectionFailedErrno = 4;
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
            if (i2 < this.availableAPIs.size()) {
                this.availableAPIs.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onAPIFailed(int i) {
        a aVar = this.availableAPIs.get(i);
        if (aVar == null) {
            aVar = new a();
            this.availableAPIs.append(i, aVar);
        }
        if (aVar != null) {
            aVar.onError(this.maxErrorCount);
        }
        this.longConnectionFailedErrno = 5;
    }

    public void onAPISuccessed(int i) {
        this.availableAPIs.remove(i);
    }

    public void setCloseLongConnectionAPI(boolean z) {
        this.closeLongConnectionAPI = z;
    }

    public void setUnAvailableAPIS(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.unavailableAPIS.clear();
            for (int i : iArr) {
                this.unavailableAPIS.add(Integer.valueOf(i));
            }
        }
    }

    public void setMaxErrorCount(int i) {
        this.maxErrorCount = i;
    }

    public void setRetryTimeInMills(long j) {
        this.retryTimeInMills = j;
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
        public int errorCount;
        public boolean startBlockOnErrorCount;
        public long startBlockTime;

        private a() {
        }

        public void reset() {
            this.errorCount = 0;
            if (this.startBlockOnErrorCount) {
                this.startBlockOnErrorCount = false;
                this.startBlockTime = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.startBlockOnErrorCount && this.errorCount >= i) {
                this.startBlockOnErrorCount = true;
                this.startBlockTime = System.currentTimeMillis();
            }
        }
    }

    public int getLongConnectionFailedErrno() {
        return this.longConnectionFailedErrno;
    }
}
