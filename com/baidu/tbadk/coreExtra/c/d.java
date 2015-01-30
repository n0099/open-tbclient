package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private ad AR = null;
    private final String GE;
    private final String RM;
    private final String RN;

    public d(String str, String str2, String str3) {
        this.RM = str;
        this.GE = str2;
        this.RN = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bool = false;
        try {
            this.AR = new ad(this.RM);
            bool = Boolean.valueOf(this.AR.a(String.valueOf(this.GE) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
            if (bool != null && bool.booleanValue()) {
                if (!StringUtils.isNull(s.e(null, String.valueOf(this.GE) + ".tmp", null, this.GE))) {
                    s.cn(bh.cH(this.RN));
                }
            } else {
                s.cn(String.valueOf(this.GE) + ".tmp");
            }
        } catch (Exception e) {
        }
        return bool;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            new c().su();
        }
    }
}
