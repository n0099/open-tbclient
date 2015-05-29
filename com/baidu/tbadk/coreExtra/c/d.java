package com.baidu.tbadk.coreExtra.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private aa OE = null;
    private final String To;
    private final String acY;
    private final String acZ;

    public d(String str, String str2, String str3) {
        this.acY = str;
        this.To = str2;
        this.acZ = str3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        Boolean bool = false;
        try {
            this.OE = new aa(this.acY);
            bool = Boolean.valueOf(this.OE.a(String.valueOf(this.To) + ".tmp", new Handler(Looper.getMainLooper()), TbConfig.NET_MSG_GETLENTH));
            if (bool != null && bool.booleanValue()) {
                if (!StringUtils.isNull(o.e(null, String.valueOf(this.To) + ".tmp", null, this.To))) {
                    o.cH(bd.db(this.acZ));
                }
            } else {
                o.cH(String.valueOf(this.To) + ".tmp");
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
            new c().wA();
        }
    }
}
