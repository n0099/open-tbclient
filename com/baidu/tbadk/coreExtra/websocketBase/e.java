package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c anF;
    private b anG;
    private a anH;

    /* loaded from: classes.dex */
    public interface b {
        void bm(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> anK;

        c(e eVar) {
            this.anK = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.anK.get()) == null) {
                return;
            }
            eVar.Al();
        }
    }

    public e(String str, b bVar) {
        this.anF = null;
        this.anG = null;
        this.anH = null;
        this.anF = new c(this);
        this.anG = bVar;
        this.anF.sendEmptyMessageDelayed(0, 50000L);
        this.anH = new a(this, null);
        this.anH.setSelfExecute(true);
        this.anH.execute(String.valueOf(Ak()) + str);
    }

    private String Ak() {
        switch (com.baidu.adp.lib.util.i.fx()) {
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
    public void Al() {
        if (this.anH != null) {
            this.anH.cancel(true);
        }
        if (this.anF != null) {
            this.anF.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process anI;

        private a() {
            this.anI = null;
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
                        this.anI = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.anI.waitFor() == 0;
                        this.anI.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.anI.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.anI.destroy();
                    }
                } catch (Throwable th) {
                    this.anI.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.anI != null) {
                try {
                    this.anI.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.anG != null) {
                e.this.anG.bm(false);
            }
            if (e.this.anF != null) {
                e.this.anF.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.anG != null) {
                e.this.anG.bm(bool == null ? false : bool.booleanValue());
            }
            if (e.this.anF != null) {
                e.this.anF.removeMessages(0);
            }
        }
    }
}
