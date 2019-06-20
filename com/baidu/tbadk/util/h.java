package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class h {
    private static h cBu = new h();
    private b cBv;
    private a cBw;

    /* loaded from: classes.dex */
    public interface a {
        void bB(boolean z);
    }

    private h() {
    }

    public static h auV() {
        return cBu;
    }

    public void a(a aVar) {
        this.cBw = aVar;
        if (this.cBv != null) {
            this.cBv.cancel();
        }
        this.cBv = new b();
        this.cBv.setPriority(4);
        this.cBv.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auW() {
        int i;
        long j = 0;
        byte[] no = com.baidu.tbadk.core.util.m.no(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/crash_hour_record.log");
        String str = null;
        if (no != null) {
            str = new String(no);
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
            return Boolean.valueOf(h.this.auW());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (h.this.cBw != null && bool != null) {
                h.this.cBw.bB(bool.booleanValue());
            }
        }
    }
}
