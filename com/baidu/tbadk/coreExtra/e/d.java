package com.baidu.tbadk.coreExtra.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c cge;
    private b cgf;
    private a cgg;

    /* loaded from: classes.dex */
    public interface b {
        void ex(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> cgj;

        c(d dVar) {
            this.cgj = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.cgj.get()) != null) {
                dVar.wq();
            }
        }
    }

    public d(String str, b bVar) {
        this.cge = null;
        this.cgf = null;
        this.cgg = null;
        this.cge = new c(this);
        this.cgf = bVar;
        this.cge.sendEmptyMessageDelayed(0, 50000L);
        this.cgg = new a();
        this.cgg.setSelfExecute(true);
        this.cgg.execute(akX() + str);
    }

    private String akX() {
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
    public void wq() {
        if (this.cgg != null) {
            this.cgg.cancel(true);
        }
        if (this.cge != null) {
            this.cge.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process cgh;

        private a() {
            this.cgh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.cgh = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.cgh.waitFor() == 0;
                        this.cgh.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.cgh.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.cgh.destroy();
                    }
                } catch (Throwable th) {
                    this.cgh.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.cgh != null) {
                try {
                    this.cgh.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.cgf != null) {
                d.this.cgf.ex(false);
            }
            if (d.this.cge != null) {
                d.this.cge.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.cgf != null) {
                d.this.cgf.ex(bool == null ? false : bool.booleanValue());
            }
            if (d.this.cge != null) {
                d.this.cge.removeMessages(0);
            }
        }
    }
}
