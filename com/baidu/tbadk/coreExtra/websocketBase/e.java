package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c awG;
    private b awH;
    private a awI;

    /* loaded from: classes.dex */
    public interface b {
        void bv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> awL;

        c(e eVar) {
            this.awL = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.awL.get()) == null) {
                return;
            }
            eVar.Bv();
        }
    }

    public e(String str, b bVar) {
        this.awG = null;
        this.awH = null;
        this.awI = null;
        this.awG = new c(this);
        this.awH = bVar;
        this.awG.sendEmptyMessageDelayed(0, 50000L);
        this.awI = new a(this, null);
        this.awI.setSelfExecute(true);
        this.awI.execute(String.valueOf(Bu()) + str);
    }

    private String Bu() {
        switch (com.baidu.adp.lib.util.i.hq()) {
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
    public void Bv() {
        if (this.awI != null) {
            this.awI.cancel(true);
        }
        if (this.awG != null) {
            this.awG.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process awJ;

        private a() {
            this.awJ = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.awJ = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.awJ.waitFor() == 0;
                        this.awJ.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.awJ.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.awJ.destroy();
                    }
                } catch (Throwable th) {
                    this.awJ.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.awJ != null) {
                try {
                    this.awJ.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.awH != null) {
                e.this.awH.bv(false);
            }
            if (e.this.awG != null) {
                e.this.awG.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.awH != null) {
                e.this.awH.bv(bool == null ? false : bool.booleanValue());
            }
            if (e.this.awG != null) {
                e.this.awG.removeMessages(0);
            }
        }
    }
}
