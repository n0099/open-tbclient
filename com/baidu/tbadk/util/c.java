package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aDk = new c();
    private b aDl;
    private a aDm;

    /* loaded from: classes.dex */
    public interface a {
        void am(boolean z);
    }

    private c() {
    }

    public static c Gj() {
        return aDk;
    }

    public void a(a aVar) {
        this.aDm = aVar;
        if (this.aDl != null) {
            this.aDl.cancel();
        }
        this.aDl = new b(this, null);
        this.aDl.setPriority(4);
        this.aDl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gk() {
        int i;
        long j = 0;
        byte[] aF = com.baidu.adp.lib.util.e.aF("crash_hour_record.log");
        String str = null;
        if (aF != null) {
            str = new String(aF);
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
            return Boolean.valueOf(c.this.Gk());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (c.this.aDm != null && bool != null) {
                c.this.aDm.am(bool.booleanValue());
            }
        }
    }
}
