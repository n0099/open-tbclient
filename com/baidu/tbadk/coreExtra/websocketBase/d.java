package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c aWK;
    private b aWL;
    private a aWM;

    /* loaded from: classes.dex */
    public interface b {
        void cj(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aWP;

        c(d dVar) {
            this.aWP = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aWP.get()) != null) {
                dVar.timeOut();
            }
        }
    }

    public d(String str, b bVar) {
        this.aWK = null;
        this.aWL = null;
        this.aWM = null;
        this.aWK = new c(this);
        this.aWL = bVar;
        this.aWK.sendEmptyMessageDelayed(0, 50000L);
        this.aWM = new a();
        this.aWM.setSelfExecute(true);
        this.aWM.execute(Lv() + str);
    }

    private String Lv() {
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
        if (this.aWM != null) {
            this.aWM.cancel(true);
        }
        if (this.aWK != null) {
            this.aWK.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aWN;

        private a() {
            this.aWN = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aWN = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aWN.waitFor() == 0;
                        this.aWN.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aWN.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aWN.destroy();
                    }
                } catch (Throwable th) {
                    this.aWN.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aWN != null) {
                try {
                    this.aWN.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.aWL != null) {
                d.this.aWL.cj(false);
            }
            if (d.this.aWK != null) {
                d.this.aWK.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.aWL != null) {
                d.this.aWL.cj(bool == null ? false : bool.booleanValue());
            }
            if (d.this.aWK != null) {
                d.this.aWK.removeMessages(0);
            }
        }
    }
}
