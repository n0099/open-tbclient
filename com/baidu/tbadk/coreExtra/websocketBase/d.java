package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c bnC;
    private b bnD;
    private a bnE;

    /* loaded from: classes.dex */
    public interface b {
        void bU(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> bnH;

        c(d dVar) {
            this.bnH = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.bnH.get()) != null) {
                dVar.JH();
            }
        }
    }

    public d(String str, b bVar) {
        this.bnC = null;
        this.bnD = null;
        this.bnE = null;
        this.bnC = new c(this);
        this.bnD = bVar;
        this.bnC.sendEmptyMessageDelayed(0, 50000L);
        this.bnE = new a();
        this.bnE.setSelfExecute(true);
        this.bnE.execute(JG() + str);
    }

    private String JG() {
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
    public void JH() {
        if (this.bnE != null) {
            this.bnE.cancel(true);
        }
        if (this.bnC != null) {
            this.bnC.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process bnF;

        private a() {
            this.bnF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.bnF = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.bnF.waitFor() == 0;
                        this.bnF.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.bnF.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.bnF.destroy();
                    }
                } catch (Throwable th) {
                    this.bnF.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.bnF != null) {
                try {
                    this.bnF.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.bnD != null) {
                d.this.bnD.bU(false);
            }
            if (d.this.bnC != null) {
                d.this.bnC.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.bnD != null) {
                d.this.bnD.bU(bool == null ? false : bool.booleanValue());
            }
            if (d.this.bnC != null) {
                d.this.bnC.removeMessages(0);
            }
        }
    }
}
