package com.baidu.tieba.app;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.TbadkApplication;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AppInfoUploadService aql;

    private c(AppInfoUploadService appInfoUploadService) {
        this.aql = appInfoUploadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(AppInfoUploadService appInfoUploadService, c cVar) {
        this(appInfoUploadService);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public Boolean doInBackground(Object... objArr) {
        boolean z = false;
        String genPostData = this.aql.genPostData();
        if (!TextUtils.isEmpty(genPostData)) {
            try {
                AppInfoUploadService.access$0(this.aql, z.n(genPostData.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
            }
            if (!((TextUtils.isEmpty(AppInfoUploadService.access$1(this.aql)) && AppInfoUploadService.access$1(this.aql).equals(TbadkApplication.getInst().getAppUploadMd5())) ? false : true)) {
                z = true;
            } else if (!TextUtils.isEmpty(AppInfoUploadService.access$2(this.aql))) {
                z = AppInfoUploadService.access$4(this.aql, AppInfoUploadService.access$3(this.aql, genPostData));
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            TbadkApplication.getInst().setAppUploadDate(System.currentTimeMillis());
            TbadkApplication.getInst().setAppUploadMd5(AppInfoUploadService.access$1(this.aql));
        }
        this.aql.stopSelf();
    }
}
