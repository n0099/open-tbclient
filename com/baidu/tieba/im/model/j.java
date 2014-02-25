package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, LocalPicModel.ResponseData> {
    final /* synthetic */ LocalPicModel a;

    private j(LocalPicModel localPicModel) {
        this.a = localPicModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(LocalPicModel localPicModel, j jVar) {
        this(localPicModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public LocalPicModel.ResponseData a(Object... objArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "im_" + String.valueOf(System.currentTimeMillis());
        str = this.a.mSPath;
        str2 = this.a.mSName;
        String a = com.baidu.tieba.util.af.a(str, str2, com.baidu.tieba.im.g.c, String.valueOf(str5) + "_send");
        String str6 = String.valueOf(str5) + "_display";
        str3 = this.a.mDPath;
        str4 = this.a.mDName;
        String a2 = com.baidu.tieba.util.af.a(str3, str4, com.baidu.tieba.im.g.c, str6);
        Bitmap c = com.baidu.tieba.util.af.c(com.baidu.tieba.im.g.c, str6);
        if (a == null || a2 == null || c == null) {
            return null;
        }
        return new LocalPicModel.ResponseData(c, a, a2);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.a.mImageTask = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(LocalPicModel.ResponseData responseData) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((j) responseData);
        this.a.mImageTask = null;
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(responseData);
        }
    }
}
