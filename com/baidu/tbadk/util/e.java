package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class e {
    private static e aMf = new e();
    private b aMg;
    private a aMh;

    /* loaded from: classes.dex */
    public interface a {
        void al(boolean z);
    }

    private e() {
    }

    public static e Ha() {
        return aMf;
    }

    public void a(a aVar) {
        this.aMh = aVar;
        if (this.aMg != null) {
            this.aMg.cancel();
        }
        this.aMg = new b();
        this.aMg.setPriority(4);
        this.aMg.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Hb() {
        int i;
        long j = 0;
        byte[] aD = com.baidu.adp.lib.util.e.aD("crash_hour_record.log");
        String str = null;
        if (aD != null) {
            str = new String(aD);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.g.b.g(split[0], 0);
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
            return Boolean.valueOf(e.this.Hb());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.aMh != null && bool != null) {
                e.this.aMh.al(bool.booleanValue());
            }
        }
    }
}
