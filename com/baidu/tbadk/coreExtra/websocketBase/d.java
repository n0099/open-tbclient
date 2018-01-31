package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bnU;
    private b bnV;
    private a bnW;

    /* loaded from: classes.dex */
    public interface b {
        void bT(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bnZ;

        c(d dVar) {
            this.bnZ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bnZ.get()) != null) {
                dVar.Jy();
            }
        }
    }

    public d(String str, b bVar) {
        this.bnU = null;
        this.bnV = null;
        this.bnW = null;
        this.bnU = new c(this);
        this.bnV = bVar;
        this.bnU.sendEmptyMessageDelayed(0, 50000L);
        this.bnW = new a();
        this.bnW.setSelfExecute(true);
        this.bnW.execute(Jx() + str);
    }

    private String Jx() {
        switch (j.oP()) {
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
    public void Jy() {
        if (this.bnW != null) {
            this.bnW.cancel(true);
        }
        if (this.bnU != null) {
            this.bnU.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bnX;

        private a() {
            this.bnX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bnX = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bnX.waitFor() == 0;
                        this.bnX.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bnX.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bnX.destroy();
                    }
                } catch (Throwable th) {
                    this.bnX.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bnX != null) {
                try {
                    this.bnX.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bnV != null) {
                d.this.bnV.bT(false);
            }
            if (d.this.bnU != null) {
                d.this.bnU.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bnV != null) {
                d.this.bnV.bT(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bnU != null) {
                d.this.bnU.removeMessages(0);
            }
        }
    }
}
