package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c ayq = new c();
    private b ayr;
    private a ays;

    /* loaded from: classes.dex */
    public interface a {
        void ag(boolean z);
    }

    private c() {
    }

    public static c Em() {
        return ayq;
    }

    public void a(a aVar) {
        this.ays = aVar;
        if (this.ayr != null) {
            this.ayr.cancel();
        }
        this.ayr = new b(this, null);
        this.ayr.setPriority(4);
        this.ayr.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean En() {
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.En());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.ays != null && bool != null) {
                c.this.ays.ag(bool.booleanValue());
            }
        }
    }
}
