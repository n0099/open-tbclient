package com.baidu.tbadk.coreExtra.websocketBase;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e {
    private c aoc;
    private b aod;
    private a aoe;

    /* loaded from: classes.dex */
    public interface b {
        void bb(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends Handler {
        private final WeakReference<e> aoh;

        c(e eVar) {
            this.aoh = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar;
            super.handleMessage(message);
            if (message.what != 0 || (eVar = this.aoh.get()) == null) {
                return;
            }
            eVar.zO();
        }
    }

    public e(String str, b bVar) {
        this.aoc = null;
        this.aod = null;
        this.aoe = null;
        this.aoc = new c(this);
        this.aod = bVar;
        this.aoc.sendEmptyMessageDelayed(0, 50000L);
        this.aoe = new a(this, null);
        this.aoe.setSelfExecute(true);
        this.aoe.execute(String.valueOf(zN()) + str);
    }

    private String zN() {
        switch (com.baidu.adp.lib.util.i.iR()) {
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
    public void zO() {
        if (this.aoe != null) {
            this.aoe.cancel(true);
        }
        if (this.aoc != null) {
            this.aoc.removeMessages(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Void, Boolean> {
        Process aof;

        private a() {
            this.aof = null;
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
                        this.aof = Runtime.getRuntime().exec(strArr[0]);
                        boolean z2 = this.aof.waitFor() == 0;
                        this.aof.destroy();
                        z = z2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        this.aof.destroy();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        this.aof.destroy();
                    }
                } catch (Throwable th) {
                    this.aof.destroy();
                    throw th;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aof != null) {
                try {
                    this.aof.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (e.this.aod != null) {
                e.this.aod.bb(false);
            }
            if (e.this.aoc != null) {
                e.this.aoc.removeMessages(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (e.this.aod != null) {
                e.this.aod.bb(bool == null ? false : bool.booleanValue());
            }
            if (e.this.aoc != null) {
                e.this.aoc.removeMessages(0);
            }
        }
    }
}
