package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cpJ;
    private b cpK;
    private a cpL;

    /* loaded from: classes.dex */
    public interface b {
        void eX(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cpO;

        c(d dVar) {
            this.cpO = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cpO.get()) != null) {
                dVar.xI();
            }
        }
    }

    public d(String str, b bVar) {
        this.cpJ = null;
        this.cpK = null;
        this.cpL = null;
        this.cpJ = new c(this);
        this.cpK = bVar;
        this.cpJ.sendEmptyMessageDelayed(0, 50000L);
        this.cpL = new a();
        this.cpL.setSelfExecute(true);
        this.cpL.execute(ard() + str);
    }

    private String ard() {
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
        if (this.cpL != null) {
            this.cpL.cancel(true);
        }
        if (this.cpJ != null) {
            this.cpJ.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cpM;

        private a() {
            this.cpM = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cpM = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cpM.waitFor() == 0;
                        this.cpM.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cpM.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cpM.destroy();
                    }
                } catch (Throwable th) {
                    this.cpM.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cpM != null) {
                try {
                    this.cpM.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cpK != null) {
                d.this.cpK.eX(false);
            }
            if (d.this.cpJ != null) {
                d.this.cpJ.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cpK != null) {
                d.this.cpK.eX(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cpJ != null) {
                d.this.cpJ.removeMessages(0);
            }
        }
    }
}
