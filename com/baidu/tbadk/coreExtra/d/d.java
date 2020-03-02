package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c duv;
    private b duw;
    private a dux;

    /* loaded from: classes.dex */
    public interface b {
        void gs(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> duA;

        c(d dVar) {
            this.duA = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.duA.get()) != null) {
                dVar.Ki();
            }
        }
    }

    public d(String str, b bVar) {
        this.duv = null;
        this.duw = null;
        this.dux = null;
        this.duv = new c(this);
        this.duw = bVar;
        this.duv.sendEmptyMessageDelayed(0, 50000L);
        this.dux = new a();
        this.dux.setSelfExecute(true);
        this.dux.execute(aNt() + str);
    }

    private String aNt() {
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
    public void Ki() {
        if (this.dux != null) {
            this.dux.cancel(true);
        }
        if (this.duv != null) {
            this.duv.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process duy;

        private a() {
            this.duy = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.duy = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.duy.waitFor() == 0;
                        this.duy.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.duy.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.duy.destroy();
                    }
                } catch (Throwable th) {
                    this.duy.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.duy != null) {
                try {
                    this.duy.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.duw != null) {
                d.this.duw.gs(false);
            }
            if (d.this.duv != null) {
                d.this.duv.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.duw != null) {
                d.this.duw.gs(bool == null ? false : bool.booleanValue());
            }
            if (d.this.duv != null) {
                d.this.duv.removeMessages(0);
            }
        }
    }
}
