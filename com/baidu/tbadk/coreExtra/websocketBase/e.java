package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c amq;
    private b amr;
    private a ams;

    /* loaded from: classes.dex */
    public interface b {
        void aU(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> amv;

        c(e eVar) {
            this.amv = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.amv.get()) == null) {
                return;
            }
            eVar.zB();
        }
    }

    public e(String str, b bVar) {
        this.amq = null;
        this.amr = null;
        this.ams = null;
        this.amq = new c(this);
        this.amr = bVar;
        this.amq.sendEmptyMessageDelayed(0, 50000L);
        this.ams = new a(this, null);
        this.ams.setSelfExecute(true);
        this.ams.execute(String.valueOf(zA()) + str);
    }

    private String zA() {
        switch (com.baidu.adp.lib.util.i.iU()) {
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
    public void zB() {
        if (this.ams != null) {
            this.ams.cancel(true);
        }
        if (this.amq != null) {
            this.amq.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process amt;

        private a() {
            this.amt = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.amt = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.amt.waitFor() == 0;
                        this.amt.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.amt.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.amt.destroy();
                    }
                } catch (Throwable th) {
                    this.amt.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.amt != null) {
                try {
                    this.amt.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.amr != null) {
                e.this.amr.aU(false);
            }
            if (e.this.amq != null) {
                e.this.amq.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.amr != null) {
                e.this.amr.aU(bool == null ? false : bool.booleanValue());
            }
            if (e.this.amq != null) {
                e.this.amq.removeMessages(0);
            }
        }
    }
}
