package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private a aoA;
    private c aoy;
    private b aoz;

    /* loaded from: classes.dex */
    public interface b {
        void bb(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aoD;

        c(e eVar) {
            this.aoD = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aoD.get()) == null) {
                return;
            }
            eVar.AC();
        }
    }

    public e(String str, b bVar) {
        this.aoy = null;
        this.aoz = null;
        this.aoA = null;
        this.aoy = new c(this);
        this.aoz = bVar;
        this.aoy.sendEmptyMessageDelayed(0, 50000L);
        this.aoA = new a(this, null);
        this.aoA.setSelfExecute(true);
        this.aoA.execute(String.valueOf(AB()) + str);
    }

    private String AB() {
        switch (com.baidu.adp.lib.util.i.iV()) {
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
    public void AC() {
        if (this.aoA != null) {
            this.aoA.cancel(true);
        }
        if (this.aoy != null) {
            this.aoy.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aoB;

        private a() {
            this.aoB = null;
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            if (strArr != null && strArr.length >= 1) {
                try {
                    try {
                        this.aoB = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aoB.waitFor() == 0;
                        this.aoB.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aoB.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aoB.destroy();
                    }
                } catch (Throwable th) {
                    this.aoB.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aoB != null) {
                try {
                    this.aoB.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aoz != null) {
                e.this.aoz.bb(false);
            }
            if (e.this.aoy != null) {
                e.this.aoy.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.aoz != null) {
                e.this.aoz.bb(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aoy != null) {
                e.this.aoy.removeMessages(0);
            }
        }
    }
}
