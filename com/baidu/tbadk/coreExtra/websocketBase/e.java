package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c axt;
    private b axu;
    private a axv;

    /* loaded from: classes.dex */
    public interface b {
        void bt(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> axy;

        c(e eVar) {
            this.axy = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.axy.get()) == null) {
                return;
            }
            eVar.BJ();
        }
    }

    public e(String str, b bVar) {
        this.axt = null;
        this.axu = null;
        this.axv = null;
        this.axt = new c(this);
        this.axu = bVar;
        this.axt.sendEmptyMessageDelayed(0, 50000L);
        this.axv = new a(this, null);
        this.axv.setSelfExecute(true);
        this.axv.execute(String.valueOf(BI()) + str);
    }

    private String BI() {
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
    public void BJ() {
        if (this.axv != null) {
            this.axv.cancel(true);
        }
        if (this.axt != null) {
            this.axt.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process axw;

        private a() {
            this.axw = null;
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
                        this.axw = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.axw.waitFor() == 0;
                        this.axw.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.axw.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.axw.destroy();
                    }
                } catch (Throwable th) {
                    this.axw.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.axw != null) {
                try {
                    this.axw.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.axu != null) {
                e.this.axu.bt(false);
            }
            if (e.this.axt != null) {
                e.this.axt.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.axu != null) {
                e.this.axu.bt(bool == null ? false : bool.booleanValue());
            }
            if (e.this.axt != null) {
                e.this.axt.removeMessages(0);
            }
        }
    }
}
