package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, LocalPicModel.ResponseData> {
    final /* synthetic */ LocalPicModel a;

    private k(LocalPicModel localPicModel) {
        this.a = localPicModel;
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
        String a = com.baidu.tieba.util.y.a(str, str2, com.baidu.tieba.im.j.c, str5 + "_send");
        String str6 = str5 + "_display";
        str3 = this.a.mDPath;
        str4 = this.a.mDName;
        String a2 = com.baidu.tieba.util.y.a(str3, str4, com.baidu.tieba.im.j.c, str6);
        Bitmap c = com.baidu.tieba.util.y.c(com.baidu.tieba.im.j.c, str6);
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
        super.a((k) responseData);
        this.a.mImageTask = null;
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(responseData);
        }
    }
}
