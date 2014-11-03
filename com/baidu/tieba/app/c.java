package com.baidu.tieba.app;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.TbadkApplication;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AppInfoUploadService aiZ;

    private c(AppInfoUploadService appInfoUploadService) {
        this.aiZ = appInfoUploadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AppInfoUploadService appInfoUploadService, c cVar) {
        this(appInfoUploadService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
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
        String genPostData = this.aiZ.genPostData();
        if (!TextUtils.isEmpty(genPostData)) {
            try {
                this.aiZ.mMd5 = u.n(genPostData.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
            str = this.aiZ.mMd5;
            if (TextUtils.isEmpty(str)) {
                str3 = this.aiZ.mMd5;
                if (str3.equals(TbadkApplication.m251getInst().getAppUploadMd5())) {
                    z = false;
                    if (z) {
                        z2 = true;
                    } else {
                        str2 = this.aiZ.mUid;
                        if (!TextUtils.isEmpty(str2)) {
                            AppInfoUploadService appInfoUploadService = this.aiZ;
                            encrypt = this.aiZ.getEncrypt(genPostData);
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
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        String str;
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            TbadkApplication.m251getInst().setAppUploadDate(System.currentTimeMillis());
            TbadkApplication m251getInst = TbadkApplication.m251getInst();
            str = this.aiZ.mMd5;
            m251getInst.setAppUploadMd5(str);
        }
        this.aiZ.stopSelf();
    }
}
