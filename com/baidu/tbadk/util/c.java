package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aEk = new c();
    private b aEl;
    private a aEm;

    /* loaded from: classes.dex */
    public interface a {
        void ak(boolean z);
    }

    private c() {
    }

    public static c GS() {
        return aEk;
    }

    public void a(a aVar) {
        this.aEm = aVar;
        if (this.aEl != null) {
            this.aEl.cancel();
        }
        this.aEl = new b(this, null);
        this.aEl.setPriority(4);
        this.aEl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GT() {
        int i;
        long j = 0;
        byte[] aG = com.baidu.adp.lib.util.e.aG("crash_hour_record.log");
        String str = null;
        if (aG != null) {
            str = new String(aG);
        }
        long j2 = StringUtils.getyyyyMMddHHTimeForNow();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            String[] split = str.split(":");
            if (split == null || split.length != 2) {
                i = 0;
            } else {
                i = com.baidu.adp.lib.h.b.g(split[0], 0);
                j = com.baidu.adp.lib.h.b.c(split[1], j2);
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
            return Boolean.valueOf(c.this.GT());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (c.this.aEm != null && bool != null) {
                c.this.aEm.ak(bool.booleanValue());
            }
        }
    }
}
