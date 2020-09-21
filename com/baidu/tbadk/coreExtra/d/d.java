package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c eKR;
    private b eKS;
    private a eKT;

    /* loaded from: classes.dex */
    public interface b {
        void iX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> eKW;

        c(d dVar) {
            this.eKW = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.eKW.get()) != null) {
                dVar.adm();
            }
        }
    }

    public d(String str, b bVar) {
        this.eKR = null;
        this.eKS = null;
        this.eKT = null;
        this.eKR = new c(this);
        this.eKS = bVar;
        this.eKR.sendEmptyMessageDelayed(0, 50000L);
        this.eKT = new a();
        this.eKT.setSelfExecute(true);
        this.eKT.execute(brv() + str);
    }

    private String brv() {
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
    public void adm() {
        if (this.eKT != null) {
            this.eKT.cancel(true);
        }
        if (this.eKR != null) {
            this.eKR.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process eKU;

        private a() {
            this.eKU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.eKU = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.eKU.waitFor() == 0;
                        this.eKU.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.eKU.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.eKU.destroy();
                    }
                } catch (Throwable th) {
                    this.eKU.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eKU != null) {
                try {
                    this.eKU.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.eKS != null) {
                d.this.eKS.iX(false);
            }
            if (d.this.eKR != null) {
                d.this.eKR.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.eKS != null) {
                d.this.eKS.iX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.eKR != null) {
                d.this.eKR.removeMessages(0);
            }
        }
    }
}
