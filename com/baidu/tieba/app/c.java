package com.baidu.tieba.app;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.p;
import com.baidu.tbadk.TbadkApplication;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AppInfoUploadService a;

    private c(AppInfoUploadService appInfoUploadService) {
        this.a = appInfoUploadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AppInfoUploadService appInfoUploadService, c cVar) {
        this(appInfoUploadService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Object... objArr) {
        String str;
        boolean z;
        String str2;
        String encrypt;
        String str3;
        boolean z2 = false;
        String genPostData = this.a.genPostData();
        if (!TextUtils.isEmpty(genPostData)) {
            try {
                this.a.mMd5 = p.a(genPostData.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
            str = this.a.mMd5;
            if (TextUtils.isEmpty(str)) {
                str3 = this.a.mMd5;
                if (str3.equals(TbadkApplication.m252getInst().getAppUploadMd5())) {
                    z = false;
                    if (z) {
                        z2 = true;
                    } else {
                        str2 = this.a.mUid;
                        if (!TextUtils.isEmpty(str2)) {
                            AppInfoUploadService appInfoUploadService = this.a;
                            encrypt = this.a.getEncrypt(genPostData);
                            z2 = appInfoUploadService.Upload(encrypt);
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
        }
        return Boolean.valueOf(z2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        String str;
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            TbadkApplication.m252getInst().setAppUploadDate(System.currentTimeMillis());
            TbadkApplication m252getInst = TbadkApplication.m252getInst();
            str = this.a.mMd5;
            m252getInst.setAppUploadMd5(str);
        }
        this.a.stopSelf();
    }
}
