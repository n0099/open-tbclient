package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private b awA;
    private a awB;
    private c awz;

    /* loaded from: classes.dex */
    public interface b {
        void bv(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> awE;

        c(e eVar) {
            this.awE = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.awE.get()) == null) {
                return;
            }
            eVar.Ck();
        }
    }

    public e(String str, b bVar) {
        this.awz = null;
        this.awA = null;
        this.awB = null;
        this.awz = new c(this);
        this.awA = bVar;
        this.awz.sendEmptyMessageDelayed(0, 50000L);
        this.awB = new a(this, null);
        this.awB.setSelfExecute(true);
        this.awB.execute(String.valueOf(Cj()) + str);
    }

    private String Cj() {
        switch (com.baidu.adp.lib.util.i.hp()) {
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
        if (this.awB != null) {
            this.awB.cancel(true);
        }
        if (this.awz != null) {
            this.awz.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process awC;

        private a() {
            this.awC = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.awC = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.awC.waitFor() == 0;
                        this.awC.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.awC.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.awC.destroy();
                    }
                } catch (Throwable th) {
                    this.awC.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.awC != null) {
                try {
                    this.awC.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.awA != null) {
                e.this.awA.bv(false);
            }
            if (e.this.awz != null) {
                e.this.awz.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.awA != null) {
                e.this.awA.bv(bool == null ? false : bool.booleanValue());
            }
            if (e.this.awz != null) {
                e.this.awz.removeMessages(0);
            }
        }
    }
}
