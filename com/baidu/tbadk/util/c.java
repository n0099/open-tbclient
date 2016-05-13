package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c azY = new c();
    private a aAa;
    private b azZ;

    /* loaded from: classes.dex */
    public interface a {
        void ai(boolean z);
    }

    private c() {
    }

    public static c Fq() {
        return azY;
    }

    public void a(a aVar) {
        this.aAa = aVar;
        if (this.azZ != null) {
            this.azZ.cancel();
        }
        this.azZ = new b(this, null);
        this.azZ.setPriority(4);
        this.azZ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fr() {
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
            return Boolean.valueOf(c.this.Fr());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.aAa != null && bool != null) {
                c.this.aAa.ai(bool.booleanValue());
            }
        }
    }
}
