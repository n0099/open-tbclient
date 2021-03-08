package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c fAH;
    private b fAI;
    private a fAJ;

    /* loaded from: classes.dex */
    public interface b {
        void kD(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> fAM;

        c(d dVar) {
            this.fAM = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.fAM.get()) != null) {
                dVar.akK();
            }
        }
    }

    public d(String str, b bVar) {
        this.fAH = null;
        this.fAI = null;
        this.fAJ = null;
        this.fAH = new c(this);
        this.fAI = bVar;
        this.fAH.sendEmptyMessageDelayed(0, 50000L);
        this.fAJ = new a();
        this.fAJ.setSelfExecute(true);
        this.fAJ.execute(bAk() + str);
    }

    private String bAk() {
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
    public void akK() {
        if (this.fAJ != null) {
            this.fAJ.cancel(true);
        }
        if (this.fAH != null) {
            this.fAH.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process fAK;

        private a() {
            this.fAK = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.fAK = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.fAK.waitFor() == 0;
                        this.fAK.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.fAK.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.fAK.destroy();
                    }
                } catch (Throwable th) {
                    this.fAK.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.fAK != null) {
                try {
                    this.fAK.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.fAI != null) {
                d.this.fAI.kD(false);
            }
            if (d.this.fAH != null) {
                d.this.fAH.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.fAI != null) {
                d.this.fAI.kD(bool == null ? false : bool.booleanValue());
            }
            if (d.this.fAH != null) {
                d.this.fAH.removeMessages(0);
            }
        }
    }
}
