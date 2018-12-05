package com.baidu.tieba.dnsproxy;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {
    private static b dkQ = null;

    public static final b atT() {
        if (dkQ == null) {
            synchronized (b.class) {
                if (dkQ == null) {
                    dkQ = new b();
                }
            }
        }
        return dkQ;
    }

    private b() {
    }

    public void e(Set<String> set) {
        for (String str : set) {
            new a(str).execute(new String[0]);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends BdAsyncTask<String, Void, Boolean> {
        private static final BdUniqueId bQM = BdUniqueId.gen();
        Process aWb;
        private long dkR;
        private String ip;

        private a(String str) {
            this.aWb = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, bQM));
            this.ip = str;
        }

        private String Lf() {
            switch (j.netType()) {
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

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            boolean z;
            Throwable th;
            InterruptedException e;
            IOException e2;
            Runtime runtime = Runtime.getRuntime();
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.aWb = runtime.exec(Lf() + this.ip);
                    z = this.aWb.waitFor() == 0;
                    try {
                        this.dkR = System.currentTimeMillis() - currentTimeMillis;
                    } catch (IOException e3) {
                        e2 = e3;
                        BdLog.detailException(e2);
                        d.atU().aX("test_speed", e2.getMessage());
                        this.aWb.destroy();
                        return Boolean.valueOf(z);
                    } catch (InterruptedException e4) {
                        e = e4;
                        BdLog.detailException(e);
                        d.atU().aX("test_speed", e.getMessage());
                        this.aWb.destroy();
                        return Boolean.valueOf(z);
                    } catch (Throwable th2) {
                        th = th2;
                        BdLog.detailException(th);
                        d.atU().aX("test_speed", th.getMessage());
                        this.aWb.destroy();
                        return Boolean.valueOf(z);
                    }
                } finally {
                    this.aWb.destroy();
                }
            } catch (IOException e5) {
                z = false;
                e2 = e5;
            } catch (InterruptedException e6) {
                z = false;
                e = e6;
            } catch (Throwable th3) {
                z = false;
                th = th3;
            }
            return Boolean.valueOf(z);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.aWb != null) {
                try {
                    this.aWb.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.baidu.tieba.dnsproxy.a.d.aui().c(this.ip, (int) this.dkR, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            com.baidu.tieba.dnsproxy.a.d.aui().c(this.ip, (int) this.dkR, booleanValue);
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_testspeed");
            statsItem.f("issuc", Boolean.valueOf(booleanValue));
            statsItem.append("ip", this.ip);
            statsItem.f("speed", Integer.valueOf((int) this.dkR));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
