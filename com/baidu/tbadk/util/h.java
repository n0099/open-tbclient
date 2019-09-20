package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static h cDN = new h();
    private b cDO;
    private a cDP;

    /* loaded from: classes.dex */
    public interface a {
        void bE(boolean z);
    }

    private h() {
    }

    public static h aws() {
        return cDN;
    }

    public void a(a aVar) {
        this.cDP = aVar;
        if (this.cDO != null) {
            this.cDO.cancel();
        }
        this.cDO = new b();
        this.cDO.setPriority(4);
        this.cDO.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awt() {
        int i;
        long j = 0;
        byte[] nC = com.baidu.tbadk.core.util.m.nC(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (nC != null) {
            str = new String(nC);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.f(split[0], 0);
                j = com.baidu.adp.lib.g.b.e(split[1], j2);
            }
        }
        if (j == j2 && i > 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(h.this.awt());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (h.this.cDP != null && bool != null) {
                h.this.cDP.bE(bool.booleanValue());
            }
        }
    }
}
