package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c axV;
    private b axW;
    private a axX;

    /* loaded from: classes.dex */
    public interface b {
        void bs(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> aya;

        c(d dVar) {
            this.aya = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.aya.get()) != null) {
                dVar.Bu();
            }
        }
    }

    public d(String str, b bVar) {
        this.axV = null;
        this.axW = null;
        this.axX = null;
        this.axV = new c(this);
        this.axW = bVar;
        this.axV.sendEmptyMessageDelayed(0, 50000L);
        this.axX = new a();
        this.axX.setSelfExecute(true);
        this.axX.execute(Bt() + str);
    }

    private String Bt() {
        switch (j.hn()) {
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
    public void Bu() {
        if (this.axX != null) {
            this.axX.cancel(true);
        }
        if (this.axV != null) {
            this.axV.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process axY;

        private a() {
            this.axY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.axY = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.axY.waitFor() == 0;
                        this.axY.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.axY.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.axY.destroy();
                    }
                } catch (Throwable th) {
                    this.axY.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.axY != null) {
                try {
                    this.axY.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.axW != null) {
                d.this.axW.bs(false);
            }
            if (d.this.axV != null) {
                d.this.axV.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.axW != null) {
                d.this.axW.bs(bool == null ? false : bool.booleanValue());
            }
            if (d.this.axV != null) {
                d.this.axV.removeMessages(0);
            }
        }
    }
}
