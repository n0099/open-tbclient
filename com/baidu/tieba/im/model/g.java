package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.util.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Object, Integer, LocalPicModel.ResponseData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LocalPicModel f1749a;

    private g(LocalPicModel localPicModel) {
        this.f1749a = localPicModel;
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
        str = this.f1749a.mSPath;
        str2 = this.f1749a.mSName;
        String a2 = af.a(str, str2, com.baidu.tieba.im.j.e, str5 + "_send");
        String str6 = str5 + "_display";
        str3 = this.f1749a.mDPath;
        str4 = this.f1749a.mDName;
        String a3 = af.a(str3, str4, com.baidu.tieba.im.j.e, str6);
        Bitmap c = af.c(com.baidu.tieba.im.j.e, str6);
        if (a2 == null || a3 == null || c == null) {
            return null;
        }
        return new LocalPicModel.ResponseData(c, a2, a3);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        this.f1749a.mImageTask = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(LocalPicModel.ResponseData responseData) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((g) responseData);
        this.f1749a.mImageTask = null;
        gVar = this.f1749a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1749a.mLoadDataCallBack;
            gVar2.a(responseData);
        }
    }
}
