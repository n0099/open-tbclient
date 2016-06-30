package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aAP = new c();
    private b aAQ;
    private a aAR;

    /* loaded from: classes.dex */
    public interface a {
        void ag(boolean z);
    }

    private c() {
    }

    public static c Fy() {
        return aAP;
    }

    public void a(a aVar) {
        this.aAR = aVar;
        if (this.aAQ != null) {
            this.aAQ.cancel();
        }
        this.aAQ = new b(this, null);
        this.aAQ.setPriority(4);
        this.aAQ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fz() {
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
            return Boolean.valueOf(c.this.Fz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.aAR != null && bool != null) {
                c.this.aAR.ag(bool.booleanValue());
            }
        }
    }
}
