package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cCp;
    private b cCq;
    private a cCr;

    /* loaded from: classes.dex */
    public interface b {
        void eU(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cCu;

        c(d dVar) {
            this.cCu = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cCu.get()) != null) {
                dVar.CI();
            }
        }
    }

    public d(String str, b bVar) {
        this.cCp = null;
        this.cCq = null;
        this.cCr = null;
        this.cCp = new c(this);
        this.cCq = bVar;
        this.cCp.sendEmptyMessageDelayed(0, 50000L);
        this.cCr = new a();
        this.cCr.setSelfExecute(true);
        this.cCr.execute(ate() + str);
    }

    private String ate() {
        switch (j.netType()) {
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
    public void CI() {
        if (this.cCr != null) {
            this.cCr.cancel(true);
        }
        if (this.cCp != null) {
            this.cCp.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cCs;

        private a() {
            this.cCs = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cCs = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cCs.waitFor() == 0;
                        this.cCs.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cCs.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cCs.destroy();
                    }
                } catch (Throwable th) {
                    this.cCs.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cCs != null) {
                try {
                    this.cCs.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cCq != null) {
                d.this.cCq.eU(false);
            }
            if (d.this.cCp != null) {
                d.this.cCp.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cCq != null) {
                d.this.cCq.eU(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cCp != null) {
                d.this.cCp.removeMessages(0);
            }
        }
    }
}
