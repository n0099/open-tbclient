package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c aqU;
    private b aqV;
    private a aqW;

    /* loaded from: classes.dex */
    public interface b {
        void bc(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aqZ;

        c(e eVar) {
            this.aqZ = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aqZ.get()) == null) {
                return;
            }
            eVar.BI();
        }
    }

    public e(String str, b bVar) {
        this.aqU = null;
        this.aqV = null;
        this.aqW = null;
        this.aqU = new c(this);
        this.aqV = bVar;
        this.aqU.sendEmptyMessageDelayed(0, 50000L);
        this.aqW = new a(this, null);
        this.aqW.setSelfExecute(true);
        this.aqW.execute(String.valueOf(BH()) + str);
    }

    private String BH() {
        switch (com.baidu.adp.lib.util.i.jf()) {
            case 1:
                return "ping -c 3 -w 3000 ";
            case 2:
                return "ping -c 3 -w 10000 ";
            case 3:
                return "ping -c 3 -w 5000 ";
            default:
                return "ping -c 3 -w 5000 ";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BI() {
        if (this.aqW != null) {
            this.aqW.cancel(true);
        }
        if (this.aqU != null) {
            this.aqU.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aqX;

        private a() {
            this.aqX = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aqX = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aqX.waitFor() == 0;
                        this.aqX.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aqX.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aqX.destroy();
                    }
                } catch (Throwable th) {
                    this.aqX.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aqX != null) {
                try {
                    this.aqX.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aqV != null) {
                e.this.aqV.bc(false);
            }
            if (e.this.aqU != null) {
                e.this.aqU.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.aqV != null) {
                e.this.aqV.bc(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aqU != null) {
                e.this.aqU.removeMessages(0);
            }
        }
    }
}
