package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class d {
    private c ayG;
    private b ayH;
    private a ayI;

    /* loaded from: classes.dex */
    public interface b {
        void bn(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<d> ayL;

        c(d dVar) {
            this.ayL = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            super.handleMessage(message);
            if (message.what == 0 && (dVar = this.ayL.get()) != null) {
                dVar.BI();
            }
        }
    }

    public d(String str, b bVar) {
        this.ayG = null;
        this.ayH = null;
        this.ayI = null;
        this.ayG = new c(this);
        this.ayH = bVar;
        this.ayG.sendEmptyMessageDelayed(0, 50000L);
        this.ayI = new a();
        this.ayI.setSelfExecute(true);
        this.ayI.execute(BH() + str);
    }

    private String BH() {
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
    public void BI() {
        if (this.ayI != null) {
            this.ayI.cancel(true);
        }
        if (this.ayG != null) {
            this.ayG.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process ayJ;

        private a() {
            this.ayJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.ayJ = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.ayJ.waitFor() == 0;
                        this.ayJ.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.ayJ.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.ayJ.destroy();
                    }
                } catch (Throwable th) {
                    this.ayJ.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.ayJ != null) {
                try {
                    this.ayJ.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (d.this.ayH != null) {
                d.this.ayH.bn(false);
            }
            if (d.this.ayG != null) {
                d.this.ayG.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (d.this.ayH != null) {
                d.this.ayH.bn(bool == null ? false : bool.booleanValue());
            }
            if (d.this.ayG != null) {
                d.this.ayG.removeMessages(0);
            }
        }
    }
}
