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
    private static b cMo = null;

    public static final b amW() {
        if (cMo == null) {
            synchronized (b.class) {
                if (cMo == null) {
                    cMo = new b();
                }
            }
        }
        return cMo;
    }

    private b() {
    }

    public void b(Set<String> set) {
        for (String str : set) {
            new a(str).execute(new String[0]);
        }
    }

    /* loaded from: classes3.dex */
    private static class a extends BdAsyncTask<String, Void, Boolean> {
        private static final BdUniqueId bxj = BdUniqueId.gen();
        Process aJT;
        private long cMp;
        private String ip;

        private a(String str) {
            this.aJT = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, bxj));
            this.ip = str;
        }

        private String GD() {
            switch (j.jJ()) {
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
                    this.aJT = runtime.exec(GD() + this.ip);
                    z = this.aJT.waitFor() == 0;
                    try {
                        this.cMp = System.currentTimeMillis() - currentTimeMillis;
                    } catch (IOException e3) {
                        e2 = e3;
                        BdLog.detailException(e2);
                        d.amX().aS("test_speed", e2.getMessage());
                        this.aJT.destroy();
                        return Boolean.valueOf(z);
                    } catch (InterruptedException e4) {
                        e = e4;
                        BdLog.detailException(e);
                        d.amX().aS("test_speed", e.getMessage());
                        this.aJT.destroy();
                        return Boolean.valueOf(z);
                    } catch (Throwable th2) {
                        th = th2;
                        BdLog.detailException(th);
                        d.amX().aS("test_speed", th.getMessage());
                        this.aJT.destroy();
                        return Boolean.valueOf(z);
                    }
                } finally {
                    this.aJT.destroy();
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
            if (this.aJT != null) {
                try {
                    this.aJT.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.baidu.tieba.dnsproxy.a.d.anl().c(this.ip, (int) this.cMp, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            com.baidu.tieba.dnsproxy.a.d.anl().c(this.ip, (int) this.cMp, booleanValue);
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_testspeed");
            statsItem.f("issuc", Boolean.valueOf(booleanValue));
            statsItem.append("ip", this.ip);
            statsItem.f("speed", Integer.valueOf((int) this.cMp));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
