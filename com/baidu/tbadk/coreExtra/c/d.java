package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private aa Oi = null;
    private final String SB;
    private final String abL;
    private final String abM;

    public d(String str, String str2, String str3) {
        this.abL = str;
        this.SB = str2;
        this.abM = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bool = false;
        try {
            this.Oi = new aa(this.abL);
            bool = Boolean.valueOf(this.Oi.a(String.valueOf(this.SB) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
            if (bool != null && bool.booleanValue()) {
                if (!StringUtils.isNull(o.e(null, String.valueOf(this.SB) + ".tmp", null, this.SB))) {
                    o.cs(bf.cN(this.abM));
                }
            } else {
                o.cs(String.valueOf(this.SB) + ".tmp");
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
            new c().vK();
        }
    }
}
