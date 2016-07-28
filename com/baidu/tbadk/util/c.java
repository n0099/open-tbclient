package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aBF = new c();
    private b aBG;
    private a aBH;

    /* loaded from: classes.dex */
    public interface a {
        void ai(boolean z);
    }

    private c() {
    }

    public static c Fz() {
        return aBF;
    }

    public void a(a aVar) {
        this.aBH = aVar;
        if (this.aBG != null) {
            this.aBG.cancel();
        }
        this.aBG = new b(this, null);
        this.aBG.setPriority(4);
        this.aBG.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FA() {
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
            return Boolean.valueOf(c.this.FA());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (c.this.aBH != null && bool != null) {
                c.this.aBH.ai(bool.booleanValue());
            }
        }
    }
}
