package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static h cCS = new h();
    private b cCT;
    private a cCU;

    /* loaded from: classes.dex */
    public interface a {
        void bE(boolean z);
    }

    private h() {
    }

    public static h awg() {
        return cCS;
    }

    public void a(a aVar) {
        this.cCU = aVar;
        if (this.cCT != null) {
            this.cCT.cancel();
        }
        this.cCT = new b();
        this.cCT.setPriority(4);
        this.cCT.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean awh() {
        int i;
        long j = 0;
        byte[] nA = com.baidu.tbadk.core.util.m.nA(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (nA != null) {
            str = new String(nA);
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
                j = com.baidu.adp.lib.g.b.c(split[1], j2);
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
            return Boolean.valueOf(h.this.awh());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (h.this.cCU != null && bool != null) {
                h.this.cCU.bE(bool.booleanValue());
            }
        }
    }
}
