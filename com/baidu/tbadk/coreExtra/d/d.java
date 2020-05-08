package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c dUU;
    private b dUV;
    private a dUW;

    /* loaded from: classes.dex */
    public interface b {
        void hr(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> dUZ;

        c(d dVar) {
            this.dUZ = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.dUZ.get()) != null) {
                dVar.RY();
            }
        }
    }

    public d(String str, b bVar) {
        this.dUU = null;
        this.dUV = null;
        this.dUW = null;
        this.dUU = new c(this);
        this.dUV = bVar;
        this.dUU.sendEmptyMessageDelayed(0, 50000L);
        this.dUW = new a();
        this.dUW.setSelfExecute(true);
        this.dUW.execute(aVT() + str);
    }

    private String aVT() {
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
    public void RY() {
        if (this.dUW != null) {
            this.dUW.cancel(true);
        }
        if (this.dUU != null) {
            this.dUU.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process dUX;

        private a() {
            this.dUX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.dUX = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.dUX.waitFor() == 0;
                        this.dUX.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.dUX.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.dUX.destroy();
                    }
                } catch (Throwable th) {
                    this.dUX.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.dUX != null) {
                try {
                    this.dUX.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.dUV != null) {
                d.this.dUV.hr(false);
            }
            if (d.this.dUU != null) {
                d.this.dUU.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.dUV != null) {
                d.this.dUV.hr(bool == null ? false : bool.booleanValue());
            }
            if (d.this.dUU != null) {
                d.this.dUU.removeMessages(0);
            }
        }
    }
}
