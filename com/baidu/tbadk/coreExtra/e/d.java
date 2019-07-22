package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cpC;
    private b cpD;
    private a cpE;

    /* loaded from: classes.dex */
    public interface b {
        void eX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cpH;

        c(d dVar) {
            this.cpH = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cpH.get()) != null) {
                dVar.xI();
            }
        }
    }

    public d(String str, b bVar) {
        this.cpC = null;
        this.cpD = null;
        this.cpE = null;
        this.cpC = new c(this);
        this.cpD = bVar;
        this.cpC.sendEmptyMessageDelayed(0, 50000L);
        this.cpE = new a();
        this.cpE.setSelfExecute(true);
        this.cpE.execute(arb() + str);
    }

    private String arb() {
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
    public void xI() {
        if (this.cpE != null) {
            this.cpE.cancel(true);
        }
        if (this.cpC != null) {
            this.cpC.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cpF;

        private a() {
            this.cpF = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cpF = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cpF.waitFor() == 0;
                        this.cpF.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cpF.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cpF.destroy();
                    }
                } catch (Throwable th) {
                    this.cpF.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cpF != null) {
                try {
                    this.cpF.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cpD != null) {
                d.this.cpD.eX(false);
            }
            if (d.this.cpC != null) {
                d.this.cpC.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cpD != null) {
                d.this.cpD.eX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cpC != null) {
                d.this.cpC.removeMessages(0);
            }
        }
    }
}
