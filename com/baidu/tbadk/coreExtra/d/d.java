package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ejd;
    private b eje;
    private a ejf;

    /* loaded from: classes.dex */
    public interface b {
        void hN(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> eji;

        c(d dVar) {
            this.eji = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.eji.get()) != null) {
                dVar.UK();
            }
        }
    }

    public d(String str, b bVar) {
        this.ejd = null;
        this.eje = null;
        this.ejf = null;
        this.ejd = new c(this);
        this.eje = bVar;
        this.ejd.sendEmptyMessageDelayed(0, 50000L);
        this.ejf = new a();
        this.ejf.setSelfExecute(true);
        this.ejf.execute(bcd() + str);
    }

    private String bcd() {
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
    public void UK() {
        if (this.ejf != null) {
            this.ejf.cancel(true);
        }
        if (this.ejd != null) {
            this.ejd.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ejg;

        private a() {
            this.ejg = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ejg = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ejg.waitFor() == 0;
                        this.ejg.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ejg.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ejg.destroy();
                    }
                } catch (Throwable th) {
                    this.ejg.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ejg != null) {
                try {
                    this.ejg.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.eje != null) {
                d.this.eje.hN(false);
            }
            if (d.this.ejd != null) {
                d.this.ejd.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.eje != null) {
                d.this.eje.hN(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ejd != null) {
                d.this.ejd.removeMessages(0);
            }
        }
    }
}
