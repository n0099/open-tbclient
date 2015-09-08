package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class c {
    private static c aAQ = new c();
    private b aAR;
    private a aAS;

    /* loaded from: classes.dex */
    public interface a {
        void ag(boolean z);
    }

    private c() {
    }

    public static c EJ() {
        return aAQ;
    }

    public void a(a aVar) {
        this.aAS = aVar;
        if (this.aAR != null) {
            this.aAR.cancel();
        }
        this.aAR = new b(this, null);
        this.aAR.setPriority(4);
        this.aAR.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EK() {
        int i;
        long j = 0;
        byte[] aH = com.baidu.adp.lib.util.e.aH("crash_hour_record.log");
        String str = null;
        if (aH != null) {
            str = new String(aH);
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
            return Boolean.valueOf(c.this.EK());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (c.this.aAS != null && bool != null) {
                c.this.aAS.ag(bool.booleanValue());
            }
        }
    }
}
