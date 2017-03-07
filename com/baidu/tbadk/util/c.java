package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aIH = new c();
    private b aII;
    private a aIJ;

    /* loaded from: classes.dex */
    public interface a {
        void al(boolean z);
    }

    private c() {
    }

    public static c GI() {
        return aIH;
    }

    public void a(a aVar) {
        this.aIJ = aVar;
        if (this.aII != null) {
            this.aII.cancel();
        }
        this.aII = new b(this, null);
        this.aII.setPriority(4);
        this.aII.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GJ() {
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

        /* synthetic */ b(c cVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.GJ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (c.this.aIJ != null && bool != null) {
                c.this.aIJ.al(bool.booleanValue());
            }
        }
    }
}
