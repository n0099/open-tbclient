package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bnL;
    private b bnM;
    private a bnN;

    /* loaded from: classes.dex */
    public interface b {
        void bS(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bnQ;

        c(d dVar) {
            this.bnQ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bnQ.get()) != null) {
                dVar.Jw();
            }
        }
    }

    public d(String str, b bVar) {
        this.bnL = null;
        this.bnM = null;
        this.bnN = null;
        this.bnL = new c(this);
        this.bnM = bVar;
        this.bnL.sendEmptyMessageDelayed(0, 50000L);
        this.bnN = new a();
        this.bnN.setSelfExecute(true);
        this.bnN.execute(Jv() + str);
    }

    private String Jv() {
        switch (j.oO()) {
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
    public void Jw() {
        if (this.bnN != null) {
            this.bnN.cancel(true);
        }
        if (this.bnL != null) {
            this.bnL.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bnO;

        private a() {
            this.bnO = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bnO = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bnO.waitFor() == 0;
                        this.bnO.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bnO.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bnO.destroy();
                    }
                } catch (Throwable th) {
                    this.bnO.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bnO != null) {
                try {
                    this.bnO.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bnM != null) {
                d.this.bnM.bS(false);
            }
            if (d.this.bnL != null) {
                d.this.bnL.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bnM != null) {
                d.this.bnM.bS(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bnL != null) {
                d.this.bnL.removeMessages(0);
            }
        }
    }
}
