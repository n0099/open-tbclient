package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c duV;
    private b duW;
    private a duX;

    /* loaded from: classes.dex */
    public interface b {
        void gt(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> dva;

        c(d dVar) {
            this.dva = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.dva.get()) != null) {
                dVar.Kl();
            }
        }
    }

    public d(String str, b bVar) {
        this.duV = null;
        this.duW = null;
        this.duX = null;
        this.duV = new c(this);
        this.duW = bVar;
        this.duV.sendEmptyMessageDelayed(0, 50000L);
        this.duX = new a();
        this.duX.setSelfExecute(true);
        this.duX.execute(aNy() + str);
    }

    private String aNy() {
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
    public void Kl() {
        if (this.duX != null) {
            this.duX.cancel(true);
        }
        if (this.duV != null) {
            this.duV.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process duY;

        private a() {
            this.duY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.duY = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.duY.waitFor() == 0;
                        this.duY.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.duY.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.duY.destroy();
                    }
                } catch (Throwable th) {
                    this.duY.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.duY != null) {
                try {
                    this.duY.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.duW != null) {
                d.this.duW.gt(false);
            }
            if (d.this.duV != null) {
                d.this.duV.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.duW != null) {
                d.this.duW.gt(bool == null ? false : bool.booleanValue());
            }
            if (d.this.duV != null) {
                d.this.duV.removeMessages(0);
            }
        }
    }
}
