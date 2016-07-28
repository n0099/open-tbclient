package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c aou;
    private b aov;
    private a aow;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aoz;

        c(e eVar) {
            this.aoz = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aoz.get()) == null) {
                return;
            }
            eVar.Al();
        }
    }

    public e(String str, b bVar) {
        this.aou = null;
        this.aov = null;
        this.aow = null;
        this.aou = new c(this);
        this.aov = bVar;
        this.aou.sendEmptyMessageDelayed(0, 50000L);
        this.aow = new a(this, null);
        this.aow.setSelfExecute(true);
        this.aow.execute(String.valueOf(Ak()) + str);
    }

    private String Ak() {
        switch (com.baidu.adp.lib.util.i.fw()) {
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
        if (this.aow != null) {
            this.aow.cancel(true);
        }
        if (this.aou != null) {
            this.aou.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aox;

        private a() {
            this.aox = null;
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
                        this.aox = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aox.waitFor() == 0;
                        this.aox.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aox.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aox.destroy();
                    }
                } catch (Throwable th) {
                    this.aox.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aox != null) {
                try {
                    this.aox.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aov != null) {
                e.this.aov.bp(false);
            }
            if (e.this.aou != null) {
                e.this.aou.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (e.this.aov != null) {
                e.this.aov.bp(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aou != null) {
                e.this.aou.removeMessages(0);
            }
        }
    }
}
