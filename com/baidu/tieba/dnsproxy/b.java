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
/* loaded from: classes8.dex */
public class b {
    private static b iEB = null;

    public static final b cuf() {
        if (iEB == null) {
            synchronized (b.class) {
                if (iEB == null) {
                    iEB = new b();
                }
            }
        }
        return iEB;
    }

    private b() {
    }

    public void g(Set<String> set) {
        for (String str : set) {
            new a(str).execute(new String[0]);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends BdAsyncTask<String, Void, Boolean> {
        private static final BdUniqueId gCD = BdUniqueId.gen();
        private long MU;
        Process fzl;
        private String ip;

        private a(String str) {
            this.fzl = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, gCD));
            this.ip = str;
        }

        private String bAh() {
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
            Runtime runtime = Runtime.getRuntime();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.fzl = runtime.exec(bAh() + this.ip);
                r0 = this.fzl.waitFor() == 0;
                this.MU = System.currentTimeMillis() - currentTimeMillis;
            } catch (InterruptedException e) {
                BdLog.detailException(e);
                d.cug().error("test_speed", e.getMessage());
            } catch (IOException e2) {
                BdLog.detailException(e2);
                d.cug().error("test_speed", e2.getMessage());
            } catch (Throwable th) {
                BdLog.detailException(th);
                d.cug().error("test_speed", th.getMessage());
            } finally {
                this.fzl.destroy();
            }
            return Boolean.valueOf(r0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            if (this.fzl != null) {
                try {
                    this.fzl.destroy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            com.baidu.tieba.dnsproxy.a.d.cuu().c(this.ip, (int) this.MU, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            boolean booleanValue = bool != null ? bool.booleanValue() : true;
            com.baidu.tieba.dnsproxy.a.d.cuu().c(this.ip, (int) this.MU, booleanValue);
            com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.append("workflow", "dnsproxy_testspeed");
            statsItem.append("issuc", Boolean.valueOf(booleanValue));
            statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, this.ip);
            statsItem.append("speed", Integer.valueOf((int) this.MU));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        }
    }
}
