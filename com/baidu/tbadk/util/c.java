package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aAv = new c();
    private b aAw;
    private a aAx;

    /* loaded from: classes.dex */
    public interface a {
        void ai(boolean z);
    }

    private c() {
    }

    public static c Fo() {
        return aAv;
    }

    public void a(a aVar) {
        this.aAx = aVar;
        if (this.aAw != null) {
            this.aAw.cancel();
        }
        this.aAw = new b(this, null);
        this.aAw.setPriority(4);
        this.aAw.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fp() {
        int i;
        long j = 0;
        byte[] aJ = com.baidu.adp.lib.util.e.aJ("crash_hour_record.log");
        String str = null;
        if (aJ != null) {
            str = new String(aJ);
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.Fp());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.aAx != null && bool != null) {
                c.this.aAx.ai(bool.booleanValue());
            }
        }
    }
}
