package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c awB;
    private b awC;
    private a awD;

    /* loaded from: classes.dex */
    public interface b {
        void bv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> awG;

        c(e eVar) {
            this.awG = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.awG.get()) == null) {
                return;
            }
            eVar.Ck();
        }
    }

    public e(String str, b bVar) {
        this.awB = null;
        this.awC = null;
        this.awD = null;
        this.awB = new c(this);
        this.awC = bVar;
        this.awB.sendEmptyMessageDelayed(0, 50000L);
        this.awD = new a(this, null);
        this.awD.setSelfExecute(true);
        this.awD.execute(String.valueOf(Cj()) + str);
    }

    private String Cj() {
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
    public void Ck() {
        if (this.awD != null) {
            this.awD.cancel(true);
        }
        if (this.awB != null) {
            this.awB.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process awE;

        private a() {
            this.awE = null;
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
                        this.awE = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.awE.waitFor() == 0;
                        this.awE.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.awE.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.awE.destroy();
                    }
                } catch (Throwable th) {
                    this.awE.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.awE != null) {
                try {
                    this.awE.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.awC != null) {
                e.this.awC.bv(false);
            }
            if (e.this.awB != null) {
                e.this.awB.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.awC != null) {
                e.this.awC.bv(bool == null ? false : bool.booleanValue());
            }
            if (e.this.awB != null) {
                e.this.awB.removeMessages(0);
            }
        }
    }
}
