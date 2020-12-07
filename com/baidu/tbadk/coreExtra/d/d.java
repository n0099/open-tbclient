package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c frV;
    private b frW;
    private a frX;

    /* loaded from: classes.dex */
    public interface b {
        void ki(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> fsa;

        c(d dVar) {
            this.fsa = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.fsa.get()) != null) {
                dVar.amS();
            }
        }
    }

    public d(String str, b bVar) {
        this.frV = null;
        this.frW = null;
        this.frX = null;
        this.frV = new c(this);
        this.frW = bVar;
        this.frV.sendEmptyMessageDelayed(0, 50000L);
        this.frX = new a();
        this.frX.setSelfExecute(true);
        this.frX.execute(bBn() + str);
    }

    private String bBn() {
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
    public void amS() {
        if (this.frX != null) {
            this.frX.cancel(true);
        }
        if (this.frV != null) {
            this.frV.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process frY;

        private a() {
            this.frY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.frY = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.frY.waitFor() == 0;
                        this.frY.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.frY.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.frY.destroy();
                    }
                } catch (Throwable th) {
                    this.frY.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.frY != null) {
                try {
                    this.frY.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.frW != null) {
                d.this.frW.ki(false);
            }
            if (d.this.frV != null) {
                d.this.frV.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.frW != null) {
                d.this.frW.ki(bool == null ? false : bool.booleanValue());
            }
            if (d.this.frV != null) {
                d.this.frV.removeMessages(0);
            }
        }
    }
}
