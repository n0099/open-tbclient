package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c duu;
    private b duv;
    private a duw;

    /* loaded from: classes.dex */
    public interface b {
        void gs(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> duz;

        c(d dVar) {
            this.duz = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.duz.get()) != null) {
                dVar.Kg();
            }
        }
    }

    public d(String str, b bVar) {
        this.duu = null;
        this.duv = null;
        this.duw = null;
        this.duu = new c(this);
        this.duv = bVar;
        this.duu.sendEmptyMessageDelayed(0, 50000L);
        this.duw = new a();
        this.duw.setSelfExecute(true);
        this.duw.execute(aNr() + str);
    }

    private String aNr() {
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
    public void Kg() {
        if (this.duw != null) {
            this.duw.cancel(true);
        }
        if (this.duu != null) {
            this.duu.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process dux;

        private a() {
            this.dux = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.dux = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.dux.waitFor() == 0;
                        this.dux.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.dux.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.dux.destroy();
                    }
                } catch (Throwable th) {
                    this.dux.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dux != null) {
                try {
                    this.dux.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.duv != null) {
                d.this.duv.gs(false);
            }
            if (d.this.duu != null) {
                d.this.duu.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.duv != null) {
                d.this.duv.gs(bool == null ? false : bool.booleanValue());
            }
            if (d.this.duu != null) {
                d.this.duu.removeMessages(0);
            }
        }
    }
}
