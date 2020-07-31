package com.baidu.tieba.dnsproxy;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.db.TableDefine;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes13.dex */
public class b {
    private static b hdO = null;

    public static final b bTo() {
        if (hdO == null) {
            synchronized (b.class) {
                if (hdO == null) {
                    hdO = new b();
                }
            }
        }
        return hdO;
    }

    private b() {
    }

    public void g(Set<String> set) {
        for (String str : set) {
            new a(str).execute(new String[0]);
        }
    }

    /* loaded from: classes13.dex */
    private static class a extends BdAsyncTask<String, Void, Boolean> {
        private static final BdUniqueId fuC = BdUniqueId.gen();
        private long Lt;
        Process eyk;
        private String ip;

        private a(String str) {
            this.eyk = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, fuC));
            this.ip = str;
        }

        private String bhO() {
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
                    this.eyk = runtime.exec(bhO() + this.ip);
                    z = this.eyk.waitFor() == 0;
                    try {
                        this.Lt = System.currentTimeMillis() - currentTimeMillis;
                    } catch (IOException e3) {
                        e2 = e3;
                        BdLog.detailException(e2);
                        d.bTp().dY("test_speed", e2.getMessage());
                        this.eyk.destroy();
                        return Boolean.valueOf(z);
                    } catch (InterruptedException e4) {
                        e = e4;
                        BdLog.detailException(e);
                        d.bTp().dY("test_speed", e.getMessage());
                        this.eyk.destroy();
                        return Boolean.valueOf(z);
                    } catch (Throwable th2) {
                        th = th2;
                        BdLog.detailException(th);
                        d.bTp().dY("test_speed", th.getMessage());
                        this.eyk.destroy();
                        return Boolean.valueOf(z);
                    }
                } finally {
                    this.eyk.destroy();
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
            if (this.eyk != null) {
                try {
                    this.eyk.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.baidu.tieba.dnsproxy.a.d.bTD().c(this.ip, (int) this.Lt, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            com.baidu.tieba.dnsproxy.a.d.bTD().c(this.ip, (int) this.Lt, booleanValue);
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_testspeed");
            statsItem.append("issuc", Boolean.valueOf(booleanValue));
            statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, this.ip);
            statsItem.append("speed", Integer.valueOf((int) this.Lt));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
