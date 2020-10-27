package com.baidu.tbadk.coreExtra.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ffu;
    private b ffv;
    private a ffw;

    /* loaded from: classes.dex */
    public interface b {
        void jI(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ffz;

        c(d dVar) {
            this.ffz = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ffz.get()) != null) {
                dVar.ahS();
            }
        }
    }

    public d(String str, b bVar) {
        this.ffu = null;
        this.ffv = null;
        this.ffw = null;
        this.ffu = new c(this);
        this.ffv = bVar;
        this.ffu.sendEmptyMessageDelayed(0, 50000L);
        this.ffw = new a();
        this.ffw.setSelfExecute(true);
        this.ffw.execute(bvY() + str);
    }

    private String bvY() {
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
    public void ahS() {
        if (this.ffw != null) {
            this.ffw.cancel(true);
        }
        if (this.ffu != null) {
            this.ffu.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ffx;

        private a() {
            this.ffx = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ffx = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ffx.waitFor() == 0;
                        this.ffx.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ffx.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ffx.destroy();
                    }
                } catch (Throwable th) {
                    this.ffx.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ffx != null) {
                try {
                    this.ffx.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.ffv != null) {
                d.this.ffv.jI(false);
            }
            if (d.this.ffu != null) {
                d.this.ffu.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.ffv != null) {
                d.this.ffv.jI(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ffu != null) {
                d.this.ffu.removeMessages(0);
            }
        }
    }
}
