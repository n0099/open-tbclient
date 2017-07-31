package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.i;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c azC;
    private b azD;
    private a azE;

    /* loaded from: classes.dex */
    public interface b {
        void bv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> azH;

        c(d dVar) {
            this.azH = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.azH.get()) != null) {
                dVar.Cc();
            }
        }
    }

    public d(String str, b bVar) {
        this.azC = null;
        this.azD = null;
        this.azE = null;
        this.azC = new c(this);
        this.azD = bVar;
        this.azC.sendEmptyMessageDelayed(0, 50000L);
        this.azE = new a();
        this.azE.setSelfExecute(true);
        this.azE.execute(Cb() + str);
    }

    private String Cb() {
        switch (i.hx()) {
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
    public void Cc() {
        if (this.azE != null) {
            this.azE.cancel(true);
        }
        if (this.azC != null) {
            this.azC.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process azF;

        private a() {
            this.azF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.azF = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.azF.waitFor() == 0;
                        this.azF.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.azF.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.azF.destroy();
                    }
                } catch (Throwable th) {
                    this.azF.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.azF != null) {
                try {
                    this.azF.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.azD != null) {
                d.this.azD.bv(false);
            }
            if (d.this.azC != null) {
                d.this.azC.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.azD != null) {
                d.this.azD.bv(bool == null ? false : bool.booleanValue());
            }
            if (d.this.azC != null) {
                d.this.azC.removeMessages(0);
            }
        }
    }
}
