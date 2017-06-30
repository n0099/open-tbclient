package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class e {
    private static e aKd = new e();
    private b aKe;
    private a aKf;

    /* loaded from: classes.dex */
    public interface a {
        void al(boolean z);
    }

    private e() {
    }

    public static e GE() {
        return aKd;
    }

    public void a(a aVar) {
        this.aKf = aVar;
        if (this.aKe != null) {
            this.aKe.cancel();
        }
        this.aKe = new b(this, null);
        this.aKe.setPriority(4);
        this.aKe.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GF() {
        int i;
        long j = 0;
        byte[] az = com.baidu.adp.lib.util.e.az("crash_hour_record.log");
        String str = null;
        if (az != null) {
            str = new String(az);
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

        /* synthetic */ b(e eVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(e.this.GF());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (e.this.aKf != null && bool != null) {
                e.this.aKf.al(bool.booleanValue());
            }
        }
    }
}
