package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c eWY;
    private b eWZ;
    private a eXa;

    /* loaded from: classes.dex */
    public interface b {
        void jv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> eXd;

        c(d dVar) {
            this.eXd = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.eXd.get()) != null) {
                dVar.afY();
            }
        }
    }

    public d(String str, b bVar) {
        this.eWY = null;
        this.eWZ = null;
        this.eXa = null;
        this.eWY = new c(this);
        this.eWZ = bVar;
        this.eWY.sendEmptyMessageDelayed(0, 50000L);
        this.eXa = new a();
        this.eXa.setSelfExecute(true);
        this.eXa.execute(buf() + str);
    }

    private String buf() {
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
    public void afY() {
        if (this.eXa != null) {
            this.eXa.cancel(true);
        }
        if (this.eWY != null) {
            this.eWY.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process eXb;

        private a() {
            this.eXb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.eXb = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.eXb.waitFor() == 0;
                        this.eXb.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.eXb.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.eXb.destroy();
                    }
                } catch (Throwable th) {
                    this.eXb.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.eXb != null) {
                try {
                    this.eXb.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.eWZ != null) {
                d.this.eWZ.jv(false);
            }
            if (d.this.eWY != null) {
                d.this.eWY.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.eWZ != null) {
                d.this.eWZ.jv(bool == null ? false : bool.booleanValue());
            }
            if (d.this.eWY != null) {
                d.this.eWY.removeMessages(0);
            }
        }
    }
}
