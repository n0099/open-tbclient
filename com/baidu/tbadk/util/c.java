package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aCS = new c();
    private b aCT;
    private a aCU;

    /* loaded from: classes.dex */
    public interface a {
        void ag(boolean z);
    }

    private c() {
    }

    public static c Gu() {
        return aCS;
    }

    public void a(a aVar) {
        this.aCU = aVar;
        if (this.aCT != null) {
            this.aCT.cancel();
        }
        this.aCT = new b(this, null);
        this.aCT.setPriority(4);
        this.aCT.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Gv() {
        int i;
        long j = 0;
        byte[] aI = com.baidu.adp.lib.util.e.aI("crash_hour_record.log");
        String str = null;
        if (aI != null) {
            str = new String(aI);
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(c.this.Gv());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.aCU != null && bool != null) {
                c.this.aCU.ag(bool.booleanValue());
            }
        }
    }
}
