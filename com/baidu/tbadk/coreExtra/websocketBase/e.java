package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c amZ;
    private b ana;
    private a anb;

    /* loaded from: classes.dex */
    public interface b {
        void bp(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> ane;

        c(e eVar) {
            this.ane = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.ane.get()) == null) {
                return;
            }
            eVar.Af();
        }
    }

    public e(String str, b bVar) {
        this.amZ = null;
        this.ana = null;
        this.anb = null;
        this.amZ = new c(this);
        this.ana = bVar;
        this.amZ.sendEmptyMessageDelayed(0, 50000L);
        this.anb = new a(this, null);
        this.anb.setSelfExecute(true);
        this.anb.execute(String.valueOf(Ae()) + str);
    }

    private String Ae() {
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
    public void Af() {
        if (this.anb != null) {
            this.anb.cancel(true);
        }
        if (this.amZ != null) {
            this.amZ.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process anc;

        private a() {
            this.anc = null;
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
                        this.anc = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.anc.waitFor() == 0;
                        this.anc.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.anc.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.anc.destroy();
                    }
                } catch (Throwable th) {
                    this.anc.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.anc != null) {
                try {
                    this.anc.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.ana != null) {
                e.this.ana.bp(false);
            }
            if (e.this.amZ != null) {
                e.this.amZ.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.ana != null) {
                e.this.ana.bp(bool == null ? false : bool.booleanValue());
            }
            if (e.this.amZ != null) {
                e.this.amZ.removeMessages(0);
            }
        }
    }
}
