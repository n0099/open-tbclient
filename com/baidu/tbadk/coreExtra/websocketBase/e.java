package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c awq;
    private b awr;
    private a aws;

    /* loaded from: classes.dex */
    public interface b {
        void bs(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> awv;

        c(e eVar) {
            this.awv = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.awv.get()) == null) {
                return;
            }
            eVar.Bo();
        }
    }

    public e(String str, b bVar) {
        this.awq = null;
        this.awr = null;
        this.aws = null;
        this.awq = new c(this);
        this.awr = bVar;
        this.awq.sendEmptyMessageDelayed(0, 50000L);
        this.aws = new a(this, null);
        this.aws.setSelfExecute(true);
        this.aws.execute(String.valueOf(Bn()) + str);
    }

    private String Bn() {
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
    public void Bo() {
        if (this.aws != null) {
            this.aws.cancel(true);
        }
        if (this.awq != null) {
            this.awq.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process awt;

        private a() {
            this.awt = null;
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
                        this.awt = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.awt.waitFor() == 0;
                        this.awt.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.awt.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.awt.destroy();
                    }
                } catch (Throwable th) {
                    this.awt.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.awt != null) {
                try {
                    this.awt.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.awr != null) {
                e.this.awr.bs(false);
            }
            if (e.this.awq != null) {
                e.this.awq.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.awr != null) {
                e.this.awr.bs(bool == null ? false : bool.booleanValue());
            }
            if (e.this.awq != null) {
                e.this.awq.removeMessages(0);
            }
        }
    }
}
