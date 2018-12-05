package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aVY;
    private b aVZ;
    private a aWa;

    /* loaded from: classes.dex */
    public interface b {
        void ci(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aWd;

        c(d dVar) {
            this.aWd = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aWd.get()) != null) {
                dVar.timeOut();
            }
        }
    }

    public d(String str, b bVar) {
        this.aVY = null;
        this.aVZ = null;
        this.aWa = null;
        this.aVY = new c(this);
        this.aVZ = bVar;
        this.aVY.sendEmptyMessageDelayed(0, 50000L);
        this.aWa = new a();
        this.aWa.setSelfExecute(true);
        this.aWa.execute(Lf() + str);
    }

    private String Lf() {
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
    public void timeOut() {
        if (this.aWa != null) {
            this.aWa.cancel(true);
        }
        if (this.aVY != null) {
            this.aVY.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aWb;

        private a() {
            this.aWb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aWb = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aWb.waitFor() == 0;
                        this.aWb.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aWb.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aWb.destroy();
                    }
                } catch (Throwable th) {
                    this.aWb.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aWb != null) {
                try {
                    this.aWb.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aVZ != null) {
                d.this.aVZ.ci(false);
            }
            if (d.this.aVY != null) {
                d.this.aVY.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aVZ != null) {
                d.this.aVZ.ci(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aVY != null) {
                d.this.aVY.removeMessages(0);
            }
        }
    }
}
