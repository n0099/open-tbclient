package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c arB;
    private b arC;
    private a arD;

    /* loaded from: classes.dex */
    public interface b {
        void br(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> arG;

        c(e eVar) {
            this.arG = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.arG.get()) == null) {
                return;
            }
            eVar.BA();
        }
    }

    public e(String str, b bVar) {
        this.arB = null;
        this.arC = null;
        this.arD = null;
        this.arB = new c(this);
        this.arC = bVar;
        this.arB.sendEmptyMessageDelayed(0, 50000L);
        this.arD = new a(this, null);
        this.arD.setSelfExecute(true);
        this.arD.execute(String.valueOf(Bz()) + str);
    }

    private String Bz() {
        switch (com.baidu.adp.lib.util.i.gs()) {
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
    public void BA() {
        if (this.arD != null) {
            this.arD.cancel(true);
        }
        if (this.arB != null) {
            this.arB.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process arE;

        private a() {
            this.arE = null;
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
                        this.arE = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.arE.waitFor() == 0;
                        this.arE.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.arE.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.arE.destroy();
                    }
                } catch (Throwable th) {
                    this.arE.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.arE != null) {
                try {
                    this.arE.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.arC != null) {
                e.this.arC.br(false);
            }
            if (e.this.arB != null) {
                e.this.arB.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.arC != null) {
                e.this.arC.br(bool == null ? false : bool.booleanValue());
            }
            if (e.this.arB != null) {
                e.this.arB.removeMessages(0);
            }
        }
    }
}
