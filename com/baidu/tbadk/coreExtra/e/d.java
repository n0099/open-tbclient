package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cqD;
    private b cqE;
    private a cqF;

    /* loaded from: classes.dex */
    public interface b {
        void fa(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cqI;

        c(d dVar) {
            this.cqI = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cqI.get()) != null) {
                dVar.xM();
            }
        }
    }

    public d(String str, b bVar) {
        this.cqD = null;
        this.cqE = null;
        this.cqF = null;
        this.cqD = new c(this);
        this.cqE = bVar;
        this.cqD.sendEmptyMessageDelayed(0, 50000L);
        this.cqF = new a();
        this.cqF.setSelfExecute(true);
        this.cqF.execute(arp() + str);
    }

    private String arp() {
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
    public void xM() {
        if (this.cqF != null) {
            this.cqF.cancel(true);
        }
        if (this.cqD != null) {
            this.cqD.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cqG;

        private a() {
            this.cqG = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cqG = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cqG.waitFor() == 0;
                        this.cqG.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cqG.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cqG.destroy();
                    }
                } catch (Throwable th) {
                    this.cqG.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cqG != null) {
                try {
                    this.cqG.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cqE != null) {
                d.this.cqE.fa(false);
            }
            if (d.this.cqD != null) {
                d.this.cqD.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cqE != null) {
                d.this.cqE.fa(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cqD != null) {
                d.this.cqD.removeMessages(0);
            }
        }
    }
}
