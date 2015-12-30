package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c aqc;
    private b aqd;
    private a aqe;

    /* loaded from: classes.dex */
    public interface b {
        void ba(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aqh;

        c(e eVar) {
            this.aqh = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aqh.get()) == null) {
                return;
            }
            eVar.As();
        }
    }

    public e(String str, b bVar) {
        this.aqc = null;
        this.aqd = null;
        this.aqe = null;
        this.aqc = new c(this);
        this.aqd = bVar;
        this.aqc.sendEmptyMessageDelayed(0, 50000L);
        this.aqe = new a(this, null);
        this.aqe.setSelfExecute(true);
        this.aqe.execute(String.valueOf(Ar()) + str);
    }

    private String Ar() {
        switch (com.baidu.adp.lib.util.i.iW()) {
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
    public void As() {
        if (this.aqe != null) {
            this.aqe.cancel(true);
        }
        if (this.aqc != null) {
            this.aqc.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aqf;

        private a() {
            this.aqf = null;
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
                        this.aqf = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aqf.waitFor() == 0;
                        this.aqf.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aqf.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aqf.destroy();
                    }
                } catch (Throwable th) {
                    this.aqf.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aqf != null) {
                try {
                    this.aqf.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aqd != null) {
                e.this.aqd.ba(false);
            }
            if (e.this.aqc != null) {
                e.this.aqc.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.aqd != null) {
                e.this.aqd.ba(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aqc != null) {
                e.this.aqc.removeMessages(0);
            }
        }
    }
}
